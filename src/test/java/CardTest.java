import Cards.Card;
import Cards.Face;
import Cards.Suit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CardTest {
    private Card card1;
    private Card card2;

    @Before
    public void setup() {
        card1 = new Card(Suit.HEARTS, Face.NINE);
        card2 = new Card(Suit.SPADES, Face.ACE);
    }

    @Test
    public void testToCard() {
        Card expected = card1;
        Card actual = Card.toCard('9','H');
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testGetSuit() {
        Suit expected = Suit.HEARTS;
        Suit actual = card1.getSuit();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testGetFace() {
        Face expected = Face.NINE;
        Face actual = card1.getFace();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testIsBlack() {
        Assert.assertFalse(card1.isBlack());
        Assert.assertTrue(card2.isBlack());
    }

    @Test
    public void testIsCovered_Fails() {
        Assert.assertFalse(card2.isCovered());
    }

    @Test
    public void testIsCovered() {
        card1.setCovered(true);
        Assert.assertTrue(card1.isCovered());
    }
}
