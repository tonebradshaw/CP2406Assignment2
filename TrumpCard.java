import javax.swing.*;

/**
 * Created by tony on 6/08/2016.
 */
public class TrumpCard extends Card{ //trump card information

    private String category;

    public TrumpCard(String name, String category, JButton button, ImageIcon image){ //trump card constructor

        super(name, button, image);
        this.category = category;
    }

    public String getCategory(){return category;}

    @Override
    public String getName(){return this.name;}

    @Override
    public JButton getButton(){return this.button;}

    @Override
    public ImageIcon getImage(){return this.image;}

    @Override
    public String toString() { //used to print trump card values
        return "Name: " + super.name + ",  " +
                "Category: " + this.getCategory()+ "\n" ;
    }
}
