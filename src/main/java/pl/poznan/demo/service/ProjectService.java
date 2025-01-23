package pl.poznan.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pl.poznan.demo.domain.Project;
import pl.poznan.demo.dto.ProjectDto;
import pl.poznan.demo.exception.GenericApplicationException;
import pl.poznan.demo.repository.ProjectRepository;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectDto findById(final Long projectId) {
        final Optional<Project> projectById = projectRepository.findById(projectId);
        return projectById
                .map(project -> ProjectDto.fromEntity(project, true))
                .orElseThrow(() -> new GenericApplicationException("Project not found", HttpStatus.NOT_FOUND));
    }

    public Page<ProjectDto> findAllProjects(final Pageable pageable) {
        return projectRepository.findAll(pageable).map(project -> ProjectDto.fromEntity(project, true));
    }
}
