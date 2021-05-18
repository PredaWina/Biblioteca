import java.io.*;
import java.util.*;

public class ReadData {

    public static NodeBook Read(){
        
        NodeBook data = null;

        File f = new File("data.txt");
        if(f.exists()){
            Scanner sc = null;
            try{
                sc = new Scanner(new File("data.txt"));
                String aux;
                int cantLibros = 0;
                while(sc.hasNextLine()){
                    aux = sc.nextLine();
                    if(cantLibros == 0){
                        data = new NodeBook(CreateBook(aux));
                        CreateSec.SetUp(data);
                        cantLibros++;
                    }
                    else{
                        data = CreateSec.AddBook(CreateBook(aux), data);
                        cantLibros++;

                    }
                    
                }
                System.out.println("Se han creado " + cantLibros + " libros!");


            }catch(FileNotFoundException e){
                System.out.println("Error 0102: Puede que el archivo no se haya abierto correctamente.");
            }
            finally{
                if(sc != null){
                    sc.close();
                }
                
            }
        }
        else{
            System.out.println("No existen datos!");
        }
        
        return data;
    }

    public static Book CreateBook(String aux){
        Book libro = new Book();
        String nameaux = "";
        String ISBNaux = "";
        String authoraux = "";
        String editorialaux = "";
        String amountaux = "";

        
        char[] chararr = aux.toCharArray();
        int datapos = 0;

        for(int i = 0; i < chararr.length; i++){

            switch(datapos){
                case 0:
                    if(chararr[i] == ','){
                        datapos++;
                    }
                    else{
                        nameaux += chararr[i];
                    }
                    break;
                case 1:
                    if(chararr[i] == ','){
                        datapos++;
                    }
                    else{
                        ISBNaux += chararr[i];
                    }
                    break;
                case 2:
                    if(chararr[i] == ','){
                        datapos++;
                    }
                    else{
                        authoraux += chararr[i];
                    }
                    break;
                case 3:
                    if(chararr[i] == ','){
                        datapos++;
                    }
                    else{
                        editorialaux += chararr[i];
                    }
                    break;
                case 4:
                    if(chararr[i] == '|'){
                        datapos++;
                    }
                    else{
                        amountaux += chararr[i];
                    }
                    break;  
                default:
                    i = chararr.length;
            }


        }
        
        libro.name = nameaux;
        libro.ISBN = ISBNaux;
        libro.author = authoraux;
        libro.editorial = editorialaux;

        libro.amount = Integer.parseInt(amountaux);


        return libro;
    }

    public static void viewLoadedData(NodeBook nodo){
        NodeBook main = nodo;
        int aux = 1;
        if(main == null || main.data.ISBN == "0"){
            System.out.println("ERROR 0103: No hay datos cargados.");

        }
        else{
            while(main != null){
                System.out.println(main.data.toString());
                
                System.out.println("Libro numero: " + aux);
                main = main.next; 
                aux++;
            }
            System.out.println("\n--------------------");
            System.out.println("Total de libros: " + (aux - 1));
            System.out.println("--------------------");
        }
        
            
    }

    public static boolean isBookOnLoadedDataByName(NodeBook nodo, String name){
        NodeBook main = nodo;
        boolean isFound = false;

        if(main == null || main.data.ISBN == "0"){
            System.out.println("ERROR 0103: No hay datos cargados.");

        }
        else{
            while(main != null && isFound == false){
                if(main.data.name.equals(name)){
                    isFound = true;
                    
                }  
                else{
                    main = main.next;
                } 
            }
            
        }


        return isFound;
    }

    public static Book searchBookOnLoadedDataByName(NodeBook nodo, String name){
        Book libro = new Book();
        NodeBook main = nodo;
        boolean found = false;
        
        if(main == null || main.data.ISBN == "0"){
            System.out.println("ERROR 0103: No hay datos cargados.");

        }
        else{
            while(main != null && found == false){
                if(main.data.name.equals(name)){
                    libro =  main.data;     
                    found = true;
                }  
                else{
                    main = main.next;
                } 
            }
            
        }
        return libro;
    }

    public static boolean isBookOnLoadedDataByISBN(NodeBook nodo, String ISBN){
        NodeBook main = nodo;
        boolean isFound = false;

        if(main == null || main.data.ISBN == "0"){
            System.out.println("ERROR 0103: No hay datos cargados.");

        }
        else{
            while(main != null && isFound == false){
                if(main.data.ISBN.equals(ISBN)){
                    isFound = true;
                    
                }  
                else{
                    main = main.next;
                } 
            }
            
        }


        return isFound;
    }

    public static Book searchBookOnLoadedDataByISBN(NodeBook nodo, String ISBN){
        Book libro = new Book();
        NodeBook main = nodo;
        boolean found = false;
        
        if(main == null || main.data.ISBN == "0"){
            System.out.println("ERROR 0103: No hay datos cargados.");

        }
        else{
            while(main != null && found == false){
                if(main.data.ISBN.equals(ISBN)){
                    libro =  main.data;     
                    found = true;
                }  
                else{
                    main = main.next;
                } 
            }
            
        }
        return libro;
    }

    public static NodeBook deleteBookByISBN(NodeBook nodo, String ISBN){

        NodeBook main = nodo;
        boolean found = false;
        
        if(main == null || main.data.ISBN == "0"){
            System.out.println("ERROR 0103: No hay datos cargados.");

        }
        else{
            while(main != null && found == false){
                if(main.data.ISBN.equals(ISBN)){

                    if(main.next != null && main.next.data != null){ //? Borrrar todo el if despues
                        System.out.println(main.next.data.toString());
                    }
                    
                    main = main.next;
                    found = true;
                }
                else if(main.next.data.ISBN.equals(ISBN)){

                    if(main.next != null){
                        main.next = main.next.next;  
                    }
                      
                    found = true;
                }
                else{
                    main = main.next;
                } 
            }
            
        }
        return main;
    }

    public static void modifyBookByISBN(NodeBook nodo, String ISBN){

        NodeBook main = nodo;
        boolean found = false;
        
        if(main == null || main.data.ISBN == "0"){
            System.out.println("ERROR 0103: No hay datos cargados.");

        }
        else{
            while(main != null && found == false){
                if(main.data.ISBN.equals(ISBN)){
                    main.data = CreateBook.add();

                    found = true;
                }
                else{
                    main = main.next;
                } 
            }
            
        }
        
    }
}
