import java.util.Scanner;

public class Blackjack {

    static int dealerCarta1 = 0;
    static int dealerCarta2 = 0;
    static int dealerCarta3 = 0;
    static int dealerCarta4 = 0;
    static int jugadorCarta1 = 0;
    static int jugadorCarta2 = 0;
    static int jugadorCarta3 = 0;
    static int jugadorCarta4 = 0;
    static int apuesta;

    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        boolean salir = false;
        double dinero = 100;
        double winrate;
        int ganadas = 0;
        int perdidas = 0;
        int partidas = 0;
        System.out.println("--------------------------- Bienvenido/a a Blackjack. -----------------------------------");
        System.out.println("--- En este Blackjack, la máxima cantidad de cartas que se puede tener por mano son 4 ---");

        while (salir == false) {

            int totalJugador = 0;
            int totalDealer = 0;
            int turnos = 0;
            boolean apuestaInvalida = false;

            while (apuestaInvalida == false) {
                System.out.print("Introduce tu apuesta: ");
                apuesta = src.nextInt();
                if (apuesta > dinero) {
                    System.out.println("No puedes apostar dinero que no tienes.");
                } else break;
            }
            dinero -= apuesta;
            dealerCarta1 = generarCarta();
            dealerCarta2 = generarCarta();
            System.out.println("Dealer: " + dealerCarta1);
            totalDealer = dealerCarta1 + dealerCarta2;

            if (totalDealer < 17) {
                dealerCarta3 = generarCarta();
                totalDealer += dealerCarta3;
            }
            if (totalDealer < 17) {
                dealerCarta4 = generarCarta();
                totalDealer += dealerCarta4;
            }

            jugadorCarta1 = generarCarta();
            jugadorCarta2 = generarCarta();
            totalJugador = jugadorCarta1 + jugadorCarta2;

            System.out.println("Jugador: " + jugadorCarta1 + " " + jugadorCarta2);
            System.out.println("Quieres pedir una carta? (true/false)");
            boolean pedirCarta = src.nextBoolean();
            if (pedirCarta) {
                while (totalJugador < 21) {
                    jugadorCarta3 = generarCarta();
                    totalJugador += jugadorCarta3;
                    if (totalJugador >= 21) break;
                    System.out.println("Dealer: " + dealerCarta1);
                    System.out.println("Jugador: " + jugadorCarta1 + " " + jugadorCarta2 + " " + jugadorCarta3);
                    System.out.println("Quieres pedir una carta? (true/false)");
                    pedirCarta = src.nextBoolean();
                    turnos += 1;

                    if (pedirCarta) {
                        jugadorCarta4 = generarCarta();
                        totalJugador += jugadorCarta4;
                        System.out.println("No puedes pedir más cartas.");
                    } else break;
                }
            }
            if (totalJugador == 21 && turnos == 0){
                estadoCartas();
                System.out.println("BLACKJACK! Multiplicaste tu apuesta por x2.5");
                dinero = apuesta * 2.5;
                ganadas += 1;
            } else if (totalJugador > 21) {
                estadoCartas();
                System.out.println("Te pasaste. Perdiste.");
                perdidas += 1;
            } else if (totalDealer > 21) {
                estadoCartas();
                System.out.println("El dealer se pasó. Ganaste!");
                dinero = apuesta * 2;
                ganadas += 1;
            } else if (totalJugador > totalDealer) {
                estadoCartas();
                System.out.println("Ganaste. Duplicaste tu apuesta.");
                dinero = apuesta * 2;
                ganadas += 1;
            } else if (totalJugador < totalDealer) {
                estadoCartas();
                System.out.println("Perdiste.");
                perdidas += 1;
            } else {
                estadoCartas();
                System.out.println("Empate. Recuperas tu apuesta.");
                dinero += apuesta;
            }

            winrate = partidas * ((double) ganadas / 100);

            System.out.println("------------------------------------------------------");
            System.out.println("Dinero actual: " + dinero);
            System.out.println("Partidas ganadas: " + ganadas);
            System.out.println("Partidas perdidas: " + perdidas);
            System.out.println("Winrate: " + winrate);

            if (dinero <= 0){
                System.out.println("Has perdido todo tu dinero, finalizando el programa...");
                break;
            }

            System.out.println("Quieres finalizar el programa? (true/false)");
            salir = src.nextBoolean();
            if (salir) break;
        }
    }
    public static int generarCarta() {
        int carta = (int) (Math.random() * 13) + 1; // genera entre 1 y 13
        if (carta > 10) {
            carta = 10; // J, Q, K valen 10
        }
        return carta;
    }

    public static void estadoCartas() {

        System.out.print("Dealer: " + dealerCarta1 + " " + dealerCarta2);
        if (dealerCarta3 != 0) System.out.print(" " + dealerCarta3);
        if (dealerCarta4 != 0) System.out.println(" " + dealerCarta4);
        else System.out.println();

        System.out.print("Jugador: " + jugadorCarta1 + " " + jugadorCarta2);
        if (jugadorCarta3 != 0) System.out.print(" " + jugadorCarta3);
        if (jugadorCarta4 != 0) System.out.println(" " + jugadorCarta4);
        else System.out.println();
    }

}