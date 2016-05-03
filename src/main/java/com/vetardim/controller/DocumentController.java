package com.vetardim.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletResponseAware;
import com.vetardim.service.DocumentGenerator;
import com.opensymphony.xwork2.ActionSupport;
/**
 * Created by artsiom on 5/1/16.
 */
public class DocumentController extends ActionSupport implements ServletResponseAware {

    private HttpServletResponse response;
    private int id;

    private void makeResponse(ByteArrayOutputStream stream, String contentType, String fileName) throws IOException {
        response.setContentType(contentType);
        response.setHeader("Content-Disposition",
                "inline; filename=" + fileName);
        response.setContentLength(stream.size());

        OutputStream os = response.getOutputStream();
        os.write(stream.toByteArray());
        os.flush();
        os.close();
        stream.reset();
    }
    @Override
    public String execute() throws Exception {

        return super.execute();
    }

    public String getOrderPDF() throws IOException {
        makeResponse(DocumentGenerator.generateOrderInPDFById(getId()), "application/pdf", "order.pdf");
        return NONE;
    }

    public String getOrdersXLS() throws IOException {
        makeResponse(DocumentGenerator.generateOrdersInXLS(), "application/vnd.ms-excel", "orders.xls");
        return NONE;
    }
    public String getOrdersCSV() throws IOException {
        makeResponse(DocumentGenerator.generateOrdersInCSV(), "text/csv", "orders.csv");
        return NONE;
    }

    public String getAnalysePDF() throws IOException {
        makeResponse(DocumentGenerator.generateAnalyseInPDFById(getId()), "application/pdf", "analyse.pdf");
        return NONE;
    }

    public String getAnalysesXLS() throws IOException {
        makeResponse(DocumentGenerator.generateAnalysesInXLS(), "application/vnd.ms-excel", "analyses.xls");
        return NONE;
    }
    public String getAnalysesCSV() throws IOException {
        makeResponse(DocumentGenerator.generateAnalysesInCSV(), "text/csv", "analyses.csv");
        return NONE;
    }

    public String getTreatmentPDF() throws IOException {
        makeResponse(DocumentGenerator.generateTreatmentInPDFbyId(getId()), "application/pdf", "treatment.pdf");
        return NONE;
    }

    public String getTreatmentsXLS() throws IOException {
        makeResponse(DocumentGenerator.generateTreatmentsInXLS(), "application/vnd.ms-excel", "treatments.xls");
        return NONE;
    }
    public String getTreatmentsCSV() throws IOException {
        makeResponse(DocumentGenerator.generateTreatmentsInCSV(), "text/csv", "treatments.csv");
        return NONE;
    }

    public String getVisitPDF() throws IOException {
        makeResponse(DocumentGenerator.generateVisitInPDFById(getId()), "application/pdf", "visit.pdf");
        return NONE;
    }

    public String getVisitsCSV() throws IOException {
        makeResponse(DocumentGenerator.generateVisitsInCSV(), "text/csv", "visits.csv");
        return NONE;
    }
    public String getVisitsXLS() throws IOException {
        makeResponse(DocumentGenerator.generateVisitsInXLS(), "application/vnd.ms-excel", "visits.xls");
        return NONE;
    }

    public String getMedicalHistoryPDF() throws IOException {
        makeResponse(DocumentGenerator.generateMedicalHistoryInPDFbyId(getId()), "application/pdf", "MedicalHistory.pdf");
        return NONE;
    }

    public String getMedicalHistoryCSV() throws IOException {
        makeResponse(DocumentGenerator.generateMedicalHistoryInCSV(getId()), "text/csv", "MedicalHistory.csv");
        return NONE;
    }
    public String getMedicalHistoryXLS() throws IOException {
        makeResponse(DocumentGenerator.generateMedicalHistoryInXLS(getId()), "application/vnd.ms-excel", "MedicalHistory.xls");
        return NONE;
    }
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
