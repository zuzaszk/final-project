package com.backend.zpi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author yl
 * @since 2024-10-22
 */

@Data
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "project_id", type = IdType.AUTO)
    private Integer projectId;

    private String title;

    private String acronym;

    private String description;

    private Integer language;

    private Integer status;

    private LocalDateTime createdAt;

    private Boolean isArchived;

    private Integer year;

    private String technology;


    private List<Users> users;

    private List<Element> elements;


}
