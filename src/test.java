public class test {
    public static void main(String[] args) {
        String aux;
        int xd;
        char[] caracteresprohibidos = {',','|'};

        xd = Input.ObtenerNumeroEnRango(1, 3, "Introduce un número: ");
        aux = Input.ObtenerString(caracteresprohibidos, "Introduce un mensaje: ");

        /*
        System.out.println(xd);
        System.out.println(aux);
        */
    }
}
