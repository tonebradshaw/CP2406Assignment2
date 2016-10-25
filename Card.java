import javax.swing.*;
import java.awt.*;

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

        Dimension dim = new Dimension(148,206);
        button.setPreferredSize(dim);
    }
    public abstract String getName();
    public abstract JButton getButton();
    public abstract ImageIcon getImage();
}
