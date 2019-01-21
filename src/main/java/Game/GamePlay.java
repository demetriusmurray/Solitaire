package Game;

import Cards.Card;
import Cards.Deck;

import java.util.Stack;

import static Cards.Card.toCard;
import static Game.Foundation.drop;
import static Util.MyConsole.CONSOLE;
//TODO inject tempStack and lastStack INTO Tableau class? It is so tightly coupled
public class GamePlay {
//    public Tableau tab1, tab2, tab3, tab4, tab5, tab6, tab7;
    public static Stack<Card> drawPile = new Stack<>();
    public static Tableau[] arrayTabs;
    public static Stack<Card> tempStack = new Stack<>();
    public static Stack<Card> lastStack = new Stack<>();
    public static Deck deck;

    public GamePlay() {
        setup();
//        tempStack = new Stack<>();
//        drawPile = new Stack<>();
//        tab1 = new Tableau();
//        tab2 = new Tableau();
//        tab3 = new Tableau();
//        tab4 = new Tableau();
//        tab5 = new Tableau();
//        tab6 = new Tableau();
//        tab7 = new Tableau();
//        arrayTabs = new Tableau[]{tab1, tab2, tab3, tab4, tab5, tab6, tab7};
//        arrayTabs = new Tableau[]{new Tableau(), new Tableau(), new Tableau(), new Tableau(), new Tableau(), new Tableau(), new Tableau()};
    }

    public void deal() {
        for (int i = 0; i < arrayTabs.length; i++) {
            for (int j = 0; j < arrayTabs.length; j++) {
                if (j >= i) arrayTabs[j].add(draw());
                if (j != i) arrayTabs[j].showTopCard().setCovered(true);
            }
        }
        for(Tableau tab : arrayTabs) tab.showTopCard().setCovered(false);
    }

    private static Card draw() {
        return deck.draw();
    }

    public static void drawCard(){
        drawPile.push(draw());
    }

    public static void dropCard(int key) {
        if (key > 0 && key < 8) {
            arrayTabs[key-1].place();
        } else if (key == 8)
            drop();
        else {
            dropCard(CONSOLE.notValidEntry());
        }
    }

    public static Tableau findTab(Card c){
        for (Tableau tab : arrayTabs)
            if (tab.contains(c)) {
                lastStack = tab.getStack();
                return tab;
            }
        return null;
    }

    public static void gameOver() {

    }

    public void peekTopCard(){
        if(drawPile.size()>0) CONSOLE.peekTopCard(drawPile);
    }

    public static Stack<Card> pickUp(){
        tempStack.push(drawPile.pop());
        lastStack = drawPile;
        return tempStack;
    }

    public static void pull(String cardCode){
        char f = cardCode.toUpperCase().charAt(0);
        char s = cardCode.toUpperCase().charAt(1);
        Card c = toCard(f,s);
        findTab(c).pull(c);
    }

    public void resetDeck(){
        deck = new Deck();
        deck.shuffle();
    }

    public void refillDeck(){
        if (deck.size()<1){
            while(drawPile.iterator().hasNext())
                deck.push(drawPile.pop());
        }
    }

    private void setup() {
        resetDeck();
        arrayTabs = new Tableau[]{
                new Tableau(), new Tableau(), new Tableau(),
                new Tableau(), new Tableau(), new Tableau(),
                new Tableau()
        };
        deal();
    }

    public static void unCover(Stack<Card> lastStack){
        if (lastStack.size() > 0 && lastStack.peek().isCovered())
            lastStack.peek().setCovered(false);
    }
}
