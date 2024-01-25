package com.blog.simpleblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@TableName("paper")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Paper {
    @TableId(value = "id", type = IdType.AUTO)
    private String id;
    private String title;
    private String type;
    private String date;
    private String content;
    private String imgName;
    private String imgUrl;
    private String description;
    private Integer view;
    private Integer status;


}
