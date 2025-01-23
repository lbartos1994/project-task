package pl.poznan.demo.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

@Builder
@Getter
public class TaskFilterCriteria {
    private Pageable pageable;
    private String status;
    private String priority;
    private LocalDate dueDate;
}
