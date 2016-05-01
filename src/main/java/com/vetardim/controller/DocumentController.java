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

        //makeResponse(DocumentGenerator.generatePDF(), "application/pdf", "pdffile.pdf");

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
