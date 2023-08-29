public class Main {
    public static void main(String[] args) throws InterruptedException {

        int tf = 50000;
        int t = 0;

        Estado estado = new Estado();
        Control control = new Control();
        Globales globales = new Globales();

        while(t < tf){
            Funciones.medidoresAnuales(t, globales, estado);
            Funciones.actualizarModificadorVerano(t, globales);
            Funciones.actualizarModificadorMundial(t, globales);
            Funciones.actualizarModificadorStrike(t, globales);

            if((t % 7) < 5) {
                Funciones.setUpDiaDeSemana(globales, control);
            } else {
                Funciones.setUpFinDeSemana(globales, control);
            }

            Funciones.acumularPeriodistasDisponibles(globales);
            Funciones.acumularPartidosImportantesACubrir(globales);
            Funciones.acumularPartidosNormalesACubrir(globales);

            Funciones.resetearAcumuladoresDiarios(globales);
            Funciones.cubrirPartidosImportantes(globales, estado);
            Funciones.cubrirPartidosNormales(globales, estado);

            Funciones.actualizarEstado(estado, globales);
            Funciones.actualizarAcumuladoresDiarios(globales);
            Funciones.verificarStrike(t, globales);

            t++;
        }

        Resultado.pvt(globales);
        Resultado.ppnc(globales);
        Resultado.ppic(globales);
        Resultado.ppo(globales);
        Resultado.indicesUtiles(globales);
    }
}