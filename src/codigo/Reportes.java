package codigo;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;

public class Reportes{

    // Fonts definitions (Definición de fuentes).
    private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 15, Font.BOLDITALIC);
    private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);

    private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

    private static final String iTextExampleImage = "C:/Users/Ronald/Documents/NetBeansProjects/proy2_p2/src/fotos/q.jpg";

    public void createPDF(File pdfNewFile) {
        //Create the document and set the file name.        
        try {
            Document document = new Document();
            try {
                PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("No se encontró el fichero para generar el pdf " + fileNotFoundException);
            }
            document.open();
            // First page
            Chunk chunk = new Chunk("Reportes", chapterFont);
            chunk.setBackground(BaseColor.GRAY);
            // Let's create de first Chapter
            Chapter chapter = new Chapter(new Paragraph(chunk), 1);
            chapter.setNumberDepth(0);
            chapter.add(new Paragraph(Chunk.NEWLINE));
            chapter.add(new Paragraph("texto 123456789", paragraphFont));
            chapter.add(new Paragraph(Chunk.NEWLINE));
            chapter.add(new Paragraph("texto 123456789", paragraphFont));
            document.add(chapter);
            document.close();
        } catch (DocumentException documentException) {
            System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
        }
    }
/*
    public static void main(String args[]) {
        Reportes a = new Reportes();
        a.createPDF(new File("C:/Users/Ronald/Documents/NetBeansProjects/proy2_p2/src/pdf.pdf"));

        try {
            File path = new File("C:/Users/Ronald/Documents/NetBeansProjects/proy2_p2/src/pdf.pdf");
            Desktop.getDesktop().open(path);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo abrir el documento. " + e);
        }

    }*/
    
    
    
}

