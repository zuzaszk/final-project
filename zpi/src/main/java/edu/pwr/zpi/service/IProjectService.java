package edu.pwr.zpi.service;

import edu.pwr.zpi.entity.Project;
import com.baomidou.mybatisplus.extension.service.IService;

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

    List<Project> listAllProjects();


}
