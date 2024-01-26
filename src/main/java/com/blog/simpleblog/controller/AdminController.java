package com.blog.simpleblog.controller;

import com.blog.simpleblog.common.ResultResponse;
import com.blog.simpleblog.entity.Paper;
import com.blog.simpleblog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/add")
    public ResultResponse addPaper(@RequestBody Paper paper) {
        return adminService.insertOne(paper);
    }


}
