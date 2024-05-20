package ControlWork;

import java.util.ArrayList;
import java.util.Comparator;

public class Program {
    private String chanel;
    private BroadcastsTime time;
    private String nameOfProgram;

    Program(String chanel, BroadcastsTime time, String nameOfProgram) {
        this.chanel = chanel;
        this.time = time;
        this.nameOfProgram = nameOfProgram;
    }


    public String getChanel() {
        return this.chanel;
    }
    public String getNameOfProgram() {
        return  this.nameOfProgram;
    }
    public BroadcastsTime getTime() {
        return this.time;
    }
    @Override
    public String toString() {
        String chanel1 = this.chanel;
        return chanel1 + ": " + this.getTime() + ", название программы='" + this.nameOfProgram + "'}";
    }

    public static ArrayList<Program> sortingOfTime(ArrayList<Program> programs) {
        programs.sort(Comparator.comparing(Program::getTime));
        return programs;
    }



    public static ArrayList<Program> byName(ArrayList<Program> programs, String nameOfProgram) {
        ArrayList<Program> byName = new ArrayList<>();
        for(Program p: programs) {
            if (p.getNameOfProgram().equals(nameOfProgram)) {
                byName.add(p);
            }
        }
        return byName;
    }

    /*public Program inThisTime(ArrayList<Program> programs, String time) {
        BroadcastsTime br = new BroadcastsTime(time);
        ArrayList<Program> curProg = new ArrayList<>();
        for(int i = 0; i < programs.size(); ++i) {
            if (((Program)programs.get(i)).getTime().compareTo(br) == 0) {
                curProg.add((Program)programs.get(i));
            }
        }
        return curProg;
    }*/
}
