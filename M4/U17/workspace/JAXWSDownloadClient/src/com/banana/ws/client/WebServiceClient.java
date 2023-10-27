package com.banana.ws.client;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.banana.ws.binary.client.FileServer;
import com.banana.ws.binary.client.FileServerImplService;
 
/**
 * A client program that connects to a web service in order to upload
 * and download files.
 * @author www.codejava.net
 *
 */
public class WebServiceClient {
 
    public static void main(String[] args) {
        // connects to the web service
        FileServerImplService client = new FileServerImplService();
        FileServer service = client.getFileServerImplPort();
         
        String fileName = "test.pdf";
        String filePath = "d:/" + fileName;
            
         
        byte[] fileBytes = service.downloadFile(fileName);
         
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            BufferedOutputStream outputStream = new BufferedOutputStream(fos);
            outputStream.write(fileBytes);
            outputStream.close();
             
            System.out.println("File downloaded: " + filePath);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}