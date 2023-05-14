package com.example.thymeleaf.mvc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model){
        List<Employee> employees = employeeService.listAllEmployees();
        model.addAttribute("employees",employees);
        return "list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "form-employees";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormUpdate(Model model, @RequestParam("employeeId") int id){
        Employee employee = employeeService.listEmployeeById(id);
        model.addAttribute("employee",employee);
        return "form-employees";
    }

    @GetMapping("/delete")
    public String deleteEmployee(Model model, @RequestParam("employeeId") int id){
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees/list";
    }
}
