import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tony on 26/09/2016.
 */
public class PickUpCard {

    private ImageIcon pickUpImage;
    private JButton pickUp;

    public PickUpCard(){

        pickUpImage = new ImageIcon("src\\CardImages\\PickUp.png");
        pickUp = new JButton(pickUpImage);
        pickUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                pickUp.setVisible(false);
            }
        });
    }
    public JButton getButton(){

        return pickUp;
    }

}
