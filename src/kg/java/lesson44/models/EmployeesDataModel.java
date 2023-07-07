package kg.java.lesson44.models;

import kg.java.lesson44.FileService;

import java.util.ArrayList;
import java.util.List;

public class EmployeesDataModel {
    List<Employee> employees = new ArrayList<>();

    public EmployeesDataModel(){
        employees.addAll(List.of(FileService.readEmployeesFile()));
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

}