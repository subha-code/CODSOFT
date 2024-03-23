package codesoft.project.p2;
import codesoft.project.p1.*;
public class GameRule extends NumberGuessingGame {

    public static void main(String[] args) {
        GameRule obj = new GameRule();
        obj.playGame();
        System.out.println("\nGame over!");
        System.out.println("Total rounds played: " + obj.totalRounds);
        System.out.println("Total rounds won: " + obj.totalRoundsWon);

    }
}
