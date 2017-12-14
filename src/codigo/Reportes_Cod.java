package codigo;

import base_datos.Reportes_DB;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Reportes_Cod {

    // Fonts definitions (Definición de fuentes).
    private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 15, Font.BOLDITALIC);
    private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);

    private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    //This method create or modify the pdf and set the information of the report #1
    public void Rep_1(Date inicio, Date fin) {
        Reportes_DB rep = new Reportes_DB();
        ArrayList<Object[]> info = rep.rep1(inicio, fin);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String Fini = dateFormat.format(inicio);
        String Finf = dateFormat.format(fin);

        try {
            Document document = new Document();
            try {
                PdfWriter.getInstance(document, new FileOutputStream("src/pdf/rep1.pdf"));
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("No se encontró el fichero para generar el pdf " + fileNotFoundException);
            }
            document.open();
            // First page
            Chunk chunk = new Chunk("Reporte 1", chapterFont);
            chunk.setBackground(BaseColor.GRAY);
            Chapter chapter = new Chapter(new Paragraph(chunk), 1);
            chapter.setNumberDepth(0);
            chapter.add(new Paragraph(Chunk.NEWLINE));
            chapter.add(new Paragraph(Chunk.NEWLINE));
            chapter.add(new Paragraph(Chunk.NEWLINE));
            chapter.add(new Paragraph("Vehiculos Alquilados del " + Fini + " al " + Finf));
            chapter.add(new Paragraph(Chunk.NEWLINE));
            chapter.add(new Paragraph(Chunk.NEWLINE));
            int i = 1;
            String informacion_txt = "";
            for (Object[] informacion1 : info) {
                informacion_txt += "Vehiculo Alquilado " + i + ":" + System.lineSeparator() + " Placa: " + informacion1[0] + ", Cedula del Usuario: " + informacion1[1]
                        + ", Nombre del Usuario: " + informacion1[2] + ", Fecha de retiro: " + informacion1[3]
                        + ", Fecha de devolucion: " + informacion1[4] + "." + System.lineSeparator() + System.lineSeparator();
                i = i + 1;
            }
            chapter.add(new Paragraph(Chunk.NEWLINE));
            chapter.add(new Paragraph(informacion_txt, paragraphFont));
            chapter.add(new Paragraph(Chunk.NEWLINE));
            document.add(chapter);
            document.close();
        } catch (DocumentException documentException) {
            System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
        }
        try {
            File path = new File("src/pdf/rep1.pdf");
            Desktop.getDesktop().open(path);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo abrir el documento. " + e);
        }
    }
    //This method create or modify the pdf and write the information of the report #2
    public void Rep_2(boolean estado) {
        Reportes_DB rep = new Reportes_DB();
        String est;
        if (estado == true) {
            est = "Sin Rentar";
        } else {
            est = "Rentados";
        }
        ArrayList<Object[]> info = rep.rep2(estado);
        try {
            Document document = new Document();
            try {
                PdfWriter.getInstance(document, new FileOutputStream("src/pdf/rep2.pdf"));
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("No se encontró el fichero para generar el pdf " + fileNotFoundException);
            }
            document.open();
            // First page
            Chunk chunk = new Chunk("Reporte 2", chapterFont);
            chunk.setBackground(BaseColor.GREEN);
            Chapter chapter = new Chapter(new Paragraph(chunk), 1);
            chapter.setNumberDepth(0);
            chapter.add(new Paragraph(Chunk.NEWLINE));
            chapter.add(new Paragraph(Chunk.NEWLINE));
            chapter.add(new Paragraph(Chunk.NEWLINE));
            chapter.add(new Paragraph("Informacion de Vehiculos "+ est));
            chapter.add(new Paragraph(Chunk.NEWLINE));
            chapter.add(new Paragraph(Chunk.NEWLINE));
            int i = 1;

            String informacion_txt = "";

            for (Object[] informacion1 : info) {
                informacion_txt += "Vehiculo" + i + ":" + System.lineSeparator() + " Placa: " + informacion1[0] + ", Marca: " + informacion1[1]
                        + ", Modelo: " + informacion1[2] + ", Estilo: " + informacion1[3] + "."
                        + System.lineSeparator() + System.lineSeparator();
                i = i + 1;
            }

            chapter.add(new Paragraph(Chunk.NEWLINE));
            chapter.add(new Paragraph(informacion_txt, paragraphFont));
            chapter.add(new Paragraph(Chunk.NEWLINE));

            document.add(chapter);
            document.close();
        } catch (DocumentException documentException) {
            System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
        }

        try {
            File path = new File("src/pdf/rep2.pdf");
            Desktop.getDesktop().open(path);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo abrir el documento. " + e);
        }
    }
    //This method create or modify the pdf and write the information of the report #3
    public void Rep_3() {
        Reportes_DB rep = new Reportes_DB();
       
        ArrayList<Object[]> info = rep.rep3();
        try {
            Document document = new Document();
            try {
                PdfWriter.getInstance(document, new FileOutputStream("src/pdf/rep3.pdf"));
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("No se encontró el fichero para generar el pdf " + fileNotFoundException);
            }
            document.open();
            // First page
            Chunk chunk = new Chunk("Reporte 3", chapterFont);
            chunk.setBackground(BaseColor.RED);
            Chapter chapter = new Chapter(new Paragraph(chunk), 1);
            chapter.setNumberDepth(0);
            chapter.add(new Paragraph(Chunk.NEWLINE));
            chapter.add(new Paragraph(Chunk.NEWLINE));
            chapter.add(new Paragraph(Chunk.NEWLINE));
            chapter.add(new Paragraph("Informacion de Usuarios y Vehiculos Rentados"));
            chapter.add(new Paragraph(Chunk.NEWLINE));
            chapter.add(new Paragraph(Chunk.NEWLINE));
            int i = 1;

            String informacion_txt = "";

            for (Object[] informacion1 : info) {
                informacion_txt += "Vehiculo" + i + ":" + System.lineSeparator() + " Cedula Usuario: " + informacion1[0] + ", Nombre: " + informacion1[1]
                        + ", Telefono: " + informacion1[2] + ", Direccion: " + informacion1[3] + ", Placa Vehiculo: " + informacion1[5] 
                        + ", Marca: " + informacion1[7] +", Modelo: " + informacion1[8] +", Estilo: " + informacion1[9] +", Transmision: " + informacion1[10] 
                        + ", Año: " + informacion1[11] +", Precio: " + informacion1[12] +"."
                        + System.lineSeparator() + System.lineSeparator();
                i = i + 1;
            }

            chapter.add(new Paragraph(Chunk.NEWLINE));
            chapter.add(new Paragraph(informacion_txt, paragraphFont));
            chapter.add(new Paragraph(Chunk.NEWLINE));

            document.add(chapter);
            document.close();
        } catch (DocumentException documentException) {
            System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
        }

        try {
            File path = new File("src/pdf/rep3.pdf");
            Desktop.getDesktop().open(path);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo abrir el documento. " + e);
        }
    }
}
