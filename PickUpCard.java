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

        pickUpImage = new ImageIcon(getClass().getResource("/CardImages/PickUp.png"));
        pickUp = new JButton(pickUpImage);
        Dimension dim = new Dimension(148,206);
        pickUp.setPreferredSize(dim);

        pickUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Play.shuffledDeck.size() == 0){ //move discard pile to shuffled deck

                    if (Play.discardedCards.size() == 1){

                        JOptionPane.showMessageDialog(null, "<html>There are no more cards left to pick up<br><br>" +
                                "As no-one has emptied their hand<br>the game is drawn</html");
                        System.exit(0);
                    }
                    Play.transferPile();
                }
                if (GameDisplay.resetValue == 1){

                    JOptionPane.showMessageDialog(null, "You need to throw a card");

                } else {
                    selectedCard = Play.shuffledDeck.get(0); //if card picked up
                    GameDisplay.players[GameDisplay.playerNumber].getHand().add(selectedCard); //add card to hand
                    //set player pickupcard
                    GameDisplay.players[GameDisplay.playerNumber].setPickUpCard(1);
                    //add pickupinrow to player
                    GameDisplay.players[GameDisplay.playerNumber].setPickupsInARow(GameDisplay.players[GameDisplay.playerNumber].getPickupsInARow() + 1);
                    Play.shuffledDeck.remove(0); //remove card from pickup deck
                    GameDisplay.nextPlayer();
                }
            }
        });
    }
    public JButton getButton(){

        return pickUp;
    }
}
