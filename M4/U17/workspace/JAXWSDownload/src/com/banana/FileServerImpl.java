package com.banana;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

//Service Implementation Bean  
@MTOM
@WebService(endpointInterface = "com.banana.FileServer")
public class FileServerImpl implements FileServer {
	@Override
	public DataHandler downloadFile(String fileName) {
		// Location of File in Web service
		FileDataSource dataSource = new FileDataSource("c:/test/" + fileName);
		
		DataHandler fileDataHandler = new DataHandler(dataSource);
		System.out.println("****fileDataHandler defined:"+dataSource.getFile().getAbsolutePath());
		return fileDataHandler;
	}
}