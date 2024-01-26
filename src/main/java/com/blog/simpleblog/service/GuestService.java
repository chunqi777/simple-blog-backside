package com.blog.simpleblog.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

    public ResultResponse selectType() {
        try {
            List<Paper> type = paperMapper.selectList(new QueryWrapper<Paper>().select("distinct type"));

            return ResultResponse.success(type);
        } catch (Exception e) {
            return ResultResponse.error(ExceptionEnum.INTERNAL_SERVER_ERROR);
        }
    }

    public ResultResponse selectListByType(String selectType) {
        try {
            List<Paper> type = paperMapper.selectList(new QueryWrapper<Paper>().eq("type", selectType));

            return ResultResponse.success(type);
        } catch (Exception e) {
            return ResultResponse.error(ExceptionEnum.INTERNAL_SERVER_ERROR);
        }
    }

    public ResultResponse selectPaper(String type, String uid) {
        try {
            Paper paper = paperMapper.selectOne(new QueryWrapper<Paper>()
                    .select(Paper.class, info -> !info.getColumn().equals("description"))
                    .eq("type", type).eq("uid", uid));

            if (paper.getUid() == null) {
                throw new Exception("kong");
            }

            return ResultResponse.success(paper);
        } catch (Exception e) {
            return ResultResponse.error(ExceptionEnum.INTERNAL_SERVER_ERROR);
        }
    }
}
