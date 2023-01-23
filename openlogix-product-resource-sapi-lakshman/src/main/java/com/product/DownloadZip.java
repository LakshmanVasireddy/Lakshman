package com.product;
import java.io.*;
import java.net.*;
import java.nio.file.*;

public class DownloadZip {
   
    public static String download() throws Exception {
    	 String url = "https://www.mulesoft.com/ext/solutions/draft/resources/full-load-files.csv.gz";
         String savePath = "F:\\MuleSoft\\OpenLogix KT\\Project_Openlogix\\Download\\product.zip";
         final File file = new File(savePath);
 		file.setReadable(true, false);
 		file.setExecutable(true, false);
 		file.setWritable(true, false);

         // Open a connection to the URL
         URL urlObject = new URL(url);
         URLConnection connection = urlObject.openConnection();

         // Create a stream to read data from the URL
         InputStream in = connection.getInputStream();

         // Create a stream to write data to the save file
         OutputStream out = new FileOutputStream(savePath);

         // Read data from the URL and write it to the save file
         byte[] buffer = new byte[1024];
         int bytesRead;
         while ((bytesRead = in.read(buffer)) != -1) {
             out.write(buffer, 0, bytesRead);
         }

         // Close the streams
         in.close();
         out.close();

         System.out.println("File downloaded and saved to: " + savePath);
         return "File downloaded and saved to: " + savePath;
    }
}
