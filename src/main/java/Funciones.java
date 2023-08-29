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

    public static void medidoresAnuales(int tiempo, Globales globales, Estado estado) {
        globales.aniosTranscurridos = Math.floorDiv(tiempo, 365);
        globales.indiceSuscriptores = estado.suscriptores / globales.aniosTranscurridos;
        globales.indiceBeneficio = estado.beneficio / globales.aniosTranscurridos;
        globales.indiceStrike = globales.cantidadDeStrikes / globales.aniosTranscurridos;
    }

    public static void setUpDiaDeSemana(Globales globales, Control control) {
        int pdds = Datos.pdds();
        globales.periodistasDisponibles = (int) Math.floor(control.cantidadPeriodistas * pdds * globales.modificadorVerano);
        globales.partidosACubrir = (int) (control.pcfs * globales.modificadorStrike);
        globales.partidosImportantes = (int) (globales.partidosACubrir * 0.2);
        globales.partidosNormales = globales.partidosACubrir - globales.partidosImportantes;
    }

    public static void setUpFinDeSemana(Globales globales, Control control) {
        int pdfs = Datos.pdfs();
        globales.periodistasDisponibles = (int) Math.floor(control.cantidadPeriodistas * pdfs * globales.modificadorVerano);
        globales.partidosACubrir = (int) (control.pcfs * globales.modificadorStrike);
        globales.partidosImportantes = (int) (globales.partidosACubrir * 0.4);
        globales.partidosNormales = globales.partidosACubrir - globales.partidosImportantes;
    }
}
