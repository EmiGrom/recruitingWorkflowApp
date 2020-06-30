package pl.recruitingWorkflowApp.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@Entity
@Getter
@Setter
public class Process {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    private String position;

    @NotNull
    @Min(value = 1800)
    private float maxSalary;

    @NotEmpty
    private String location;

    @NotEmpty
    private String technology;

    @NotNull
    @Min(value = 1)
    private int target;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String date;

    @Min(value = 0)
    private int candidatesInTheProcess;

    public Process() {
    }

    public Process(String position, float maxSalary, String location, String technology, int target, String date, int candidatesInTheProcess) {
        this.position = position;
        this.maxSalary = maxSalary;
        this.location = location;
        this.technology = technology;
        this.target = target;
        this.date = date;
        this.candidatesInTheProcess = candidatesInTheProcess;
    }
}