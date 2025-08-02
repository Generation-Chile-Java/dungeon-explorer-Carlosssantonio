package objetos;

import personajes.Lilo;

public class MapaIsla implements ObjetoAventura {
    private String nombre;

    public MapaIsla(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void interactuar(Lilo lilo) {
        System.out.println("¡Has encontrado el " + nombre + "! Ahora puedes ver los caminos ocultos.");
        lilo.añadirAInventario(this);
    }

    @Override
    public void usar(Lilo lilo) {
        System.out.println("Lilo despliega el " + nombre + ". Muestra rutas que antes no veías.");
        // Podría revelar nuevas opciones de movimiento o desbloquear ubicaciones
    }
}