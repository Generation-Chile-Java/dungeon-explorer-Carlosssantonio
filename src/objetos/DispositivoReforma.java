package objetos;

import personajes.Lilo;
import personajes.Experimento;

public class DispositivoReforma implements ObjetoAventura {
    private String nombre;

    public DispositivoReforma(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void interactuar(Lilo lilo) {
        System.out.println("Has encontrado el " + nombre + ". ¡Esto podría ayudar a los experimentos!");
        lilo.añadirAInventario(this);
    }

    @Override
    public void usar(Lilo lilo) {
        System.out.println("El " + nombre + " solo puede usarse en un experimento salvaje.");
    }

    // Método específico para usar en un experimento
    public void usarEnExperimento(Lilo lilo, Experimento experimento) {
        if (!experimento.estaReformado()) {
            experimento.reformar();
            // Podrías remover el dispositivo del inventario si es de un solo uso
            // lilo.getInventario().remove(this);
        } else {
            System.out.println(experimento.getNombre() + " ya ha sido reformado.");
        }
    }
}