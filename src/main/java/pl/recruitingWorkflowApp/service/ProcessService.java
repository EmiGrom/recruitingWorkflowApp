package pl.recruitingWorkflowApp.service;


import pl.recruitingWorkflowApp.model.Process;
import pl.recruitingWorkflowApp.repository.ProcessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProcessService {

    private final ProcessRepository repository;

    public List<Process> getAll() {
        return repository.findAll().stream().collect(Collectors.toList());
    }

    public void save(Process process) {
        repository.save(process);
    }

    public void delete(Process process) {
        repository.delete(process);
    }
}

