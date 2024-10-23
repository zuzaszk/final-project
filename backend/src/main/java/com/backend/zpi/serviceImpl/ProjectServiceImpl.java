package com.backend.zpi.serviceImpl;

import com.backend.zpi.entity.Project;
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


    @Override
    public List<Project> listAll(String title, Integer year, Integer language) {
        return projectMapper.listAll(title, year, language);
    }

    @Override
    public List<Project> listAllProjects() {
        return projectMapper.listAllProjectsWithDetails();
    }


}