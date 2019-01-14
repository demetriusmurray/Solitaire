package Game;

import static Util.MyConsole.CONSOLE;

public enum Commands {
    DRAW(Commands::drawCard),
    P(Commands::pickUp),
    HELP(Commands::help),
    QUIT(Commands::gameOver);
    private Runnable runnable;

    Commands(Runnable runnable) { this.runnable = runnable; }

    private static void drawCard() {
        GamePlay.drawCard();
        CONSOLE.printBoard();
    }

    private static void pickUp() {
        GamePlay.pickUp();
        CONSOLE.println("\nYou just picked up " + GamePlay.tempStack.peek().toString2());
        GamePlay.dropCard(CONSOLE.getDropTab());
        CONSOLE.printBoard();
    }

    private static void help() {
        CONSOLE.help();
    }

    private static void gameOver() {
        GamePlay.gameOver();
    }
}
