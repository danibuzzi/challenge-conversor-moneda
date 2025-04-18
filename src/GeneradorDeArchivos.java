import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class GeneradorDeArchivos {

    public void guardarJson (Moneda moneda, Double cantidadConseguida) throws IOException{
        Gson gson=new GsonBuilder()
                .setPrettyPrinting()
                .create();


           FileWriter escritura = new FileWriter("intercambios.json",true);;
           //escritura.write(gson.toJson(moneda+ String.valueOf(cantidadConseguida)+ String.valueOf(Calendar.DATE) ));
           escritura.write(gson.toJson(moneda));
           escritura.close();

    }
    public void leerArchivo(File f) throws IOException {
        FileReader fr=new FileReader(f);
        int valor=fr.read();
        while(valor!=-1){
            System.out.print((char)valor);
            valor=fr.read();
        }
        //Cerramos
        fr.close();

    }

}
