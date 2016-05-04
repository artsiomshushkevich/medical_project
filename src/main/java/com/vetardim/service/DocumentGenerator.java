package com.vetardim.service;

import com.lowagie.text.*;


import com.lowagie.text.Font;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import com.opencsv.CSVWriter;
import com.vetardim.DAO.*;
import com.vetardim.model.*;
import com.vetardim.util.UnixTimeConverter;
import org.apache.poi.hssf.usermodel.*;
import sun.font.FontFamily;

import java.awt.*;
import java.io.*;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by artsiom on 4/30/16.
 */
public class DocumentGenerator {


    private static final Font FONT_FOR_OBJECT_NAME = FontFactory.getFont(FontFactory.HELVETICA, 20,
            Font.BOLD);

    private static final Font COMMON_FONT = FontFactory.getFont(FontFactory.HELVETICA, 20);

    private static final String[] VISIT_HEADER = {"Visit Number", "Complaints", "Diagnosys"};
    private static final String[] ORDER_HEADER = {"Doctor", "Begin Time"};
    private static final String[] TREATMENTS_HEADER = {"Treatment Number", "Prescription", "Cure", "Cure Count",
                                                        "Using Method"};
    private static final String[] ANALYSE_HEADER = {"Analyse Number", "Name", "Result"};
    private static final String[] EMPTY_ARRAY = {""};


