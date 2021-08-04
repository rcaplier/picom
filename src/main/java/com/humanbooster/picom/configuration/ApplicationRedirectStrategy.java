package com.humanbooster.picom.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.DefaultRedirectStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Configuration
public class ApplicationRedirectStrategy extends DefaultRedirectStrategy {

    @Override
    public void sendRedirect(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String s) throws IOException {
        String redirectUrl = "/public/error";
        logger.debug("Redirect to : " + redirectUrl + " instead of : " + httpServletRequest.getRequestURI());
        super.sendRedirect(httpServletRequest, httpServletResponse, redirectUrl);
    }
}
