package com.vetardim.service;

import com.lowagie.text.Document;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;


/**
 * Created by artsiom on 4/30/16.
 */
public class DocumentGenerator {


    public static ByteArrayOutputStream generatePDF()  {
        Document document = new Document();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PdfWriter pdfWriter = null;
        try {
            pdfWriter = PdfWriter.getInstance(document, stream);
            document.open();
            PdfStamper stamper = new PdfStamper();

            document.add(new Paragraph("asdasdasdasdasdd"));
            Font font = new Font()
            document.addAuthor("Vetardim Systems");
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            if (document != null){
                document.close();
            }
            if (pdfWriter != null) {
                document.close();
            }
        }
        return stream;
    }



}
