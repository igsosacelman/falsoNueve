import java.text.DecimalFormat;

public class Resultado {

    /**
     * promedio de visualizaciones por transmision
     */
    public static void pvt(Globales globales) {
        DecimalFormat df = new DecimalFormat("0.00");
        double pvt = (double) globales.sumatoriaVistasDiarias / globales.sumatoriaPartidosACubrir;
        System.out.println( "sumatoriaVistasDiarias: " + globales.sumatoriaVistasDiarias);
        System.out.println( "sumatoriaPartidosACubrir: " + globales.sumatoriaPartidosACubrir);
        System.out.println( "Promedio de visualizaciones por transmision: " + df.format(pvt));
        System.out.println("");
    }

    /**
     * Porcentaje de partidos normales cubiertos
     */
    public static void ppnc(Globales globales) {
        DecimalFormat df = new DecimalFormat("0.00");
        double ppnc = (double) globales.sumatoriaPartidosNormalesTransmitidos / globales.sumatoriaPartidosNormalesACubrir;
        System.out.println( "sumatoriaPartidosNormalesTransmitidos: " + globales.sumatoriaPartidosNormalesTransmitidos);
        System.out.println( "sumatoriaPartidosNormalesACubrir: " + globales.sumatoriaPartidosNormalesACubrir);
        System.out.println( "Porcentaje de partidos normales cubiertos: " + (df.format(ppnc*100))+"%");
        System.out.println("");
    }

    /**
     * Porcentaje de partidos importantes cubiertos
     */
    public static void ppic(Globales globales) {
        DecimalFormat df = new DecimalFormat("0.00");
        double ppic = (double) globales.sumatoriaPartidosImportantesTransmitidos / globales.sumatoriaPartidosImportantesACubrir;
        System.out.println( "sumatoriaPartidosImportantesTransmitidos: " + globales.sumatoriaPartidosImportantesTransmitidos);
        System.out.println( "sumatoriaPartidosImportantesACubrir: " + globales.sumatoriaPartidosImportantesACubrir);
        System.out.println( "Porcentaje de partidos importantes cubiertos: " + (df.format(ppic*100))+"%");
        System.out.println("");
    }

    /**
     * Porcentaje de periodistas ociosos
     */
    public static void ppo(Globales globales) {
        DecimalFormat df = new DecimalFormat("0.00");
        double ppo = (double) globales.sumatoriaPeriodistasOciosos / globales.sumatoriaPeriodistasDisponibles;
        System.out.println( "sumatoriaPeriodistasOciosos: " + globales.sumatoriaPeriodistasOciosos);
        System.out.println( "sumatoriaPeriodistasDisponibles: " + globales.sumatoriaPeriodistasDisponibles);
        System.out.println( "Porcentaje de periodistas ociosos: " + (df.format(ppo*100))+"%");
    }
}
