package pl.poznan.demo.dto;

import lombok.Builder;
import lombok.Data;
import pl.poznan.demo.domain.TaskPriority;
import pl.poznan.demo.domain.TaskStatus;

import java.time.LocalDate;

@Builder
@Data
public class NewTaskDto {
    private Long id;
    private Long projectId;
    private String name;
    private String description;
    private TaskStatus taskStatus;
    private TaskPriority taskPriority;
    private LocalDate dueDate;
}
