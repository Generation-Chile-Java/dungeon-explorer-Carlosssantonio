package ubicaciones;

import personajes.Lilo;
import objetos.Ukulele;

public class PlayaKokaua extends UbicacionVacia {
    @Override
    public void entrar(Lilo lilo) {
        System.out.println("\n--- Playa de Kokaua ---");
        System.out.println("Lilo llega a la soleada Playa de Kokaua. Las olas rompen suavemente en la orilla y las palmeras se mecen con la brisa.");
        System.out.println("Es un lugar tranquilo, perfecto para empezar una aventura.");
        // Podríamos añadir un Ukulele si Lilo no lo tiene
        boolean tieneUkulele = false;
        for (objetos.ObjetoAventura obj : lilo.getInventario()) {
            if (obj instanceof Ukulele) {
                tieneUkulele = true;
                break;
            }
        }
        if (!tieneUkulele) {
            Ukulele ukuleleInicial = new Ukulele("Ukulele de Lilo");
            ukuleleInicial.interactuar(lilo);
        }
    }

    @Override
    public String getDescripcion() {
        return "la hermosa Playa de Kokaua";
    }
}