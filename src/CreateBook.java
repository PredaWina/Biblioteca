public class CreateBook {

    public static Book add(){
        Book libro = new Book();
        char[] caracteresprohibidos = {',','|'};

        String msgIntroducirNombre = "Introduce el *nombre* del libro: ";
        String msgIntroducirISBN = "Introduce el *ISBN* del libro: ";
        String msgIntroducirAutor = "Introduce el *autor* del libro: ";
        String msgIntroducirEditorial = "Introduce la *editorial* del libro: ";
        String msgIntroducirCantidad = "Introduce la *cantidad* de libros: ";

        libro.name = Input.ObtenerString(caracteresprohibidos, msgIntroducirNombre);
        libro.ISBN = Input.ObtenerString(caracteresprohibidos, msgIntroducirISBN); 
        libro.author = Input.ObtenerString(caracteresprohibidos, msgIntroducirAutor);
        libro.editorial = Input.ObtenerString(caracteresprohibidos, msgIntroducirEditorial);
        libro.amount = Input.ObtenerNumeroEnRango(-999, 999, msgIntroducirCantidad);

        return libro;

    }
}
