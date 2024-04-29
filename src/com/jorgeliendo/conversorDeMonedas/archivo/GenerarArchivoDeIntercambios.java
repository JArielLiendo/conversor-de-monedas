package com.jorgeliendo.conversorDeMonedas.archivo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GenerarArchivoDeIntercambios {

    public void guardarIntercambio(RegistroIntercambios registroIntercambios) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        LocalDateTime fechaYHora= LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
        String fechaHoraFormateada = fechaYHora.format(formatter);

        String rutaArchivo = "archivoMovimientos/ "+fechaHoraFormateada+".Json";
        FileWriter escritura = new FileWriter(rutaArchivo);
        escritura.write(gson.toJson(registroIntercambios));
        escritura.close();
    }
}
