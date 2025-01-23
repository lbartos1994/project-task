package pl.poznan.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.poznan.demo.domain.Project;
import pl.poznan.demo.domain.Task;
import pl.poznan.demo.dto.NewTaskDto;
import pl.poznan.demo.dto.ProjectDto;
import pl.poznan.demo.dto.TaskDto;
import pl.poznan.demo.dto.TaskFilterCriteria;
import pl.poznan.demo.exception.GenericApplicationException;
import pl.poznan.demo.repository.ProjectRepository;
import pl.poznan.demo.repository.TaskRepository;

import static java.util.Objects.nonNull;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    private final ProjectRepository projectRepository;

    private final TaskSpecificationService taskSpecificationService;

    @Transactional
    public Long removeTask(final Long taskId) {
        if (nonNull(taskId)) {
            taskRepository.deleteTaskById(taskId);
            return taskId;
        } else {
            throw new GenericApplicationException("Task id cannot be null", HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional
    public ProjectDto addTask(final NewTaskDto newTaskDto) {
        if (nonNull(newTaskDto.getProjectId())) {
            final Project projectById = projectRepository.findById(newTaskDto.getProjectId()).orElseThrow(() -> new GenericApplicationException("Project not found", HttpStatus.NOT_FOUND));
            // todo >> walidacja taskDto
            final Task task = Task.toTask(newTaskDto);
            projectById.addTask(task);
            projectRepository.save(projectById);
            return ProjectDto.fromEntity(projectById, true);
        } else {
            throw new GenericApplicationException("ProjectId variable not passed", HttpStatus.BAD_REQUEST);
        }
    }

    public Page<TaskDto> findAllTasksByFilters(final TaskFilterCriteria taskFilterCriteria) {
        final Specification<Task> specifications = Specification
                .where(taskSpecificationService.hasStatus(taskFilterCriteria.getStatus()))
                .and(taskSpecificationService.hasPriority(taskFilterCriteria.getPriority()))
                .and(taskSpecificationService.hasDueDate(taskFilterCriteria.getDueDate()));

        return taskRepository.findAll(specifications, taskFilterCriteria.getPageable()).map(TaskDto::fromEntity);
    }
}
