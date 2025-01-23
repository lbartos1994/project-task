package pl.poznan.demo.service;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.poznan.demo.domain.Task;

import java.time.LocalDate;

@Service
public class TaskSpecificationService {

    Specification<Task> hasStatus(String status) {
        return (root, query, criteriaBuilder) ->
                status == null ? null : criteriaBuilder.equal(root.get("taskStatus"), status);
    }

    Specification<Task> hasPriority(String priority) {
        return (root, query, criteriaBuilder) ->
                priority == null ? null : criteriaBuilder.equal(root.get("taskPriority"), priority);
    }

    Specification<Task> hasDueDate(LocalDate dueDate) {
        return (root, query, criteriaBuilder) ->
                dueDate == null ? null : criteriaBuilder.equal(root.get("dueDate"), dueDate);
    }
}
