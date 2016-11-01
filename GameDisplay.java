import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by tony on 7/10/2016.
 */
public class GameDisplay extends JFrame implements ActionListener {

    private JMenuBar mainBar;
    private JMenu menu1, menu2, menu3;
    private JMenuItem quit, rules, rules1, ok;
    private JRadioButton three, four, five;
    private ButtonGroup group;
    private JButton button;

    private JLabel label1, player1, player2, player3, player4, player5;
    private JTextField player1Name, player2Name, player3Name, player4Name, player5Name;
    private Font font;

    static Color color;
    static JPanel panel1, panel, panel3, panel4, panel5, displayHand, top;
    static Card activeCard;
    static Player playerOne, playerTwo, playerThree, playerFour, playerFive;
    static ShowVirtualKeyboard keyboard;

    static int playerNumber, numberOfPlayers, gos, card, holdPlayerNumber;
    static String choice, playerNameOne, playerNameTwo, playerNameThree, playerNameFour, playerNameFive;

    static final int NUMBER_OF_CARDS_PER_HAND = 8;

    static String [] playerNames;
    static Player [] players;

    public GameDisplay(){

        super("Mineral Supertrumps Game"); //Frame name
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        color = new Color(0,153,76);
        getContentPane().setBackground(color);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize(); //get screen size; use next 2 lines as well
        int width = (int)screen.getWidth();
        int height = (int)screen.getHeight();
        setSize(width, height - 40);

        font = new Font("Arial", Font.PLAIN, 18);
        //javax.swing.UIManager.put("OptionPane.Font", font);

        numberOfPlayers = 1; //set number so it can respond to no player number being given
        gos = 0; //first play

        panel = new JPanel();
        panel.setBackground(color);

        panel1 = new JPanel();
        panel1.setBackground(color);

        panel3 = new JPanel();
        panel3.setBackground(color);
        panel3.setLayout(new GridLayout(0, 2));
        panel3.setVisible(false);

        panel4 = new JPanel();
        panel4.setBackground(color);
        panel4.setLayout(new GridLayout(0, 2));
        panel4.setVisible(false);

        panel5 = new JPanel();
        panel5.setBackground(color);
        panel5.setLayout(new GridLayout(0, 2));
        panel5.setVisible(false);

        label1 = new JLabel(); //for rules
        label1.setFont(font);
        //rules display
        label1.setText("<html>THE RULES<br><br>The number of players and their names are entered first<br>" +
                "The first player is randomly chosen and the player sequence is displayed<br>" +
                "The first player must select one of the 5 categories then select their discard to start the game<br>" +
                "Categories are: Hardness, Specific Gravity, Cleavage, Crustal Abundance and Economic Value<br>" +
                "After the first play, the active card name, category and value to beat are listed at the top of the selection panel<br>" +
                "Values of Hardness and Specific Gravity are numerical and you must discard a higher value than displayed at the top of the selection panel<br><br>" +
                "Values of Cleavage from low to high: \"none\", \"poor/none\", \"1 poor\", \"2 poor\", \"1 good\", \"1 good, 1 poor\", \"2 good\", \"3 good\",<br>" +
                "\"1 perfect\", \"1 perfect, 1 good\", \"1 perfect, 2 good\", \"2 perfect, 1 good\", \"3 perfect\", \"4 perfect\", \"6 perfect\"<br><br>" +
                "Values of Crustal Abundance from low to high: \"ultratrace\", \"trace\", \"low\", \"moderate\", \"high\", \"very high\"<br><br>" +
                "Values of Economic Value from low to high: \"trivial\", \"low\", \"moderate\", \"high\", \"very high\", \"I'm rich!\"<br><br>" +
                "Familiarize yourself with the Cleavage, Crustal Abundance and Economic Value value sequences above for a moment<br>" +
                "Trump Cards reset the category and the value<br>" +
                "If there is no category value, you can discard any card<br>" +
                "Make your selection by clicking on the card<br>" +
                "If you need to pass, you will be informed<br>" +
                "If you cannot throw a card, you must pick up by clicking on the pickup card<br>" +
                "When you discard, you must state your card name, active category and value<br>" +
                "If your discard is deemed smaller than the active value, you will need to choose again<br>" +
                "</html>");

        label1.setVisible(false);
        label1.setVisible(false);

        //player identification labels
        player1 = new JLabel("Player1 Name");
        player2 = new JLabel("Player2 Name");
        player3 = new JLabel("Player3 Name");
        player4 = new JLabel("Player4 Name");
        player5 = new JLabel("Player5 Name");

        player1.setFont(font);
        player2.setFont(font);
        player3.setFont(font);
        player4.setFont(font);
        player5.setFont(font);

        //player name textfields
        player1Name = new JTextField(15);
        player2Name = new JTextField(15);
        player3Name = new JTextField(15);
        player4Name = new JTextField(15);
        player5Name = new JTextField(15);

        player1Name.setFont(font);
        player2Name.setFont(font);
        player3Name.setFont(font);
        player4Name.setFont(font);
        player5Name.setFont(font);

        panel1.add(label1, BorderLayout.CENTER);
        add(panel1);

        //menus

        mainBar = new JMenuBar();
        menu1 = new JMenu("Quit");
        menu2 = new JMenu("Player Number");
        menu3 = new JMenu("Rules");
        menu1.setFont(font);
        menu2.setFont(font);
        menu3.setFont(font);

        quit = new JMenuItem("Quit Game");
        rules = new JMenuItem("Show Rules");
        rules1 = new JMenuItem("Close Rules");
        ok = new JMenuItem("Add Names");

        quit.setFont(font);
        rules.setFont(font);
        rules1.setFont(font);
        ok.setFont(font);

        //player number selection
        three = new JRadioButton("Three");
        four = new JRadioButton("Four");
        five = new JRadioButton("Five");

        three.setFont(font);
        four.setFont(font);
        five.setFont(font);

        group = new ButtonGroup();
        group.add(three);
        group.add(four);
        group.add(five);

        //add menus
        setJMenuBar(mainBar);
        mainBar.add(menu1);
        mainBar.add(menu2);
        mainBar.add(menu3);

        menu1.add(quit);
        menu2.add(three);
        menu2.add(four);
        menu2.add(five);
        menu2.addSeparator();
        menu2.add(ok);

        menu3.add(rules);
        menu3.add(rules1);

        //start play button
        button = new JButton("Play Game");

        button.setFont(font);

        //add actionListeners to menus
        quit.addActionListener(this);
        rules.addActionListener(this);
        rules1.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        ok.addActionListener(this);
        button.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){ //listener actions

        Object source = e.getSource(); //name actionListener source

        if (source == quit){ //exit game

            System.exit(0);

        } else if (source == rules){ //show rules

            label1.setVisible(true);
            panel4.setVisible(false);
            panel5.setVisible(false);
            panel3.setVisible(false);

        } else if (source == rules1){ //close rules

            label1.setVisible(false);

        } else if (source == three){ //select 3 players

            numberOfPlayers = 3;
            playerNames = new String[numberOfPlayers];
            players = new Player[numberOfPlayers]; //array containing Player objects

        } else if (source == four){ //select 4 players

            numberOfPlayers = 4;
            playerNames = new String[numberOfPlayers];
            players = new Player[numberOfPlayers]; //array containing Player objects

        } else if (source == five){ //select 5 players

            numberOfPlayers = 5;
            playerNames = new String[numberOfPlayers];
            players = new Player[numberOfPlayers]; //array containing Player objects

        } else if (source == ok){ //add players menu item

            if (numberOfPlayers == 1){ //if number of players hasn't been selected

                label1.setVisible(false);
                JOptionPane.showMessageDialog(null, "You must select the number of players first");

            } else if (numberOfPlayers == 3){ //show 3 player names screen

                label1.setVisible(false);
                panel4.setVisible(false);
                panel5.setVisible(false);
                panel3.add(player1);
                panel3.add(player1Name);
                panel3.add(player2);
                panel3.add(player2Name);
                panel3.add(player3);
                panel3.add(player3Name);
                panel3.add(button);
                panel1.add(panel3, BorderLayout.CENTER);
                panel3.setVisible(true);

            } else if (numberOfPlayers == 4){ //show 4 player names screen

                label1.setVisible(false);
                panel3.setVisible(false);
                panel5.setVisible(false);
                panel4.add(player1);
                panel4.add(player1Name);
                panel4.add(player2);
                panel4.add(player2Name);
                panel4.add(player3);
                panel4.add(player3Name);
                panel4.add(player4);
                panel4.add(player4Name);
                panel4.add(button);
                panel1.add(panel4, BorderLayout.CENTER);
                panel4.setVisible(true);

            } else if (numberOfPlayers == 5){ //show 5 player names screen

                label1.setVisible(false);
                panel3.setVisible(false);
                panel4.setVisible(false);
                panel5.add(player1);
                panel5.add(player1Name);
                panel5.add(player2);
                panel5.add(player2Name);
                panel5.add(player3);
                panel5.add(player3Name);
                panel5.add(player4);
                panel5.add(player4Name);
                panel5.add(player5);
                panel5.add(player5Name);
                panel5.add(button);
                panel1.add(panel5, BorderLayout.CENTER);
                panel5.setVisible(true);
            }
            player1Name.requestFocus();
            keyboard = new ShowVirtualKeyboard();

        } else if (source == button) { //start game

            switch(numberOfPlayers) {

                case 3:

                    if (player1Name.getText().equals("") || player2Name.getText().equals("") || player3Name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "You need to enter all three names before playing"); //check all names have been entered

                    } else {

                        firstThreePlayersNames(); //get entered names and remove intro screen
                        mainBar.setVisible(false);
                        panel1.removeAll();
                        panel1.invalidate();
                        panel1.revalidate();
                        panel1.repaint();
                        panel1.setVisible(false);

                        playerNumber = (int)(Math.random() * numberOfPlayers); //randomly choose player 1, the following players are in order of entry
                        holdPlayerNumber = playerNumber;
                        players = buildFirstThreePlayers(); //make the players from their names
                        for (int i=0; i < NUMBER_OF_CARDS_PER_HAND; ++i){ //add 8 cards to each hand and remove those cards from deck

                            Play.fillThreeHands();
                        }
                        playerNumber = holdPlayerNumber;
                        playGame();
                    }
                    break;

                case 4:

                    if (player1Name.getText().equals("") || player2Name.getText().equals("") || player3Name.getText().equals("")
                            || player4Name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "You need to enter all four names before playing"); //check all names have been entered
                    } else {
                        firstThreePlayersNames(); //get entered names and remove intro screen
                        playerNameFour = player4Name.getText();
                        playerNames[3] = playerNameFour;

                        mainBar.setVisible(false);
                        panel1.removeAll();
                        panel1.invalidate();
                        panel1.revalidate();
                        panel1.repaint();
                        panel1.setVisible(false);

                        playerNumber = (int)(Math.random() * numberOfPlayers); //randomly choose player 1, the following players are in order of entry
                        holdPlayerNumber = playerNumber;
                        players = buildFirstFourPlayers(); //make the players from their names

                        for (int i=0; i < NUMBER_OF_CARDS_PER_HAND; ++i){ //add 8 cards to each hand and remove those cards from deck

                            Play.fillFourHands();
                        }
                        playerNumber = holdPlayerNumber;
                        playGame();
                    }
                    break;

                case 5:

                    if (player1Name.getText().equals("") || player2Name.getText().equals("") || player3Name.getText().equals("")
                            || player4Name.getText().equals("") || player5Name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "You need to enter all five names before playing"); //check all names have been entered

                    } else {

                        firstThreePlayersNames(); //get entered names and remove intro screen
                        playerNameFour = player4Name.getText();
                        playerNames[3] = playerNameFour;
                        playerNameFive = player5Name.getText();
                        playerNames[4] = playerNameFive;

                        mainBar.setVisible(false);
                        panel1.removeAll();
                        panel1.invalidate();
                        panel1.revalidate();
                        panel1.repaint();
                        panel1.setVisible(false);

                        playerNumber = (int)(Math.random() * numberOfPlayers); //randomly choose player 1, the following players are in order of entry
                        holdPlayerNumber = playerNumber;
                        players = buildFirstFivePlayers(); //make the players from their names

                        for (int i=0; i < NUMBER_OF_CARDS_PER_HAND; ++i){ //add 8 cards to each hand and remove those cards from deck

                            Play.fillFiveHands();
                        }
                        playerNumber = holdPlayerNumber;
                        playGame();
                    }
                    break;
            }
        }
    }
    public void firstThreePlayersNames(){ //get first 3 names from textboxes

        playerNameOne = player1Name.getText();
        playerNames[0] = playerNameOne;
        playerNameTwo = player2Name.getText();
        playerNames[1] = playerNameTwo;
        playerNameThree = player3Name.getText();
        playerNames[2] = playerNameThree;
    }
    public Player [] buildFirstThreePlayers(){ //build three players using the names in order of play; add names to players array

        playerOne = new Player(playerNames[playerNumber]);
        players[playerNumber] = playerOne;

        incrementPlayerNumber();
        playerTwo = new Player(playerNames[playerNumber]);
        players[playerNumber] = playerTwo;

        incrementPlayerNumber();
        playerThree = new Player(playerNames[playerNumber]);
        players[playerNumber] = playerThree;

        return players;
    }
    public Player [] buildFirstFourPlayers(){ //build four players using the names in order of play; add names to players array

        playerOne = new Player(playerNames[playerNumber]);
        players[playerNumber] = playerOne;

        incrementPlayerNumber();
        playerTwo = new Player(playerNames[playerNumber]);
        players[playerNumber] = playerTwo;

        incrementPlayerNumber();
        playerThree = new Player(playerNames[playerNumber]);
        players[playerNumber] = playerThree;

        incrementPlayerNumber();
        playerFour = new Player(playerNames[playerNumber]);
        players[playerNumber] = playerFour;

        return players;
    }
    public Player [] buildFirstFivePlayers(){ //build four players using the names in order of play; add names to players array

        playerOne = new Player(playerNames[playerNumber]);
        players[playerNumber] = playerOne;

        incrementPlayerNumber();
        playerTwo = new Player(playerNames[playerNumber]);
        players[playerNumber] = playerTwo;

        incrementPlayerNumber();
        playerThree = new Player(playerNames[playerNumber]);
        players[playerNumber] = playerThree;

        incrementPlayerNumber();
        playerFour = new Player(playerNames[playerNumber]);
        players[playerNumber] = playerFour;

        incrementPlayerNumber();
        playerFive = new Player(playerNames[playerNumber]);
        players[playerNumber] = playerFive;

        return players;
    }
    public static int incrementPlayerNumber(){ //increment and return player number

        ++playerNumber;

        if(playerNumber > numberOfPlayers - 1){

            playerNumber = 0;
        }
        return playerNumber;
    }

    public static void nextPlayer(){ //display next player screen

        incrementPlayerNumber();
        panel1.removeAll();
        panel1.invalidate();
        panel1.revalidate();
        panel1.repaint();
        panel1.setVisible(false);

        Play.playerWaitToStart(); //wait til player is ready
        displayHand = new DisplayHand(players[playerNumber].getHand());
        top = new Top();
        panel1.setLayout(new BorderLayout());

        if (players[playerNumber].getHand().size() < 8 || (players[playerNumber].getHand().size() > 8 &&
                players[playerNumber].getHand().size() <= 14)){ //use border layout or flow layout with JPanel depending on number of cards in hand

            panel.removeAll();
            panel.invalidate();
            panel.revalidate();
            panel.repaint();
            panel.setVisible(false);
            panel.setBackground(color);
            panel.setLayout(new FlowLayout());
            panel.add(displayHand);
            panel1.add(panel, BorderLayout.SOUTH);
            panel.setVisible(true);

        } else {

            panel1.add(displayHand, BorderLayout.SOUTH);
            displayHand.setVisible(true);
        }
        panel1.add(top, BorderLayout.WEST);
        top.setVisible(true);
        panel1.setVisible(true);

        holdPlayerNumber = playerNumber; //hold playerNumber to reset after cycle

        switch (numberOfPlayers) { //calculate if player needs to pass

            case 3:

                if (players[playerNumber].getPickUpCard() == 1 && (players[incrementPlayerNumber()].getPickUpCard() +
                        players[incrementPlayerNumber()].getPickUpCard()) == 0) { //if player has picked up and none of the remaining 2 players
                                                                                //have picked up in the last round then player must pass
                    incrementPlayerNumber();
                    JOptionPane.showMessageDialog(null, players[playerNumber].getName() + ", you have picked up from the deck recently" +
                            "\nMore then 1 player has discarded per round since you picked up" +
                            "\nNo Trump Card has been thrown since you picked up" +
                            "\nYou therefore must pass this turn");
                    playerNumber = holdPlayerNumber; //reset playerNumber after check for pass conditions
                    nextPlayer();
                }
            case 4:
                if (players[playerNumber].getPickUpCard() == 1 && (players[incrementPlayerNumber()].getPickUpCard() +
                        players[incrementPlayerNumber()].getPickUpCard() + players[incrementPlayerNumber()].getPickUpCard()) <= 1) { //if player has picked up and 1 or less
                                                                                                                                    // of the remaining 3 players have picked up in the last round then player must pass
                    incrementPlayerNumber();
                    JOptionPane.showMessageDialog(null, players[playerNumber].getName() + ", you have picked up from the deck recently" +
                            "\nMore then 1 player has discarded per round since you picked up" +
                            "\nNo Trump Card has been thrown since you picked up" +
                            "\nYou therefore must pass this turn");
                    playerNumber = holdPlayerNumber; //reset playerNumber after check for pass conditions
                    nextPlayer();
                }
            case 5:
                if (players[playerNumber].getPickUpCard() == 1 && (players[incrementPlayerNumber()].getPickUpCard() +
                        players[incrementPlayerNumber()].getPickUpCard() + players[incrementPlayerNumber()].getPickUpCard() +
                        players[incrementPlayerNumber()].getPickUpCard()) <= 2) { //if player has picked up and 2 or less
                                                                                //of the remaining 4 players have picked up in the last round then player must pass
                    incrementPlayerNumber();
                    JOptionPane.showMessageDialog(null, players[playerNumber].getName() + ", you have picked up from the deck recently" +
                            "\nMore then 1 player has discarded per round since you picked up" +
                            "\nNo Trump Card has been thrown since you picked up" +
                            "\nYou therefore must pass this turn");
                    playerNumber = holdPlayerNumber; //reset playerNumber after check for pass conditions
                    nextPlayer();
                }
        }
        playerNumber = holdPlayerNumber; //reset playerNumber after check for pass conditions
    }
    public static void playGame(){ //display first player's hand

        Play.displayPlayerSequence(); //window showing the players in order of play
        Play.playerWaitToStart(); //wait til player is ready
        displayHand = new DisplayHand(players[playerNumber].getHand());
        top = new Top();
        panel1.setLayout(new BorderLayout());

        if (players[playerNumber].getHand().size() < 9 || (players[playerNumber].getHand().size() > 9 &&
                players[playerNumber].getHand().size() <= 14)){ //use border layout or flow layout with JPanel depending on number of cards in hand

            panel.setBackground(color);
            panel.setLayout(new FlowLayout());
            panel.add(displayHand);
            panel1.add(panel, BorderLayout.SOUTH);
            panel.setVisible(true);

        } else {

            panel1.add(displayHand, BorderLayout.SOUTH);
            displayHand.setVisible(true);
        }
        panel1.add(top, BorderLayout.WEST);
        top.setVisible(true);
        panel1.setVisible(true);

        if (gos == 0){ //first play

            choice = Game.firstHand(); //choose category for start of game

        } else {

            if (activeCard.getName().startsWith("The ")){

                choice = ((TrumpCard)activeCard).getCategory();
                Game.resetPass();
            }
        }
    }
}
