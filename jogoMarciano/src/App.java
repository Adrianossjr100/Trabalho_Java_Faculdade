import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        int tentativas = 0;
        int limite_tentativas;
        boolean acertou = false;

        System.out.println(
            "Uma pequena nave espacial pousou em um bosque misterioso na Terra.\n" +
            "Dela saiu um marciano curioso, que resolveu brincar de esconde-esconde.\n" +
            "O bosque tinha 100 árvores, cada uma marcada com um número de 1 a 100.\n" +
            "O visitante se escondeu atrás de uma delas e desafiou você a encontrá-lo.\n" +
            "Escolha um número e tente adivinhar qual árvore guarda esse novo amigo!\n" +
            "Será que você consegue descobrir o esconderijo antes que a nave decole?"
        );

        System.out.println("\nDigite a dificuldade desejada:");
        System.out.println("D - Difícil     M - Médio     F - Fácil");

        String dificuldade = sc.nextLine().trim();

        if (dificuldade.equalsIgnoreCase("D")) {
            limite_tentativas = 7;
        } else if (dificuldade.equalsIgnoreCase("M")) {
            limite_tentativas = 8;
        } else if (dificuldade.equalsIgnoreCase("F")) {
            limite_tentativas = 10;
        } else {
            System.out.println("Dificuldade inválida. Digite D, M ou F.");
            sc.close();
            return;
        }

        int arvore_certa = rd.nextInt(100) + 1;

        System.out.println(
            "\nEncontre o marciano em até " + limite_tentativas + " tentativas!"
        );

        while (tentativas < limite_tentativas) {
            System.out.print(
                "\nTentativa " + (tentativas + 1) +
                ": escolha uma árvore de 1 a 100: "
            );

            if (!sc.hasNextInt()) {
                System.out.println("Digite um número inteiro.");
                sc.next();
                continue;
            }

            int arvore_chute = sc.nextInt();

            if (arvore_chute < 1 || arvore_chute > 100) {
                System.out.println("Digite um número entre 1 e 100.");
                continue;
            }

            tentativas++;

            if (arvore_chute == arvore_certa) {
                acertou = true;
                System.out.println(
                    "Você encontrou o marciano em " + tentativas + " tentativa(s)!"
                );
                break;
            } else if (arvore_chute > arvore_certa) {
                System.out.println(
                    "O número digitado é MAIOR que o número da árvore do marciano."
                );
            } else {
                System.out.println(
                    "O número digitado é MENOR que o número da árvore do marciano."
                );
            }
        }

        if (!acertou) {
            System.out.println(
                "\nA nave decolou! O marciano estava na árvore " + arvore_certa + "."
            );
        }

        sc.close();
    }
}