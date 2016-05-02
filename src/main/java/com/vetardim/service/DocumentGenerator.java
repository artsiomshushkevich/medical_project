package com.vetardim.service;

import com.lowagie.text.*;

import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.GrayColor;
import com.lowagie.text.pdf.PdfWriter;
import com.opencsv.CSVWriter;
import com.vetardim.DAO.AnalyseDao;
import com.vetardim.DAO.ClientDao;
import com.vetardim.DAO.DoctorDao;
import com.vetardim.DAO.OrderDao;
import com.vetardim.model.Analyse;
import com.vetardim.model.Client;
import com.vetardim.model.Doctor;
import com.vetardim.model.Order;
import com.vetardim.util.UnixTimeConverter;
import org.apache.poi.hssf.usermodel.*;

import java.io.*;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by artsiom on 4/30/16.
 */
public class DocumentGenerator {

    private static final Font fontForWaterMark = FontFactory.getFont(FontFactory.HELVETICA, 130,
                                                                    Font.BOLD, new GrayColor(0.85f));

    private  static List<String> setOrdersRow(Order order ){
        List<String> ordersRow = new LinkedList<String>();
        Doctor doctor = DoctorDao.getDoctorById(order.getDoctorId());
        Client client = ClientDao.getClientById(order.getClientId());
        ordersRow.add(String.format("%d", order.getId()));

        ordersRow.add(String.format("%s %s %s ", doctor.getFirstname(),
                doctor.getSecondname(),
                doctor.getLastname()));

        ordersRow.add(String.format("%s %s %s", client.getFirstname(),
                client.getSecondname(),
                client.getLastname()));

        ordersRow.add(String.format("%s %s",
                UnixTimeConverter.convertUnixTimeToTime(order.getBeginTime(), "hh:mm"),
                UnixTimeConverter.convertUnixTimeToTime(order.getDate(), "yyyy-MM-dd")));

        return ordersRow;
    }
    public static ByteArrayOutputStream generateOrderInPDFById(int id) {
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PdfWriter pdfWriter = null;
        try {
            pdfWriter = PdfWriter.getInstance(document, stream);
            document.open();
            Order order = OrderDao.getOrderById(id);
            List<String> ordersRow = setOrdersRow(order);
            Paragraph orderText = new Paragraph("Order # " + ordersRow.get(0) + "\n" +
                                                "Doctor: " + ordersRow.get(1) + "\n" +
                                                "Client: " + ordersRow.get(2) + "\n" +
                                                "Date:" + ordersRow.get(3) + "\n",
                                                FontFactory.getFont(FontFactory.HELVETICA, 40, Font.BOLD));

            orderText.setAlignment(Element.ALIGN_CENTER);
            document.add(orderText);
            ColumnText.showTextAligned(pdfWriter.getDirectContentUnder(), Element.ALIGN_CENTER,
                                        new Phrase("NoQueues", fontForWaterMark),
                                        297.5f, 421, 45);
            document.addAuthor("VetArtDim Systems");
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            if (document != null) {
                document.close();
            }
            if (pdfWriter != null) {
                document.close();
            }
        }
        return stream;
    }

    public static ByteArrayOutputStream generateOrdersInXLS() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("order");
        sheet.setColumnWidth(0, 3500);
        sheet.setColumnWidth(1, 5000);
        sheet.setColumnWidth(2, 7500);
        sheet.setColumnWidth(3, 7500);
        HSSFCellStyle headerCellStyle = workbook.createCellStyle();
        HSSFFont boldFont = workbook.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerCellStyle.setFont(boldFont);

        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Order Number"));
        cell = row.createCell(1);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Doctor"));
        cell = row.createCell(2);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Client"));
        cell = row.createCell(3);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Date"));

