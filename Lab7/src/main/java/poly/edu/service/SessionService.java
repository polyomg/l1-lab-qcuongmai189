package poly.edu.service;

import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SessionService {

    @Autowired
    HttpSession session;

    // Lưu vào session
    public <T> void set(String name, T value) {
        session.setAttribute(name, value);
    }

    // Đọc từ session
    @SuppressWarnings("unchecked")
    public <T> T get(String name, T defaultValue) {
        T value = (T) session.getAttribute(name);
        return value != null ? value : defaultValue;
    }

    // Xóa session
    public void remove(String name) {
        session.removeAttribute(name);
    }
}
