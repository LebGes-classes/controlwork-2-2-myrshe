package ControlWork;

import java.util.ArrayList;
import java.util.Iterator;

public class ConvertDataToProgram{
    static String chanel = "";
    static BroadcastsTime time = null;

    public ConvertDataToProgram() {
    }

    public static ArrayList<Program> convertAllPrograms(ArrayList<String> data) {
        ArrayList<Program> allPrograms = new ArrayList();
        Iterator var2 = data.iterator();

        while(true) {

            while(var2.hasNext()) {

                String program = (String)var2.next();
                if (program.contains("#")) {
                    chanel = program.split("#")[1];
                } else if (program.contains(":") && program.length() == 5) {
                    time = new BroadcastsTime(Byte.parseByte(program.split(":")[0]), Byte.parseByte(program.split(":")[1]));
                } else {
                    Program p = new Program(chanel, time, program);//в таком порядке потому что сначала идет канал, потом время, потом программа
                    allPrograms.add(p);
                }
            }
            return allPrograms;
        }
    }
}
