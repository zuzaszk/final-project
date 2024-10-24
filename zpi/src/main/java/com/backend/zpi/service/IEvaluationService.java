package com.backend.zpi.service;

import com.backend.zpi.entity.Evaluation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yl
 * @since 2024-10-24
 */
public interface IEvaluationService extends IService<Evaluation> {

    void addComment(Evaluation evaluation);

}
