import java.io.*;


public class WriteData {
    

    public static void Write(NodeBook sec){

        int cantLibros = 0;
        PrintWriter pw = null;
        try{
            pw = new PrintWriter(new File("data.txt"));

            for(NodeBook aux = sec; aux != null; aux = aux.next){

                if(aux.data == null){
                    pw.println("null |");
                }
                else{
                    pw.println(aux.data.name + "," + aux.data.ISBN + "," + aux.data.author + "," + aux.data.editorial + "," + aux.data.amount+ "|");
                }
                cantLibros++;
            
            }
            System.out.println(cantLibros + " libros encontrados.");
        
        }catch(FileNotFoundException e){
            System.out.println("Error 0102: Puede que el archivo no se haya abierto correctamente.");
        }
        finally{
            if(pw != null){
                pw.close();
            }
            
        }

    }

    public static void DeleteData(){
        File f = new File("data.txt");

        if(f.exists()){
            f.delete();
        }
        else{
            System.out.println("ERROR 0101 no existen datos!!");
        }
    }

    public static void SustituirData(NodeBook sec){
        DeleteData(); 
        Write(sec);
    }

    
}
