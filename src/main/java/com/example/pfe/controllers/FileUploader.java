package  com.example.pfe.controllers;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileUploader {
    private static final String UPLOAD_URL = "http://localhost:80/"; // Replace with your server URL

    public static void uploadFile(File file, String filePath) {
        System.out.println("file : "+file.getAbsoluteFile());
        if (file.isFile()==true){
            System.out.println("this is a file");
        }
        try {
            URL url = new URL(UPLOAD_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            // Set request headers
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=---Boundary");

            // Create the request body
            OutputStream outputStream = connection.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream));

            // Set the file parameter name and the file data
            writer.println("-----Boundary");
            writer.println("Content-Disposition: form-data; name=\"file\"; filename=\"" + file.getName() + "\"");
            writer.println("Content-Type: application/octet-stream");
            writer.println();

            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            writer.println();
            writer.println("-----Boundary--");
            writer.close();

            // Get the response from the server
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // File uploaded successfully
                // Read the response if needed
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String response = reader.readLine();
                reader.close();

                System.out.println("File uploaded successfully. Link path: " + response);
            } else {
                // Handle the error case
                System.out.println("File upload failed. Response Code: " + responseCode);
            }

            // Close connections
            outputStream.close();
            fileInputStream.close();
            connection.disconnect();

            // Move the file to the desired location
            File uploadedFile = new File(filePath);
            file.renameTo(uploadedFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}