public class Main {
    public static void main(String[] args) {

        int tf = 50000;
        int t = 0;

        Globales globales = new Globales();

        while(t < tf){
            // System.out.println( "Hello World! " + t);
            Funciones.medidoresAnuales(t, globales);
            Funciones.actualizarModificadorVerano(t, globales);
            Funciones.actualizarModificadorMundial(t, globales);
            Funciones.actualizarModificadorStrike(t, globales);
            t++;


        }
    }



}