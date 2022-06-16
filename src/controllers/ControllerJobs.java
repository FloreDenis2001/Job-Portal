package controllers;

import Exceptions.IdStatus;
import model.Job;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerJobs {
    private ArrayList<Job> jobs;

    public ControllerJobs() {
        jobs = new ArrayList<>();
        this.load();
    }

    public void load() {
        try {
            File f = new File("C:\\Users\\flore\\Desktop\\mycode\\aplicatie1\\job-portal\\src\\res\\jobs");
            Scanner scanner = new Scanner(f);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                this.jobs.add(new Job(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //todo Afisare
    public void afisare() {
        for (Job x : jobs) {
            System.out.println(x);
        }
    }

    //todo findById

    public Job findById(int job_id) {
        for (Job x : jobs) {
            if (x.getJob_id() == job_id) {
                return x;
            }
        }
        return null;
    }

    //todo Adaugare

    public void adaugareJob(Job x) throws IdStatus {


        Job t = findById(x.getJob_id());
        if (t == null) {
            this.jobs.add(x);
        } else {
            throw new IdStatus("Exista acest job !");
        }
    }

    //todo Stergere

    public void stergereJob(int id) throws IdStatus {
        Job b = findById(id);
        if (b != null) {
            this.jobs.remove(b);
        } else {
            throw new IdStatus("Nu exista job-ul respectiv!");
        }

    }

    //todo Update
    public void updateDescriere(int id, String nouaDescriere) throws IdStatus {
        Job x = findById(id);
        if (x != null) {
            x.setJob_description(nouaDescriere);
        } else {
            throw new IdStatus("Nu exista job-ul respectiv!");
        }
    }

}
