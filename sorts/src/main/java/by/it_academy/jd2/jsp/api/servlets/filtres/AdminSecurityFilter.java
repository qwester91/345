package by.it_academy.jd2.jsp.api.servlets.filtres;

import by.it_academy.jd2.jsp.api.core.dto.Roles;
import by.it_academy.jd2.jsp.api.core.dto.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/ui/admin/*","/api/admin/*"})
public class AdminSecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }



    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if((session != null) && (user != null)){
            if(user.getRole().equals(Roles.ADMIN)){
            filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            resp.sendRedirect(contextPath + "/");

        }
    }

    @Override
    public void destroy() {

    }
}
