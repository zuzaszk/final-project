package com.backend.zpi.service;

import com.backend.zpi.entity.Element;
import com.backend.zpi.entity.Evaluation;
import com.backend.zpi.entity.Project;
import com.backend.zpi.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Service
 * </p>
 *
 * @author yl
 * @since 2024-10-22
 */
public interface IProjectService extends IService<Project> {

    List<Project> listAll(String title, Integer year, Integer language);

    Project getProjectByID(@Param("projectId") Integer projectID);

    //Get members (users) with their roles by projectID
    List<Users> getProjectMembers(@Param("projectId") Integer projectId);

    // Get elements and their element types
    List<Element> getProjectElements(@Param("projectId") Integer projectId);

    // Service method to get evaluations/comments of a project
    List<Evaluation> getProjectEvaluations(@Param("projectId") Integer projectId);




}
