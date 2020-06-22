package pl.recruitingWorkflowApp.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Data
@Entity
@Getter
@Setter
public class Process {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String position;

    private float maxSalary;

    private String location;

    private String technology;

    private int target;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @EqualsAndHashCode.Exclude
    private LocalDate date;

    private int candidatesInTheProcess;

    public Process() {
    }

    public Process(String position, float maxSalary, String location, String technology, int target, LocalDate date, int candidatesInTheProcess) {
        this.position = position;
        this.maxSalary = maxSalary;
        this.location = location;
        this.technology = technology;
        this.target = target;
        this.date = date;
        this.candidatesInTheProcess = candidatesInTheProcess;
    }
}