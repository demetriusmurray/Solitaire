package Cards;

import java.util.Collections;
import java.util.Stack;

public class Deck {

    public Stack<Card> deckOfCards = new Stack<>();

    public void shuffle(){
        Collections.shuffle(deckOfCards);
    }

    public Card draw(){
        return deckOfCards.pop();
    }

    public Deck() {
        for (Suit suit : Suit.values()) {
            for (Face face : Face.values()) {
                deckOfCards.push(new Card(suit, face));
            }
        }
    }
}