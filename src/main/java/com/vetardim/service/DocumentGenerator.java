package com.vetardim.service;

import com.lowagie.text.*;

import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.GrayColor;
import com.lowagie.text.pdf.PdfWriter;
import com.vetardim.DAO.ClientDao;
import com.vetardim.DAO.DoctorDao;
import com.vetardim.DAO.OrderDao;
import com.vetardim.model.Client;
import com.vetardim.model.Doctor;
import com.vetardim.model.Order;
import com.vetardim.util.UnixTimeConverter;
import org.apache.poi.hssf.usermodel.*;


import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.util.List;


/**
 * Created by artsiom on 4/30/16.
 */
public class DocumentGenerator {

    private static final Font fontForWaterMark = FontFactory.getFont(FontFactory.HELVETICA, 130,
                                                                    Font.BOLD, new GrayColor(0.85f));

    public static ByteArrayOutputStream generateOrderInPDFById(int id) {
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PdfWriter pdfWriter = null;
        try {
            pdfWriter = PdfWriter.getInstance(document, stream);
            document.open();
            Order order = OrderDao.getOrderById(id);
            Doctor doctor = DoctorDao.getDoctorById(order.getDoctorId());
            Client client = ClientDao.getClientById(order.getClientId());

            String doctorFullName = String.format("Doctor: %s %s %s ", doctor.getFirstname(),
                    doctor.getSecondname(),
                    doctor.getLastname());
            String clientFullName = String.format("Client: %s %s %s", client.getFirstname(),
                    client.getSecondname(),
                    client.getLastname());
            String timeOfVisit = String.format("Date: %s %s",
                    UnixTimeConverter.convertUnixTimeToTime(order.getBeginTime(), "hh:mm"),
                    UnixTimeConverter.convertUnixTimeToTime(order.getDate(), "yyyy-MM-dd"));
            String orderNumber = String.format("Order # %d", order.getId());

            Paragraph orderText = new Paragraph(orderNumber + "\n" + timeOfVisit +
                                        "\n" + doctorFullName + "\n" +
                                        clientFullName,
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
        cell.setCellValue(new HSSFRichTextString("Date"));
        cell = row.createCell(2);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Doctor"));
        cell = row.createCell(3);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Client"));

        List<Order> orderList = OrderDao.getOrdersList();
        for (int i = 1; i < orderList.size(); i++ ) {
            Doctor doctor = DoctorDao.getDoctorById(orderList.get(i).getDoctorId());
            Client client = ClientDao.getClientById(orderList.get(i).getClientId());

            String doctorFullName = String.format("%s %s %s ", doctor.getFirstname(),
                    doctor.getSecondname(),
                    doctor.getLastname());
            String clientFullName = String.format("%s %s %s", client.getFirstname(),
                    client.getSecondname(),
                    client.getLastname());
            String timeOfVisit = String.format("%s %s",
                    UnixTimeConverter.convertUnixTimeToTime(orderList.get(i).getBeginTime(), "hh:mm"),
                    UnixTimeConverter.convertUnixTimeToTime(orderList.get(i).getDate(), "yyyy-MM-dd"));
            String orderNumber = String.format("%d", orderList.get(i).getId());
            row = sheet.createRow(i);
            cell = row.createCell(0);

            HSSFRichTextString orderNumberCellValue = new HSSFRichTextString(orderNumber);
            cell.setCellValue(orderNumberCellValue);
            cell = row.createCell(1);
            HSSFRichTextString timeOfVisitCellValue = new HSSFRichTextString(timeOfVisit);
            cell.setCellValue(timeOfVisitCellValue);
            cell = row.createCell(2);
            HSSFRichTextString doctorFullNameCellValue = new HSSFRichTextString(doctorFullName);
            cell.setCellValue(doctorFullNameCellValue);
            cell = row.createCell(3);
            HSSFRichTextString clientFullNameCellValue = new HSSFRichTextString(clientFullName);
            cell.setCellValue(clientFullNameCellValue);
        }

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        workbook.write(stream);
        return  stream;
    }
}
