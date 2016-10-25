import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by tony on 23/09/2016.
 */
public class TestDisplayHand extends JFrame{

    static ArrayList<Card> shuffledDeck = new ArrayList<>();
    static ArrayList<Card> handCards = new ArrayList<>() ;
    static public final int DECK_SIZE = 60;
    static int handSize = 5;
    static JPanel panel;
    static DisplayHand display;
    static TopDisplay top;
    static BorderLayout border = new BorderLayout();
    static FlowLayout flow = new FlowLayout();

    public TestDisplayHand(){

        super("Mineral Supertrumps Game"); //Frame name
        getContentPane().setBackground(Color.GREEN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize(); //get screen size; use next 2 lines as well
        int width = (int)screen.getWidth();
        int height = (int)screen.getHeight();

        setSize(width, height - 40);
        setLayout(border); //can use north, south locations
    }

    public static void main(String[] args) {

        TestDisplayHand test = new TestDisplayHand();

        Deck deck = new Deck(); // make deck

        for (int i = 0; i < DECK_SIZE; ++i) { //convert Deck array to shuffledDeck ArrayList

            shuffledDeck.add(deck.cards[i]);
        }
        Collections.shuffle(shuffledDeck); //shuffle the deck

        for (int i = 0; i < handSize; ++i){ // make hand

            handCards.add(shuffledDeck.get(i));
        }

        display = new DisplayHand(handCards); //make bottom card display
        top = new TopDisplay(); // make top display
        top.setBackground(Color.GREEN);

        if (handSize < 7 || (handSize > 8 && handSize <= 13)){ //use border layout or flow layout with JPanel depending on number of cards in hand
            panel = new JPanel();
            panel.setBackground(Color.GREEN);
            panel.setLayout(flow);
            panel.add(display);
            test.add(panel, BorderLayout.SOUTH);
        } else {
            test.add(display, BorderLayout.SOUTH);
        }
        test.add(top, BorderLayout.NORTH);
        test.setLocationRelativeTo(null);
        test.setVisible(true);
    }
}
