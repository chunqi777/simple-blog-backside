package com.blog.simpleblog.service;

import com.blog.simpleblog.MyConfig.ExceptionEnum;
import com.blog.simpleblog.common.ResultResponse;
import com.blog.simpleblog.entity.Paper;
import com.blog.simpleblog.mapper.PaperMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminService {

    @Resource
    private PaperMapper paperMapper;

    public ResultResponse insertOne(Paper paper) {
        try {
            if (paper.getContent() == null) {
                throw new Exception();
            }

            paperMapper.insert(paper);

            return ResultResponse.success();
        } catch (Exception e) {
            return ResultResponse.error(ExceptionEnum.INTERNAL_SERVER_ERROR);
        }
    }
}
