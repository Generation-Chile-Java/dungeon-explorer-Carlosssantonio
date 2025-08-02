package ubicaciones;

import java.util.Random;

import personajes.Lilo;

public class UbicacionTrampa implements Ubicacion {
    private int danoTrampa;

    public UbicacionTrampa(int danoTrampa) {
        this.danoTrampa = danoTrampa;
    }

    @Override
    public void entrar(Lilo lilo) {
        System.out.println("¡Has entrado en una ubicación y de repente sientes un dolor agudo! ¡Parece una trampa!");
        int dano = new Random().nextInt(danoTrampa) + 5; // Daño mínimo de 5
        lilo.recibirDano(dano);
        System.out.println("La trampa te inflige " + dano + " puntos de daño.");
    }

    @Override
    public String getDescripcion() {
        return "una ubicación con una trampa oculta";
    }
}