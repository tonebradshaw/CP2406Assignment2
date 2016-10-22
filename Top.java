import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tony on 13/10/2016.
 */
public class Top extends JPanel{

    private ImageIcon cardBackImage;
    private BorderLayout border = new BorderLayout();
    //private Card faceCard;
    private String categoryType, playerName1, playerName2, playerName3, playerName4;
    private JLabel label1, label1a, label2, label2a, label4, label4a;
    private Color color;
    private int playerCard1, playerCard2, playerCard3, playerCard4;

    static ArrayList<Card> hand;
    static ArrayList <Card> discardedCards;
    static ArrayList <Card> shuffledDeck = new ArrayList<>();

    static Card activeCard;
    static Scanner input;
    static Player playerOne, playerTwo, playerThree, playerFour, playerFive;
    static String category, choice, activeCategory, activeCardNotice;

    static int numberOfPlayers, playerNumber, gos;

    static final int NUMBER_OF_CARDS_PER_HAND = 8;

    static String [] playerNames;
    static Card [] hold;
    static Player [] players;


    public Top(){

        color = new Color(0,153,76);
        Font font = new Font("Arial Rounded MT Bold", Font.PLAIN, 20);
        if(gos != 0) {
            activeCard = Play.discardedCards.get(0);
        }
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize(); //find screen size
        int width = (int)screen.getWidth();
        setSize(width, 150);

        numberOfPlayers = GameDisplay.numberOfPlayers;
        playerNumber = GameDisplay.playerNumber;
        players = GameDisplay.players;

        if(numberOfPlayers == 3) {

            GameDisplay.incrementPlayerNumber(playerNumber);
            playerName1 = players[GameDisplay.playerNumber].getName();
            playerCard1 = players[GameDisplay.playerNumber].getHand().size();
            GameDisplay.incrementPlayerNumber(playerNumber);
            playerName2 = players[GameDisplay.playerNumber].getName();
            playerCard2 = players[GameDisplay.playerNumber].getHand().size();
            GameDisplay.incrementPlayerNumber(playerNumber);

        } else if(numberOfPlayers == 4){

            Play.incrementPlayerNumber();
            playerName1 = players[GameDisplay.numberOfPlayers].getName();
            playerCard1 = players[GameDisplay.numberOfPlayers].getHand().size();
            Play.incrementPlayerNumber();
            playerName2 = players[numberOfPlayers].getName();
            playerCard2 = players[numberOfPlayers].getHand().size();
            Play.incrementPlayerNumber();
            playerName3 = players[numberOfPlayers].getName();
            playerCard3 = players[numberOfPlayers].getHand().size();
            Play.incrementPlayerNumber();

        } else if(numberOfPlayers == 5){

            Play.incrementPlayerNumber();
            playerName1 = players[numberOfPlayers].getName();
            playerCard1 = players[numberOfPlayers].getHand().size();
            Play.incrementPlayerNumber();
            playerName2 = players[numberOfPlayers].getName();
            playerCard2 = players[numberOfPlayers].getHand().size();
            Play.incrementPlayerNumber();
            playerName3 = players[numberOfPlayers].getName();
            playerCard3 = players[numberOfPlayers].getHand().size();
            Play.incrementPlayerNumber();
            playerName4 = players[numberOfPlayers].getName();
            playerCard4 = players[numberOfPlayers].getHand().size();
            Play.incrementPlayerNumber();
        }

        setLayout(border);

        cardBackImage = new ImageIcon("src\\CardImages\\CardBack.png"); //image of back of card

        JPanel panel1 = new JPanel(); //contains right side cards
        panel1.setBackground(color);

        //make labels1
        if(numberOfPlayers == 3){

            label1 = new JLabel("<html><br>&emsp<b>Name: </b>" + playerName1 + "&emsp<br>&emsp<b>Cards : </b>" + playerCard1 + "<br><br>" +
                    "&emsp<b>Name: </b>" + playerName2 + "&emsp<br>&emsp<b>Cards : </b>" + playerCard2 + "</html>");

        } else if(numberOfPlayers == 4){

            label1 = new JLabel("<html><br>&emsp<b>Name: </b>" + playerName1 + "&emsp<br>&emsp<b>Cards : </b>" + playerCard1 + "<br><br>" +
                    "&emsp<b>Name: </b>" + playerName2 + "&emsp<br>&emsp<b>Cards : </b>" + playerCard2 +
                    "&emsp<b>Name: </b>" + playerName3 + "&emsp<br>&emsp<b>Cards : </b>" + playerCard3 + "</html>");

        } else if(numberOfPlayers == 5){

            label1 = new JLabel("<html><br>&emsp<b>Name: </b>" + playerName1 + "&emsp<br>&emsp<b>Cards : </b>" + playerCard1 + "<br><br>" +
                    "&emsp<b>Name: </b>" + playerName2 + "&emsp<br>&emsp<b>Cards : </b>" + playerCard2 +
                    "&emsp<b>Name: </b>" + playerName3 + "&emsp<br>&emsp<b>Cards : </b>" + playerCard3 +
                    "&emsp<b>Name: </b>" + playerName4 + "&emsp<br>&emsp<b>Cards : </b>" + playerCard4 + "</html>");
        }

        label1.setFont(font);
        label1.setForeground(Color.BLUE);
        label1a = new JLabel(cardBackImage);

        //add label1s to panels
        panel1.add(label1);
        panel1.add(label1a);

        JPanel panel2 = new JPanel(); //contains active card and values
        panel2.setBackground(color);

        if(gos == 0){

        }else {
            //make labels2
            if (activeCard.getName().startsWith("The ")) {
                categoryType = ((TrumpCard)activeCard).getCategory();

                label2 = new JLabel("<html><b>Active Card<br><br>Category: </b>" + categoryType + "&emsp<br><b>Value </b>></html>");
            } else {
                label2 = new JLabel("<html><b><b>Active Card<br><br>Category: </b>Specific Gravity&emsp<br><b>Value > </b><html>" +
                        ((MineralCard)activeCard).getSpecificGravity() + "&emsp");
            }

            label2.setFont(font);
            label2.setForeground(Color.MAGENTA);
            label2a = new JLabel(activeCard.image);
        }
        //add lable2s to panel2
        //panel2.add(label2);
        //panel2.add(label2a);

        JPanel panel4 = new JPanel(); //contains left side cards
        panel4.setBackground(color);

        /*//make label4s
        label4 = new JLabel("<html><br><b>Name: </b>Catherine&emsp<br><b>Cards : </b>8<br><br>" +
                "<b>Name: </b>Joseph&emsp<br><b>Cards : </b>18</html>");
        label4.setFont(font);
        label4.setForeground(Color.BLUE);
        label4a = new JLabel(cardBackImage);

        //add label4s to panel4
        panel4.add(label4);
        panel4.add(label4a);*/

        //add panels to TopDisplay panel(BorderLayout)
        add(panel1, BorderLayout.EAST);
        add(panel4, BorderLayout.WEST);
        //add(panel2, BorderLayout.CENTER);
    }
}

