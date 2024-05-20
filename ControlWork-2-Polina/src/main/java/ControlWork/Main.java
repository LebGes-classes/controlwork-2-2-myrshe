package ControlWork;

import java.io.IOException;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> programs = Deserialization.deserialize("data.txt");
        System.out.println(programs);
        ArrayList<Program> programs1 = ConvertDataToProgram.convertAllPrograms(programs);
        ArrayList<Program> sortProgram = Program.sortingOfTime(programs1);
        System.out.println(sortProgram);
        new Serializator(sortProgram, "Programs.xlsx");
        Serializator.saveToExcel(sortProgram, "Programs.xlsx");
    }
}
