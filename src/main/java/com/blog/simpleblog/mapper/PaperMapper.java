package com.blog.simpleblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.simpleblog.entity.Paper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaperMapper extends BaseMapper<Paper> {
}
