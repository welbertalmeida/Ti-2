import java.net.http.*;
import java.net.URI;
import java.io.IOException;
import java.nio.file.Path;

public class AzureOCR {
    public static void main(String[] args) throws IOException, InterruptedException {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
            .uri(URI.create("https://<seu-endpoint>.cognitiveservices.azure.com/vision/v3.2/ocr"))
            .header("Ocp-Apim-Subscription-Key", "<sua-chave>")
            .header("Content-Type", "application/octet-stream")
            .POST(HttpRequest.BodyPublishers.ofFile(Path.of("extrato.png")))
            .build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}

