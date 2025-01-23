package pl.poznan.demo.dto;

import lombok.Builder;
import lombok.Data;
import pl.poznan.demo.domain.Task;
import pl.poznan.demo.domain.TaskPriority;
import pl.poznan.demo.domain.TaskStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
public class TaskDto {

    private Long id;
    private String name;
    private String description;
    private TaskStatus taskStatus;
    private TaskPriority taskPriority;
    private LocalDate dueDate;
    private LocalDateTime createdAt;
    private ProjectDto projectDto;

    public static TaskDto fromEntity(Task task) {
        return TaskDto
                .builder()
                .id(task.getId())
                .name(task.getName())
                .description(task.getDescription())
                .taskStatus(task.getTaskStatus())
                .taskPriority(task.getTaskPriority())
                .dueDate(task.getDueDate())
                .createdAt(task.getCreatedAt())
                .projectDto(ProjectDto.fromEntity(task.getProject(), false))
                .build();
    }
}
