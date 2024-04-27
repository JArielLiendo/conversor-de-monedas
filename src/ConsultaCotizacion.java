import com.google.gson.Gson;

import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCotizacion {

    public String buscaRatio(String par) {

        String direccion = "https://v6.exchangerate-api.com" +
                "/v6/028a4040c5cd466a598fe1e8/pair/" + par;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            var json = response.body();

            Gson gson= new Gson();
            RatioDeCambio ratioDeCambio = gson.fromJson(json, RatioDeCambio.class);
            //System.out.println("Gson: "+ratioDeCambio);
           // System.out.println(ratioDeCambio.conversion_rate());
            //var ratio=ratioDeCambio.conversion_rate();
            return ratioDeCambio.conversion_rate();

        }catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
