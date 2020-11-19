package be.ifosup.boilerplate.controller.admin;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import be.ifosup.boilerplate.form.AdminForm;

/**
 * Admin controller
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String adminPage(Model model) {
        AdminForm adminForm = new AdminForm();
        adminForm.setEmail("lejes@actito.com");
        model.addAttribute("adminForm", adminForm);
        return "admin/index";
    }

    @PostMapping("/create")
    public String postAdminPage(Model model, @Valid AdminForm adminForm) {
        model.addAttribute("adminForm", adminForm);
        return "admin/index2";
    }
}
