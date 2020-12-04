package com.flameshine.app.configuration;

import java.io.IOException;

import javax.servlet.http.*;

import org.springframework.stereotype.Component;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * @author Anton Pokhyla
 */

@Component
public class ApplicationAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException exception) throws IOException {
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/403");
    }
}