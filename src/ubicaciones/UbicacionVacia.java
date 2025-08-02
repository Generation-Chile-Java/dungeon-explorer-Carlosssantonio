package ubicaciones;

import personajes.Lilo;

public class UbicacionVacia implements Ubicacion {
    @Override
    public void entrar(Lilo lilo) {
        System.out.println("La ubicación está tranquila. Solo el sonido del viento y las olas.");
    }

    @Override
    public String getDescripcion() {
        return "una ubicación tranquila";
    }
}