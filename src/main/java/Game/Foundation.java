package Game;

import Cards.Card;
import Cards.Face;
import Cards.Suit;

import java.util.Stack;

import static Game.GamePlay.*;

public class Foundation {

    public static Stack<Card> clubStack = new Stack<>();
    public static Stack<Card> diamondStack = new Stack<>();
    public static Stack<Card> heartStack = new Stack<>();
    public static Stack<Card> spadeStack = new Stack<>();

    public static void drop() {
        Card card = tempStack.pop();
        Suit suit = card.getSuit();
        if (suit == Suit.CLUBS && canReceive(card,clubStack)) {
                clubStack.push(card);

        }
        else if (suit == Suit.DIAMONDS && canReceive(card,diamondStack)) {
                diamondStack.push(card);
        }
        else if (suit == Suit.HEARTS && canReceive(card,heartStack)) {
                heartStack.push(card);
        }
        else if (suit == Suit.SPADES && canReceive(card,spadeStack)) {
                spadeStack.push(card);
        } else {
            tempStack.push(card);
        }
        unCover(lastStack);
    }

    private static boolean canReceive(Card tempStackCard, Stack<Card> foundation) {
        Face face = tempStackCard.getFace();
        return foundation.empty() && face == Face.ACE || face.getPrimaryValue() == foundation.peek().getFace().getPrimaryValue() + 1;
    }
}
