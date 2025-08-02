package objetos;

import personajes.Lilo;

public class PezSuerte implements ObjetoAventura {
    private String nombre;

    public PezSuerte(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void interactuar(Lilo lilo) {
        System.out.println("Has encontrado un " + nombre + ". ¡Dicen que trae buena fortuna!");
        lilo.añadirAInventario(this);
    }

    @Override
    public void usar(Lilo lilo) {
        System.out.println("Lilo sostiene el " + nombre + ". Sientes una oleada de buena suerte.");
        // Podría tener un efecto aleatorio o usarse en un evento específico
    }
}