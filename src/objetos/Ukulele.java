package objetos;

import personajes.Lilo;

public class Ukulele implements ObjetoAventura {
    private String nombre;

    public Ukulele(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void interactuar(Lilo lilo) {
        System.out.println("Has encontrado tu " + nombre + ". ¡Perfecto para defenderte y animar!");
        lilo.añadirAInventario(this);
    }

    @Override
    public void usar(Lilo lilo) {
        System.out.println("Lilo toca el " + nombre + ". No tiene un efecto directo aquí, pero te sientes más valiente.");
    }
}