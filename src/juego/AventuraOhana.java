package juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import personajes.Lilo;
import personajes.Experimento;
import personajes.Gantu;
import personajes.Hamsterviel;
import ubicaciones.Ubicacion;
import ubicaciones.PlayaKokaua;
import ubicaciones.SelvaTropical;
import ubicaciones.LaboratorioJumba;
import ubicaciones.NaveGantu;
import ubicaciones.UbicacionVacia;
import ubicaciones.UbicacionRecurso;
import ubicaciones.UbicacionEnemigo;
import ubicaciones.UbicacionTrampa;
import ubicaciones.UbicacionBloqueada;
import objetos.BayaCurativa;
import objetos.Ukulele;
import objetos.DispositivoReforma;
import objetos.PistolaPlasma;
import objetos.PezSuerte;
import objetos.MapaIsla;

public class AventuraOhana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- ¡Bienvenido a la Aventura Ohana de Lilo! ---");
        System.out.print("¿Cuál es tu nombre, pequeña terrícola?: ");
        String nombreJugador = scanner.nextLine();
        Lilo lilo = new Lilo(nombreJugador, 100, 15); // Salud inicial 100, Ataque inicial 15

        List<Ubicacion> mapa = new ArrayList<>();
        mapa.add(new PlayaKokaua()); // Ubicación 1
        mapa.add(new UbicacionRecurso(new BayaCurativa("Baya Dulce", 10))); // Ubicación 2
        mapa.add(new SelvaTropical()); // Ubicación 3 (con Experimento 627)
        mapa.add(new UbicacionTrampa(10)); // Ubicación 4
        mapa.add(new UbicacionRecurso(new Ukulele("Ukulele de Lilo"))); // Ubicación 5
        mapa.add(new UbicacionVacia()); // Ubicación 6
        mapa.add(new UbicacionEnemigo(new Experimento("Experimento 621 (Chomp)", 40, 12))); // Ubicación 7
        mapa.add(new UbicacionRecurso(new BayaCurativa("Baya Brillante", 30))); // Ubicación 8
        mapa.add(new UbicacionTrampa(20)); // Ubicación 9
        mapa.add(new LaboratorioJumba()); // Ubicación 10 (Dispositivo de Reforma y Pistola de Plasma)
        mapa.add(new UbicacionEnemigo(new Experimento("Experimento 221 (Sparky)", 35, 18))); // Ubicación 11
        mapa.add(new UbicacionRecurso(new PezSuerte("Pez de la Suerte"))); // Ubicación 12
        mapa.add(new NaveGantu()); // Ubicación 13 (Combate con Gantu, suelta MapaIsla)
        mapa.add(new UbicacionBloqueada("Mapa Completo de Kauai")); // Ubicación 14 (Requiere MapaIsla)
        mapa.add(new UbicacionEnemigo(new Hamsterviel())); // Ubicación 15 (Combate con Hamsterviel)
        mapa.add(new UbicacionVacia()); // Ubicación 16 (Final del juego)

        int indiceUbicacionActual = 0;

        System.out.println("\nLilo se prepara para su aventura en Kauai. ¡Ohana significa familia, y la familia nunca te abandona ni te olvida!\n");

        while (lilo.estaViva()) {
            lilo.mostrarEstado();
            Ubicacion ubicacionActual = mapa.get(indiceUbicacionActual);

            System.out.println("\nEstás en la ubicación #" + (indiceUbicacionActual + 1) + ". Es " + ubicacionActual.getDescripcion() + ".");
            ubicacionActual.entrar(lilo);

            if (!lilo.estaViva()) {
                System.out.println("\n¡Oh no! Lilo ha perdido toda su salud. La aventura Ohana ha terminado aquí.");
                System.out.println("--- FIN DEL JUEGO ---");
                break;
            }

            if (indiceUbicacionActual >= mapa.size() - 1) {
                System.out.println("\n¡Felicidades! Lilo ha explorado toda la isla y ha fortalecido el espíritu Ohana. ¡Has ganado la aventura!");
                System.out.println("--- ¡AVENTURA OHANA COMPLETADA! ---");
                break;
            }

            System.out.print("¿Qué deseas hacer? (a:avanzar / u:usar / i:inventario / s:salir): ");
            String eleccion = scanner.nextLine();

            if (eleccion.equalsIgnoreCase("a")) {
                if (indiceUbicacionActual + 1 < mapa.size() && mapa.get(indiceUbicacionActual + 1) instanceof UbicacionBloqueada) {
                    UbicacionBloqueada siguienteUbicacion = (UbicacionBloqueada) mapa.get(indiceUbicacionActual + 1);
                    if (siguienteUbicacion.estaBloqueada()) {
                        System.out.println("No puedes avanzar. La siguiente ubicación está bloqueada. Necesitas encontrar el objeto clave.");
                    } else {
                        indiceUbicacionActual++;
                    }
                } else {
                    indiceUbicacionActual++;
                }
            } else if (eleccion.equalsIgnoreCase("u")) {
                System.out.print("¿Qué objeto quieres usar de tu inventario?: ");
                String objetoAUsar = scanner.nextLine();
                lilo.usarObjeto(objetoAUsar, lilo);
            } else if (eleccion.equalsIgnoreCase("i")) {
                lilo.mostrarEstado();
            } else if (eleccion.equalsIgnoreCase("s")) {
                System.out.println("Lilo decide que es hora de un descanso. ¡Hasta la próxima aventura!");
                break;
            } else {
                System.out.println("Comando no válido. Lilo no entiende esa acción.");
            }
        }

        scanner.close();
    }
}
