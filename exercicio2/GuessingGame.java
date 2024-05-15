// SCC0504 - Programação Orientada a Objetos (2024)
// Exercise 2: Simple Two-Person Game
// Nome: Eduardo Ribeiro Rodrigues  NUSP: 13696679

import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    // Variáveis para representar o status do jogo
    private int secretNumber; // O número secreto que o jogador deve adivinhar
    private int guessCount; // Contador de tentativas de adivinhação

    // Construtor
    public GuessingGame() {
        this.guessCount = 0;
    }

    // Método para configurar o jogo
    public void setupGame(int min, int max) {
        Random rand = new Random();
        this.secretNumber = rand.nextInt(max - min + 1) + min; // Gera um número secreto entre min e max
        // (100 - 1 + 1) + 1 = 101 (1 a 100)
    }

    // Método para aceitar o palpite do usuário
    public int acceptGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your guess: ");

        // verificar se o usuário digitou um número
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number.\nEnter your guess: ");
            scanner.next(); // Limpa o buffer do scanner
        }

        // verificar se o número digitado está dentro do intervalo
        int guess = scanner.nextInt();
        while (guess < 1 || guess > 100) {
            System.out.print("Invalid input. Please enter a number between 1 and 100.\nEnter your guess: ");
            guess = scanner.nextInt();
        }

        return guess; // Retorna o palpite do usuário
    }

    // Método para fornecer feedback
    public String feedback(int guess) {
        this.guessCount++; // Incrementa o contador de tentativas a cada palpite
        if (guess < this.secretNumber) {
            return "Too low!";
        } else if (guess > this.secretNumber) {
            return "Too high!";
        } else {
            return "Correct!";
        }
    }

    // Método para contar o número de palpites
    public int countGuess() {
        return this.guessCount;
    }

    // Método principal que executa o jogo
    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
        game.setupGame(1, 100); // Configura o jogo com um número entre 1 e 100
        int guess;
        String result;
        int answerExit = 1;

        // Loop principal do jogo
        while (answerExit == 1) {
            System.out.println("Guess a number between 1 and 100.");
            do {
                guess = game.acceptGuess(); // Aceita o palpite do usuário
                result = game.feedback(guess); // Fornece feedback
                System.out.println(result);
            } while (!result.equals("Correct!")); // Continua até o palpite estar correto

            System.out.println("Congratulations! You guessed the number in " + game.countGuess() + " attempts.");

            // Pergunta ao usuário se deseja jogar novamente
            System.out.println("\nDo you want to play again? (1 - Yes, 0 - No)");
            Scanner scanner = new Scanner(System.in);
            answerExit = scanner.nextInt();

            // Se o usuário deseja jogar novamente, configura o jogo com um novo número secreto
            if (answerExit == 1) {
                game.setupGame(1, 100); // Configura o jogo com um número entre 1 e 100
            }
        }
    }
}
