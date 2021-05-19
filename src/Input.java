
import java.util.*;



public class Input {
    
    public static int ObtenerNumeroEnRango(int min, int max, String msg){
        Scanner teclado = new Scanner(System.in);
        int seleccion = 0;
        
        while(seleccion < min || seleccion > max){
            System.out.println(msg);

            try{

                seleccion = teclado.nextInt();
                //sc.next();

                if(seleccion < min || seleccion > max){

                    System.out.println("ERROR 0002: Opcion fuera de rango. ");
                }
                else{
                    System.out.println("Has seleccionado: " + seleccion);
                    System.out.println("---------------------");
                }

            }catch(InputMismatchException e){
                System.out.println("ERROR 0001: Solo puedes introducir numeros. ");
                teclado.next();
            }
        }
        teclado.close();
        return seleccion;
    }

    public static String ObtenerString(String CaracteresProhibidos){
        Scanner teclado = new Scanner(System.in);
        String resultado = "";

        

        return "0";
    }
}
