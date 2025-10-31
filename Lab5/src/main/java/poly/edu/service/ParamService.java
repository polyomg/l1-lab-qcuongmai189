package poly.edu.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class ParamService {
    @Autowired
    HttpServletRequest request;

    // Đọc chuỗi
    public String getString(String name, String defaultValue) {
        String value = request.getParameter(name);
        return (value != null) ? value : defaultValue;
    }

    // Đọc số nguyên
    public int getInt(String name, int defaultValue) {
        try {
            return Integer.parseInt(request.getParameter(name));
        } catch (Exception e) {
            return defaultValue;
        }
    }

    // Đọc số thực
    public double getDouble(String name, double defaultValue) {
        try {
            return Double.parseDouble(request.getParameter(name));
        } catch (Exception e) {
            return defaultValue;
        }
    }

    // Đọc boolean
    public boolean getBoolean(String name, boolean defaultValue) {
        try {
            String value = request.getParameter(name);
            return (value != null) ? Boolean.parseBoolean(value) : defaultValue;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    // Đọc ngày tháng
    public Date getDate(String name, String pattern) {
        try {
            String value = request.getParameter(name);
            if (value == null || value.isEmpty()) return null;
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(value);
        } catch (Exception e) {
            throw new RuntimeException("Sai định dạng ngày: " + e.getMessage());
        }
    }

    // Lưu file upload
    public File save(MultipartFile file, String path) {
        if (file == null || file.isEmpty()) return null;
        try {
            // Lấy đường dẫn tuyệt đối từ webroot
            File dir = new File(request.getServletContext().getRealPath(path));
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File savedFile = new File(dir, file.getOriginalFilename());
            file.transferTo(savedFile);
            return savedFile;
        } catch (IOException e) {
            throw new RuntimeException("Lỗi khi lưu file: " + e.getMessage());
        }
    }
}

