import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        int vida = 15;
        int experiencia = 0;
        boolean envenenado = false;

        System.out.println("------Juego aventurero------");

        while (vida > 0 && experiencia < 50) {
            System.out.println("Preciona ENTER para lanzar el dado");
            teclado.nextLine();
            int dado = random.nextInt(12) + 1;
            System.out.println("Has sacado: " + dado);

            switch (dado) {
                case 1, 2 -> {
                    vida += 1;
                    System.out.println("Encontraste una fuente de vida, +1 punto de vida. Vida: " + vida);
                }
                case 3, 4, 5 -> {
                    vida -= 5;
                    System.out.println("Fuiste atacado brutalmente, -5 puntos de vida. Vida: " + vida);
                }
                case 6, 7 -> {
                    experiencia += 3;
                    System.out.println("Ganas experiencia, +3 puntos de experiencia. Experiencia: " + experiencia);
                    break;
                }
                case 8, 9 -> {
                    experiencia = experiencia - 6;
                    System.out.println("Cometiste un error grave. -6 puntos de experiencia. Experiencia: " + experiencia);
                    break;
                }
                case 10, 11 -> {
                    vida -= 8;
                    System.out.println("Caiste en una trampa letal. -8 puntos de vida. Vida: " + vida);
                    break;
                }
                case 12 -> {
                    int eventoEspecial = random.nextInt(3);
                    if (eventoEspecial == 0) {
                        experiencia += 10;
                        System.out.println("Encontraste un pergamino antiguo. +10 puntos de experiencia. Experiencia: " + experiencia);
                    } else if (eventoEspecial == 1) {
                        envenenado = true;
                        System.out.println("Te infectaste con veneno. Perderás -2 puntos de vida por turno.");
                    } else {
                        vida /= 2;
                        System.out.println("Un demonio te ataco. Tu vida se reduce a la mitad. Vida: " + vida);
                    }
                    break;
                }
            }

            if (envenenado) {
                vida -= 2;
                System.out.println("El veneno hace efecto. -2 puntos de vida. Vida: " + vida);
            }
        }
        if (vida <= 0) {
            System.out.println("Has muerto, fin del juego");
        } else {
            System.out.println("Has alcanzado 50 puntos de experiencia, Ganaste");
        }
        teclado.close();
    }
}
