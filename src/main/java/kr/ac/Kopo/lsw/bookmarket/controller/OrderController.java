// src/main/java/kr/ac/Kopo/lsw/bookmarket/controller/OrderController.java
package kr.ac.Kopo.lsw.bookmarket.controller;

import kr.ac.Kopo.lsw.bookmarket.domain.*;
import kr.ac.Kopo.lsw.bookmarket.service.BookService;
import kr.ac.Kopo.lsw.bookmarket.service.CartService;
import kr.ac.Kopo.lsw.bookmarket.service.OrderProService;
import kr.ac.Kopo.lsw.bookmarket.service.OrderService;
// import kr.ac.Kopo.lsw.bookmarket.service.BookService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private CartService cartService;

    // 원래 있던 필드 (삭제하지 않음)
    Order order;
    List<Book> listofBooks;

    @Autowired
    private OrderProService orderProService;
    @Autowired
    private BookService bookService;

    // @Autowired
    // private BookService bookService;

    // ====== private helpers (추가) ======
    private HttpSession session() {
        ServletRequestAttributes attr =
                (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession();
    }

    private Order getOrInitOrderInSession() {
        HttpSession s = session();
        Order o = (Order) s.getAttribute("order");
        if (o == null) {
            o = new Order();
            o.setCustomer(new Customer());
            o.setShipping(new Shipping());
            if (o.getShipping().getAddress() == null) {
                o.getShipping().setAddress(new Address());
            }
            s.setAttribute("order", o);
        } else {
            if (o.getCustomer() == null) o.setCustomer(new Customer());
            if (o.getShipping() == null) o.setShipping(new Shipping());
            if (o.getShipping().getAddress() == null) o.getShipping().setAddress(new Address());
        }
        return o;
    }
    // ===================================

    @GetMapping("/{cartId}")
    public String requestCartList(@PathVariable(value = "cartId") String cartId, Model model) {
        Cart cart = cartService.validateCart(cartId);

        // 새 주문 생성
        Order o = new Order();
        o.setCustomer(new Customer());
        o.setShipping(new Shipping());
        if (o.getShipping().getAddress() == null) {
            o.getShipping().setAddress(new Address());
        }

        List<Book> books = new ArrayList<>();
        for (CartItem item : cart.getCartItems().values()) {
            Book book = item.getBook();
            books.add(book);

            OrderItem orderItem = new OrderItem();
            orderItem.setBookId(book.getBookId());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setTotalPrice(item.getTotalPrice());

            o.getOrderItems().put(book.getBookId(), orderItem);
        }
        o.setGrandTotal(cart.getGrandTotal());

        // 세션 보관 (컨트롤러 필드 대신 세션 사용)
        session().setAttribute("order", o);
        session().setAttribute("bookList", books);

        return "redirect:/order/orderCustomerInfo";
    }

    @GetMapping("/orderCustomerInfo")
    public String requestCustomerInfoForm(Model model) {
        Order o = getOrInitOrderInSession();
        model.addAttribute("customer", o.getCustomer());
        return "orderCustomerInfo";
    }

    @PostMapping("/orderCustomerInfo")
    public String requestCustomerInfo(@ModelAttribute Customer customer, Model model) {
        Order o = getOrInitOrderInSession();
        o.setCustomer(customer);
        session().setAttribute("order", o);
        return "redirect:/order/orderShippingInfo";
    }

    @GetMapping("/orderShippingInfo")
    public String requestShippingInfoForm(Model model) {
        Order o = getOrInitOrderInSession();
        if (o.getShipping().getAddress() == null) {
            o.getShipping().setAddress(new Address());
        }
        model.addAttribute("shipping", o.getShipping());
        return "orderShippingInfo";
    }

    @PostMapping("/orderShippingInfo")
    public String requestShippingInfo(@Valid @ModelAttribute Shipping shipping,
                                      BindingResult bindingResult,
                                      Model model) {
        if (bindingResult.hasErrors()) {
            return "orderShippingInfo";
        }
        if (shipping.getAddress() == null) {
            shipping.setAddress(new Address());
        }
        Order o = getOrInitOrderInSession();
        o.setShipping(shipping);
        session().setAttribute("order", o);
        model.addAttribute("order", o);
        return "redirect:/order/orderConfirmation";
    }

    @GetMapping("/orderConfirmation")
    public String requestConfirmation(Model model) {
        Order o = getOrInitOrderInSession();
        @SuppressWarnings("unchecked")
        List<Book> books = (List<Book>) session().getAttribute("bookList");
        if (books == null) books = new ArrayList<>();
        model.addAttribute("bookList", books);
        model.addAttribute("order", o);
        return "orderConfirmation";
    }



    @GetMapping("/orderFinished")
    public String requestFinished(HttpServletRequest request, Model model) {
        Order o = getOrInitOrderInSession();
        // 원래 코드 유지: 커스텀 저장 로직
        orderService.saveOrder(o);

        model.addAttribute("order", o);

        HttpSession s = request.getSession(false);
        if (s != null) {
            s.invalidate(); // 세션 정리
        }
        return "orderFinished";
    }

    @GetMapping("/orderCancelled")
    public String requestCancelled(HttpServletRequest request) {
        HttpSession s = request.getSession(false);
        if (s != null) {
            s.invalidate();
        }
        return "orderCancelled";
    }

    @GetMapping("/orderConfirmation/finish")
    public String requestConfirmationFinished(Model model) {
        // 세션의 주문 정보 사용
        Order o = getOrInitOrderInSession();
        model.addAttribute("order", o);
        // 실제 저장 처리는 /order/orderFinished 에서 수행
        return "redirect:/order/orderFinished";
    }

    @GetMapping("/list")
    public String viewHomePage(Model model) {
        return viewPage(1,"orderId","asc",model);
    }

    @GetMapping("/page")
    public String viewPage(@RequestParam("pageNum") int pageNum,@RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir, Model model) {
        Page<Order> page=orderProService.listAll(pageNum,sortField,sortDir);
        List<Order> listOrders = page.getContent();
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc")?"desc":"asc");
        model.addAttribute("orderList", listOrders);
        return "orderList";
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewOder(@PathVariable(value = "id") Long id) {
        Order order=orderProService.get(id);
        List<Book> listOfBook=new ArrayList<Book>();
        for (OrderItem orderItem:order.getOrderItems().values()){
           String bookId=orderItem.getBookId();
           Book book=bookService.getBookById(bookId);
           listOfBook.add(book);
        }
        ModelAndView modelAndView=new ModelAndView("orderview");
        modelAndView.addObject("order",order);
        modelAndView.addObject("bookList",listOfBook);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditOder(@PathVariable(value = "id") Long id) {
        Order order=orderProService.get(id);
        List<Book> listofBooks=new ArrayList<Book>();
        for(OrderItem orderItem:order.getOrderItems().values()){
            String bookId=orderItem.getBookId();
            Book book=bookService.getBookById(bookId);
            listofBooks.add(book);
        }
        ModelAndView modelAndView=new ModelAndView("orderedit");
        modelAndView.addObject("order",order);
        modelAndView.addObject("bookList",listofBooks);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable(value = "id") Long id) {
        orderProService.delete(id);
        return "redirect:/order/list";
    }

    @GetMapping("/deleteAll")
    public String deleteAll() {
        orderProService.deleteAll();
        return "redirect:/order/list";
    }

    @GetMapping("/save")
    public String saveProduct(@ModelAttribute Order order) {
        Order saveOrder=orderProService.get(order.getOrderId());
        saveOrder.setShipping(order.getShipping());
        orderProService.save(saveOrder);
        return "redirect:/order/list";
    }
}
