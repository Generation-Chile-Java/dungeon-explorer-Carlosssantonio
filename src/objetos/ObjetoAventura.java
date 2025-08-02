package objetos;

import personajes.Lilo;

public interface ObjetoAventura {
    String getNombre();
    void interactuar(Lilo lilo);
    void usar(Lilo lilo);
}