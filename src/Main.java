import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException{
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o livro que você deseja pesquisar: ");
        var book = scanner.nextLine();

        String url = "https://www.googleapis.com/books/v1/volumes?q=" + book + "&key=myKey"; // insira a chave da API do Google Books aqui

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}