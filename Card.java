import javax.swing.*;
import java.awt.*;

/**
 * Created by tony on 9/08/2016.
 */
public abstract class Card {

    protected String name;
    protected JButton button;
    protected ImageIcon image;
    protected ImageIcon backImage;


    public Card(String name, JButton button, ImageIcon image){ //card constructor

        this.name = name;
        this.button = button;
        this.image = image;
        backImage = new ImageIcon("src\\CardImages\\PickUp.png");

        Dimension dim = new Dimension(148,206);
        button.setPreferredSize(dim);
    }
    public abstract String getName();
    public JButton getButton(){return button;}
    public ImageIcon getImage(){return image;}
    public ImageIcon getBackImage(){return backImage;}
}
