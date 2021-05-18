public class CreateSec {
    
    static NodeBook seq = null, last = null;
   
    public static void SetUp(NodeBook b){
        seq = b;
        last = seq; 
    }

    public static NodeBook AddBook(Book libro, NodeBook nodo){
        seq = nodo;
        seq = new NodeBook(libro, seq);

        return seq;
    }
}
