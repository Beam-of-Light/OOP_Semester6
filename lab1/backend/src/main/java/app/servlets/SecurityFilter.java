package app.servlets;

import app.entities.UserAccount;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class SecurityFilter implements Filter {

    public SecurityFilter() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String servletPath = request.getServletPath();

        if (servletPath.equals("/login") || request.getMethod().equals("OPTIONS")) {
            chain.doFilter(request, response);
            return;
        }

        UserAccount loggedInUser = AppUtils.getLoggedInUser(request.getSession());

        HttpServletRequest wrapRequest = request;

        if (loggedInUser != null) {
            String userName = loggedInUser.getUsername();

            String role = loggedInUser.getRole();

            wrapRequest = new UserRoleRequestWrapper(userName, role, request);
        }


        if (loggedInUser == null) {
            return;
        }

        boolean hasPermission = SecurityUtils.hasPermission(wrapRequest);
        if (!hasPermission) {
            return;
        }
        chain.doFilter(wrapRequest, response);
    }

    @Override
    public void init(FilterConfig fConfig) {

    }

}