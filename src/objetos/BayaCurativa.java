package objetos;

import personajes.Lilo;

public class BayaCurativa implements ObjetoAventura {
    private String nombre;
    private int cantidadCuracion;

    public BayaCurativa(String nombre, int cantidadCuracion) {
        this.nombre = nombre;
        this.cantidadCuracion = cantidadCuracion;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void interactuar(Lilo lilo) {
        System.out.println("Has encontrado una " + nombre + ". ¡Podría ser útil!");
        lilo.añadirAInventario(this);
    }

    @Override
    public void usar(Lilo lilo) {
        System.out.println("Lilo come la " + nombre + " y recupera " + cantidadCuracion + " puntos de salud.");
        lilo.curar(cantidadCuracion);
    }
}