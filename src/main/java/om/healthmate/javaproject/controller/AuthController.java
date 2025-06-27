package om.healthmate.javaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import om.healthmate.javaproject.entity.User;
import om.healthmate.javaproject.service.UserService;


@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestParam String name, @RequestParam String email, @RequestParam String password, Model model, HttpSession session) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        userService.register(user);
        session.setAttribute("userName", user.getName());
        session.setAttribute("userEmail", user.getEmail()); // Thêm dòng này
        session.setAttribute("role", "USER");
        return "redirect:/";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        // Đăng nhập admin cứng
        if (email.equals("admin@gmail.com") && password.equals("12345")) {
            session.setAttribute("userName", "Admin");
            session.setAttribute("userEmail", "admin@gmail.com"); // Thêm dòng này cho admin
            session.setAttribute("role", "ADMIN");
            return "redirect:/dashboard";
        }
        User user = userService.login(email, password);
        if (user != null) {
            session.setAttribute("userName", user.getName());
            session.setAttribute("userEmail", user.getEmail()); // Thêm dòng này
            session.setAttribute("role", "USER");
            return "redirect:/";
        }
        model.addAttribute("error", "Sai thông tin đăng nhập!");
        return "redirect:/#login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/hiemmuon")
    public String hiemmuonPage() {
        return "pages/hiemmuon";
    }
} 