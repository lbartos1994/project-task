package pl.poznan.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.poznan.demo.dto.NewTaskDto;
import pl.poznan.demo.dto.ProjectDto;
import pl.poznan.demo.dto.TaskDto;
import pl.poznan.demo.dto.TaskFilterCriteria;
import pl.poznan.demo.service.TaskService;

import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tasks")
public class TaskController extends BaseRestController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<ProjectDto> addTask(@RequestBody NewTaskDto newTaskDto) {
        return execute(taskService::addTask, newTaskDto);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Long> removeTask(@PathVariable final Long taskId) {
        return execute(taskService::removeTask, taskId);
    }

    @GetMapping
    public ResponseEntity<Page<TaskDto>> getTasks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "dueDate") String sortField,
            @RequestParam(defaultValue = "asc") String sortDirection,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String priority,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dueDate
    ) {
        final Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortField);
        final Pageable pageable = PageRequest.of(page, size, sort);
        final TaskFilterCriteria taskFilterCriteria = TaskFilterCriteria
                .builder()
                .pageable(pageable)
                .status(status)
                .priority(priority)
                .dueDate(dueDate)
                .build();
        return execute(taskService::findAllTasksByFilters, taskFilterCriteria);
    }
}
