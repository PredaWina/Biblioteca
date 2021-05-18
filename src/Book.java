public class Book {

    String name;
    String ISBN;
    String author;
    String editorial;
    int amount; 

    Book(){
        this.name = "-";
        this.ISBN = "0";
        this.author = "-";
        this.editorial = "-";   
    }
    Book(String name){
        this.name = name;
        this.ISBN = "0";
        this.author = "-";
        this.editorial = "-";
        
    }
    Book(String name, String ISBN){
        this.name = name;
        this.ISBN = ISBN;
        this.author = "-";
        this.editorial = "-";
        
    }
    Book(String name, String ISBN, String author){
        this.name = name;
        this.ISBN = ISBN;
        this.author = author;
        this.editorial = "-";
        
    }
    Book(String name, String ISBN, String author, String editorial){
        this.name = name;
        this.ISBN = ISBN;
        this.author = author;
        this.editorial = editorial;
        
    }
    Book(String name, String ISBN, String author, String editorial, int amount){
        this.name = name;
        this.ISBN = ISBN;
        this.author = author;
        this.editorial = editorial;
        this.amount = amount;
        
    }


    public String toString(){
        return "---------------------------\n" + "Nombre: " + name + "\nISBN: " + ISBN + "\nAutor: " + author + "\nEditorial: " + editorial + "\nCantidad: " + amount + "\n---------------------------";
    }
}
