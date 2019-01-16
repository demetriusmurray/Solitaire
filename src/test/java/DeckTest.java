import Cards.Card;
import Cards.Deck;
import Cards.Face;
import Cards.Suit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeckTest {
    private Deck deck;

    @Before
    public void setup() {
        deck = new Deck();
    }

    @Test
    public void deckSize() {
        Assert.assertEquals(52, deck.size());
    }

    @Test
    public void cardsUnique() {
        Long expected = 52L;
        Long actual = deck.getDeck().stream().distinct().count();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testShuffle() {
        Card card1 = deck.getDeck().peek();
        Card card2 = deck.getDeck().peek();
        Card card3 = deck.getDeck().peek();

        deck.shuffle();

        Card cardA = deck.getDeck().peek();
        Card cardB = deck.getDeck().peek();
        Card cardC = deck.getDeck().peek();

        Assert.assertNotEquals(card1, cardA);
        Assert.assertNotEquals(card2, cardB);
        Assert.assertNotEquals(card3, cardC);
    }

    @Test
    public void testPush() {
        Card card = new Card(Suit.HEARTS, Face.EIGHT);
        deck.push(card);
        Assert.assertEquals(53,deck.size());
        Assert.assertEquals(card,deck.draw());
    }
}
