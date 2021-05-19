import java.util.*;



public class Input {
    
    public static int ObtenerNumeroEnRango(int min, int max, String msg){
        Scanner teclado = new Scanner(System.in);
        int seleccion = 0;
        
        do{
            System.out.println(msg);

            try{

                seleccion = teclado.nextInt();
                //teclado.next();

                if(seleccion < min || seleccion > max){

                    System.out.println("ERROR 0002: Opcion fuera de rango. ");
                }
                else{
                    System.out.println("Has introducido: " + seleccion);
                    System.out.println("---------------------");
                }

            }catch(InputMismatchException e){
                System.out.println("ERROR 0001: Solo puedes introducir numeros. ");
                teclado.next();
            }
        }while(seleccion < min || seleccion > max);
       
            
        //teclado.close();
        return seleccion;
    }

    public static String ObtenerString(char[] CaracteresProhibidos, String msg){
        Scanner teclado = new Scanner(System.in);
        String resultado = "";
        boolean keepGoing = true;
        String aux;

        do{
            try{
                //teclado.nextLine();  
                System.out.println(msg);
                resultado = teclado.nextLine();  
                for(int i = 0; i < CaracteresProhibidos.length; i++){
                    aux = CaracteresProhibidos[i] + "";
                    if(resultado.contains(aux)){
                        keepGoing = true;
                        System.out.println("Has introducido caracteres prohibidos!");
                        System.out.println("---------------------------------------");
                        break;
                    }else{
                        keepGoing = false; 
                    }
                }
                if(!keepGoing){
                    System.out.println("Has introducido: " + resultado);
                    System.out.println("---------------------");
                }
                

            }catch(InputMismatchException e){

                System.out.println("Error 0003: Se perdian caracteres ASCII, se obtuvo otra cosa.");
                keepGoing = true;
                teclado.next();

            }
        }
        while(keepGoing);

        //teclado.close();

        return resultado;
    }
}
