package com.backend.zpi.serviceImpl;

import com.backend.zpi.entity.Element;
import com.backend.zpi.entity.Evaluation;
import com.backend.zpi.entity.Project;
import com.backend.zpi.entity.Users;
import com.backend.zpi.mapper.EvaluationMapper;
import com.backend.zpi.mapper.ProjectMapper;
import com.backend.zpi.service.IProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yl
 * @since 2024-10-22
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService {

    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private EvaluationMapper evaluationMapper;


    @Override
    public List<Project> listAll(String title, Integer year, Integer language) {
        return projectMapper.listAll(title, year, language);
    }

    @Override
    public Project getProjectByID(Integer projectId) {
        return projectMapper.getProjectByID(projectId);
    }

    @Override
    public List<Users> getProjectMembers(Integer projectId) {
        return projectMapper.getProjectMembers(projectId);
    }

    @Override
    public List<Evaluation> getProjectEvaluations(Integer projectId) {
        return evaluationMapper.getProjectEvaluations(projectId);
    }

    @Override
    public List<Element> getProjectElements(Integer projectId) {
        return projectMapper.getProjectElements(projectId);
    }


}