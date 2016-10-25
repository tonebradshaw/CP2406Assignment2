import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tony on 13/10/2016.
 */
public class Top extends JPanel{

    private ImageIcon cardBackImage;
    private Card activeCard;
    private String categoryValue, playerName1, playerName2, playerName3, playerName4;
    private JLabel label1, label1a, label2, label2a;
    private Color color, color1;
    private int playerCard1, playerCard2, playerCard3, playerCard4;

    static int numberOfPlayers, playerNumber;

    static Player [] players;

    public Top(){

        color = new Color(0,153,76);
        color1 = new Color(255,215,0);
        Font font = new Font("Arial Rounded MT Bold", Font.PLAIN, 20);
        PickUpCard pickUpCard = new PickUpCard();

        if (GameDisplay.gos != 0) {
            activeCard = Play.discardedCards.get(0);
        }
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize(); //find screen size
        int width = (int)screen.getWidth();
        Dimension dim1 = new Dimension(width,250);
        setPreferredSize(dim1);
        setLayout(new FlowLayout());setBackground(color);

        numberOfPlayers = GameDisplay.numberOfPlayers;
        playerNumber = GameDisplay.playerNumber;
        players = GameDisplay.players;

        if (numberOfPlayers == 3) { //3 player: populate names and hand size for left side information

            GameDisplay.incrementPlayerNumber();
            playerName1 = GameDisplay.players[GameDisplay.playerNumber].getName();
            playerCard1 = GameDisplay.players[GameDisplay.playerNumber].getHand().size();
            GameDisplay.incrementPlayerNumber();
            playerName2 = GameDisplay.players[GameDisplay.playerNumber].getName();
            playerCard2 = GameDisplay.players[GameDisplay.playerNumber].getHand().size();
            GameDisplay.incrementPlayerNumber();

        } else if (numberOfPlayers == 4){ //4 player: populate names and hand size for left side information

            GameDisplay.incrementPlayerNumber();
            playerName1 = GameDisplay.players[GameDisplay.playerNumber].getName();
            playerCard1 = GameDisplay.players[GameDisplay.playerNumber].getHand().size();
            GameDisplay.incrementPlayerNumber();
            playerName2 = GameDisplay.players[GameDisplay.playerNumber].getName();
            playerCard2 = GameDisplay.players[GameDisplay.playerNumber].getHand().size();
            GameDisplay.incrementPlayerNumber();
            playerName3 = GameDisplay.players[GameDisplay.playerNumber].getName();
            playerCard3 = GameDisplay.players[GameDisplay.playerNumber].getHand().size();
            GameDisplay.incrementPlayerNumber();

        } else if (numberOfPlayers == 5){ //5 player: populate names and hand size for left side information

            GameDisplay.incrementPlayerNumber();
            playerName1 = players[GameDisplay.playerNumber].getName();
            playerCard1 = players[GameDisplay.playerNumber].getHand().size();
            GameDisplay.incrementPlayerNumber();
            playerName2 = players[GameDisplay.playerNumber].getName();
            playerCard2 = players[GameDisplay.playerNumber].getHand().size();
            GameDisplay.incrementPlayerNumber();
            playerName3 = players[GameDisplay.playerNumber].getName();
            playerCard3 = players[GameDisplay.playerNumber].getHand().size();
            GameDisplay.incrementPlayerNumber();
            playerName4 = players[GameDisplay.playerNumber].getName();
            playerCard4 = players[GameDisplay.playerNumber].getHand().size();
            GameDisplay.incrementPlayerNumber();
        }
        cardBackImage = new ImageIcon("src\\CardImages\\CardBack.png"); //image of back of card

        JPanel panel1 = new JPanel(); //contains right side cards
        panel1.setBackground(color);
        Dimension dim2 = new Dimension(350,200); // size panel1
        panel1.setPreferredSize(dim2);
        panel1.setLayout(new BorderLayout());

        //make labels1: other player's names and hand size
        if (numberOfPlayers == 3){

            label1 = new JLabel("<html><br><b>Name: </b>" + playerName1 + "&emsp<br><b>Cards : </b>" + playerCard1 + "<br><br>" +
                    "<b>Name: </b>" + playerName2 + "&emsp<br><b>Cards : </b>" + playerCard2 + "</html>");

        } else if (numberOfPlayers == 4){

            label1 = new JLabel("<html>&emsp<b>Name: </b>" + playerName1 + "&emsp<br>&emsp<b>Cards : </b>" + playerCard1 + "<br><br>" +
                    "&emsp<b>Name: </b>" + playerName2 + "&emsp<br>&emsp<b>Cards : </b>" + playerCard2 + "<br><br>" +
                    "&emsp<b>Name: </b>" + playerName3 + "&emsp<br>&emsp<b>Cards : </b>" + playerCard3 + "</html>");

        } else if (numberOfPlayers == 5){

            label1 = new JLabel("<html>&emsp<b>Name: </b>" + playerName1 + "&emsp<br>&emsp<b>Cards : </b>" + playerCard1 + "<br>" +
                    "&emsp<b>Name: </b>" + playerName2 + "&emsp<br>&emsp<b>Cards : </b>" + playerCard2 + "<br>" +
                    "&emsp<b>Name: </b>" + playerName3 + "&emsp<br>&emsp<b>Cards : </b>" + playerCard3 + "<br>" +
                    "&emsp<b>Name: </b>" + playerName4 + "&emsp<br>&emsp<b>Cards : </b>" + playerCard4 + "</html>");
        }

        label1.setFont(font);
        label1.setForeground(color1);
        label1a = new JLabel(cardBackImage);

        //add label1s to panels
        panel1.add(label1, BorderLayout.WEST);
        panel1.add(label1a, BorderLayout.CENTER);
        panel1.setVisible(true);

        JPanel panel2 = new JPanel(); //contains active card and values
        panel2.setBackground(color);

        if (GameDisplay.gos == 1){ //first play of game

            //make labels2: value, category and face card
            if (activeCard.getName().startsWith("The ")) {

                label2 = new JLabel("<html><b>Active Card<br><br>Category: </b>" + GameDisplay.choice + "&emsp<br><b>Value </b></html>");

            } else {

                if (GameDisplay.choice.equals("Specific Gravity")){
                    categoryValue = ((MineralCard)activeCard).getSpecificGravity() + "";
                } else if (GameDisplay.choice.equals("Hardness")){
                    categoryValue = ((MineralCard)activeCard).getHardness() + "";
                } else if (GameDisplay.choice.equals("Cleavage")){
                    categoryValue = ((MineralCard)activeCard).getCleavage();
                } else if (GameDisplay.choice.equals("Crustal Abundance")){
                    categoryValue = ((MineralCard)activeCard).getCrustalAbundance();
                } else {
                    categoryValue = ((MineralCard)activeCard).getEconomicValue();
                }
                label2 = new JLabel("<html><b><b>Active Card<br><br>Category: </b>" + GameDisplay.choice + "&emsp<br><b>Value > </b><html>" +
                        categoryValue + "&emsp");
            }
            label2.setFont(font);
            label2.setForeground(color1);
            label2a = new JLabel(activeCard.getImage());

            //add lable2 and 2a to panel2
            panel2.add(label2);
            panel2.add(label2a);
            panel2.setVisible(true);

            JPanel panel4 = new JPanel(); //contains left side cards
            panel4.setBackground(color);
            Dimension dim3 = new Dimension(300,200);
            panel4.setPreferredSize(dim3);
            panel4.setLayout(new BorderLayout());
            panel4.add(pickUpCard.getButton(), BorderLayout.EAST);
            panel4.setVisible(true);

            //add panels to TopDisplay panel(BorderLayout)
            add(panel1);
            add(panel2);
            add(panel4);
        }
    }
}

