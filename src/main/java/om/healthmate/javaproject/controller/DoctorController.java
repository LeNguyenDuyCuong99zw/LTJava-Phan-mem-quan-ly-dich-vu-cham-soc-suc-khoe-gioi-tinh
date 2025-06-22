package om.healthmate.javaproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard/doctors")
public class DoctorController {
    @GetMapping("")
    public String doctorPage(Model model) {
        model.addAttribute("title", "Quản lý bác sĩ");
        return "dashboard/doctor-layout";
    }
    // Có thể mở rộng thêm các route cho thêm/sửa/xóa bác sĩ
} 