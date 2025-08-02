package personajes;

public class Experimento extends Enemigo {
    private boolean reformado;

    public Experimento(String nombre, int salud, int ataque) {
        super(nombre, salud, ataque);
        this.reformado = false;
    }

    public boolean estaReformado() {
        return reformado;
    }

    public void reformar() {
        this.reformado = true;
        System.out.println("¡" + getNombre() + " ha sido reformado! Ahora es un buen experimento.");
        // Podríamos reducir su ataque a 0 o cambiar su comportamiento
        // setAtaque(0); // Si tuvieramos un setter para ataque en Enemigo
    }

    @Override
    public void recibirDano(int dano) {
        if (!reformado) {
            super.recibirDano(dano);
        } else {
            System.out.println(getNombre() + " ya ha sido reformado y no puede ser dañado.");
        }
    }
}