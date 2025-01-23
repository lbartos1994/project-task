package pl.poznan.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.poznan.demo.domain.Project;
import pl.poznan.demo.domain.Task;
import pl.poznan.demo.domain.TaskPriority;
import pl.poznan.demo.domain.TaskStatus;
import pl.poznan.demo.repository.ProjectRepository;

import java.time.LocalDate;

@RequiredArgsConstructor
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    private final ProjectRepository projectRepository;

    @Override
    public void run(String... args) throws Exception {
        Project project = new Project();
        project.setName("Test Project");

        Task task1 = new Task();
        task1.setName("Task one");
        task1.setDescription("Task 1 Description");
        task1.setTaskStatus(TaskStatus.IN_PROGRESS);
        task1.setTaskPriority(TaskPriority.HIGH);
        task1.setDueDate(LocalDate.of(2025, 1, 30));
        task1.setProject(project);

        Task task2 = new Task();
        task2.setName("Task two");
        task2.setDescription("Task 2 Description");
        task2.setTaskStatus(TaskStatus.DONE);
        task2.setTaskPriority(TaskPriority.MEDIUM);
        task2.setDueDate(LocalDate.of(2028, 2, 15));
        task2.setProject(project);

        Task task3 = new Task();
        task3.setName("Task two");
        task3.setDescription("Task 3 Description");
        task3.setTaskStatus(TaskStatus.DONE);
        task3.setTaskPriority(TaskPriority.CRITICAL);
        task3.setDueDate(LocalDate.of(2025, 2, 15));
        task3.setProject(project);

        Task task4 = new Task();
        task4.setName("Task two");
        task4.setDescription("Task 4 Description");
        task4.setTaskStatus(TaskStatus.NEW);
        task4.setTaskPriority(TaskPriority.MEDIUM);
        task4.setDueDate(LocalDate.of(2027, 2, 15));
        task4.setProject(project);

        Task task5 = new Task();
        task5.setName("Task two");
        task5.setDescription("Task 5 Description");
        task5.setTaskStatus(TaskStatus.IN_PROGRESS);
        task5.setTaskPriority(TaskPriority.CRITICAL);
        task5.setDueDate(LocalDate.of(2026, 2, 15));
        task5.setProject(project);

        Task task6 = new Task();
        task6.setName("Task two");
        task6.setDescription("Task 6 Description");
        task6.setTaskStatus(TaskStatus.DONE);
        task6.setTaskPriority(TaskPriority.MEDIUM);
        task6.setDueDate(LocalDate.of(2026, 2, 15));
        task6.setProject(project);

        project.addTask(task1);
        project.addTask(task2);
        project.addTask(task3);
        project.addTask(task4);
        project.addTask(task5);
        project.addTask(task6);

        projectRepository.save(project);
    }
}
