package om.healthmate.javaproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }


    @RequestMapping({
        "/s_experiences",
    })
    public String s_exper(){
        return "pages/s_experiences"; 
    }
    @GetMapping("/page_s_1")
    public String pageS1() {
        return "pages/page_s_1";
    }
    @GetMapping("/page_s_2")
    public String pageS2() {
        return "pages/page_s_2";
    }
    @GetMapping("/page_s_3")
    public String pageS3() {
        return "pages/page_s_3";
    }
    @GetMapping("/page_s_4")
    public String pageS4() {
        return "pages/page_s_4";
    }
    @GetMapping("/page_s_5")
    public String pageS5() {
        return "pages/page_s_5";
    }


    
    @GetMapping("/health-records")
    public String healthRecords(){
        return "pages/health-records"; 
    }

    //@GetMapping("/appointment-booking")
    //public String appointmentBooking() {
    //    return "pages/appointment-booking";
    //}

    @GetMapping("/bac-si-noi-bat")
    public String showDoctorsPage() {
        return "pages/doctors/doctorsListing";
    }
    @GetMapping("/bac-si-noi-bat/trang-2")
    public String showDoctorsPage2() {
        return "pages/doctors/doctorsListing2"; 
}
}