package com.backend.zpi.controller;

import com.backend.zpi.entity.Evaluation;
import com.backend.zpi.service.IEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yl
 * @since 2024-10-24
 */
@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

    @Autowired
    private IEvaluationService evaluationService;

    @PostMapping("/add")
    public ResponseEntity<String> addComment(@RequestParam Integer projectId,
                                             @RequestParam Integer userId,
                                             @RequestParam String comment,
                                             @RequestParam(required = false) BigDecimal score) {
        Evaluation evaluation = new Evaluation();
        evaluation.setProjectId(projectId);
        evaluation.setUserId(userId);
        evaluation.setComment(comment);
        evaluation.setScore(score);
        evaluation.setIsPublic(false);
        evaluationService.addComment(evaluation);
        return ResponseEntity.ok("Comment added successfully");
    }

}
