package com.backend.zpi.serviceImpl;

import com.backend.zpi.entity.Evaluation;
import com.backend.zpi.mapper.EvaluationMapper;
import com.backend.zpi.service.IEvaluationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yl
 * @since 2024-10-24
 */
@Service
public class EvaluationServiceImpl extends ServiceImpl<EvaluationMapper, Evaluation> implements IEvaluationService {

    @Autowired
    private EvaluationMapper evaluationMapper;

    @Override
    public void addComment(Evaluation evaluation) {
        evaluationMapper.insertEvaluation(evaluation);
    }
}
