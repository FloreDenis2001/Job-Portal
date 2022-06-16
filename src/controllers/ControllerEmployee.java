package controllers;

import Exceptions.IdStatus;
import model.Employee;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerEmployee {
    private ArrayList<Employee> employees;

    public ControllerEmployee() {
        employees = new ArrayList<>();
        this.load();
    }

    public void load() {
        try {
            File f = new File("C:\\Users\\flore\\Desktop\\mycode\\aplicatie1\\job-portal\\src\\res\\employees");
            Scanner scanner = new Scanner(f);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Employee x = new Employee(line);
                this.employees.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //todo afisare
    public void afisare() {
        for (Employee x : employees) {
            System.out.println(x);
        }
    }

    //todo findById
    public Employee findById(int employee_id) {
        for (Employee e : employees) {
            if (e.getEmployee_id() == employee_id) {
                return e;
            }
        }
        return null;
    }

    //todo adaugare

    public void adaugareEmployee(Employee e) throws IdStatus {
        Employee t = findById(e.getEmployee_id());
        if (t == null) {
            this.employees.add(e);
        } else {
            throw new IdStatus("Angajatul exista!");
        }
    }

    //todo stergere

    public void stergereEmployee(int id) throws IdStatus {
        Employee t = findById(id);
        if (t != null) {
            this.employees.remove(t);
        } else {
            throw new IdStatus("Angajatul nu exista!");
        }
    }

    //todo update

    public void updatePassword(int id, String nouaParola) throws IdStatus {
        Employee x = findById(id);
        if (x != null) {
            x.setEmployee_password(nouaParola);
        } else {
            throw new IdStatus("Angajatul nu exista!");
        }
    }
}
