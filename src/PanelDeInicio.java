import java.util.spi.AbstractResourceBundleProvider;

public class PanelDeInicio {
    String parDeCambio;
    int opcion;

    String panel =  """ 
            ************************************************
            Sea bienvenido al conversor de monedas
             1) Dólar ==> Peso Argentino
             2) Peso Argentino ==> Dólar
             3) Dólar ==> Real
             4) Real ==> Dólar
             5) Dólar ==> Peso Colombiano
             6) Peso Colombiano ==> Dólar
             7) Salir
             Elija una opción válida.
            ************************************************
            """;

    public String seleccionaParDeCambio (int opcion) {


        switch (opcion) {

            case 1:
                parDeCambio = "USD/ARS";
                break;
            case 2:
                parDeCambio = "ARS/USD";
                break;
            case 3:
                parDeCambio = "USD/BRL";
                break;
            case 4:
                parDeCambio = "BRL/USD";
                break;
            case 5:
                parDeCambio = "USD/COP";
                break;
            case 6:
                parDeCambio = "COP/USD";
                break;
        }

        return parDeCambio;

    }

}
