/** Programa de cosola para la gestion de una biblioteca.
 * 
 * 
 * Los datos se guardan en un fichero de texto sin codificar. Funciona exclusivamente a traves de la consola.
 * El programa es una chapuza pero funciona completamente.
 * 
 * 
 * Lista de errores posibles: 
 * Error 0001: Se pedia exclusivamente un numero entero, se obtuvo otra cosa.
 * Error 0002: Se pedia un numero entre un rango determinado, se obtuvo un numero fuera de rango.
 * Error 0003: Se perdian caracteres ASCII, se obtuvo otra cosa.
 * 
 * Error 0101: No existen o no se encuentras los datos.
 * Error 0102: No se ha podido abrir, leer o modificar un archivo.
 * Error 0103: No hay datos cargados.
 * 
 * Error 1001: Error desconocido en el menu.
 * Error 1002: Error desconocido durante la creacion de un libro.
 */

import java.util.*;

public class Biblioteca {
    public static void main(String[] args) {
        

        final float version = 1.3f;
        boolean exe = true;
        int seleccion = 0;
        Scanner sc = new Scanner(System.in);

        Book libro = new Book();
        NodeBook main = new NodeBook(libro);
        CreateSec.SetUp(main); //* Set up de la clase para poder manejar la secuencia.
    
        System.out.println("\nBienvenidos al software para el control de tu biblioteca. Version: " + version + "\n\n");
        
        
        while(exe){
            System.out.println(" ---------------------Opciones----------------------");
            System.out.println("|                                                   |");
            System.out.println("| [1]. Cargar datos                                 |");
            System.out.println("| [2]. Guardar datos                                |");
            System.out.println("| [3]. Buscar un libro                              |");
            System.out.println("| [4]. Anyadir libro                                |");
            System.out.println("| [5]. Eliminar libro                               |");
            System.out.println("| [6]. Modificar un libro                           |");
            System.out.println("| [7]. Ver todos los libros                         |");
            System.out.println("| [8]. Borrar TODOS los datos                       |");
            System.out.println("| [9]. Salir                                        |");
            System.out.println("|                                                   |");
            System.out.println(" ---------------------------------------------------");
            
            while(seleccion < 1 || seleccion > 9){
                System.out.println("Seleccione una opcion: ");

                try{

                    seleccion = sc.nextInt();
                    //sc.next();

                    if(seleccion < 1 || seleccion > 9){
                        System.out.println("ERROR 0002: Opcion fuera de rango. ");
                    }
                    else{
                        System.out.println("Has seleccionado: " + seleccion);
                        System.out.println("---------------------");
                    }

                }catch(InputMismatchException e){
                    System.out.println("ERROR 0001: Solo puedes introducir numeros. ");
                    sc.next();
                }
              
                

                
            }


            switch(seleccion){
                case 1:
                    System.out.println("Cargando datos... ");
                    System.out.println("---------------------");

                    main = ReadData.Read();

                    seleccion = 0;
                    break;
                case 2:
                    System.out.println("Guardando datos... ");
                    WriteData.SustituirData(main);
                    System.out.println("Datos guardados con exito! ");
                    seleccion = 0;

                    break;
                case 3: 
                    int searchType = 0;
        
                    do{
                        try{
                            System.out.println("Quieres buscar por ISBN[1](Recomendado) o quieres buscar por nombre[2]? Pulse 3 para cancelar.");
                            searchType = sc.nextInt();  
                            sc.nextLine();
            
                        }catch(InputMismatchException e){
            
                            System.out.println("ERROR 0001: Solo puedes introducir numeros. ");
                            sc.next(); 
            
                        }
                        
                    }
                    while(searchType < 1 || searchType > 3);
                    
                    if(searchType == 3){
                        System.out.println("Cancelando... ");
                    }
                    else if(searchType == 2){
                        boolean seguirBuscandoName = true;
                        String auxName = "";
                        do{
                            try{
                                System.out.println("Introduce el nombre del libro a buscar: ");
                                 
                                auxName = sc.nextLine();  
                                seguirBuscandoName = false;
                
                            }catch(InputMismatchException e){
                
                                System.out.println("Error 0003: Se perdian caracteres ASCII, se obtuvo otra cosa.");
                                seguirBuscandoName = true;
                                sc.next();
                
                            }
                        }
                        while(seguirBuscandoName);

                        if(ReadData.isBookOnLoadedDataByName(main, auxName)){
                            System.out.println("Se ha encontrado el libro: ");
                            System.out.println(ReadData.searchBookOnLoadedDataByName(main, auxName).toString());
                        }   
                        else{
                            System.out.println("No hay ningun libro con exactamente ese nombre.");
                        }
 
                    }
                    else{
                        boolean seguirBuscandoISBN = true;
                        String auxISBN = "";
                        do{
                            try{
                                System.out.println("Introduce el ISBN del libro a buscar: ");
                                auxISBN = sc.nextLine();  
                                seguirBuscandoISBN = false;
                
                            }catch(InputMismatchException e){
                
                                System.out.println("ERROR 0001: Solo puedes introducir numeros. ");
                                seguirBuscandoISBN = true;
                                sc.next();
                
                            }
                        }
                        while(seguirBuscandoISBN);

                        if(ReadData.isBookOnLoadedDataByISBN(main, auxISBN)){
                            System.out.println("Se ha encontrado el libro: ");
                            System.out.println(ReadData.searchBookOnLoadedDataByISBN(main, auxISBN).toString());
                        }   
                        else{
                            System.out.println("No hay ningun libro con exactamente ese ISBN.");
                        }

                    }

                    
                    seleccion = 0;

                    break;
                case 4:
                    System.out.println("Introduce los datos del libro: ");
                    main = CreateSec.AddBook(CreateBook.add(), main);  
                    
                    main.data.toString();
                    System.out.println("El libro se ha anyadido con exito! "); 
                    

                    seleccion = 0;

                    break;
                case 5:
                    boolean seguirBuscandoISBNBorrar = true;
                    String auxISBNBorrar = "";

                    do{
                        try{
                            sc.nextLine();  
                            System.out.println("Introduce el ISBN del libro a BORRAR(Para cancelar escribe 0): ");
                            auxISBNBorrar = sc.nextLine();  
                            seguirBuscandoISBNBorrar = false;
            
                        }catch(InputMismatchException e){
            
                            System.out.println("ERROR 0001: Solo puedes introducir numeros. ");
                            seguirBuscandoISBNBorrar = true;
                            sc.next();
            
                        }
                    }
                    while(seguirBuscandoISBNBorrar);

                    if(ReadData.isBookOnLoadedDataByISBN(main, auxISBNBorrar)){
                        System.out.println("Se ha BORRADO el libro: ");
                        System.out.println(ReadData.searchBookOnLoadedDataByISBN(main, auxISBNBorrar).toString());
                        main = ReadData.deleteBookByISBN(main, auxISBNBorrar);
                    }   
                    else{
                        System.out.println("No hay ningun libro con exactamente ese ISBN.");
                    }

                    seleccion = 0;

                    break;
                case 6:
                    boolean seguirBuscandoISBNModficar = true;
                    String auxISBNModficar = "";

                    boolean seguirBuscandoSelectModficar = true;
                    int selectModify = 0;

                    boolean seguirBuscandoCantidadModificar = true;
                    int cantidadModify = 0;

                    do{
                        try{
                            sc.nextLine();  
                            System.out.println("¿Quieres modificar los datos[1], añadir una unidad[2], cancelar[0]?: ");
                            selectModify = sc.nextInt();  
                            if(selectModify >= 0 && selectModify < 3){
                                seguirBuscandoSelectModficar = false;
                            }
                            else{
                                seguirBuscandoISBNModficar = true;
                            }
            
                        }catch(InputMismatchException e){
            
                            System.out.println("ERROR 0001: Solo puedes introducir numeros. ");
                            seguirBuscandoSelectModficar = true;
                            sc.next();
            
                        }
                    }
                    while(seguirBuscandoSelectModficar);

                    if(selectModify != 0){
                        do{
                            try{
                                sc.nextLine();  
                                System.out.println("Introduce el ISBN del libro a añadir unidades(Para cancelar escribe 0): ");
                                auxISBNModficar = sc.nextLine();  
                                seguirBuscandoISBNModficar = false;
                
                            }catch(InputMismatchException e){
                
                                System.out.println("ERROR 0001: Solo puedes introducir numeros. ");
                                seguirBuscandoISBNModficar = true;
                                sc.next();
                
                            }
                        }
                        while(seguirBuscandoISBNModficar);
    
                        if(selectModify == 1){
                            if(ReadData.isBookOnLoadedDataByISBN(main, auxISBNModficar)){
                                System.out.println(ReadData.searchBookOnLoadedDataByISBN(main, auxISBNModficar).toString());
                                ReadData.modifyBookByISBN(main, auxISBNModficar);
                            }   
                            else{
                                System.out.println("No hay ningun libro con exactamente ese ISBN.");
                            }
                        }
                        else if(selectModify == 2){
                            do{
                                try{
                                    //sc.nextLine();  
                                    System.out.println("¿Cuantos unidades quieres añadir?(Número negativos para restar): ");
                                    cantidadModify = sc.nextInt();  
                                    seguirBuscandoCantidadModificar = false;
                                    
                    
                                }catch(InputMismatchException e){
                    
                                    System.out.println("ERROR 0001: Solo puedes introducir numeros. ");
                                    seguirBuscandoCantidadModificar = true;
                                    sc.next();
                    
                                }
                            }
                            while(seguirBuscandoCantidadModificar);
    
    
                            if(ReadData.isBookOnLoadedDataByISBN(main, auxISBNModficar)){
                                ReadData.addUnitByISBN(main, auxISBNModficar, cantidadModify);
                                System.out.println(ReadData.searchBookOnLoadedDataByISBN(main, auxISBNModficar).toString());

                            }   
                            else{
                                System.out.println("No hay ningun libro con exactamente ese ISBN.");
                            }
    
                        }
    
                    }

                    
                    

                    seleccion = 0;

                    break;
                case 7:
                    System.out.println("Mostrando todos los libros... ");
                    ReadData.viewLoadedData(main);
                    seleccion = 0;

                    break;
                case 8:
                    
                    int aux = 0;
                    
                        
                    do{
                        try{
                            System.out.println("¿Estas seguro que quieres borrar todos tus datos? Si[1] No[2]");
                            aux = sc.nextInt();  
                            
                        }catch(InputMismatchException e){
                            System.out.println("ERROR 0001: Solo puedes introducir numeros. ");
                            sc.next();
                        }
                    }
                    while(aux < 1 || aux > 2);

    
                    
                    if(aux == 1){
                        WriteData.DeleteData();
                        seleccion = 0;
                    }
                    else{
                        System.out.println("Cancelando operacion.");
                        seleccion = 0;
                    }
                    break;
                case 9:
                    System.out.println("Recuerda guardar antes de salir si no quieres perder tus datos.");
                    
                    int aux1 = 0;
                    
                        
                    do{
                        try{
                            System.out.println("¿Estas seguro que quieres salir? Si[1] No[2]");
                            aux1 = sc.nextInt();  
                            
                        }catch(InputMismatchException e){
                            System.out.println("ERROR 0001: Solo puedes introducir numeros. ");
                            sc.next();
                        }
                    }
                    while(aux1 < 1 || aux1 > 2);


                    
                    if(aux1 == 1){
                        
                        System.out.println("Saliendo...");
                        exe = false;
                    }
                    else{
                        System.out.println("Cancelando operacion...");
                        seleccion = 0;
                    }


                    break;
                default:
                    System.out.println("Error 1001: Desconocido");  
            }
        }
        sc.close(); 
    }
}
