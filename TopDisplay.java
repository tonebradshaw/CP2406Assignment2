import javax.swing.*;
import java.awt.*;

/**
 * Created by tony on 23/09/2016.
 */
public class TopDisplay extends JPanel {

    public ImageIcon cardBackImage;
    BorderLayout border = new BorderLayout();
    GridLayout grid = new GridLayout(2, 3);
    FlowLayout flow = new FlowLayout();
    Card card;
    String category;
    JLabel label1, label1a, label2, label2a, label3, label3a, label4, label4a, label5, label5a;

    public TopDisplay(){

        Deck deck = new Deck();
        Font font = new Font("Arial Rounded MT Bold", Font.PLAIN, 20);

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize(); //find screen size
        int width = (int)screen.getWidth();
        int height = (int)screen.getHeight();
        setSize(width, 150);

        int rand = (int)(Math.random() * 60); //random card number

        setLayout(border);

        card = deck.cards[rand];
        cardBackImage = new ImageIcon("src\\CardImages\\CardBack.png"); //image of back of card

        JPanel panel1 = new JPanel(); //contains right side cards
        panel1.setBackground(Color.GREEN);

        //make labels1
        label1 = new JLabel("<html><br>&emsp<b>Name: </b>William&emsp<br>&emsp<b>Cards : </b>4<br><br>" +
                "&emsp<b>Name: </b>James&emsp<br>&emsp<b>Cards : </b>11</html>");
        label1.setFont(font);
        label1.setForeground(Color.BLUE);
        label1a = new JLabel(cardBackImage);

        //add label1s to panels
        panel1.add(label1a);
        panel1.add(label1);

        JPanel panel2 = new JPanel(); //contains active card and values
        panel2.setBackground(Color.GREEN);

        //make labels2
        if(card.getName().startsWith("The ")){
            category = ((TrumpCard)card).getCategory();

            label2 = new JLabel("<html><b>Active Card<br><br>Category: </b>" + category + "&emsp<br><b>Value </b>></html>");
        }else{
            label2 = new JLabel("<html><b><b>Active Card<br><br>Category: </b>Specific Gravity&emsp<br><b>Value > </b><html>" + ((MineralCard)card).getSpecificGravity() + "&emsp");
        }
        label2.setFont(font);
        label2.setForeground(Color.MAGENTA);
        label2a = new JLabel(card.image);

        //add lable2s to panel2
        panel2.add(label2);
        panel2.add(label2a);

        JPanel panel4 = new JPanel(); //contains left side cards
        panel4.setBackground(Color.GREEN);

        //make label4s
        label4 = new JLabel("<html><br><b>Name: </b>Catherine&emsp<br><b>Cards : </b>8<br><br>" +
                "<b>Name: </b>Joseph&emsp<br><b>Cards : </b>18</html>");
        label4.setFont(font);
        label4.setForeground(Color.BLUE);
        label4a = new JLabel(cardBackImage);

        //add label4s to panel4
        panel4.add(label4);
        panel4.add(label4a);

        //add panels to TopDisplay panel(BorderLayout)
        add(panel1, BorderLayout.EAST);
        add(panel4, BorderLayout.WEST);
        add(panel2, BorderLayout.CENTER);
    }
}
