package pl.poznan.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/{projectId}")
    public Project getProject(@PathVariable Long projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }

    @PostMapping("/{projectId}/tasks")
    public void addTask(@PathVariable Long projectId, @RequestBody Task task) {
        Project project = projectRepository.findById(projectId).orElse(null);
        if (project != null) {
            project.getTasks().add(task);
            projectRepository.save(project);
        }
    }
}