package ru.netology.springBootDemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.netology.springBootDemo.resolver.UserFromQueryResolver;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final UserFromQueryResolver resolver;

    public WebConfig(UserFromQueryResolver resolver) {
        this.resolver = resolver;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(resolver);
    }
}
