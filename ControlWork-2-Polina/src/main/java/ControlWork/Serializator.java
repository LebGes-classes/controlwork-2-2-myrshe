package ControlWork;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Serializator {
    private ArrayList<Program> programs;
    private String fileName;

    public Serializator(ArrayList<Program> programs, String fileName) {
        this.programs = programs;
        this.fileName = fileName;
    }

    public static void saveToExcel(ArrayList<Program> programs, String fileName) throws IOException {


        Workbook workbook = new XSSFWorkbook();


        Sheet sheet = workbook.createSheet("Programs");


        Row Row1 = sheet.createRow(0);
        Row1.createCell(0).setCellValue("Chanel");
        Row1.createCell(1).setCellValue("Time");
        Row1.createCell(2).setCellValue("Name");

        int rowNum = 0;
        Iterator var6 = programs.iterator();

        while(var6.hasNext()) {
            Program program = (Program)var6.next();
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(program.getChanel());
            row.createCell(1).setCellValue(program.getTime().toString());
            row.createCell(2).setCellValue(program.getNameOfProgram());
        }

        for(int i = 0; i < 3; ++i) {
            sheet.autoSizeColumn(i);
        }

        FileOutputStream outputStream = new FileOutputStream(fileName);
        try {
            workbook.write(outputStream);
        } catch (Throwable var10) {
            try {
                outputStream.close();
            } catch (Throwable var9) {
                var10.addSuppressed(var9);
            }

            throw var10;
        }
        outputStream.close();
    }
}
