package com.company.shyhhaw;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
public class Excel {

    private static final String[] columns = {"Number", "Login","Number of Repositories","Number of Followers","Number of Project","Number of Following"};


    public void WriteToExcel(ArrayList<Data> personalInfor) throws IOException {

        // Create a Workbook
        Workbook workbook = new XSSFWorkbook();

        //Create sheet
        Sheet sheet = workbook.createSheet("zhamri's Github followers");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 16);


        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);


        //set border style for header cells
        headerCellStyle.setBorderRight(BorderStyle.MEDIUM);
        headerCellStyle.setBorderBottom(BorderStyle.MEDIUM);

        //set text to center
        headerCellStyle.setAlignment(HorizontalAlignment.CENTER);


        //create a  CellStyle with border
        CellStyle cellStyle = workbook.createCellStyle();

        cellStyle.setBorderRight(BorderStyle.MEDIUM);
        cellStyle.setBorderLeft(BorderStyle.MEDIUM);
        cellStyle.setBorderTop(BorderStyle.MEDIUM);
        cellStyle.setBorderBottom(BorderStyle.MEDIUM);

        //Create row
        Row headerRow = sheet.createRow(0);

        // Create cells
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);

        }

        // Print data to row
        int rowNum = 1;
        for (Data Data1 : personalInfor) {
            Row row = sheet.createRow(rowNum++);

            Cell column1 = row.createCell(0);
            column1.setCellValue((rowNum-1));
            column1.setCellStyle(cellStyle);

            Cell column2 = row.createCell(1);
            column2.setCellValue(Data1.getLogin());
            column2.setCellStyle(cellStyle);

            Cell column3 = row.createCell(2);
            column3.setCellValue(Data1.getNumRespo());
            column3.setCellStyle(cellStyle);

            Cell column4 = row.createCell(3);
            column4.setCellValue(Data1.getNumFollower());
            column4.setCellStyle(cellStyle);

            Cell column5 = row.createCell(4);
            column5.setCellValue(Data1.getNumProject());
            column5.setCellStyle(cellStyle);

            Cell column6 = row.createCell(5);
            column6.setCellValue(Data1.getNumFollowing());
            column6.setCellStyle(cellStyle);
        }



        // Resize all columns to fit the content size
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("Assignment2.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        System.out.println("\n\n\n"+"Excel file has successfully created..........");

    }

}
