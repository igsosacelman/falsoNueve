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

    public static void acumularPeriodistasDisponibles(Globales globales) {
        globales.sumatoriaPeriodistasDisponibles += globales.periodistasDisponibles;
    }

    public static void acumularPartidosImportantesACubrir(Globales globales) {
        globales.sumatoriaPartidosImportantesACubrir += globales.partidosImportantes;
    }

    public static void acumularPartidosNormalesACubrir(Globales globales) {
        globales.sumatoriaPartidosNormalesACubrir += globales.partidosNormales;
    }

    public static void resetearAcumuladoresDiarios(Globales globales) {
        globales.gananciaDiaria = 0;
        globales.costoDiarioOperadores = 0;
        globales.costoDiarioPeriodistas = 0;
        globales.vistasDiarias = 0;
        globales.partidosNoTransmitidosDiarios = 0;
    }

    public static double probabilidadDeFallas() {
        return 1;
    }

    public static double partidoImportanteAburrido() {
        return 1;
    }

    public static double partidoNormalAburrido() {
        return 1;
    }

    public static void cubrirPartidosImportantes(Globales globales, Estado estado) {
        for (int i = 0; i < globales.partidosImportantes; i++) {
            if(probabilidadDeFallas() < 0.01) {
                globales.partidosNoTransmitidosDiarios++;
            } else {
                if(globales.periodistasDisponibles <= 4) {
                    globales.partidosNoTransmitidosDiarios++;
                } else {
                    globales.periodistasDisponibles -= 4;
                    int vistasPartido = (int) ((estado.suscriptores * (0.002) + Datos.vpi()) * globales.modificadorMundial * partidoImportanteAburrido());
                    int gananciasPartido = (int) (vistasPartido * 0.02) * 500 + vistasPartido * globales.gananciasPorVista;
                    globales.costoDiarioOperadores += 2000 + estado.suscriptores * 0.05;
                    globales.costoDiarioPeriodistas += Math.min(gananciasPartido * 0.4, 4000);
                    globales.vistasDiarias += vistasPartido;
                    globales.sumatoriaPartidosImportantesTransmitidos++;
                    globales.gananciaDiaria += gananciasPartido;
                }
            }
        }
    }

    public static void cubrirPartidosNormales(Globales globales, Estado estado) {
        for (int i = 0; i < globales.partidosNormales; i++) {
            if(probabilidadDeFallas() < 0.01) {
                globales.partidosNoTransmitidosDiarios++;
            } else {
                if(globales.periodistasDisponibles <= 2) {
                    globales.partidosNoTransmitidosDiarios++;
                } else {
                    globales.periodistasDisponibles -= 2;
                    int vistasPartido = (int) ((estado.suscriptores * (0.002) + Datos.vpn()) * globales.modificadorMundial * partidoNormalAburrido());
                    int gananciasPartido = (int) (vistasPartido * 0.02) * 500 + vistasPartido * globales.gananciasPorVista;
                    globales.costoDiarioOperadores += 2000 + estado.suscriptores * 0.05;
                    globales.costoDiarioPeriodistas += Math.min(gananciasPartido * 0.4, 2000);
                    globales.vistasDiarias += vistasPartido;
                    globales.sumatoriaPartidosNormalesTransmitidos++;
                    globales.gananciaDiaria += gananciasPartido;
                }
            }
        }
    }
}
