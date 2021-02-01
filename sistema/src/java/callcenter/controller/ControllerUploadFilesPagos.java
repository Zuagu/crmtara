/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callcenter.controller;

import callcenter.model.ModelProcesadorCsv;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author zuagu
 */
public class ControllerUploadFilesPagos extends HttpServlet {
    
    
    private static final String UPLOAD_DIRECTORY = "upload";
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 500; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 500; // 50MB

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload = new ServletFileUpload(factory);

        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(MAX_REQUEST_SIZE);
        
        String responseDb = "";
        String fileName = "";
        String filePath = "";
        File dir = new File(".");
        String uploadPath = dir.getCanonicalPath().replace("\\bin", "");
        //System.out.println(uploadPath);
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            //uploadDir.mkdir();
        }
        Boolean status_file = false;
        try {
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
            if (formItems != null && formItems.size() > 0) {
                for (FileItem item : formItems) {
                    if (!item.isFormField()) {
                        fileName = new File(item.getName()).getName();
                        //System.out.println("paso por qui " + fileName );
//                        filePath = uploadPath + File.separator + "webapps/sistema/excel/" + fileName;
                        filePath = "/opt/tomcat/webapps/sistema/excel/" + fileName;
//                        filePath = "C:\\\\Users\\\\Public\\\\" + fileName;
                        
                        File storeFile = new File(filePath);
                        if (storeFile.delete()){
                            //System.out.println("El fichero ha sido borrado satisfactoriamente");
                        } else {
                            System.out.println("El fichero no puede ser borrado");
                        }
                        System.out.println(filePath);
                        item.write(storeFile);
                        status_file = true;
                        request.setAttribute("message", "Archivo: " + fileName + " cargado corectamente!");
                    }
                }
            }
            if(status_file) {
                responseDb = ModelProcesadorCsv.cargar_pagos_azteca(filePath);
                request.setAttribute("message_db", responseDb);
                //System.out.println(responseDb);
            }
            
        } catch (Exception ex) {
            request.setAttribute("message", "Hubo un error en la ruta: " + filePath + " al cargar el archivo: " + ex.getMessage());
            request.setAttribute("message_db", responseDb);
            request.setAttribute("jsp_redirecion", "carga-pagos-azteca.jsp");
        }
        getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
