package Cards;

import java.util.Collections;
import java.util.Stack;

public class Deck {

    private Stack<Card> deckOfCards = new Stack<>();

    public Deck() {
        for (Suit suit : Suit.values()) {
            for (Face face : Face.values()) {
                deckOfCards.push(new Card(suit, face));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(deckOfCards);
    }

    public Card draw(){
        return deckOfCards.pop();
    }

    public int size() {
        return deckOfCards.size();
    }

    public Stack<Card> getDeck() {
        return deckOfCards;
    }

    public void push(Card card) {
        deckOfCards.push(card);
    }
}