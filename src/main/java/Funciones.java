public class Funciones {

    public static void actualizarModificadorVerano(int tiempo, Globales globales) {
        if((tiempo % 365 ) > 274) {
            globales.modificadorVerano = 1;
        } else {
            globales.modificadorVerano = 0.7;
        }
    }

    public static void actualizarModificadorMundial(int tiempo, Globales globales) {
        if((tiempo % 1460 ) < 30) {
            globales.modificadorMundial = 1;
        } else {
            globales.modificadorMundial = 3;
        }
    }

    public static void actualizarModificadorStrike(int tiempo, Globales globales) {
        if(tiempo < globales.finDeStrike) {
            globales.modificadorStrike = 1;
        } else {
            globales.modificadorStrike = 0.5;
        }
    }

    public static void medidoresAnuales(int tiempo, Globales globales) {
        if((tiempo % 365 ) == 0) {

        }
    }

}
