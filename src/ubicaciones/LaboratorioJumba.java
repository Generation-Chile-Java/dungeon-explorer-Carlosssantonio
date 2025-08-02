package ubicaciones;

import personajes.Lilo;
import objetos.DispositivoReforma;
import objetos.PistolaPlasma;

public class LaboratorioJumba extends UbicacionVacia {
    private boolean visitado = false;

    @Override
    public void entrar(Lilo lilo) {
        System.out.println("\n--- Laboratorio Secreto de Jumba ---");
        System.out.println("Lilo se adentra en el desordenado pero fascinante laboratorio de Jumba. Hay artilugios extraños por todas partes.");

        if (!visitado) {
            System.out.println("Jumba: ¡Ah, pequeña terrícola! Justo a tiempo. Tengo algo que podría ayudarte con mis... 'primos'.");
            DispositivoReforma dispositivo = new DispositivoReforma("Dispositivo de Reforma");
            dispositivo.interactuar(lilo);
            PistolaPlasma pistola = new PistolaPlasma("Pistola de Plasma", 20);
            pistola.interactuar(lilo);
            visitado = true;
        } else {
            System.out.println("Jumba está ocupado con sus experimentos. Parece que no tiene nada nuevo por ahora.");
        }
    }

    @Override
    public String getDescripcion() {
        return "el misterioso Laboratorio de Jumba";
    }
}
