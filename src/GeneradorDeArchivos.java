import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class GeneradorDeArchivos {

    public void guardarJson (Moneda moneda, Double cantidadConseguida) throws IOException{
        Gson gson=new GsonBuilder()
                .setPrettyPrinting()
                .create();

           FileWriter escritura = new FileWriter("intercambios.json");;
           escritura.write(gson.toJson(moneda+ String.valueOf(cantidadConseguida)+ String.valueOf(Calendar.DATE) ));
           escritura.close();

    }
}
