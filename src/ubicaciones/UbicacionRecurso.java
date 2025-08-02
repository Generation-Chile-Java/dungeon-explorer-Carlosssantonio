package ubicaciones;

import personajes.Lilo;
import objetos.ObjetoAventura;

public class UbicacionRecurso implements Ubicacion {
    private ObjetoAventura recurso;

    public UbicacionRecurso(ObjetoAventura recurso) {
        this.recurso = recurso;
    }

    @Override
    public void entrar(Lilo lilo) {
        System.out.println("Has llegado a un lugar con un recurso valioso. ¡Parece que hay algo brillante aquí!");
        recurso.interactuar(lilo);
    }

    @Override
    public String getDescripcion() {
        return "una ubicación con un recurso";
    }
}