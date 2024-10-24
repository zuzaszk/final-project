package com.backend.zpi.mapper;

import com.backend.zpi.entity.Evaluation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yl
 * @since 2024-10-24
 */
public interface EvaluationMapper extends BaseMapper<Evaluation> {

    //Get evaluations and who gave the evaluations
    List<Evaluation> getProjectEvaluations(@Param("projectId") Integer projectId);

    void insertEvaluation(Evaluation evaluation);


}
