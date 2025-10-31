package poly.edu.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import poly.edu.entity.Account;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String uri = request.getRequestURI();
        session.setAttribute("securityUri", uri);

        Account user = (Account) session.getAttribute("user");

        // Nếu chưa đăng nhập
        if (user == null) {
            session.setAttribute("message", "Bạn cần đăng nhập để truy cập trang này!");
            response.sendRedirect("/auth/login");
            return false;
        }

        // Nếu URI yêu cầu quyền admin
        if (uri.startsWith("/admin/") && !uri.equals("/admin/home/index")) {
            // Giả sử Account có field: boolean admin hoặc role
            // Kiểm tra quyền
            if (user.getRole() == null || !user.getRole().equalsIgnoreCase("ADMIN")) {
                session.setAttribute("message", "Bạn không có quyền truy cập trang quản trị!");
                response.sendRedirect("/auth/login");
                return false;
            }
        }

        return true;
    }
}
