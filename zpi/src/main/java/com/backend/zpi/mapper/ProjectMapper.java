package com.backend.zpi.mapper;

import com.backend.zpi.entity.Element;
import com.backend.zpi.entity.Project;
import com.backend.zpi.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yl
 * @since 2024-10-22
 */

@Mapper
public interface ProjectMapper extends BaseMapper<Project> {

    List<Project> listAll(
            @Param("title") String title,
            @Param("year") Integer year,
            @Param("language") Integer language
    );

    Project getProjectByID(@Param("projectId") Integer projectID);

//    // Method to get project by id
//    Project getProjectById(@Param("projectId") Integer projectId);

    // Method to get members (users) with their roles
    List<Users> getProjectMembers(@Param("projectId") Integer projectId);


    // Method to get elements and their element types
    List<Element> getProjectElements(@Param("projectId") Integer projectId);




}
