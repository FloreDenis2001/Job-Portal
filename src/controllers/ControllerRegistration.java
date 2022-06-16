package controllers;

import Exceptions.IdStatus;
import model.Registration;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerRegistration {
    private ArrayList<Registration> registrations;

    public ControllerRegistration() {
        registrations = new ArrayList<>();
        this.load();
    }

    public void load() {
        try {
            File f = new File("C:\\Users\\flore\\Desktop\\mycode\\aplicatie1\\job-portal\\src\\res\\registrations");
            Scanner scanner = new Scanner(f);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                this.registrations.add(new Registration(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //todo afisare
    public void afisare() {
        for (Registration x : registrations) {
            System.out.println(x);
        }
    }


    //todo findById

    public Registration findById(int registration_id) {
        for (Registration x : registrations) {
            if (x.getRegistration_id() == registration_id) {
                return x;
            }
        }
        return null;
    }

    //todo Adaugare

    public void adaugareRegistration(Registration x) throws IdStatus {


        Registration t = findById(x.getRegistration_id());
        if (t == null) {
            this.registrations.add(x);
        } else {
            throw new IdStatus("Este deja inregistrata !");
        }
    }

    //todo Stergere

    public void stergereRegistration(int id) throws IdStatus {
       Registration b = findById(id);
        if (b != null) {
            this.registrations.remove(b);
        } else {
            throw new IdStatus("Nu exista aceast registru!");
        }

    }

    //todo Update
    public void updateNumber(int id, String nouNumber) throws IdStatus {
        Registration x = findById(id);
        if (x != null) {
            x.setRegistration_number(nouNumber);
        } else {
            throw new IdStatus("Nu exista acest registru!");
        }
    }
}
