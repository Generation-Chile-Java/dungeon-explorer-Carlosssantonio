package ubicaciones;

import personajes.Lilo;
import objetos.ObjetoAventura;
import objetos.MapaIsla;

public class UbicacionBloqueada implements Ubicacion {
    private String nombreObjetoRequerido;
    private boolean estaBloqueada;

    public UbicacionBloqueada(String nombreObjetoRequerido) {
        this.nombreObjetoRequerido = nombreObjetoRequerido;
        this.estaBloqueada = true;
    }

    @Override
    public void entrar(Lilo lilo) {
        if (estaBloqueada) {
            System.out.println("Este camino está bloqueado. Necesitas un/a " + nombreObjetoRequerido + " para avanzar.");
            boolean tieneObjeto = false;
            for (ObjetoAventura objeto : lilo.getInventario()) {
                if (objeto.getNombre().equalsIgnoreCase(nombreObjetoRequerido)) {
                    tieneObjeto = true;
                    break;
                }
            }

            if (tieneObjeto) {
                System.out.println("¡Usas el/la " + nombreObjetoRequerido + " y el camino se abre!");
                estaBloqueada = false;
            } else {
                System.out.println("No tienes el/la " + nombreObjetoRequerido + " en tu inventario. El camino permanece bloqueado.");
            }
        } else {
            System.out.println("El camino ya está despejado. Lilo avanza sin problemas.");
        }
    }

    @Override
    public String getDescripcion() {
        return estaBloqueada ? "una ubicación bloqueada" : "una ubicación despejada";
    }

    public boolean estaBloqueada() {
        return estaBloqueada;
    }
}