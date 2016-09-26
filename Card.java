import javax.swing.*;

/**
 * Created by tony on 9/08/2016.
 */
public abstract class Card {

    protected String name;
    protected JButton button;
    protected ImageIcon image;

    public Card(String name, JButton button, ImageIcon image){ //card constructor

        this.name = name;
        this.button = button;
        this.image = image;
    }
    public abstract String getName();
    public JButton getButton(){return button;}
    public ImageIcon getImage(){return image;}
}
