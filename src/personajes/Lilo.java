package personajes;

import java.util.ArrayList;
import java.util.List;

import objetos.ObjetoAventura;
import objetos.BayaCurativa;

public class Lilo {
    private String nombre;
    private int salud;
    private int ataque;
    private List<ObjetoAventura> inventario;

    public Lilo(String nombre, int salud, int ataque) {
        this.nombre = nombre;
        this.salud = salud;
        this.ataque = ataque;
        this.inventario = new ArrayList<>();
    }

    public void recibirDano(int dano) {
        this.salud -= dano;
        if (this.salud < 0) {
            this.salud = 0;
        }
        System.out.println(this.nombre + " ha recibido " + dano + " puntos de daño. Salud actual: " + this.salud);
    }

    public void curar(int cantidad) {
        this.salud += cantidad;
        if (this.salud > 100) { // Asumiendo que la salud máxima es 100
            this.salud = 100;
        }
        System.out.println(this.nombre + " se ha curado " + cantidad + " puntos de salud. Salud actual: " + this.salud);
    }

    public void usarObjeto(String nombreObjeto, Lilo lilo) {
        ObjetoAventura objetoAUsar = null;
        for (ObjetoAventura objeto : inventario) {
            if (objeto.getNombre().equalsIgnoreCase(nombreObjeto)) {
                objetoAUsar = objeto;
                break;
            }
        }

        if (objetoAUsar != null) {
            objetoAUsar.usar(lilo);
            // Solo remover si es un consumible como una baya curativa
            if (objetoAUsar instanceof BayaCurativa) {
                inventario.remove(objetoAUsar);
            }
        } else {
            System.out.println("No tienes ese objeto en tu inventario.");
        }
    }

    public void añadirAInventario(ObjetoAventura objeto) {
        inventario.add(objeto);
        System.out.println("Has añadido " + objeto.getNombre() + " a tu inventario.");
    }

    public void mostrarEstado() {
        System.out.println("\n--- Estado de " + nombre + " ---");
        System.out.println("Salud: " + salud);
        System.out.println("Ataque: " + ataque);
        System.out.println("Inventario: " + getNombresInventario());
        System.out.println("----------------------------");
    }

    public int getAtaque() {
        return ataque;
    }

    public int getSalud() {
        return salud;
    }

    public boolean estaViva() {
        return this.salud > 0;
    }

    public String getNombre() {
        return nombre;
    }

    public List<ObjetoAventura> getInventario() {
        return inventario;
    }

    private List<String> getNombresInventario() {
        List<String> nombres = new ArrayList<>();
        if (inventario.isEmpty()) {
            nombres.add("Vacío");
        }
        else {
            for (ObjetoAventura objeto : inventario) {
                nombres.add(objeto.getNombre());
            }
        }
        return nombres;
    }
}