package org.woven.dsa;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class VideoDownloader {
    public static void downloadVideo(String videoUrl, String outputFilePath) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(videoUrl))
                    .build();

            HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());

            try (InputStream inputStream = response.body();
                 FileOutputStream outputStream = new FileOutputStream(outputFilePath)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }

            System.out.println("Video downloaded successfully to: " + outputFilePath);
        } catch (Exception e) {
            System.err.println("Error downloading video: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String videoUrl = "https://www.youtube.com/shorts/WbTUtVFFT1c"; // Replace with actual video URL
        String outputFilePath = "downloaded_video.mp4";

        downloadVideo(videoUrl, outputFilePath);
    }
}
