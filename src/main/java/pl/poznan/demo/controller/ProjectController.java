package pl.poznan.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.poznan.demo.dto.ProjectDto;
import pl.poznan.demo.service.ProjectService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/projects")
public class ProjectController extends BaseRestController {

    private final ProjectService projectService;

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectDto> getProject(@PathVariable Long projectId) {
        return execute(projectService::findById, projectId);
    }

    @GetMapping
    public ResponseEntity<Page<ProjectDto>> getAllProjects(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return execute(projectService::findAllProjects, PageRequest.of(page, size));
    }
}