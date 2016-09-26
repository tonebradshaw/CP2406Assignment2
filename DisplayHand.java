import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

import static javax.swing.UIManager.get;

/**
 * Created by tony on 23/09/2016.
 */
public class DisplayHand extends JPanel {

    private GridLayout grid;
    private GridLayout grid1;
    private PickUpCard pickUp;

    public DisplayHand(ArrayList<Card> handCards, Card pickUpCard){

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();//get screen size
        int width = (int)screen.getWidth();
        int height = (int)screen.getHeight();
        grid = new GridLayout(2, 10); //2 rows
        grid1 = new GridLayout(1, 10); //1 row

        setBackground(Color.GREEN);
        setSize(width, height / 2);

        for(int i = 0; i < handCards.size(); ++i) { //add card JButtons to DisplayHand JPanel

            add(handCards.get(i).button);
        }
        pickUp = new PickUpCard();
        add(pickUp.getButton());


        if(handCards.size() <= 9){ //1 row if less than 10 cards else 2 rows
            setLayout(grid1);
        }else{
            setLayout(grid);
        }
    }
}
