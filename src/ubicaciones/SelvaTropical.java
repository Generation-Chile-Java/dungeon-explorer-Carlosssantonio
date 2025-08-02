package ubicaciones;

import personajes.Lilo;
import personajes.Experimento;
import objetos.BayaCurativa;

public class SelvaTropical extends UbicacionEnemigo {
    public SelvaTropical() {
        super(new Experimento("Experimento 627 (Evile)", 50, 20)); // Un experimento más fuerte
    }

    @Override
    public void entrar(Lilo lilo) {
        System.out.println("\n--- Selva Tropical de Kauai ---");
        System.out.println("La densa selva te envuelve. Los sonidos de la vida salvaje resuenan por todas partes. El aire es húmedo y pesado.");
        super.entrar(lilo); // Llama al método entrar de UbicacionEnemigo

        // Posibilidad de encontrar una baya curativa después del combate o al explorar
        if (new java.util.Random().nextInt(100) < 30) { // 30% de probabilidad
            BayaCurativa baya = new BayaCurativa("Baya de la Selva", 15);
            baya.interactuar(lilo);
        }
    }

    @Override
    public String getDescripcion() {
        return "la profunda Selva Tropical";
    }
}
