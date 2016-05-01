package com.vetardim.service;

import com.lowagie.text.*;

import com.lowagie.text.pdf.BaseFont;
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


import java.io.ByteArrayOutputStream;


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
            pdfWriter.a
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

    public static ByteArrayOutputStream generateOrderIn
}
