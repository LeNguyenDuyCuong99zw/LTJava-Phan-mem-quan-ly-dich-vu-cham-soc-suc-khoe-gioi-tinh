package om.healthmate.javaproject.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogoutController {
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Xóa session
        return "redirect:/"; // Về trang chủ
    }
} 