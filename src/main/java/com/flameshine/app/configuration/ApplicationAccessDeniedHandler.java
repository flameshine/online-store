package com.flameshine.app.configuration;

import org.springframework.stereotype.Component;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import javax.servlet.http.*;
import java.io.IOException;

@Component
public class ApplicationAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException exception) throws IOException {
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/403");
    }
}