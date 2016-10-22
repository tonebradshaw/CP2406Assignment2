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
    private Card activeCard, pickupCard;
    private String categoryType, categoryValue, playerName1, playerName2, playerName3, playerName4;
    private JLabel label1, label1a, label2, label2a, label4, label4a;
    private Color color, color1;
    private int playerCard1, playerCard2, playerCard3, playerCard4;
    private Double categoryValueDouble;

    static ArrayList<Card> hand;
    static ArrayList <Card> discardedCards;
    static ArrayList <Card> shuffledDeck = new ArrayList<>();

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
        color1 = new Color(107, 120, 180);
        Font font = new Font("Arial Rounded MT Bold", Font.PLAIN, 20);
        PickUpCard pickUpCard = new PickUpCard();

        if(GameDisplay.gos != 0) {
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

        if(numberOfPlayers == 3) {

            GameDisplay.incrementPlayerNumber();
            playerName1 = players[GameDisplay.playerNumber].getName();
            playerCard1 = players[GameDisplay.playerNumber].getHand().size();
            GameDisplay.incrementPlayerNumber();
            playerName2 = players[GameDisplay.playerNumber].getName();
            playerCard2 = players[GameDisplay.playerNumber].getHand().size();
            GameDisplay.incrementPlayerNumber();

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

        cardBackImage = new ImageIcon("src\\CardImages\\CardBack.png"); //image of back of card
        pickupCard = Play.shuffledDeck.get(0);

        JPanel panel1 = new JPanel(); //contains right side cards
        panel1.setBackground(color);
        Dimension dim2 = new Dimension(350,200);
        panel1.setPreferredSize(dim2);
        panel1.setLayout(new BorderLayout());

        //make labels1
        if(numberOfPlayers == 3){

            label1 = new JLabel("<html><br><b>Name: </b>" + playerName1 + "&emsp<br><b>Cards : </b>" + playerCard1 + "<br><br>" +
                    "<b>Name: </b>" + playerName2 + "&emsp<br><b>Cards : </b>" + playerCard2 + "</html>");

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
        label1.setForeground(Color.YELLOW);
        label1a = new JLabel(cardBackImage);

        //add label1s to panels
        panel1.add(label1, BorderLayout.WEST);
        panel1.add(label1a, BorderLayout.CENTER);
        panel1.setVisible(true);

        JPanel panel2 = new JPanel(); //contains active card and values
        panel2.setBackground(color);

        if(GameDisplay.gos == 0){

        } else {

//make labels2
            if (activeCard.getName().startsWith("The ")) {
                GameDisplay.choice = ((TrumpCard)activeCard).getCategory();

                label2 = new JLabel("<html><b>Active Card<br><br>Category: </b>" + GameDisplay.choice + "&emsp<br><b>Value </b>></html>");
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
            label2.setForeground(Color.YELLOW);
            label2a = new JLabel(activeCard.image);

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

