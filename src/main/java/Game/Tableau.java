package Game;

import Cards.Card;

import java.util.Collection;
import java.util.Stack;

import static Game.GamePlay.lastStack;
import static Game.GamePlay.tempStack;
import static Game.GamePlay.unCover;

public class Tableau {
    //consider making an undo method.
    //or better yet, create method that lets you know where you can place. highlighted card in the UI.

    private Stack<Card> stack;


    public Tableau(){
        this.stack = new Stack<>();
    }

    public Integer size() { return stack.size(); }

    public void add(Card c){
        stack.push(c);
    }

    public boolean contains(Card c) { return stack.contains(c); }

    public Card showTopCard() { return stack.peek(); }

    public Card removeTopCard() { return stack.pop(); }

    public Stack<Card> getStack() { return this.stack; }

    //c = the top card of the subStack you want to pull - ex. 6D, 5C, 4H, 3S, 2D, AS; if you want to pull 4H and down, c = 4H.
    public void pull(Card c){
        while(!stack.peek().equals(c))  tempStack.push(stack.pop());
        tempStack.push(stack.pop());
    }

    //does not need parameter. with a stack representing each column, will simply call 'stack'.place() to drop the tempStack on top of it.
    public void place(){
        if (this.canReceive(tempStack.peek())){
            while(tempStack.iterator().hasNext()){
                add(tempStack.pop());
                unCover(lastStack);
            }
            unCover(lastStack);
        } else { lastStack.push(tempStack.pop()); }
    }

    //checks whether 'top' card of stack is opposite color and 1 above passed card
    private boolean canReceive(Card c) {
        if(size() > 0) {
            if ((this.stack.peek().getFace().getPrimaryValue() - 1) == c.getFace().getPrimaryValue()
                    && (this.stack.peek().isBlack() != c.isBlack())) {
                return true;
            } else {
                System.out.println("Can't match " + stack.peek().toString() + " and " + c.toString());
                return false;
            }
        } else {
            //primVal of 13 is KING
            return c.getFace().getPrimaryValue() == 13;
        }
    }
}
