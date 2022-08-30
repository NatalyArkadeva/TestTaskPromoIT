import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpActions {
    private final HttpClient client;

    public HttpActions() {
        this.client = HttpClient.newHttpClient();
    }

    public String httpGetRequest(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .uri(URI.create(url))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }
}
