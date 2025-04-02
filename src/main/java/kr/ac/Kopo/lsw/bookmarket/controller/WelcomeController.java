package kr.ac.Kopo.lsw.bookmarket.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String welcomeMethod() {
        String welcomeHTML = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Welcome BookMarket</title>\n" +
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<svg xmlns=\"http://www.w3.org/2000/svg\" class=\"d-none\">\n" +
                "    <symbol id=\"check2\" viewBox=\"0 0 16 16\">\n" +
                "        <path d=\"M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z\"/>\n" +
                "    </symbol>\n" +
                "    <symbol id=\"circle-half\" viewBox=\"0 0 16 16\">\n" +
                "        <path d=\"M8 15A7 7 0 1 0 8 1v14zm0 1A8 8 0 1 1 8 0a8 8 0 0 1 0 16z\"/>\n" +
                "    </symbol>\n" +
                "    <symbol id=\"moon-stars-fill\" viewBox=\"0 0 16 16\">\n" +
                "        <path d=\"M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278z\"/>\n" +
                "        <path d=\"M10.794 3.148a.217.217 0 0 1 .412 0l.387 1.162c.173.518.579.924 1.097 1.097l1.162.387a.217.217 0 0 1 0 .412l-1.162.387a1.734 1.734 0 0 0-1.097 1.097l-.387 1.162a.217.217 0 0 1-.412 0l-.387-1.162A1.734 1.734 0 0 0 9.31 6.593l-1.162-.387a.217.217 0 0 1 0-.412l1.162-.387a1.734 1.734 0 0 0 1.097-1.097l.387-1.162zM13.863.099a.145.145 0 0 1 .274 0l.258.774c.115.346.386.617.732.732l.774.258a.145.145 0 0 1 0 .274l-.774.258a1.156 1.156 0 0 0-.732.732l-.258.774a.145.145 0 0 1-.274 0l-.258-.774a1.156 1.156 0 0 0-.732-.732l-.774-.258a.145.145 0 0 1 0-.274l.774-.258c.346-.115.617-.386.732-.732L13.863.1z\"/>\n" +
                "    </symbol>\n" +
                "    <symbol id=\"sun-fill\" viewBox=\"0 0 16 16\">\n" +
                "        <path d=\"M8 12a4 4 0 1 0 0-8 4 4 0 0 0 0 8zM8 0a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 0zm0 13a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 13zm8-5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2a.5.5 0 0 1 .5.5zM3 8a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2A.5.5 0 0 1 3 8zm10.657-5.657a.5.5 0 0 1 0 .707l-1.414 1.415a.5.5 0 1 1-.707-.708l1.414-1.414a.5.5 0 0 1 .707 0zm-9.193 9.193a.5.5 0 0 1 0 .707L3.05 13.657a.5.5 0 0 1-.707-.707l1.414-1.414a.5.5 0 0 1 .707 0zm9.193 2.121a.5.5 0 0 1-.707 0l-1.414-1.414a.5.5 0 0 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .707zM4.464 4.465a.5.5 0 0 1-.707 0L2.343 3.05a.5.5 0 1 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .708z\"/>\n" +
                "    </symbol>\n" +
                "</svg>\n" +
                "\n" +
                "<div class=\"dropdown position-fixed bottom-0 end-0 mb-3 me-3 bd-mode-toggle\">\n" +
                "    <button class=\"btn btn-bd-primary py-2 dropdown-toggle d-flex align-items-center\"\n" +
                "            id=\"bd-theme\"\n" +
                "            type=\"button\"\n" +
                "            aria-expanded=\"false\"\n" +
                "            data-bs-toggle=\"dropdown\"\n" +
                "            aria-label=\"Toggle theme (auto)\">\n" +
                "        <svg class=\"bi my-1 theme-icon-active\" width=\"1em\" height=\"1em\"><use href=\"#circle-half\"></use></svg>\n" +
                "        <span class=\"visually-hidden\" id=\"bd-theme-text\">Toggle theme</span>\n" +
                "    </button>\n" +
                "    <ul class=\"dropdown-menu dropdown-menu-end shadow\" aria-labelledby=\"bd-theme-text\">\n" +
                "        <li>\n" +
                "            <button type=\"button\" class=\"dropdown-item d-flex align-items-center\" data-bs-theme-value=\"light\" aria-pressed=\"false\">\n" +
                "                <svg class=\"bi me-2 opacity-50\" width=\"1em\" height=\"1em\"><use href=\"#sun-fill\"></use></svg>\n" +
                "                Light\n" +
                "                <svg class=\"bi ms-auto d-none\" width=\"1em\" height=\"1em\"><use href=\"#check2\"></use></svg>\n" +
                "            </button>\n" +
                "        </li>\n" +
                "        <li>\n" +
                "            <button type=\"button\" class=\"dropdown-item d-flex align-items-center\" data-bs-theme-value=\"dark\" aria-pressed=\"false\">\n" +
                "                <svg class=\"bi me-2 opacity-50\" width=\"1em\" height=\"1em\"><use href=\"#moon-stars-fill\"></use></svg>\n" +
                "                Dark\n" +
                "                <svg class=\"bi ms-auto d-none\" width=\"1em\" height=\"1em\"><use href=\"#check2\"></use></svg>\n" +
                "            </button>\n" +
                "        </li>\n" +
                "        <li>\n" +
                "            <button type=\"button\" class=\"dropdown-item d-flex align-items-center active\" data-bs-theme-value=\"auto\" aria-pressed=\"true\">\n" +
                "                <svg class=\"bi me-2 opacity-50\" width=\"1em\" height=\"1em\"><use href=\"#circle-half\"></use></svg>\n" +
                "                Auto\n" +
                "                <svg class=\"bi ms-auto d-none\" width=\"1em\" height=\"1em\"><use href=\"#check2\"></use></svg>\n" +
                "            </button>\n" +
                "        </li>\n" +
                "    </ul>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "<main>\n" +
                "    <div class=\"container py-4\">\n" +
                "        <header class=\"pb-3 mb-4 border-bottom\">\n" +
                "            <a href=\"/\" class=\"d-flex align-items-center text-body-emphasis text-decoration-none\">\n" +
                "                <?xml version=\"1.0\" encoding=\"utf-8\"?><!-- Uploaded to: SVG Repo, www.svgrepo.com, Generator: SVG Repo Mixer Tools -->\n" +
                "                <svg fill=\"#000000\" width=\"32px\" height=\"32px\" viewBox=\"0 0 14 14\" role=\"img\" focusable=\"false\" aria-hidden=\"true\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M 6.55466,11.542 C 6.10897,11.0187 5.36501,10.459 4.6445,10.1049 3.91698,9.7473 3.22595,9.5487 2.44138,9.4719 2.28669,9.4569 2.15844,9.4429 2.15639,9.4409 c -0.002,0 0.002,-1.6151 0.01,-3.5846 l 0.0132,-3.5808 0.14284,0.014 c 0.87708,0.087 1.85601,0.4184 2.59669,0.8803 0.63833,0.398 1.29749,1.0126 1.71774,1.6015 l 0.10576,0.1482 0,3.4014 c 0,1.8707 -0.008,3.401 -0.0176,3.4007 -0.01,-3e-4 -0.0861,-0.081 -0.16992,-0.1794 z m 0.72656,-3.2297 0,-3.4156 0.20424,-0.2729 C 7.74623,4.2754 8.27075,3.7505 8.61758,3.491 9.54472,2.7971 10.55044,2.405 11.70505,2.287 l 0.14648,-0.015 0,3.5858 0,3.5859 -0.16992,0.016 C 10.0739,9.6093 8.6801,10.2726 7.5899,11.4068 l -0.30868,0.3212 0,-3.4156 z m 0.9961,3.1835 c 0.63101,-0.592 1.46635,-1.0624 2.30546,-1.2985 0.4391,-0.1235 1.01012,-0.2097 1.38918,-0.2097 0.19874,0 0.30898,-0.043 0.37116,-0.1451 0.0468,-0.077 0.0473,-0.1101 0.0474,-3.0157 l 8e-5,-2.9382 0.0879,0.016 c 0.0483,0.01 0.18544,0.048 0.30468,0.086 l 0.2168,0.069 0,3.6669 c 0,2.0168 -0.008,3.6669 -0.0179,3.6669 -0.01,0 -0.15489,-0.031 -0.32227,-0.069 -0.66143,-0.149 -1.20614,-0.2002 -1.92152,-0.1809 -0.86772,0.024 -1.54209,0.145 -2.34375,0.422 l -0.30469,0.1053 0.1875,-0.1759 z m -2.67188,0.057 C 5.27252,11.4336 4.7227,11.2931 4.35153,11.2325 c -0.50468,-0.082 -0.85286,-0.1038 -1.4714,-0.09 -0.61458,0.013 -0.98632,0.056 -1.49344,0.1711 -0.1418,0.032 -0.28682,0.065 -0.32227,0.072 l -0.0644,0.014 1.1e-4,-3.6767 1.2e-4,-3.6768 0.27529,-0.08 c 0.1514,-0.044 0.28847,-0.085 0.30458,-0.09 0.0233,-0.01 0.0293,0.589 0.0293,2.9349 0,3.2057 -0.007,3.027 0.12978,3.1169 0.0476,0.031 0.1465,0.045 0.42893,0.062 1.12246,0.064 2.18752,0.4409 3.05702,1.0822 0.1875,0.1383 0.63749,0.5181 0.66328,0.5598 0.018,0.029 0.006,0.026 -0.28292,-0.078 z\"/></svg>\n" +
                "                <span class=\"fs-4\">&nbsp; BookMarKet</span>\n" +
                "            </a>\n" +
                "        </header>\n" +
                "\n" +
                "        <div class=\"p-5 mb-4 bg-body-tertiary rounded-3\">\n" +
                "            <div class=\"container-fluid py-5\">\n" +
                "                <h1 class=\"display-5 fw-bold\">도서 쇼핑몰에 오신것을 환영합니다.</h1>\n" +
                "                <p class=\"col-md-8 fs-4\">BookMarket</p>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class=\"row align-items-md-stretch text-center\">\n" +
                "            <div class=\"col-md-12\">\n" +
                "                <div class=\"h-100 p-5 text-bg-dark rounded-3\">\n" +
                "                    <h2>Welcome to WebMarket</h2>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "        <footer class=\"pt-3 mt-4 text-body-secondary border-top\">\n" +
                "            <span class=\"text-body-secondary\"> &copy; BookMarket 2025</span>\n" +
                "        </footer>\n" +
                "    </div>\n" +
                "</main>\n" +
                "<script src=\"../assets/dist/js/bootstrap.bundle.min.js\"></script>\n" +
                "\n" +
                "</body>\n" +
                "</html>";

        return welcomeHTML;
    }
}
