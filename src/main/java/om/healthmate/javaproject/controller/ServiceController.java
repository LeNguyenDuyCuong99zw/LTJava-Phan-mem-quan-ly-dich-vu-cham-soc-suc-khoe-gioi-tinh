package om.healthmate.javaproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard/services")
public class ServiceController {
    @GetMapping("")
    public String servicePage(Model model) {
        model.addAttribute("title", "Quản lý dịch vụ");
        return "dashboard/service-layout";
    }
    // Có thể mở rộng thêm các route cho thêm/sửa/xóa dịch vụ
} 