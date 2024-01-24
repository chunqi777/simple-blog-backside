package com.blog.simpleblog.controller;

import com.blog.simpleblog.common.ResultResponse;
import com.blog.simpleblog.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guest")
public class GuestController {

    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping("/paperAll")
    public ResultResponse selectAll() {
        return guestService.allPaper();
    }
}
