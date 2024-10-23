package edu.pwr.zpi.controller;

import edu.pwr.zpi.entity.Project;
import edu.pwr.zpi.mapper.ProjectMapper;
import edu.pwr.zpi.service.IProjectService;
import edu.pwr.zpi.util.ResultUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  Project Controller
 * </p>
 *
 * @author yl
 * @since 2024-10-22
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private IProjectService projectService;


    @GetMapping("/listAll")
    public ResponseEntity<List<Project>> listAll(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer language) {
        List<Project> projects = projectService.listAll(title,year,language);
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/listDetails")
    public ResponseEntity<List<Project>> listAllProjects() {
        List<Project> projects = projectService.listAllProjects();
        return ResponseEntity.ok(projects);
    }


}
