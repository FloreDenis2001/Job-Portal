package controllers;

import Exceptions.IdStatus;
import model.Interview;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerInterview {

    private ArrayList<Interview> interviews;

    public ControllerInterview(){
        interviews=new ArrayList<>();
        this.load();
    }

    public void load() {
        try {
            File f = new File("C:\\Users\\flore\\Desktop\\mycode\\aplicatie1\\job-portal\\src\\res\\interview");
            Scanner scanner = new Scanner(f);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                this.interviews.add(new Interview(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //todo afisare
    public void afisare() {
        for (Interview x : interviews) {
            System.out.println(x);
        }
    }


    //todo findById

    public Interview findById(int interview_id) {
        for (Interview x : interviews) {
            if (x.getInterview_id() == interview_id) {
                return x;
            }
        }
        return null;
    }

    //todo Adaugare

    public void adaugareInterview(Interview x) throws IdStatus {


        Interview t = findById(x.getInterview_id());
        if (t == null) {
            this.interviews.add(x);
        } else {
            throw new IdStatus("Interviu Existent!");
        }
    }

    //todo Stergere

    public void stergereInterview(int id) throws IdStatus {
        Interview b = findById(id);
        if (b != null) {
            this.interviews.remove(b);
        } else {
            throw new IdStatus("Nu exista aceast interviu !");
        }

    }

    //todo Update
    public void updateTitle(int id, String noulTitlu) throws IdStatus {
        Interview x = findById(id);
        if (x != null) {
            x.setInterview_title(noulTitlu);
        } else {
            throw new IdStatus("Nu exista acest interviu!");
        }
    }
}