        List<Order> orderList = OrderDao.getOrdersList();
        for (int i = 0; i < orderList.size(); i++ ) {
            row = sheet.createRow(i+1);
            List<String> ordersRow = setOrdersRow(orderList.get(i));
            for (int j = 0; j < ordersRow.size(); j ++) {
                cell = row.createCell(j);
                HSSFRichTextString orderNumberCellValue = new HSSFRichTextString(ordersRow.get(j));
                cell.setCellValue(orderNumberCellValue);
            }

        }

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        workbook.write(stream);
        return  stream;
    }

    public static ByteArrayOutputStream generateOrdersInCSV() throws IOException {
        String[] fileHeader = {"Order Number", "Doctor", "Client", "Date"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        CSVWriter writer = new CSVWriter(new OutputStreamWriter(stream, Charset.forName("UTF-8")), ',');
        writer.writeNext(fileHeader);
        List<String[]> ordersInString = new LinkedList<String[]>();
        List<Order> orderList = OrderDao.getOrdersList();
        for (int i = 0; i < orderList.size(); i++) {
            List<String> ordersRow = setOrdersRow(orderList.get(i));
            String[] tempArray = {ordersRow.get(0), ordersRow.get(1), ordersRow.get(2), ordersRow.get(3)};
            ordersInString.add(tempArray);
        }

        writer.writeAll(ordersInString);
        writer.close();
        return stream;
    }

    private static List<String> setAnalysesRow(Analyse analyse) {
        List<String> analysesRow = new LinkedList<String>();
        Doctor doctor = DoctorDao.getDoctorById(analyse.getDoctorId());
        Client client = ClientDao.getClientById(analyse.getClientId());
        analysesRow.add(String.format("%d", analyse.getId()));


        analysesRow.add(String.format("%s %s %s ", doctor.getFirstname(),
                doctor.getSecondname(),
                doctor.getLastname()));

        analysesRow.add(String.format("%s %s %s", client.getFirstname(),
                client.getSecondname(),
                client.getLastname()));

        analysesRow.add(String.format("%s", analyse.getName()));
        analysesRow.add(String.format("%s", analyse.getResult()));

        return analysesRow;
    }


    public static ByteArrayOutputStream generateAnalyseInPDFById(int id) {
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PdfWriter pdfWriter = null;
        try {
            pdfWriter = PdfWriter.getInstance(document, stream);
            document.open();
            Analyse analyse = AnalyseDao.getAnalyseById(id);
            List<String> analysesRow = setAnalysesRow(analyse);
            Paragraph orderText = new Paragraph("Analyse # " + analysesRow.get(0) + "\n" +
                    "Doctor: " + analysesRow.get(1) + "\n" +
                    "Client: " + analysesRow.get(2) + "\n" +
                    "Name:" + analysesRow.get(3) + "\n",
                    FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD));

            orderText.setAlignment(Element.ALIGN_CENTER);
            document.add(orderText);
            document.add(new Paragraph("Result: " + analysesRow.get(4)));
            ColumnText.showTextAligned(pdfWriter.getDirectContentUnder(), Element.ALIGN_CENTER,
                    new Phrase("NoQueues", fontForWaterMark),
                    297.5f, 421, 45);
            document.addAuthor("VetArtDim Systems");
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            if (document != null) {
                document.close();
            }
            if (pdfWriter != null) {
                document.close();
            }
        }
        return stream;
    }


    public static ByteArrayOutputStream generateAnalysesInXLS() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("analyse");


        HSSFCellStyle headerCellStyle = workbook.createCellStyle();
        HSSFFont boldFont = workbook.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerCellStyle.setFont(boldFont);

        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Analyse Number"));
        cell = row.createCell(1);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Doctor"));
        cell = row.createCell(2);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Client"));
        cell = row.createCell(3);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Name"));
        cell = row.createCell(4);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Result"));

        List<Analyse> analyseList = AnalyseDao.getAnalysesList();
        for (int i = 0; i < analyseList.size(); i++ ) {
            row = sheet.createRow(i+1);
            List<String> ordersRow = setAnalysesRow(analyseList.get(i));
            for (int j = 0; j < ordersRow.size(); j ++) {
                cell = row.createCell(j);
                HSSFRichTextString orderNumberCellValue = new HSSFRichTextString(ordersRow.get(j));
                cell.setCellValue(orderNumberCellValue);
            }

        }

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        workbook.write(stream);
        return  stream;
    }

    public static ByteArrayOutputStream generateAnalysesInCSV() throws IOException {
        String[] fileHeader = {"Analyse Number", "Doctor", "Client", "Name", "Result"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        CSVWriter writer = new CSVWriter(new OutputStreamWriter(stream, Charset.forName("UTF-8")), ',');
        writer.writeNext(fileHeader);
        List<String[]> analysesInString = new LinkedList<String[]>();
        List<Analyse> analyseList = AnalyseDao.getAnalysesList();
        for (int i = 0; i < analyseList.size(); i++) {
            List<String> analysesRow = setAnalysesRow(analyseList.get(i));
            String[] tempArray = {analysesRow.get(0), analysesRow.get(1), analysesRow.get(2), analysesRow.get(3), analysesRow.get(3)};
            analysesInString.add(tempArray);
        }

        writer.writeAll(analysesInString);
        writer.close();
        return stream;
    }


    private List<String> set
}
