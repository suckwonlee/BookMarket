package kr.ac.Kopo.lsw.bookmarket.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceConfig implements WebMvcConfigurer {
    @Value("${file.uploadDir}")
    String fileDir;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println(fileDir);
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:///"+fileDir)
                .setCachePeriod(60*60*24*365);

    }
}
