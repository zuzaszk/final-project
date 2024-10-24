package com.backend.zpi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author yl
 * @since 2024-10-24
 */


@Data
public class Evaluation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "evaluation_id", type = IdType.AUTO)
    private Integer evaluationId;

    private Integer projectId;

    private Integer userId;

    private BigDecimal score;

    private String comment;

    private Integer state;

    private Boolean isPublic;

    private LocalDateTime createdAt;


}
