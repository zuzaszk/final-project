package com.backend.zpi.controller;
import com.backend.zpi.entity.Element;
import com.backend.zpi.entity.Evaluation;
import com.backend.zpi.entity.Project;
import com.backend.zpi.entity.Users;
import com.backend.zpi.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/detail/{projectId}")
    public ResponseEntity<Map<String, Object>> searchProjectByID(@PathVariable("projectId") Integer projectId) {
        // Get basic project info
        Project project = projectService.getProjectByID(projectId);

        // Get project members
        List<Users> members = projectService.getProjectMembers(projectId);

        // Get evaluations/comments
        List<Evaluation> evaluations = projectService.getProjectEvaluations(projectId);

        // Get elements and their types
        List<Element> elements = projectService.getProjectElements(projectId);

        Map<String, Object> projectDetails = new HashMap<>();
        projectDetails.put("project", project);
        projectDetails.put("members", members);
        projectDetails.put("evaluations", evaluations);
        projectDetails.put("elements", elements);

        return ResponseEntity.ok(projectDetails);
    }




}
