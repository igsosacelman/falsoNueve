import java.util.Random;

public class Datos {

    /**
     * Visualizaciones por partido normal
     */
    public static int vpn() {
        double random = new Random().nextDouble();
        return (int) (1000 * (Math.sqrt(3*random+1) - 1));
    }

    /**
     * Visualizaciones por partido importante
     */
    public static int vpi() {
        double random = new Random().nextDouble();
        return (int) (500 * ( ( 2 * Math.sqrt(3 * random + 1) ) - 1));
    }

    /**
     * Porcentaje disponibilidad periodistas dia de semana
     */
    public static double pdds() {
        double random = new Random().nextDouble();
        double pdds = (-Math.log(1 - random)/(0.13315)) + 25;
        return Math.min(pdds,45)/100;
    }

    /**
     * Porcentaje disponibilidad periodistas fin de semana
     */
    public static double pdfs() {
        double random = new Random().nextDouble();
        double pdfs = (-Math.log(1 - random)/(0.11369)) + 40;
        return Math.min(pdfs,66)/100;
    }
}
