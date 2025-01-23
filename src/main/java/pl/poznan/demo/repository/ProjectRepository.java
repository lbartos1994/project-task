package pl.poznan.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.poznan.demo.domain.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
