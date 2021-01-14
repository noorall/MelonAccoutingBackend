package com.nwpu.melonbookkeeping.controller.admin;

import com.nwpu.melonbookkeeping.entity.App;
import com.nwpu.melonbookkeeping.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author noorall
 * @date 2021/1/13 6:24 下午
 * @Description: app控制器
 */
@Controller
@RequestMapping("/admin/app")
public class AppController {
    @Autowired
    AppService appService;

    @RequestMapping({"/", "/index", ""})
    public String index(Model model) {
        model.addAttribute("appList", appService.getAllApp());
        return "admin/app/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(RedirectAttributes redirectAttributes, @PathVariable("id") int id) {
        if (appService.deleteAppById(id)) {
            redirectAttributes.addFlashAttribute("success", "删除成功！");
        } else {
            redirectAttributes.addFlashAttribute("error", "删除失败！");
        }
        return "redirect:/admin/app";
    }

    @GetMapping("/modify/{id}")
    public String modify(RedirectAttributes redirectAttributes, @PathVariable("id") int id) {
        if (appService.recallAppById(id)) {
            redirectAttributes.addFlashAttribute("success", "撤回成功！");
        } else {
            redirectAttributes.addFlashAttribute("error", "撤回失败！");
        }
        return "redirect:/admin/app";
    }

    @PostMapping("/add")
    public String modify(RedirectAttributes redirectAttributes, App app) {
        if (appService.saveApp(app)) {
            redirectAttributes.addFlashAttribute("success", "新增成功！");
        } else {
            redirectAttributes.addFlashAttribute("error", "新增失败！");
        }
        return "redirect:/admin/app";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("appVersion", appService.getNewestVersion());
        return "admin/app/add";
    }
}
