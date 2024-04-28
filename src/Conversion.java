public class Conversion {

   private double ratio;
   private double cantidadAConvertir;

   public Conversion(double cantidadAConvertir, double ratio){
       this.cantidadAConvertir=cantidadAConvertir;
       this.ratio=ratio;
   }

    public double convierte(double cantidad, double ratio){
       if (cantidad <= 0){
           System.out.println("Ingrese un valor válido");

       }
        return cantidad * ratio;
    }


}
