package Util;

import Cards.Card;
import Game.Foundation;
import Game.GamePlay;
import Game.Tableau;

import java.util.Scanner;
import java.util.Stack;

public class MyConsole {
    private final Scanner input;
    public static final MyConsole CONSOLE = new MyConsole();

    private MyConsole() {
        this.input = new Scanner(System.in);
    }

    public int notValidEntry() {
        return getIntegerInput("Not a valid entry. Try again");
    }

    public int getDropTab() {
        return getIntegerInput("To which pile do you want to drop?");
    }

    public void help() {
        println("\n\nInstructions:\n%s\n%s\n%s\n%s\n%s\n%s\n\n","To draw a card, enter \'DRAW\'"
                ,"To pick up card from draw pile, enter \'P\'"
                ,"To place card on a specific column, enter column number. If card should go onto foundation, just enter \'8\'"
                ,"To pull card down, type in 2-digit card code (i.e. \'7H\' for Seven of Hearts. " +
                "To pull down multiple cards, simply enter the highest card in the group " +
                "(ex: \'7H\' will pull down \'7H, 6S, 5D, etc...\'","To quit, type \'QUIT\'"
                , "If you need help, just type 'HELP'");
    }

    public void printBoard() {
        println("CLUBS\t\tDIAMONDS\t\tHEARTS\t\tSPADES");
        println("------\t\t--------\t\t------\t\t------");

        if (Foundation.clubStack.size() == 0){
            print("  --  \t\t");
        } else {
            print("  " + Foundation.clubStack.peek().toString2() + "  \t\t");
        }

        if (Foundation.diamondStack.size() == 0){
            print("   --  \t\t\t");
        } else {
            print("  " + Foundation.diamondStack.peek().toString2() + "  \t\t\t");
        }

        if (Foundation.heartStack.size() == 0){
            print("  --  \t\t");
        } else {
            print("  " + Foundation.heartStack.peek().toString2() + "  \t\t");
        }
        if (Foundation.spadeStack.size() == 0){
            println("  --  \t\t");
        } else {
            print("  " + Foundation.spadeStack.peek().toString2() + "  \t\t\n");
        }

        int i = 1;
        for (Tableau tab : GamePlay.arrayTabs) {
            println("\nCOLUMN " + i); i++;
            tab.getStack().forEach(e -> print(e.toString2() + " " + "\t"));
        }
        peekTopCard(GamePlay.drawPile);
    }

    public void peekTopCard(Stack<Card> pile) {
        println("\n\nDraw pile: " + pile.peek().toString2());
    }

    public String getStringInput(String prompt) {
        System.out.println(prompt);
        return input.nextLine();
    }

    public Character getCharacterInput(String prompt) {
        return getStringInput(prompt).charAt(0);
    }

    public Integer getIntegerInput(String prompt) {
        return Integer.parseInt(getStringInput(prompt));
    }

    public void println(String prompt, Object... args) {
        System.out.println(String.format(prompt+"\n", args));
    }

    public void print(String prompt, Object... args) {
        System.out.print(String.format(prompt+"\n", args));
    }
}
