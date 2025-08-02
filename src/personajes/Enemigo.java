package personajes;

public class Enemigo {
    private String nombre;
    private int salud;
    private int ataque;

    public Enemigo(String nombre, int salud, int ataque) {
        this.nombre = nombre;
        this.salud = salud;
        this.ataque = ataque;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getAtaque() {
        return ataque;
    }

    public void recibirDano(int dano) {
        this.salud -= dano;
        if (this.salud < 0) {
            this.salud = 0;
        }
        System.out.println(this.nombre + " ha recibido " + dano + " puntos de daño. Salud actual: " + this.salud);
    }

    public boolean estaVivo() {
        return this.salud > 0;
    }
}