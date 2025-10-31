package poly.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class SessionService {
    @Autowired
    HttpSession session;

    // Lấy attribute
    @SuppressWarnings("unchecked")
    public <T> T get(String name) {
        return (T) session.getAttribute(name);
    }

    // Gán attribute
    public void set(String name, Object value) {
        session.setAttribute(name, value);
    }

    // Xóa attribute
    public void remove(String name) {
        session.removeAttribute(name);
    }
}