package com.zerobase.fastlms.admin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/banner")
public class AdminBannerController {
    @GetMapping("/lists.do")
    public String getLists(){
        return "admin/banner/list";
    }

    @GetMapping("/add.do")
    public String getAdd(){
        return "admin/banner/add";
    }
}
