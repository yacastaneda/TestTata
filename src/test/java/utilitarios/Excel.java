package utilitarios;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Excel {

    static HSSFWorkbook workbook;
    static HSSFSheet sheet;
    static Row rowHeading;
    static CellStyle styleHeading, styleCellEstadoFailed, styleCell, styleCellEstadoPass;
    static Font fontHEad,fontCell;
    static FileOutputStream out;

    public static void main(String[] args) throws IOException {
        createHeading();
        saveExcel();
    }

    public static void createHeading() {

        workbook = new HSSFWorkbook();
        sheet = workbook.createSheet("Summary");
        rowHeading = sheet.createRow(0);
        rowHeading.createCell(0).setCellValue("User Rating");
        rowHeading.createCell(1).setCellValue("Display");
        rowHeading.createCell(2).setCellValue("Storage");
        rowHeading.createCell(3).setCellValue("Processor");
        rowHeading.createCell(4).setCellValue("Ram");


        for (int i = 0; i < 5; i++) {
            styleHeading = workbook.createCellStyle();
            fontHEad = workbook.createFont();
            fontHEad.setBold(true);
            fontHEad.setFontName(HSSFFont.FONT_ARIAL);
            fontHEad.setFontHeightInPoints((short) 11);
            styleHeading.setFont(fontHEad);
            //styleHeading.setVerticalAlignment(VerticalAlignment.CENTER);
            rowHeading.getCell(i).setCellStyle(styleHeading);

            // Estilo celda para Fallos
            styleCellEstadoFailed = workbook.createCellStyle();
            fontCell = workbook.createFont();
            // aplicar negrita
            fontCell.setBold(true);
            fontCell.setFontName(HSSFFont.FONT_ARIAL);
            // tamaño de fuente
            fontCell.setFontHeightInPoints((short) 11);
            fontCell.setColor(IndexedColors.RED.getIndex());
            styleCellEstadoFailed.setFont(fontCell);
            styleCellEstadoFailed.setAlignment(HorizontalAlignment.CENTER);

            // Estilo celda para Pasados
            styleCellEstadoPass = workbook.createCellStyle();
            fontCell = workbook.createFont();
            // aplicar negrita
            fontCell.setBold(true);
            fontCell.setFontName(HSSFFont.FONT_ARIAL);
            // tamaño de fuente
            fontCell.setFontHeightInPoints((short) 11);
            fontCell.setColor(IndexedColors.GREEN.getIndex());
            styleCellEstadoPass.setFont(fontCell);
            styleCellEstadoPass.setAlignment(HorizontalAlignment.CENTER);

            // Estilo celdas por defecto
            styleCell = workbook.createCellStyle();
            fontCell = workbook.createFont();
            // aplicar negrita
            //fontCell.setBold(true);
            fontCell.setFontName(HSSFFont.FONT_ARIAL);
            // tamaño de fuente
            fontCell.setFontHeightInPoints((short) 11);
            //fontCell.setColor(IndexedColors.GREEN.getIndex());
            styleCell.setFont(fontCell);
            styleCell.setAlignment(HorizontalAlignment.CENTER);

        }

    }

    public static void saveExcel() throws IOException {
        // Guardar Excel
        out = new FileOutputStream(new File("out/reporte.xls"));
        workbook.write(out);
        out.close();
        workbook.close();
        System.out.println("Excel fue escrito satisfactoriamente");
    }

}
