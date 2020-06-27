package pl.recruitingWorkflowApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.recruitingWorkflowApp.model.Process;
import pl.recruitingWorkflowApp.service.ProcessService;

import java.time.LocalDate;


@Component
//podstawowy stereotyp dla każdego z komponentów, którymi ma zarządzać Spring. Adnotacja ta jest równoważna z <bean>.Każdy inny stereotyp dziedziczy po @Component
public class ProcessInitializer implements CommandLineRunner {//CommandLineRunner to interfejs Spring Boot z metodą run.
    // Spring Boot automatycznie wywoła metodę uruchamiania wszystkich komponentów bean implementujących ten interfejs po załadowaniu kontekstu aplikacji

    @Autowired
    ProcessService processService;

    public void run(String... args) throws Exception {
        System.out.println("Starting initialize sample data...");
        processService.save(new Process(".NET Developer", 13000, "Poznań", ".NET/C#", 5, LocalDate.parse("2020-07-20"), 2));
        processService.save(new Process("Senior Java Developer", 18000, "Gdańsk", "Java", 4, LocalDate.parse("2020-06-15"), 1));
        processService.save(new Process("PHP Developer", 11000, "Warszawa", "PHP", 5, LocalDate.parse("2020-09-01"), 4));
        processService.save(new Process("Senior PHP Developer/Architect", 19000, "Warszawa", "PHP", 3, LocalDate.parse("2020-07-04"), 1));
        System.out.println("...finish initializing data");
        //przykładowych procesów nie da się edytować i usuwać
    }
}