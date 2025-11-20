import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaConversao {
    public BuscaValorConversao valorConversao(Moeda moedaBase, Moeda moedaConverter, double valor) {
        String apiKey = System.getenv("API_KEY");

        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/"+moedaBase.getCodigo()+"/"+ moedaConverter.getCodigo()+"/"+valor);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), BuscaValorConversao.class);
        } catch (Exception e) {
            throw new RuntimeException("⚠️ Não foi possível concluirmos a requisição.");
        }
    }
}
