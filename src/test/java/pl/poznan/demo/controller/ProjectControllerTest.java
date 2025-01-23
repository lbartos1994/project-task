package pl.poznan.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import pl.poznan.demo.domain.Project;
import pl.poznan.demo.domain.Task;
import pl.poznan.demo.domain.TaskPriority;
import pl.poznan.demo.domain.TaskStatus;
import pl.poznan.demo.repository.ProjectRepository;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProjectRepository projectRepository;

    private final String testName = "test project";

    @BeforeEach
    public void setUp() {
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
        task2.setDueDate(LocalDate.of(2025, 2, 15));
        task2.setProject(project);

        project.addTask(task1);
        project.addTask(task2);

        projectRepository.save(project);
    }

    @Test
    void shouldReturnProjectWhenProjectExist() throws Exception {
        Long projectId = 1L;

        mockMvc.perform(get("/projects/{projectId}", projectId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(projectId))
                .andExpect(jsonPath("$.name").value(testName));
    }

    @Test
    void shouldHaveSavedProjectAndTasks() {
        Project project = projectRepository.findById(1L).orElseThrow();
        assert project.getName().equals(testName);
        assert project.getTasks().size() == 2;
    }
}