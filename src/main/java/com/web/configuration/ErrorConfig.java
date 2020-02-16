package com.web.configuration;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorConfig implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
    @Override
    public void customize(ConfigurableServletWebServerFactory  factory) {
        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/pages/errors/404"));
        factory.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/pages/errors/403"));
        factory.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/pages/errors/500"));
    }
}
