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

//import java.util.*;

public class Biblioteca {
    public static void main(String[] args) {

        final float version = 1.7f;
        char[] caracteresprohibidos = {',','|'};
        boolean exe = true;
        int seleccion = 0;
        //Scanner sc = new Scanner(System.in);

        Book libro = new Book();
        NodeBook main = new NodeBook(libro);
        CreateSec.SetUp(main); //* Set up de la clase para poder manejar la secuencia.

        String msgSeleccionarOpcion = "Seleccione una opcion: ";
        String msgBuscarPorNombre = "Introduce el nombre del libro a buscar: ";
        String msgBorrarLibroPorISBN = "Introduce el ISBN del libro a BORRAR(Para cancelar escribe 0): ";
        String msgOpcionModificar = "¿Quieres modificar los datos[1], añadir una unidad[2], cancelar[0]?: ";
        String msgAnadirPorISBN = "Introduce el ISBN del libro a añadir unidades(Para cancelar escribe 0): ";
        String msgCantidadAnadir = "¿Cuantos unidades quieres añadir?(Número negativos para restar): ";
        String msgConfirmarBorrarDatos = "¿Estas seguro que quieres borrar todos tus datos? Si[1] No[2]";
        String msgConfirmarSalir = "¿Estas seguro que quieres salir? Si[1] No[2]";
        

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
            
    
            seleccion = Input.ObtenerNumeroEnRango(1, 9, msgSeleccionarOpcion);

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
                    String auxName = "";
                    auxName = Input.ObtenerString(caracteresprohibidos, msgBuscarPorNombre);
                    ReadData.searchBookOnLoadedDataByName(main, auxName);

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
                    String auxISBNBorrar = "";
                    auxISBNBorrar = Input.ObtenerString(caracteresprohibidos, msgBorrarLibroPorISBN);

                    if(ReadData.isBookOnLoadedDataByISBN(main, auxISBNBorrar)){
                        System.out.println("Se ha BORRADO el libro: ");
                        ReadData.searchBookOnLoadedDataByName(main, auxISBNBorrar);
                        main = ReadData.deleteBookByISBN(main, auxISBNBorrar);
                    }   
                    else{
                        System.out.println("No hay ningun libro con exactamente ese ISBN.");
                    }

                    seleccion = 0;
                    break;
                case 6:

                    int selectModify = 0;
                    String auxISBNModficar = "";
                    int cantidadModify = 0;

                    selectModify = Input.ObtenerNumeroEnRango(0, 2, msgOpcionModificar);
                    System.out.println("SelectModify vale: "+selectModify);

                    if(selectModify != 0){

                        auxISBNModficar = Input.ObtenerString(caracteresprohibidos, msgAnadirPorISBN);

                        if(!auxISBNModficar.equals("0")){
                            if(selectModify == 1){
                                if(ReadData.isBookOnLoadedDataByISBN(main, auxISBNModficar)){
                                    ReadData.searchBookOnLoadedDataByName(main, auxISBNModficar);
                                    ReadData.modifyBookByISBN(main, auxISBNModficar);
                                }   
                                else{
                                    System.out.println("No hay ningun libro con exactamente ese ISBN.");
                                }
                            }
                            else if(selectModify == 2){
                                
                                cantidadModify = Input.ObtenerNumeroEnRango(-999, 999, msgCantidadAnadir);

                                if(ReadData.isBookOnLoadedDataByISBN(main, auxISBNModficar)){
                                    ReadData.addUnitByISBN(main, auxISBNModficar, cantidadModify);
                                    ReadData.searchBookOnLoadedDataByName(main, auxISBNModficar);
    
                                }   
                                else{
                                    System.out.println("No hay ningun libro con exactamente ese ISBN.");
                                }
                            }
                        }
                        else{
                            System.out.println("Cancelando1... ");
                        }
                    }
                    else{
                        System.out.println("Cancelando2... ");
                    }

                    seleccion = 0;
                    break;
                case 7:
                    System.out.println("Mostrando todos los libros... ");
                    ReadData.viewLoadedData(main);
                    seleccion = 0;

                    break;
                case 8:      
                    int aux = Input.ObtenerNumeroEnRango(1, 2, msgConfirmarBorrarDatos);

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
                    
                    int aux1 = Input.ObtenerNumeroEnRango(1, 2, msgConfirmarSalir);

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
        //sc.close(); 
    }
}
