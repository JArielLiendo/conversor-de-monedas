import com.google.gson.JsonSyntaxException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        while (true) {

            PanelDeInicio panelDeInicio = new PanelDeInicio();
            System.out.println(panelDeInicio.panel);

            try {
                var entrada=teclado.next();
                panelDeInicio.opcion = Integer.valueOf(entrada);
                if (panelDeInicio.opcion == 7) {
                    System.out.println("Gracias por usar nuestros servicios.");
                    break;
                }

                var parDeCambio = panelDeInicio.seleccionaParDeCambio(panelDeInicio.opcion);

                ConsultaCotizacion consultaCotizacion = new ConsultaCotizacion();
                var ratio = Double.parseDouble(consultaCotizacion.buscaRatio(parDeCambio));

                var monedaBase = parDeCambio.substring(0, 3);
                var monedaDestino = parDeCambio.substring(4, 7);


                System.out.println("Ingresa el valor de ["+monedaBase+"] que deceas convertir:");
                var cantidadACambiar = teclado.nextDouble();
                Conversion conversion = new Conversion(cantidadACambiar, ratio);
                //double resultado;
               var resultado = conversion.convierte(cantidadACambiar, ratio);
                System.out.println("A cambiado " + cantidadACambiar + " [" +
                        monedaBase + "] por ==> " + resultado +
                        " [" + monedaDestino+"]");
            } catch (JsonSyntaxException e) {
                System.out.println("Ingrese una opción valida entre 1 y 7.");
            }catch (NumberFormatException e){
                System.out.println("Verifique su opción ingresada");
            }catch (InputMismatchException e){
                System.out.println("Verifique sus datos ingresados," +
                        "debe ser un número entero o decimal.");
            }
        }

    }
}

