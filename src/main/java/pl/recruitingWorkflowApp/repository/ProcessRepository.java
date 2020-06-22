package pl.recruitingWorkflowApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.recruitingWorkflowApp.model.Process;

@Repository
public interface ProcessRepository extends JpaRepository<Process, Integer> {
}
