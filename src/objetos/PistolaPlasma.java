package objetos;

import personajes.Lilo;

public class PistolaPlasma implements ObjetoAventura {
    private String nombre;
    private int danoAdicional;

    public PistolaPlasma(String nombre, int danoAdicional) {
        this.nombre = nombre;
        this.danoAdicional = danoAdicional;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void interactuar(Lilo lilo) {
        System.out.println("¡Has encontrado una " + nombre + "! ¡Esto aumentará tu poder de ataque!");
        lilo.añadirAInventario(this);
        // Podrías aumentar el ataque de Lilo aquí o al usarla en combate
    }

    @Override
    public void usar(Lilo lilo) {
        System.out.println("Lilo equipa la " + nombre + ". Su ataque ha aumentado.");
        // Esto es solo un ejemplo, la lógica real de aumento de ataque debería estar en Lilo o en el combate
    }
}