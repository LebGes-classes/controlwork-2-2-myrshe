package ControlWork;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Deserialization {
    public Deserialization() {
    }

    public static ArrayList<String> deserialize(String nameFile) {
        ArrayList<String> programs = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(nameFile));
            String line;
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    programs.add(line);
                }
            } catch (Throwable e) {
                try {
                    bufferedReader.close();
                } catch (Throwable b) {
                    e.addSuppressed(b);
                }
                throw e;
            }

            bufferedReader.close();
            return programs;

        } catch (FileNotFoundException g) {
            throw new RuntimeException(g);
        } catch (IOException p) {
            throw new RuntimeException(p);
        }
    }
}
