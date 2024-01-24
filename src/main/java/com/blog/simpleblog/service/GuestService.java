package com.blog.simpleblog.service;

import com.blog.simpleblog.MyConfig.ExceptionEnum;
import com.blog.simpleblog.common.ResultResponse;
import com.blog.simpleblog.entity.Paper;
import com.blog.simpleblog.mapper.PaperMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GuestService {

    @Resource
    private PaperMapper paperMapper;

    public ResultResponse allPaper() {
        try {
            List<Paper> papers = paperMapper.selectList(null);
            return ResultResponse.success(papers);
        } catch (Exception e) {
            return ResultResponse.error(ExceptionEnum.NOT_FOUND);
        }
    }
}
