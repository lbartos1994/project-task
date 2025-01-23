package pl.poznan.demo.dto;

import lombok.Builder;
import lombok.Data;
import pl.poznan.demo.domain.Project;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class ProjectDto {

    private Long id;

    private String name;

    private Set<TaskDto> tasks;

    public static ProjectDto fromEntity(Project project, boolean includeTasks) {
        final ProjectDto projectDto = ProjectDto
                .builder()
                .id(project.getId())
                .name(project.getName())
                .build();

        if (includeTasks) {
            projectDto.setTasks(project.getTasks().stream().map(TaskDto::fromEntity).collect(Collectors.toUnmodifiableSet()));
        }

        return projectDto;
    }
}
