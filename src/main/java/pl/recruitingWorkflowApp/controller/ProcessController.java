package pl.recruitingWorkflowApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.recruitingWorkflowApp.model.Process;
import pl.recruitingWorkflowApp.service.ProcessService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@Controller
public class ProcessController {

    @Autowired
    private ProcessService processService;

    private List<Process> processList = new ArrayList<>();

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/process_add", method = RequestMethod.GET)
    public String showform(Model model) {
        model.addAttribute("process", new Process());
        return "process_add";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@RequestParam(value = "process_id") int id) {
        return new ModelAndView("process_add", "process", getProcessViaId(id));
    }


    @RequestMapping(value = "/save_process", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute(value = "process") Process process) throws IOException {
        if (process.getId() == 0) {
            processService.save(process);
            processList.add(process);
        } else {
            Process process2 = getProcessViaId(process.getId());
            process2.setPosition(process.getPosition());
            process2.setMaxSalary(process.getMaxSalary());
            process2.setLocation(process.getLocation());
            process2.setTechnology(process.getTechnology());
            process2.setTarget(process.getTarget());
            process2.setDate(process.getDate());
            process2.setCandidatesInTheProcess(process.getCandidatesInTheProcess());
            processService.save(process);
        }

        updateExcel();
        return new ModelAndView("redirect:/process_list");
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam(value = "process_id") int id) throws IOException {
        Process process = getProcessViaId(id);
        processList.remove(process);
        processService.delete(process);
        updateExcel();
        return new ModelAndView("redirect:/process_list");
    }

    @RequestMapping("/process_list")
    public ModelAndView viewprocess(Model model) {
        List<Process> list = (List<Process>) processService.getAll();
        return new ModelAndView("process_list", "list", list);
    }

    private Process getProcessViaId(@ModelAttribute int id) {
        return processList.stream().filter(f -> f.getId() == id).findFirst().get();
    }

    private void updateExcel() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Processes");

        List<Process> processList = (List<Process>) processService.getAll();
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("Id");
        row.createCell(1).setCellValue("Position");
        row.createCell(2).setCellValue("maxSalary");
        row.createCell(3).setCellValue("Location");
        row.createCell(4).setCellValue("Technology");
        row.createCell(5).setCellValue("Target");
        row.createCell(6).setCellValue("Date");
        row.createCell(7).setCellValue("Candidates in the process");

        int rowCount = 1;
        for (Process process : processList) {
            Row processRow = sheet.createRow(rowCount++);
            processRow.createCell(0).setCellValue(process.getId());
            processRow.createCell(1).setCellValue(process.getPosition());
            processRow.createCell(2).setCellValue(process.getMaxSalary());
            processRow.createCell(3).setCellValue(process.getLocation());
            processRow.createCell(4).setCellValue(process.getTechnology());
            processRow.createCell(5).setCellValue(process.getTarget());
            processRow.createCell(6).setCellValue(process.getDate());
            processRow.createCell(7).setCellValue(process.getCandidatesInTheProcess());

        }

        //FileOutputStream- zapis do pliku
        try (FileOutputStream fout = new FileOutputStream("C:/recruitingWorkflowApp/src/main/resources/Processes.xlsx")) {
            workbook.write(fout);//zapisanie arkusza Excel do pliku
        }
    }

}
