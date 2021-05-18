

public class NodeBook {
    Book data;
    NodeBook next;

    

    NodeBook(Book d) { 
        data = d; 
        next = null;   
    } 
    
    NodeBook(Book d, NodeBook s) { 
        data = d; 
        next = s; 
    }
}
