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

        String[] test = aux.split(",");
        libro.name = test[0];
        libro.ISBN = test[1];
        libro.author = test[2];
        libro.editorial = test[3];

        if(test[4].length() > 0){
            test[4] = test[4].substring(0, test[4].length() - 1);
            libro.amount = Integer.parseInt(test[4]);
        }
        
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
    public static void viewLoadedData(NodeBook nodo, String msgNoHayDatos){
        NodeBook main = nodo;
        int aux = 1;

        if(main == null || main.data.ISBN == "0"){
            System.out.println(msgNoHayDatos);

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

    public static void searchBookOnLoadedDataByName(NodeBook nodo, String name){
        Book libro = new Book();
        NodeBook main = nodo;
        NodeBook aux = null;
        boolean found = false;

        if(main == null || main.data.ISBN == "0"){
            System.out.println("ERROR 0103: No hay datos cargados.");
        }
        else if(isBookOnLoadedDataByISBN(main, name)){
            while(main != null && found == false){
                if(main.data.ISBN.equals(name)){
                    System.out.println(main.data.toString());   
                    found = true;
                }  
                else{
                    main = main.next;
                } 
            }
        }
        else{
            while(main != null){
                if(main.data.name.contains(name)){
                    libro =  main.data;     
                    if(aux == null){
                        aux = new NodeBook(libro);     
                    }
                    else{
                        aux = new NodeBook(libro, aux);
                    }
                    main = main.next;
                    found = true;
                }   
                else{
                    main = main.next;
                } 
            }
            if(aux != null){
                viewLoadedData(aux, "Libro(s) encontrado(s): ");
            }
        }

        if(!found){
            System.out.println("No hay concidencias");
        }
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

    public static NodeBook deleteBookByISBN(NodeBook nodo, String ISBN){

        NodeBook main = nodo;
        NodeBook aux = main;
        boolean found = false;
        
        if(main == null || main.data.ISBN == "0"){
            System.out.println("ERROR 0103: No hay datos cargados.");

        }
        else{
            if(main.data.ISBN.equals(ISBN)){

                found = true;
                aux = aux.next;
            }
            else{
                while(main.next != null && found == false){
                
                    if(main.next.data.ISBN.equals(ISBN)){
    
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
            
            
        }
        return aux;
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

    public static void addUnitByISBN(NodeBook nodo, String ISBN, int unidadesAnadidas){
        NodeBook main = nodo;
        boolean found = false;
        
        if(main == null || main.data.ISBN == "0"){
            System.out.println("ERROR 0103: No hay datos cargados.");

        }
        else{
            while(main != null && found == false){
                if(main.data.ISBN.equals(ISBN)){
                    main.data.amount += unidadesAnadidas;
                    System.out.println("Nueva cantidad: " + main.data.amount);

                    found = true;
                }
                else{
                    main = main.next;
                } 
            }
            
        }
        
    }
}
