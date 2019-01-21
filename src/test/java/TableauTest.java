import Cards.Card;
import Cards.Face;
import Cards.Suit;
import Game.Tableau;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static Game.GamePlay.lastStack;
import static Game.GamePlay.tempStack;

public class TableauTest {
    private Tableau tab;
    private Card c;

    @Before
    public void setup() {
        tab = new Tableau();
        c = new Card(Suit.SPADES, Face.NINE);
    }

    @Test
    public void testSize() {
        Assert.assertEquals(Integer.valueOf(0),tab.size());
    }

    @Test
    public void testAdd() {
        tab.add(c);
        Assert.assertEquals(Integer.valueOf(1),tab.size());
    }

    @Test
    public void containsTest() {
        tab.add(c);
        Assert.assertTrue(tab.contains(c));
    }

    @Test
    public void showTopCardTest() {
        tab.add(c);
        Assert.assertEquals(c, tab.showTopCard());
        Assert.assertEquals(Integer.valueOf(1),tab.size());
    }

    @Test
    public void removeTopCardTest() {
        tab.add(c);
        Assert.assertEquals(c,tab.removeTopCard());
        Assert.assertEquals(Integer.valueOf(0),tab.size());
    }

    @Test
    public void getStackTest() {
        tab.add(c);
        Stack<Card> stack = tab.getStack();
        System.out.println(stack.peek());
        Assert.assertEquals(c,stack.pop());
    }

    @Test
    public void pullTest() {
        tab.add(c);
        tab.pull(new Card(Suit.SPADES,Face.NINE));
        Assert.assertEquals(Integer.valueOf(0), tab.size());
        tempStack.clear();
    }

    @Test
    public void pullMultipleTest() {
        tab.add(c);
        tab.add(new Card(Suit.SPADES, Face.EIGHT));
        tab.pull(c);
        Assert.assertEquals(2, tempStack.size());
        Assert.assertEquals(Integer.valueOf(0), tab.size());
        tempStack.clear();
    }

    @Test
    public void placeTest() {
        tab.add(c);
        tempStack.push(new Card(Suit.HEARTS,Face.EIGHT));
        tab.place();
        Assert.assertEquals(Integer.valueOf(2),tab.size());
    }
}
