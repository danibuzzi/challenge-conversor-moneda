import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversionMoneda {
public Moneda convertirMonedas(String monedaBase ,String  monedaObjetivo){

    String direccion="https://v6.exchangerate-api.com/v6/7c0f0daf84b89cc738145b42/pair/"+ monedaBase+
            "/"+monedaObjetivo+"/";
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(direccion))
            .build();

    try{
        HttpResponse<String> response= client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return new Gson().fromJson(response.body(),Moneda.class);

    } catch (Exception e) {
        throw new RuntimeException("Error en la transacción");
    }

}
}
