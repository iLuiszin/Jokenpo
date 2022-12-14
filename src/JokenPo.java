import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public record JokenPo(Player user, Player IA, int rounds) {
    public void toPlay() {
        System.out.println("\n******* SEJA BEM-VINDO(A), " + user.getName() + " *******\n");

        for (int i = 1; i <= rounds; i++) {
            int choiceUser = choiceUser();
            if (choiceUser < 1 || choiceUser > 3) {
                System.out.println("\nJOGADA INVÁLIDA! (1, 2 ou 3): ");
                System.out.println("\tPONTO PARA " + IA.getName() + "\n");
                IA.incrementPoints();
                continue;
            }

            int choiceIA = choiceIA();

            System.out.println("\n" + choiceUser + " X " + choiceIA);

            int result = choiceUser - choiceIA;

            winnerRound(result);
        }

    }

    public void showFinalResult() {
        System.out.println("\n***********************************\n");

        int finalScoreUser = user.getPoints();
        int finalScoreIA = IA.getPoints();

        System.out.println("\n\tPLACAR FINAL: " + user.getName() + " " + user.getPoints() + " X " + IA.getPoints() + " " + IA.getName());

        if(finalScoreUser == finalScoreIA){
            System.out.println("\t\t\tEMPATE!");
        } else {
            String finalWinner = (finalScoreUser > finalScoreIA) ? user.getName() : IA.getName();
            System.out.println("\t\tVENCEDOR = " + finalWinner.toUpperCase());
        }
        System.out.println("\n\n***********************************");
    }

    private void winnerRound(int result) {
        String winnerRound;
        if (result == 0) {
            winnerRound = "EMPATE!";
        } else {
            if (result == -1 || result == 2) {
                IA().incrementPoints();
                winnerRound = IA().getName();
            } else {
                user.incrementPoints();
                winnerRound = user().getName();
            }
        }
        System.out.println("\nVencedor do Round: " + winnerRound + "\n");
    }

    private int choiceIA() {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }

    private int choiceUser() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1 - PEDRA ");
        System.out.println("2 - PAPEL ");
        System.out.println("3 - TESOURA ");

        System.out.print("Informe sua jogada: ");

        return scan.nextInt();
    }


}
