import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {

        boolean iterar=true;
        double cantidad=0.0;
        Scanner entrada =new Scanner(System.in);
        int opcion=0;

        while (iterar){

            double cantidadConseguida=0;
            GeneradorDeArchivos generarAchivo =new GeneradorDeArchivos();
            Moneda mon=null;

            ConversionMoneda convertir =new ConversionMoneda();
            mostrarMenu();

                do {

                    opcion = entrada.nextInt();

                    System.out.println("Debe ingresar  un nummero de valor entre 1 y 8 ");
                } while ((opcion > 8) || (opcion < 1));

            if((opcion>=1) && (opcion <7)){
                System.out.println("Ingrese la cantidad a cambiar ");

                cantidad = entrada.nextDouble();

            }


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
                case 3:{
                    mon=convertir.convertirMonedas("USD","BRL");
                    cantidadConseguida = (cantidad * (Double.valueOf(mon.conversion_rate())));
                    System.out.println(cantidad +" dolares equivale a "+ cantidadConseguida+ " pesos brasileños");
                    break;
                }
                case 4:{
                    mon=convertir.convertirMonedas("BRL","USD");
                    cantidadConseguida = (cantidad * (Double.valueOf(mon.conversion_rate())));
                    System.out.println(cantidad +" reales brasileños equivale a "+ cantidadConseguida+ " dolares");
                    break;
                }
                case 5:{
                    mon=convertir.convertirMonedas("USD","COP");
                    cantidadConseguida = (cantidad * (Double.valueOf(mon.conversion_rate())));
                    System.out.println(cantidad +" dolares  a "+ cantidadConseguida+ " pesos colombianos");
                    break;
                }
                case 6:{
                    mon=convertir.convertirMonedas("COP","USD");
                    cantidadConseguida = (cantidad * (Double.valueOf(mon.conversion_rate())));
                    System.out.println(cantidad +" pesos colombianos equivale a "+ cantidadConseguida+ " dolares");
                    break;
                }
                case 7:{
                    System.out.println("Historico de intercambios realizados\n");
                    generarAchivo.leerArchivo(new File("intercambios.json"));
                   break;
                }
                case 8:{

                    System.out.println("Programa finalizado");
                    iterar=false;
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
