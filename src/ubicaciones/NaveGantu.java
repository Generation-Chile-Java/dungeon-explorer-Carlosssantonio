package ubicaciones;

import personajes.Lilo;
import personajes.Gantu;
import objetos.MapaIsla;

public class NaveGantu extends UbicacionEnemigo {
    public NaveGantu() {
        super(new Gantu());
    }

    @Override
    public void entrar(Lilo lilo) {
        System.out.println("\n--- Nave de Gantu ---");
        System.out.println("Has logrado infiltrarte en la imponente nave de Gantu. Las luces parpadean y el aire es tenso. ¡Gantu te espera!");
        super.entrar(lilo); // Llama al método entrar de UbicacionEnemigo para el combate con Gantu

        if (!getEnemigo().estaVivo()) { // Si Gantu es derrotado
            System.out.println("Gantu ha sido derrotado. ¡Ahora puedes buscar el mapa de la isla!");
            MapaIsla mapa = new MapaIsla("Mapa Completo de Kauai");
            mapa.interactuar(lilo);
        }
    }

    @Override
    public String getDescripcion() {
        return "la temible Nave de Gantu";
    }
}