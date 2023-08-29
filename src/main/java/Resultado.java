public class Resultado {

    /**
     * promedio de visualizaciones por transmision
     */
    public static void pvt(Globales globales) {
        double pvt = globales.sumatoriaVistasDiarias / globales.sumatoriaPartidosACubrir;
        System.out.println( "Promedio de visualizaciones por transmision: " + pvt);
    }

    /**
     * Porcentaje de partidos normales cubiertos
     */
    public static void ppnc(Globales globales) {
        double ppnc = globales.sumatoriaPartidosNormalesTransmitidos / globales.sumatoriaPartidosNormalesACubrir;
        System.out.println( "Porcentaje de partidos normales cubiertos: " + ppnc);
    }

    /**
     * Porcentaje de partidos importantes cubiertos
     */
    public static void ppic(Globales globales) {
        double ppic = globales.sumatoriaPartidosImportantesTransmitidos / globales.sumatoriaPartidosImportantesACubrir;
        System.out.println( "Porcentaje de partidos normales cubiertos: " + ppic);
    }

    /**
     * Porcentaje de periodistas ociosos
     */
    public static void ppo(Globales globales) {
        double ppo = globales.sumatoriaPeriodistasOciosos / globales.sumatoriaPeriodistasDisponibles;
        System.out.println( "Porcentaje de partidos normales cubiertos: " + ppo);
    }
}
