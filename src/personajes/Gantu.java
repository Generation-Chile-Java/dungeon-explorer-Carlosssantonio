package personajes;

public class Gantu extends Enemigo {
    public Gantu() {
        super("Capitán Gantu", 80, 25);
    }

    @Override
    public void recibirDano(int dano) {
        super.recibirDano(dano);
        if (estaVivo()) {
            System.out.println("Gantu: ¡No te saldrás con la tuya, pequeña terrícola!");
        }
    }
}