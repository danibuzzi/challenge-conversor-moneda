import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        boolean iterar=true;
        while (iterar){
            Scanner entrada =new Scanner(System.in);
            //pido cantidad
            double cantidad;
            double cantidadConseguida=0;
            GeneradorDeArchivos generarAchivo =new GeneradorDeArchivos();
            Moneda mon=null;
            int opcion=0;
            ConversionMoneda convertir =new ConversionMoneda();
            mostrarMenu();

           //do {
               opcion = entrada.nextInt();

               System.out.println("Ingrese la cantidad a cambiar ");
               cantidad = entrada.nextDouble();
           //}while (!Integer.valueOf(opcion)) || Double.valueOf(cantidad)!=false)


            switch (opcion){
                case 1:{
                    mon=convertir.convertirMonedas("USD","ARS");
                    System.out.println(mon);
                    cantidadConseguida = Math.round((cantidad * (Double.valueOf(mon.conversion_rate()))));
                    System.out.println(cantidad +" dolares equivale a "+ cantidadConseguida+ " pesos argentinos");

                    break;
                }
                case 2:{
                    mon=convertir.convertirMonedas("ARS","USD");
                    cantidadConseguida = (cantidad * (Double.valueOf(mon.conversion_rate())));
                    System.out.println(cantidad +" pesos agentinos equivale a "+ cantidadConseguida+ " dolares");
                    break;
                }
                case 7:{
                    System.out.println("Historico de intercambios realizados\n");
                    generarAchivo.leerArchivo(new File("intercambios.json"));
                   break;
                }
                case 8:{

                    iterar =false;
                    System.out.println("Programa finalizado");
                    break;
                     }
                default: {
                    System.out.println("Opcion seleccionada no vàlida");
                }
            }
            if(opcion >=1 && opcion <8 && mon!=null && cantidadConseguida!= 0 ){
                //GeneradorDeArchivos generarAchivo =new GeneradorDeArchivos();
                try{
                    generarAchivo.guardarJson(mon,cantidadConseguida);
                }catch(IOException e){
                    System.out.println(e.getMessage());
                }

            }
        }

    }
    public static void mostrarMenu(){
        System.out.println("""
                *****************************************************
                Bienvenido al conversor de monedas
                
                1) Dólar ===> Peso argentino
                2) Peso argentino ===> Dòlar
                3) Real brasileño ===> Dólar
                4) Dólar ===> Real brasileño
                5) Dólar ===> Peso colombiano
                6) Peso colombiano ===> Dólar
                7) Histórico de conversiones
                8) Salir
                
                Elija una opción válida:
                ******************************************************
                """);
    }

}
