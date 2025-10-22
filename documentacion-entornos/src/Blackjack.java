import java.util.Scanner;

public class Blackjack {

    // Variables estáticas para almacenar las cartas del dealer (hasta 4 cartas)
    static int dealerCarta1 = 0;
    static int dealerCarta2 = 0;
    static int dealerCarta3 = 0;
    static int dealerCarta4 = 0;

    // Variables estáticas para almacenar las cartas del jugador (hasta 4 cartas)
    static int jugadorCarta1 = 0;
    static int jugadorCarta2 = 0;
    static int jugadorCarta3 = 0;
    static int jugadorCarta4 = 0;

    // Variable para almacenar la apuesta actual
    static int apuesta;

    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        boolean salir = false; // Controla el bucle principal del juego
        double dinero = 100; // Dinero inicial del jugador
        double winrate; // Tasa de victorias
        int ganadas = 0; // Contador de partidas ganadas
        int perdidas = 0; // Contador de partidas perdidas
        int partidas = 0; // Contador total de partidas

        // Mensaje de bienvenida
        System.out.println("--------------------------- Bienvenido/a a Blackjack. -----------------------------------");
        System.out.println("--- En este Blackjack, la máxima cantidad de cartas que se puede tener por mano son 4 ---");

        // Bucle principal del juego
        while (salir == false) {

            int totalJugador = 0; // Suma total de cartas del jugador
            int totalDealer = 0; // Suma total de cartas del dealer
            int turnos = 0; // Contador de turnos (para detectar blackjack natural)
            boolean apuestaInvalida = false;

            // Bucle para validar la apuesta
            while (apuestaInvalida == false) {
                System.out.print("Introduce tu apuesta: ");
                apuesta = src.nextInt();
                // Verifica que el jugador no apueste más dinero del que tiene
                if (apuesta > dinero) {
                    System.out.println("No puedes apostar dinero que no tienes.");
                } else break;
            }

            // Se resta la apuesta del dinero disponible
            dinero -= apuesta;

            // El dealer recibe sus dos primeras cartas
            dealerCarta1 = generarCarta();
            dealerCarta2 = generarCarta();
            System.out.println("Dealer: " + dealerCarta1); // Solo se muestra una carta del dealer
            totalDealer = dealerCarta1 + dealerCarta2;

            // El dealer pide carta si tiene menos de 17 (regla estándar del blackjack)
            if (totalDealer < 17) {
                dealerCarta3 = generarCarta();
                totalDealer += dealerCarta3;
            }
            // El dealer pide una cuarta carta si aún tiene menos de 17
            if (totalDealer < 17) {
                dealerCarta4 = generarCarta();
                totalDealer += dealerCarta4;
            }

            // El jugador recibe sus dos primeras cartas
            jugadorCarta1 = generarCarta();
            jugadorCarta2 = generarCarta();
            totalJugador = jugadorCarta1 + jugadorCarta2;

            // Muestra las cartas del jugador y pregunta si quiere pedir más
            System.out.println("Jugador: " + jugadorCarta1 + " " + jugadorCarta2);
            System.out.println("Quieres pedir una carta? (true/false)");
            boolean pedirCarta = src.nextBoolean();

            // Si el jugador decide pedir carta
            if (pedirCarta) {
                // Bucle para pedir cartas adicionales
                while (totalJugador < 21) {
                    jugadorCarta3 = generarCarta();
                    totalJugador += jugadorCarta3;
                    if (totalJugador >= 21) break; // Se detiene si llega a 21 o se pasa

                    // Muestra el estado actual y pregunta si quiere otra carta
                    System.out.println("Dealer: " + dealerCarta1);
                    System.out.println("Jugador: " + jugadorCarta1 + " " + jugadorCarta2 + " " + jugadorCarta3);
                    System.out.println("Quieres pedir una carta? (true/false)");
                    pedirCarta = src.nextBoolean();
                    turnos += 1; // Incrementa el contador de turnos

                    // Si pide una cuarta carta (máximo permitido)
                    if (pedirCarta) {
                        jugadorCarta4 = generarCarta();
                        totalJugador += jugadorCarta4;
                        System.out.println("No puedes pedir más cartas.");
                    } else break;
                }
            }

            // Evaluación de resultados y cálculo de ganancias/pérdidas

            // BLACKJACK natural (21 con las dos primeras cartas)
            if (totalJugador == 21 && turnos == 0){
                estadoCartas();
                System.out.println("BLACKJACK! Multiplicaste tu apuesta por 2.5");
                dinero += apuesta * 2.5; // Paga 2.5x
                ganadas += 1;
            }
            // El jugador se pasó de 21
            else if (totalJugador > 21) {
                estadoCartas();
                System.out.println("Te pasaste. Perdiste.");
                perdidas += 1;
            }
            // El dealer se pasó de 21
            else if (totalDealer > 21) {
                estadoCartas();
                System.out.println("El dealer se pasó. Ganaste!");
                dinero += apuesta * 2; // Duplica la apuesta
                ganadas += 1;
            }
            // El jugador tiene más puntos que el dealer
            else if (totalJugador > totalDealer) {
                estadoCartas();
                System.out.println("Ganaste. Duplicaste tu apuesta.");
                dinero += apuesta * 2;
                ganadas += 1;
            }
            // El dealer tiene más puntos que el jugador
            else if (totalJugador < totalDealer) {
                estadoCartas();
                System.out.println("Perdiste.");
                perdidas += 1;
            }
            // Empate
            else {
                estadoCartas();
                System.out.println("Empate. Recuperas tu apuesta.");
                dinero += apuesta; // Devuelve la apuesta
            }

            // Calcula el winrate (esto parece tener un error en la fórmula)
            winrate = partidas * ((double) ganadas / 100);

            // Muestra estadísticas de la sesión
            System.out.println("------------------------------------------------------");
            System.out.println("Dinero actual: " + dinero);
            System.out.println("Partidas ganadas: " + ganadas);
            System.out.println("Partidas perdidas: " + perdidas);
            System.out.println("Winrate: " + winrate);

            // Verifica si el jugador se quedó sin dinero
            if (dinero <= 0){
                System.out.println("Has perdido todo tu dinero, finalizando el programa...");
                break;
            }

            // Pregunta si quiere continuar jugando
            System.out.println("Quieres finalizar el programa? (true/false)");
            salir = src.nextBoolean();
            if (salir) break;
        }
    }

    /*Genera una carta aleatoria return valor de la carta (1-10, donde J, Q, K valen 10) */
    public static int generarCarta() {
        int carta = (int) (Math.random() * 13) + 1; // Genera un número entre 1 y 13
        if (carta > 10) {
            carta = 10; // Las figuras (J, Q, K) valen 10
        }
        return carta;
    }

    /* Muestra el estado final de las cartas del dealer y del jugador*/
    public static void estadoCartas() {

        // Imprime las cartas del dealer
        System.out.print("Dealer: " + dealerCarta1 + " " + dealerCarta2);
        if (dealerCarta3 != 0) System.out.print(" " + dealerCarta3);
        if (dealerCarta4 != 0) System.out.println(" " + dealerCarta4);
        else System.out.println();

        // Imprime las cartas del jugador
        System.out.print("Jugador: " + jugadorCarta1 + " " + jugadorCarta2);
        if (jugadorCarta3 != 0) System.out.print(" " + jugadorCarta3);
        if (jugadorCarta4 != 0) System.out.println(" " + jugadorCarta4);
        else System.out.println();
    }

}