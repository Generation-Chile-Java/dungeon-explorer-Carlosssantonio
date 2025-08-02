package ubicaciones;

import java.util.Random;
import java.util.Scanner;

import personajes.Lilo;
import personajes.Enemigo;
import personajes.Experimento;
import objetos.DispositivoReforma;
import objetos.ObjetoAventura;

public class UbicacionEnemigo implements Ubicacion {
    private Enemigo enemigo;
    private boolean enemigoDerrotado;

    public UbicacionEnemigo(Enemigo enemigo) {
        this.enemigo = enemigo;
        this.enemigoDerrotado = false;
    }

    @Override
    public void entrar(Lilo lilo) {
        if (enemigoDerrotado) {
            System.out.println("La ubicación está en silencio. Ya derrotaste a " + enemigo.getNombre() + " que había aquí.");
            return;
        }

        System.out.println("¡Un " + enemigo.getNombre() + " te bloquea el paso!");
        Scanner scanner = new Scanner(System.in);

        while (lilo.estaViva() && enemigo.estaVivo()) {
            System.out.println("\n--- Combate contra " + enemigo.getNombre() + " ---");
            System.out.println("Tu salud: " + lilo.getSalud() + " | Salud de " + enemigo.getNombre() + ": " + enemigo.getSalud());
            System.out.print("¿Qué quieres hacer? (espacio:atacar / x:huir / u:usar / r:reformar): ");
            String eleccion = scanner.nextLine();

            if (eleccion.equalsIgnoreCase(" ")) {
                int danoLilo = new Random().nextInt(lilo.getAtaque()) + 5; // Daño de Lilo
                enemigo.recibirDano(danoLilo);
                System.out.println("Le infliges " + danoLilo + " puntos de daño a " + enemigo.getNombre() + ".");

                if (!enemigo.estaVivo()) {
                    System.out.println("¡Has derrotado a " + enemigo.getNombre() + "!");
                    enemigoDerrotado = true;
                    break;
                }

                int danoEnemigo = new Random().nextInt(enemigo.getAtaque()) + 1; // Daño del enemigo
                lilo.recibirDano(danoEnemigo);
                System.out.println(enemigo.getNombre() + " te ataca y te inflige " + danoEnemigo + " puntos de daño.");

            } else if (eleccion.equalsIgnoreCase("x")) {
                if (new Random().nextInt(100) < 40) { // 40% de probabilidad de huir
                    System.out.println("¡Logras escapar de " + enemigo.getNombre() + " por ahora!");
                    break;
                } else {
                    System.out.println(enemigo.getNombre() + " te impide escapar y te ataca.");
                    int danoEnemigo = new Random().nextInt(enemigo.getAtaque()) + 1;
                    lilo.recibirDano(danoEnemigo);
                    System.out.println("Recibes " + danoEnemigo + " puntos de daño al intentar huir.");
                }
            } else if (eleccion.equalsIgnoreCase("u")) {
                System.out.print("¿Qué objeto quieres usar de tu inventario?: ");
                String objetoAUsar = scanner.nextLine();
                lilo.usarObjeto(objetoAUsar, lilo);
            } else if (eleccion.equalsIgnoreCase("r")) {
                if (enemigo instanceof Experimento) {
                    Experimento exp = (Experimento) enemigo;
                    boolean tieneDispositivo = false;
                    for (ObjetoAventura obj : lilo.getInventario()) {
                        if (obj instanceof DispositivoReforma) {
                            ((DispositivoReforma) obj).usarEnExperimento(lilo, exp);
                            tieneDispositivo = true;
                            break;
                        }
                    }
                    if (!tieneDispositivo) {
                        System.out.println("No tienes un Dispositivo de Reforma en tu inventario.");
                    }
                } else {
                    System.out.println("Solo puedes reformar experimentos.");
                }
            } else {
                System.out.println("Comando no válido. Intenta 'espacio', 'x', 'u' o 'r'.");
            }
        }
    }

    @Override
    public String getDescripcion() {
        return enemigoDerrotado ? "una ubicación silenciosa" : "una ubicación con un amenazante " + enemigo.getNombre();
    }

    // Nuevo método para acceder al enemigo
    public Enemigo getEnemigo() {
        return enemigo;
    }
}