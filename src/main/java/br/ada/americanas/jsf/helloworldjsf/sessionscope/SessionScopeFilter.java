package br.ada.americanas.jsf.helloworldjsf.sessionscope;

import jakarta.enterprise.inject.spi.CDI;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.jboss.weld.context.bound.BoundSessionContext;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebFilter
public class SessionScopeFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain
    ) throws IOException, ServletException {
        BoundSessionContext context = CDI.current().select(BoundSessionContext.class).get();
        try {
            Map<String, Object> data = getSession((HttpServletRequest) servletRequest);
            context.associate(data);
            context.activate();
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            context.deactivate();
        }
    }

    private Map<String, Object> getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        Map<String, Object> data = (Map<String, Object>) session.getAttribute("data");
        if (data == null) {
            data = new HashMap<>();
            session.setAttribute("data", data);
        }
        return data;
    }

}
