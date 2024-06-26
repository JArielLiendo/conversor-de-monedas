import com.google.gson.JsonSyntaxException;
import com.jorgeliendo.conversorDeMonedas.archivo.GenerarArchivoDeIntercambios;
import com.jorgeliendo.conversorDeMonedas.archivo.RegistroIntercambios;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

            while (true) {

                PanelDeInicio panelDeInicio = new PanelDeInicio();
                System.out.println(panelDeInicio.panel);
                double cantidadACambiar;
                double resultado;

                try {

                    panelDeInicio.opcion = Integer.valueOf(teclado.next());
                    if (panelDeInicio.opcion == 7) {
                        System.out.println("Gracias por usar nuestros servicios.");
                        break;
                    }

                    var parDeCambio = panelDeInicio.seleccionaParDeCambio(panelDeInicio.opcion);

                    ConsultaCotizacion consultaCotizacion = new ConsultaCotizacion();
                    var ratio = Double.parseDouble(consultaCotizacion.buscaRatio(parDeCambio));

                    var monedaBase = parDeCambio.substring(0, 3);
                    var monedaDestino = parDeCambio.substring(4, 7);

                    while (true) {

                        System.out.println("Ingresa el valor de [" + monedaBase + "] que deseas convertir a: ["+monedaDestino+"]" );
                        var cantidad = teclado.next();
                        cantidad = cantidad.replace(",", ".");

                        cantidadACambiar = Double.parseDouble(cantidad);

                        if (cantidadACambiar > 0) {
                            Conversion conversion = new Conversion(cantidadACambiar, ratio);
                            resultado = conversion.convierte(cantidadACambiar, ratio);
                            System.out.println("A cambiado " + cantidadACambiar + " [" +
                                    monedaBase + "] por ==> " + resultado +
                                    " [" + monedaDestino + "]");

                            break;
                        } else {
                            System.out.println("El valor ingresado debe ser mayor que 0 (cero)\n");
                        }
                    }

                    RegistroIntercambios registroIntercambios= new RegistroIntercambios(parDeCambio, cantidadACambiar, resultado);
                    GenerarArchivoDeIntercambios generarArchivoDeIntercambios = new GenerarArchivoDeIntercambios();
                    generarArchivoDeIntercambios.guardarIntercambio(registroIntercambios);

                } catch (JsonSyntaxException e) {
                    System.out.println("Ingrese una opción valida entre 1 y 7.");

                } catch (NumberFormatException e) {

                    System.out.println("Verifique los datos ingresados");

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
    }
}