    private static void addWaterMark(PdfWriter writer) {
        Phrase watermark = new Phrase("NoQueues", FontFactory.getFont(FontFactory.HELVETICA, 40,
                Font.BOLD, Color.GRAY));
        Rectangle pageSize = writer.getPageSize();
        float x = (pageSize.getLeft() + pageSize.getRight()) / 2;
        float y = (pageSize.getTop() + pageSize.getBottom()) / 2;
        PdfContentByte canvas = writer.getDirectContentUnder();
        ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, watermark, x, y, 45);

    }
    private static List<String> setOrdersRow(Order order ){
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
        Document document = new Document(PageSize.A7, 20, 20, 20, 20);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PdfWriter pdfWriter = null;
        try {
            pdfWriter = PdfWriter.getInstance(document, stream);
            document.open();
            addWaterMark(pdfWriter);
            Order order = OrderDao.getOrderById(id);
            List<String> ordersRow = setOrdersRow(order);
            Paragraph orderNumber = new Paragraph();
            orderNumber.add(new Chunk("Order #", FONT_FOR_OBJECT_NAME));
            orderNumber.add(new Chunk(ordersRow.get(0), COMMON_FONT));
            orderNumber.setAlignment(Element.ALIGN_CENTER);
            document.add(orderNumber);
            document.add(Chunk.NEWLINE);
            Paragraph doctorName = new Paragraph();
            doctorName.add(new Chunk("Doctor: ", FONT_FOR_OBJECT_NAME));
            doctorName.add(new Chunk(ordersRow.get(1), COMMON_FONT));
            document.add(doctorName);
            document.add(Chunk.NEWLINE);
            Paragraph clientName = new Paragraph();
            clientName.add(new Chunk("Client: ", FONT_FOR_OBJECT_NAME));
            clientName.add(new Chunk(ordersRow.get(2), COMMON_FONT));
            document.add(clientName);
            document.add(Chunk.NEWLINE);
            Paragraph time = new Paragraph();
            time.add(new Chunk("Begin time: ", FONT_FOR_OBJECT_NAME));
            time.add(new Chunk(ordersRow.get(3), COMMON_FONT));
            document.add(time);

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
        HSSFCellStyle headerCellStyle = workbook.createCellStyle();
        HSSFCellStyle style = workbook.createCellStyle();
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

        sheet.autoSizeColumn(0);
        headerCellStyle.setWrapText(true);
        style.setWrapText(true);
        int[] columnWidths = {20, 20, 20, 20};
        for (int i = 0; i < columnWidths.length; i++) {
            columnWidths[i] = columnWidths[i] * 256;
        }

        List<Order> orderList = OrderDao.getOrdersList();
        for (int i = 0; i < orderList.size(); i++ ) {
            row = sheet.createRow(i+1);
            row.setRowStyle(style);
            List<String> ordersRow = setOrdersRow(orderList.get(i));
            for (int j = 0; j < ordersRow.size(); j ++) {
                cell = row.createCell(j);
                cell.setCellStyle(style);
                HSSFRichTextString orderNumberCellValue = new HSSFRichTextString(ordersRow.get(j));
                sheet.autoSizeColumn(j);
                cell.setCellValue(orderNumberCellValue);
                sheet.autoSizeColumn(j);

                sheet.setColumnWidth(j, columnWidths[j]);
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
        Document document = new Document(PageSize.A6, 30, 20, 20, 30);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PdfWriter pdfWriter = null;
        try {
            pdfWriter = PdfWriter.getInstance(document, stream);
            document.open();
            addWaterMark(pdfWriter);
            Analyse analyse = AnalyseDao.getAnalyseById(id);
            List<String> analysesRow = setAnalysesRow(analyse);

            Paragraph analyseNumber = new Paragraph();
            analyseNumber.add(new Chunk("Analyse #", FONT_FOR_OBJECT_NAME));
            analyseNumber.add(new Chunk(analysesRow.get(0), COMMON_FONT));
            analyseNumber.setAlignment(Element.ALIGN_CENTER);
            document.add(analyseNumber);
            document.add(Chunk.NEWLINE);
            Paragraph doctorName = new Paragraph();
            doctorName.add(new Chunk("Doctor: ", FONT_FOR_OBJECT_NAME));
            doctorName.add(new Chunk(analysesRow.get(1), COMMON_FONT));
            document.add(doctorName);
            document.add(Chunk.NEWLINE);
            Paragraph clientName = new Paragraph();
            clientName.add(new Chunk("Client: ", FONT_FOR_OBJECT_NAME));
            clientName.add(new Chunk(analysesRow.get(2), COMMON_FONT));
            document.add(clientName);
            document.add(Chunk.NEWLINE);
            Paragraph name = new Paragraph();
            name.add(new Chunk("Analyse name: ", FONT_FOR_OBJECT_NAME));
            name.add(new Chunk(analysesRow.get(3), COMMON_FONT));
            document.add(name);
            document.add(Chunk.NEWLINE);
            Paragraph result = new Paragraph();
            result.add(new Chunk("Result: ", FONT_FOR_OBJECT_NAME));
            result.add(new Chunk(analysesRow.get(4), COMMON_FONT));
            document.add(result);
            document.add(Chunk.NEWLINE);
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

        HSSFCellStyle style = workbook.createCellStyle();
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
        sheet.autoSizeColumn(0);
        style.setWrapText(true);
        headerCellStyle.setWrapText(true);
        int[] columnWidths = {17, 10, 10, 20, 20};
        for (int i = 0; i < columnWidths.length; i++) {
            columnWidths[i] = columnWidths[i] * 256;
        }
        List<Analyse> analyseList = AnalyseDao.getAnalysesList();
        for (int i = 0; i < analyseList.size(); i++ ) {
            row = sheet.createRow(i+1);
            row.setRowStyle(style);
            List<String> ordersRow = setAnalysesRow(analyseList.get(i));
            for (int j = 0; j < ordersRow.size(); j ++) {
                cell = row.createCell(j);
                cell.setCellStyle(style);
                HSSFRichTextString orderNumberCellValue = new HSSFRichTextString(ordersRow.get(j));

                cell.setCellValue(orderNumberCellValue);
                sheet.autoSizeColumn(j);

                sheet.setColumnWidth(j, columnWidths[j]);

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
            String[] tempArray = {analysesRow.get(0), analysesRow.get(1), analysesRow.get(2), analysesRow.get(3), analysesRow.get(4)};
            analysesInString.add(tempArray);
        }

        writer.writeAll(analysesInString);
        writer.close();
        return stream;
    }


    private static List<String> setTreatmentsRow(Treatment treatment) {
        List<String> treatmentsRow = new LinkedList<String>();
        Cure cure = CureDao.getCureById(treatment.getCureId());

        treatmentsRow.add(String.format("%d", treatment.getId()));

        treatmentsRow.add(String.format("%s", treatment.getPrescription()));
        treatmentsRow.add(String.format("%s", cure.getName()));
        treatmentsRow.add(String.format("%s", treatment.getCureCount()));
        treatmentsRow.add(String.format("%s", treatment.getMethodOfUsing()));
        return treatmentsRow;
    }

    public static ByteArrayOutputStream generateTreatmentInPDFbyId(int id) {
        Document document = new Document(PageSize.A5, 40, 40, 40, 40);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PdfWriter pdfWriter = null;
        try {
            pdfWriter = PdfWriter.getInstance(document, stream);
            document.open();
            addWaterMark(pdfWriter);
            Treatment treatment = TreatmentDao.getTreatmentById(id);
            List<String> treatmentsRow = setTreatmentsRow(treatment);
            Paragraph treatmentNumber = new Paragraph();
            treatmentNumber.add(new Chunk("Treatment #", FONT_FOR_OBJECT_NAME));
            treatmentNumber.add(new Chunk(treatmentsRow.get(0), COMMON_FONT));
            treatmentNumber.setAlignment(Element.ALIGN_CENTER);
            document.add(treatmentNumber);
            document.add(Chunk.NEWLINE);
            Paragraph  prescription = new Paragraph();
            prescription.add(new Chunk("Prescription: ", FONT_FOR_OBJECT_NAME));
            prescription.add(new Chunk(treatmentsRow.get(1), COMMON_FONT));
            document.add(prescription);
            document.add(Chunk.NEWLINE);
            Paragraph  cure = new Paragraph();
            cure.add(new Chunk("Cure: ", FONT_FOR_OBJECT_NAME));
            cure.add(new Chunk(treatmentsRow.get(2), COMMON_FONT));
            document.add(cure);
            document.add(Chunk.NEWLINE);
            Paragraph  count = new Paragraph();
            count.add(new Chunk("Cure Count: ", FONT_FOR_OBJECT_NAME));
            count.add(new Chunk(treatmentsRow.get(3), COMMON_FONT));
            document.add(count);
            document.add(Chunk.NEWLINE);
            Paragraph  method = new Paragraph();
            method.add(new Chunk("Using method: ", FONT_FOR_OBJECT_NAME));
            method.add(new Chunk(treatmentsRow.get(4), COMMON_FONT));
            document.add(method);
            document.add(Chunk.NEWLINE);
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

    public static ByteArrayOutputStream generateTreatmentsInXLS() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("treatment");
        HSSFCellStyle headerCellStyle = workbook.createCellStyle();
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont boldFont = workbook.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerCellStyle.setFont(boldFont);

        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Treatment Number"));
        cell = row.createCell(1);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Prescription"));
        cell = row.createCell(2);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Cure"));
        cell = row.createCell(3);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Cure count"));
        cell = row.createCell(4);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Method of using"));

        sheet.autoSizeColumn(0);
        style.setWrapText(true);
        headerCellStyle.setWrapText(true);
        int[] columnWidths = {15, 15, 10, 10, 15};
        for (int i = 0; i < columnWidths.length; i++) {
            columnWidths[i] = columnWidths[i] * 256;
        }

        List<Treatment> treatmentList = TreatmentDao.getTreatmentsList();
        for (int i = 0; i < treatmentList.size(); i++ ) {
            row = sheet.createRow(i+1);
            row.setRowStyle(style);
            List<String> ordersRow = setTreatmentsRow(treatmentList.get(i));
            for (int j = 0; j < ordersRow.size(); j ++) {
                cell = row.createCell(j);
                cell.setCellStyle(style);
                HSSFRichTextString orderNumberCellValue = new HSSFRichTextString(ordersRow.get(j));
                cell.setCellValue(orderNumberCellValue);

                sheet.autoSizeColumn(j);
                sheet.setColumnWidth(j, columnWidths[j]);
            }

        }

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        workbook.write(stream);
        return  stream;
    }

    public static ByteArrayOutputStream generateTreatmentsInCSV() throws IOException {
        String[] fileHeader = {"Treatment Number", "Prescription", "Cure", "Cure Count", "Method of using"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        CSVWriter writer = new CSVWriter(new OutputStreamWriter(stream, Charset.forName("UTF-8")), ',');
        writer.writeNext(fileHeader);
        List<String[]> treatmentsInString = new LinkedList<String[]>();
        List<Treatment> treatmentList = TreatmentDao.getTreatmentsList();
        for (int i = 0; i < treatmentList.size(); i++) {
            List<String> treatmentsRow = setTreatmentsRow(treatmentList.get(i));
            String[] tempArray = {treatmentsRow.get(0), treatmentsRow.get(1), treatmentsRow.get(2),
                                    treatmentsRow.get(3), treatmentsRow.get(4)};
            treatmentsInString.add(tempArray);
        }

        writer.writeAll(treatmentsInString);
        writer.close();
        return stream;
    }

    private static List<List<List<String>>> setVisitsRow(Visit visit) {
        List<List<List<String>>> finalRow = new LinkedList<List<List<String>>>();
        List<List<String>> visitsRow = new LinkedList<List<String>>();

        List<String> visits = new LinkedList<String>();
        visits.add(String.format("%d", visit.getId()));
        visits.add(String.format("%s", visit.getComplaints()));
        visits.add(String.format("%s", visit.getDiagnosys()));
        visitsRow.add(visits);
        finalRow.add(visitsRow);

        Order order = OrderDao.getOrderById(visit.getOrderId());
        List<List<String>> ordersRow = new LinkedList<List<String>>();
        ordersRow.add(setOrdersRow(order));
        finalRow.add(ordersRow);

        List<Treatment> treatmentList = TreatmentDao.getTreatmentsListByVisitId(visit.getId());
        List<List<String>> treatmentsRow = new LinkedList<List<String>>();
        for (Treatment treatment : treatmentList) {
            treatmentsRow.add(setTreatmentsRow(treatment));
        }
        finalRow.add(treatmentsRow);

        List<Analyse> analyseList = AnalyseDao.getAnalysesListByVisitId(visit.getId());
        List<List<String>> analysesRow = new LinkedList<List<String>>();
        for (Analyse analyse : analyseList) {
            analysesRow.add(setAnalysesRow(analyse));
        }
        finalRow.add(analysesRow);
        return finalRow;
    }


    private static void generateVisitDocumentChunkPDF(Visit visit, PdfWriter pdfWriter, Document document) throws DocumentException {
        List<List<List<String>>> visitStringInfo = setVisitsRow(visit);
        List<String> visitInfo = visitStringInfo.get(0).get(0);
        addWaterMark(pdfWriter);
        Paragraph visitNumber = new Paragraph();
        visitNumber.add(new Chunk("Visit # ", FONT_FOR_OBJECT_NAME));
        visitNumber.add(new Chunk(visitInfo.get(0), COMMON_FONT));
        visitNumber.setAlignment(Element.ALIGN_CENTER);
        document.add(visitNumber);
        document.add(Chunk.NEWLINE);
        Paragraph complaints = new Paragraph();
        complaints.add(new Chunk("Complaints: ", FONT_FOR_OBJECT_NAME));
        complaints.add(new Chunk(visitInfo.get(1), COMMON_FONT));
        document.add(complaints);
        document.add(Chunk.NEWLINE);
        Paragraph diagnosis = new Paragraph();
        diagnosis.add(new Chunk("Diagnosis: ", FONT_FOR_OBJECT_NAME));
        diagnosis.add(new Chunk(visitInfo.get(2), COMMON_FONT));
        document.add(diagnosis);
        document.add(Chunk.NEWLINE);

        List<String> order = visitStringInfo.get(1).get(0);

        Paragraph beginTime = new Paragraph();
        beginTime.add(new Chunk("Begin time: ", FONT_FOR_OBJECT_NAME));
        beginTime.add(new Chunk(order.get(3), COMMON_FONT));
        document.add(beginTime);
        document.add(Chunk.NEWLINE);
        Paragraph doctorsFullName = new Paragraph();
        doctorsFullName.add(new Chunk("Doctor: ", FONT_FOR_OBJECT_NAME));
        doctorsFullName.add(new Chunk(order.get(1), COMMON_FONT));
        document.add(doctorsFullName);
        document.add(Chunk.NEWLINE);
        List<List<String>> analyses = visitStringInfo.get(3);
        if (!analyses.isEmpty()) {

            for (List<String> analyse : analyses) {
                Paragraph analyseNumber = new Paragraph();
                analyseNumber.add(new Chunk("Analyse # ", FONT_FOR_OBJECT_NAME));
                analyseNumber.add(new Chunk(analyse.get(0), COMMON_FONT));
                analyseNumber.setAlignment(Element.ALIGN_CENTER);
                document.add(analyseNumber);
                document.add(Chunk.NEWLINE);
                Paragraph analyseName = new Paragraph();
                analyseName.add(new Chunk("Analyse Name: ", FONT_FOR_OBJECT_NAME));
                analyseName.add(new Chunk(analyse.get(3), COMMON_FONT));
                document.add(analyseName);
                document.add(Chunk.NEWLINE);
                Paragraph analyseResult = new Paragraph();
                analyseResult.add(new Chunk("Result: ", FONT_FOR_OBJECT_NAME));
                analyseResult.add(new Chunk(analyse.get(4), COMMON_FONT));
                document.add(analyseResult);
                document.add(Chunk.NEWLINE);
            }
        }

        List<List<String>> treatments = visitStringInfo.get(2);
        if (!treatments.isEmpty()) {
            for (List<String> treatment : treatments) {
                Paragraph treatmentNumber = new Paragraph();
                treatmentNumber.add(new Chunk("Treatment # ", FONT_FOR_OBJECT_NAME));
                treatmentNumber.add(new Chunk(treatment.get(0), COMMON_FONT));
                treatmentNumber.setAlignment(Element.ALIGN_CENTER);
                document.add(treatmentNumber);
                document.add(Chunk.NEWLINE);
                Paragraph prescription = new Paragraph();
                prescription.add(new Chunk("Prescription: ", FONT_FOR_OBJECT_NAME));
                prescription.add(new Chunk(treatment.get(1), COMMON_FONT));
                document.add(prescription);
                document.add(Chunk.NEWLINE);
                Paragraph cure = new Paragraph();
                cure.add(new Chunk("Cure name: ", FONT_FOR_OBJECT_NAME));
                cure.add(new Chunk(treatment.get(2), COMMON_FONT));
                document.add(cure);
                document.add(Chunk.NEWLINE);
                Paragraph cureCount = new Paragraph();
                cureCount.add(new Chunk("Cure count: ", FONT_FOR_OBJECT_NAME));
                cureCount.add(new Chunk(treatment.get(3), COMMON_FONT));
                document.add(cureCount);
                document.add(Chunk.NEWLINE);
                Paragraph usingMethod = new Paragraph();
                usingMethod.add(new Chunk("Using method: ", FONT_FOR_OBJECT_NAME));
                usingMethod.add(new Chunk(treatment.get(4), COMMON_FONT));
                document.add(usingMethod);
                document.add(Chunk.NEWLINE);
            }
        }
        document.addAuthor("VetArtDim Systems");
    }

    private static void generateVisitDocumentChunkCSV(List<Visit> visitList, CSVWriter writer) throws IOException {
        List<String[]> visitInString = new LinkedList<String[]>();
        for (int i = 0; i < visitList.size(); i++) {
            List<List<List<String>>> visitStringInfo = setVisitsRow(visitList.get(i));

            List<String> visitInfo = visitStringInfo.get(0).get(0);
            String[] visitInfoArr = {visitInfo.get(0), visitInfo.get(1), visitInfo.get(2) };
            visitInString.add(visitInfoArr);

            visitInString.add(ORDER_HEADER);
            List<String> orderInfo = visitStringInfo.get(1).get(0);
            String[] orderInfoArr = {orderInfo.get(1), orderInfo.get(3)};
            visitInString.add(orderInfoArr);


            List<List<String>> treatmentsInfo = visitStringInfo.get(2);
            if (!treatmentsInfo.isEmpty()) {
                visitInString.add(EMPTY_ARRAY);
                visitInString.add(TREATMENTS_HEADER);
                for (List<String> treatment : treatmentsInfo) {
                    String[] treatmentInfoArr = {treatment.get(0), treatment.get(1), treatment.get(2),
                            treatment.get(3), treatment.get(4)};
                    visitInString.add(treatmentInfoArr);
                }
            }

            List<List<String>> analysesInfo = visitStringInfo.get(3);
            if (!analysesInfo.isEmpty()) {
                visitInString.add(EMPTY_ARRAY);
                visitInString.add(ANALYSE_HEADER);
                for (List<String> analyse : analysesInfo) {
                    String[] analyseInfoArr = {analyse.get(0), analyse.get(1), analyse.get(2)};
                    visitInString.add(analyseInfoArr);
                }
            }
            visitInString.add(EMPTY_ARRAY);
            visitInString.add(EMPTY_ARRAY);

        }

        writer.writeAll(visitInString);
        writer.close();
    }

    private static ByteArrayOutputStream generateVisitsChunkInXLS(List<Visit> visitList) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();

        HSSFSheet visitsSheet = workbook.createSheet("visits");
        HSSFSheet ordersSheet = workbook.createSheet("orders");
        HSSFSheet treatmentsSheet = workbook.createSheet("treatments");
        HSSFSheet analysesSheet = workbook.createSheet("analyses");
        HSSFCellStyle headerCellStyle = workbook.createCellStyle();
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont boldFont = workbook.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerCellStyle.setFont(boldFont);

        HSSFRow visitsRow = visitsSheet.createRow(0);
        HSSFCell visitsCell = visitsRow.createCell(0);
        visitsCell.setCellStyle(headerCellStyle);
        visitsCell.setCellValue(new HSSFRichTextString("Visit number"));
        visitsCell = visitsRow.createCell(1);
        visitsCell.setCellStyle(headerCellStyle);
        visitsCell.setCellValue(new HSSFRichTextString("Complaints"));
        visitsCell = visitsRow.createCell(2);
        visitsCell.setCellStyle(headerCellStyle);
        visitsCell.setCellValue(new HSSFRichTextString("Diagnosis"));


        HSSFRow treatmentsRow = treatmentsSheet.createRow(0);
        HSSFCell treatmentsCell = treatmentsRow.createCell(0);
        treatmentsCell.setCellStyle(headerCellStyle);
        treatmentsCell.setCellValue(new HSSFRichTextString("Treatment number"));
        treatmentsCell = treatmentsRow.createCell(1);
        treatmentsCell.setCellStyle(headerCellStyle);
        treatmentsCell.setCellValue(new HSSFRichTextString("Prescription"));
        treatmentsCell = treatmentsRow.createCell(2);
        treatmentsCell.setCellStyle(headerCellStyle);
        treatmentsCell.setCellValue(new HSSFRichTextString("Cure"));
        treatmentsCell = treatmentsRow.createCell(3);
        treatmentsCell.setCellStyle(headerCellStyle);
        treatmentsCell.setCellValue(new HSSFRichTextString("Cure Count"));
        treatmentsCell = treatmentsRow.createCell(4);
        treatmentsCell.setCellStyle(headerCellStyle);
        treatmentsCell.setCellValue(new HSSFRichTextString("Using Method"));

        HSSFRow analysesRow = analysesSheet.createRow(0);
        HSSFCell analysesCell = analysesRow.createCell(0);
        analysesCell.setCellStyle(headerCellStyle);
        analysesCell.setCellValue(new HSSFRichTextString("Analyse number"));
        analysesCell = analysesRow.createCell(1);
        analysesCell.setCellStyle(headerCellStyle);
        analysesCell.setCellValue(new HSSFRichTextString("Doctor"));
        analysesCell = analysesRow.createCell(2);
        analysesCell.setCellStyle(headerCellStyle);
        analysesCell.setCellValue(new HSSFRichTextString("Client"));
        analysesCell = analysesRow.createCell(3);
        analysesCell.setCellStyle(headerCellStyle);
        analysesCell.setCellValue(new HSSFRichTextString("Name"));
        analysesCell = analysesRow.createCell(4);
        analysesCell.setCellStyle(headerCellStyle);
        analysesCell.setCellValue(new HSSFRichTextString("Result"));

        HSSFRow ordersRow = ordersSheet.createRow(0);
        HSSFCell ordersCell = ordersRow.createCell(0);
        ordersCell.setCellStyle(headerCellStyle);
        ordersCell.setCellValue(new HSSFRichTextString("Order number"));
        ordersCell = ordersRow.createCell(1);
        ordersCell.setCellStyle(headerCellStyle);
        ordersCell.setCellValue(new HSSFRichTextString("Doctor"));
        ordersCell = ordersRow.createCell(2);
        ordersCell.setCellStyle(headerCellStyle);
        ordersCell.setCellValue(new HSSFRichTextString("Client"));
        ordersCell = ordersRow.createCell(3);
        ordersCell.setCellStyle(headerCellStyle);
        ordersCell.setCellValue(new HSSFRichTextString("Begin Time"));

        int analysesRowsCounter = 1;
        int treatmentsRowsCounter = 1;
        visitsSheet.autoSizeColumn(0);
        ordersSheet.autoSizeColumn(0);
        treatmentsSheet.autoSizeColumn(0);
        analysesSheet.autoSizeColumn(0);
        headerCellStyle.setWrapText(true);
        style.setWrapText(true);
        int[] columnWidths = {15, 15, 10, 10, 15};
        for (int k = 0; k < columnWidths.length; k++) {
            columnWidths[k] = columnWidths[k] * 256;
        }

        for (int i = 0; i< visitList.size(); i++) {
            List<List<List<String>>> visitStringInfo = setVisitsRow(visitList.get(i));
            List<String> visitInfo = visitStringInfo.get(0).get(0);
            List<String> orderInfo = visitStringInfo.get(1).get(0);
            List<List<String>> treatmentsInfo  = visitStringInfo.get(2);
            List<List<String>> analysesInfo = visitStringInfo.get(3);


            visitsRow = visitsSheet.createRow(i + 1);
            visitsRow.setRowStyle(style);
            for (int j = 0; j < visitInfo.size(); j++) {
                visitsCell = visitsRow.createCell(j);
                visitsCell.setCellStyle(style);
                HSSFRichTextString visitCellValue = new HSSFRichTextString(visitInfo.get(j));
                visitsCell.setCellValue(visitCellValue);

                visitsSheet.autoSizeColumn(j);
                visitsSheet.setColumnWidth(j, columnWidths[j]);
            }

            ordersRow = ordersSheet.createRow(i + 1);
            ordersRow.setRowStyle(style);
            for (int j = 0; j < orderInfo.size(); j++) {
                ordersCell = ordersRow.createCell(j);
                ordersCell.setCellStyle(style);
                HSSFRichTextString orderCellValue = new HSSFRichTextString(orderInfo.get(j));
                ordersCell.setCellValue(orderCellValue);
                ordersSheet.autoSizeColumn(j);
                ordersSheet.setColumnWidth(j, columnWidths[j]);
            }

            for (int j = 0; j < treatmentsInfo.size(); j++) {
                treatmentsRow = treatmentsSheet.createRow(treatmentsRowsCounter);
                treatmentsRow.setRowStyle(style);
                for (int k = 0; k < treatmentsInfo.get(i).size(); k ++) {
                    treatmentsCell = treatmentsRow.createCell(k);
                    treatmentsCell.setCellStyle(style);
                    HSSFRichTextString treatmentCellValue = new HSSFRichTextString(treatmentsInfo.get(j).get(k));
                    treatmentsCell.setCellValue(treatmentCellValue);
                    treatmentsSheet.autoSizeColumn(k);
                    treatmentsSheet.setColumnWidth(k, columnWidths[k]);
                }
                treatmentsRowsCounter++;
            }

            for (int j = 0; j < analysesInfo.size(); j++) {
                analysesRow = analysesSheet.createRow(analysesRowsCounter);
                analysesRow.setRowStyle(style);
                for (int k = 0; k < analysesInfo.get(j).size(); k ++) {
                    analysesCell = analysesRow.createCell(k);
                    analysesCell.setCellStyle(style);
                    HSSFRichTextString analysesCellValue = new HSSFRichTextString(analysesInfo.get(j).get(k));
                    analysesCell.setCellValue(analysesCellValue);
                    analysesSheet.autoSizeColumn(k);
                    analysesSheet.setColumnWidth(k, columnWidths[k]);
                }
                analysesRowsCounter++;
            }
        }

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        workbook.write(stream);
        return  stream;
    }


    public static ByteArrayOutputStream generateVisitInPDFById(int id) {
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PdfWriter pdfWriter = null;
        try {
            pdfWriter = PdfWriter.getInstance(document, stream);
            document.open();
            Visit visit = VisitDao.getVisitById(id);

            generateVisitDocumentChunkPDF(visit, pdfWriter, document);
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

    public static ByteArrayOutputStream generateVisitsInCSV() throws IOException {

        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        CSVWriter writer = new CSVWriter(new OutputStreamWriter(stream, Charset.forName("UTF-8")), ',');
        writer.writeNext(VISIT_HEADER);
        List<Visit> visitList = VisitDao.getVisitsList();
        generateVisitDocumentChunkCSV(visitList, writer);
        return stream;
    }

    public static ByteArrayOutputStream generateVisitsInXLS() throws IOException {
        return generateVisitsChunkInXLS(VisitDao.getVisitsList());
    }

    public static ByteArrayOutputStream generateMedicalHistoryInPDFbyId(int id){
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PdfWriter pdfWriter = null;
        try {
            pdfWriter = PdfWriter.getInstance(document, stream);

            document.open();
            addWaterMark(pdfWriter);
            MedicalHistory history = MedicalHistoryDao.getMedicalHistoryById(id);
            Client client = ClientDao.getClientById(history.getClientId());
            Paragraph  clientName = new Paragraph();
            clientName.add(new Chunk("MEDICAL HISTORY", FONT_FOR_OBJECT_NAME));
            clientName.add(Chunk.NEWLINE);
            clientName.add(Chunk.NEWLINE);
            clientName.add(new Chunk(client.getFirstname() + " " +
                                    client.getLastname(), COMMON_FONT));
            clientName.add(Chunk.NEXTPAGE);
            clientName.setAlignment(Element.ALIGN_CENTER);
            document.add(clientName);
            List<Visit> visitList = VisitDao.getVisitsListByMedicalHistoryId(id);
            for (Visit visit : visitList ) {
                generateVisitDocumentChunkPDF(visit, pdfWriter, document);
                document.add(Chunk.NEXTPAGE);
                addWaterMark(pdfWriter);
            }

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

    public static ByteArrayOutputStream generateMedicalHistoryInCSV(int id) throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        CSVWriter writer = new CSVWriter(new OutputStreamWriter(stream, Charset.forName("UTF-8")), ',');
        writer.writeNext(VISIT_HEADER);

        List<Visit> visitList = VisitDao.getVisitsListByMedicalHistoryId(id);
        generateVisitDocumentChunkCSV(visitList, writer);
        return stream;
    }

    public static ByteArrayOutputStream generateMedicalHistoryInXLS(int id) throws IOException {
        return generateVisitsChunkInXLS(VisitDao.getVisitsListByMedicalHistoryId(id));
    }



}
