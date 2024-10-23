package com.backend.zpi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;


@Data
public class Element {

    private static final long serialVersionUID = 1L;

    @TableId(value = "element_id", type = IdType.AUTO)
    private Integer elementId;

    private Integer elementTypeId;

    private Integer projectId;

    private String filePath;

    private String description;

    private Timestamp createdAt;

}

