package com.backend.zpi.mapper;

import com.backend.zpi.entity.Project;
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

    List<Project> listAllProjectsWithDetails();




}
