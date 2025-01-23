package pl.poznan.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pl.poznan.demo.dto.NewTaskDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Entity(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String name;

    @Setter
    private String description;

    @Setter
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    @Setter
    @Enumerated(EnumType.STRING)
    private TaskPriority taskPriority;

    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private Project project;

    @Setter
    private LocalDate dueDate;

    @Column(nullable = false, unique = true, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now().plusNanos(System.nanoTime());

    public Task() { }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return Objects.equals(createdAt, task.getCreatedAt()) && Objects.equals(name, task.getName()) && Objects.equals(description, task.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, name, description);
    }

    public static Task toTask(NewTaskDto newTaskDto) {
        Task task = new Task();
        task.setTaskStatus(newTaskDto.getTaskStatus());
        task.setName(newTaskDto.getName());
        task.setDescription(newTaskDto.getDescription());
        task.setTaskPriority(newTaskDto.getTaskPriority());
        task.setDueDate(newTaskDto.getDueDate());
        return task;
    }
}
