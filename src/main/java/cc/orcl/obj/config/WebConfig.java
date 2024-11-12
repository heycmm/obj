package cc.orcl.obj.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author：czx.me 2024/7/19
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final LoggingInterceptor loggingInterceptor;

    public WebConfig(LoggingInterceptor loggingInterceptor) {
        this.loggingInterceptor = loggingInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingInterceptor);
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Handle static resources from classpath
        registry.addResourceHandler("/")
                .addResourceLocations("classpath:/public/");

        // Handle static resources from file system with a specific URL pattern
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:/data/share/halo-halo-po-pvc-9730df15-fd16-460c-ba6f-d7d073ac01e3/upload/");
    }
}