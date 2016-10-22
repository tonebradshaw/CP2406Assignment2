import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tony on 26/09/2016.
 */
public class PickUpCard {

    private ImageIcon pickUpImage;
    private JButton pickUp;
    private Card selectedCard;

    public PickUpCard(){

        pickUpImage = new ImageIcon("src\\CardImages\\PickUp.png");
        pickUp = new JButton(pickUpImage);
        Dimension dim = new Dimension(148,206);
        pickUp.setPreferredSize(dim);

        pickUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                selectedCard = Play.shuffledDeck.get(0); //if card picked up

                GameDisplay.players[GameDisplay.playerNumber].getHand().add(selectedCard); //add card to hand
                Play.shuffledDeck.remove(0); //remove card from pickup deck
                pickUp.setVisible(false);
                GameDisplay.nextPlayer();
            }

        });
    }
    public JButton getButton(){

        return pickUp;
    }

}
