import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.math.RoundingMode;
import java.util.ArrayList;

import static javax.swing.UIManager.get;

/**
 * Created by tony on 23/09/2016.
 */
public class DisplayHand extends JPanel {

    private GridLayout grid;
    private GridLayout grid1;
    private Color color;
    private Dimension dimension;

    public DisplayHand(ArrayList<Card> handCards){

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();//get screen size
        int width = (int)screen.getWidth();
        int height = (int)screen.getHeight();
        grid = new GridLayout(2, 8); //2 rows
        grid1 = new GridLayout(1, 8); //1 row
        color = new Color(0,153,76);
        setBackground(color);

        for (int i = 0; i < handCards.size(); ++i) { //add card JButtons to DisplayHand JPanel

            add(handCards.get(i).getButton());
        }
        if (handCards.size() < 9){ //1 row if less than 9 cards else 2 rows

            setLayout(grid1);
            dimension = new Dimension(handCards.size() * 165, 230);
            setPreferredSize(dimension);

        } else {

            setLayout(grid);
            dimension = new Dimension(((int)(Math.ceil(((double) handCards.size())/2) * 165)), 450);
            setPreferredSize(dimension);
        }
    }
}
