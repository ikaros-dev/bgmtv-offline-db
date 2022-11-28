package run.ikaros.offlinedb.bgmtv.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@EnableWebMvc
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // register upload
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:///" + System.getProperty("user.dir")
                        + File.separatorChar + "upload" + File.separatorChar);
    }

}
