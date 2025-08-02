package personajes;

public class Hamsterviel extends Enemigo {
    public Hamsterviel() {
        super("Dr. Hamsterviel", 120, 35);
    }

    @Override
    public void recibirDano(int dano) {
        super.recibirDano(dano);
        if (estaVivo()) {
            System.out.println("Hamsterviel: ¡Maldita sea! ¡Mi plan es perfecto!");
        }
    }
}