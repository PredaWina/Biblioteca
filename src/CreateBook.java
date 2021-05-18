import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateBook {

    public static Book add(){
        Book libro = new Book();

        Scanner teclado = new Scanner(System.in);
        
        boolean seguir = true;
        int caso = 0;
        while(seguir){
            switch(caso){
                case 0:
                    try{
                        System.out.println("Introduce el *nombre* del libro: ");
                        
                        libro.name = teclado.nextLine();
                        caso++;
        
                    }catch(InputMismatchException e){
                        System.out.println("ERROR 0003: Solo puedes introducir carácteres ASCII");
                        
                    }catch(NoSuchElementException e){
                        System.out.println("ERROR 1002: No tengo ni idea");
                        teclado.next();
                    }

                  
                    break;
                case 1:
                    try{
                        System.out.println("Introduce el *ISBN* del libro: ");
                        libro.ISBN = teclado.nextLine();
                        caso++;
        
                    }catch(InputMismatchException e){
                        System.out.println("ERROR 0003:: Solo puedes introducir carácteres ASCII");
                    }
   
                    break;
                case 2:
                    try{
                        System.out.println("Introduce el *autor* del libro: ");
                        libro.author = teclado.nextLine();
                        caso++;
        
                    }catch(InputMismatchException e){
                        System.out.println("ERROR 0003: Solo puedes introducir carácteres ASCII");
                    }

                    break;
                case 3:
                    try{
                        System.out.println("Introduce la *editorial* del libro: ");
                        libro.editorial = teclado.nextLine();
                        caso++;
        
                    }catch(InputMismatchException e){
                        System.out.println("ERROR 0003: Solo puedes introducir carácteres ASCII");
                    }

                    break;
                case 4:
                    try{
                        System.out.println("Introduce la *cantidad* de libros: ");
                        libro.amount = teclado.nextInt();

                        seguir = false;
                        
                        

        
                    }catch(InputMismatchException e){
                        System.out.println("ERROR 0001: Solo puedes introducir numeros enteros");
                        teclado.next();
                    }
                break;
                default:
                    System.out.println(	"Me pase? WTF");
            }
        }
        
        
        return libro;

    }
}