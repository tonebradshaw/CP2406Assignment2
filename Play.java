import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Play {

    static ArrayList <Card> hand;
    static ArrayList <Card> discardedCards;
    static ArrayList <Card> shuffledDeck = new ArrayList<>();

    static Card activeCard;
    static Player playerOne, playerTwo, playerThree, playerFour, playerFive;

    static int playerNumber, numberOfPlayers, gos, compare, handCards, category, question, card, holdPlayerNumber;
    static String choice, activeCategory, activeCardNotice;

    static final int NUMBER_OF_CARDS_PER_HAND = 8;

    static String [] playerNames;
    static Card [] hold;
    static Player [] players;
    static String [] categories = {"Hardness", "Specific Gravity", "Cleavage", "Crustal Abundance", "Economic Value"};



    public static void main(String[] args) {

        System.out.println();
        Deck deck = new Deck();

        for (int i = 0; i < deck.DECK_SIZE; ++i) { //convert Deck array to shuffledDeck ArrayList

            shuffledDeck.add(deck.cards[i]);
        }
        Collections.shuffle(shuffledDeck); //shuffle the deck

        playerNames = new String[numberOfPlayers]; //array containing player's names
        discardedCards = new ArrayList<>(); //arrayList containing the discard pile
        players = new Player[numberOfPlayers]; //array containing Player objects

        gos = 0; //first player cycle


        //input - enter how many players
        GameDisplay game = new GameDisplay();
        game.setVisible(true);
    }


    /*public static Player[] buildFirstThreePlayers(int numberOfPlay, int number, String [] names, Player[] player){ //build three players using the names in order of play; add names to playerOrder array

        playerNumber = number;
        playerNames = names;
        players = player;
        numberOfPlayers = numberOfPlay;

        playerOne = new Player(playerNames[playerNumber]);
        players[playerNumber] = playerOne;

        incrementPlayerNumber();
        playerTwo = new Player(playerNames[playerNumber]);
        players[playerNumber] = playerTwo;

        incrementPlayerNumber();
        playerThree = new Player(playerNames[playerNumber]);
        players[playerNumber] = playerThree;

        return players;
    }*/
    public static void fillThreeHands(){ //add cards to first three players hands

        GameDisplay.playerOne.getHand().add(shuffledDeck.get(0));
        shuffledDeck.remove(0);
        GameDisplay.playerTwo.getHand().add(shuffledDeck.get(0));
        shuffledDeck.remove(0);
        GameDisplay.playerThree.getHand().add(shuffledDeck.get(0));
        shuffledDeck.remove(0);
    }
    public static void displayPlayerSequence(){ //display the players names in order of play

        if(numberOfPlayers == 3) {

            System.out.println("here");
            String playerSequence = "The order of play is " + playerNames[playerNumber] + ", " + playerNames[incrementPlayerNumber()] + ", "
                    + playerNames[incrementPlayerNumber()];
            incrementPlayerNumber(); //complete playerNumber cycle
            JOptionPane.showMessageDialog(null, playerSequence);

        }else if(numberOfPlayers == 4) {

            String playerSequence = "The order of play is " + playerNames[playerNumber] + ", " + playerNames[incrementPlayerNumber()] + ", "
                    + playerNames[incrementPlayerNumber()] + ", " + playerNames[incrementPlayerNumber()];
            incrementPlayerNumber(); //complete playerNumber cycle
            JOptionPane.showMessageDialog(null, playerSequence);

        }else if(numberOfPlayers == 5) {

            String playerSequence = "The order of play is " + playerNames[playerNumber] + ", " + playerNames[incrementPlayerNumber()] + ", "
                    + playerNames[incrementPlayerNumber()] + ", " + playerNames[incrementPlayerNumber()] + ", " + playerNames[incrementPlayerNumber()];
            incrementPlayerNumber(); //complete playerNumber cycle
            JOptionPane.showMessageDialog(null, playerSequence);
        }
    }
    public static void playerWaitToStart(){ //wait for player to respond so cards are not visible to other players

        JOptionPane.showMessageDialog(null, GameDisplay.playerNames[GameDisplay.playerNumber] + " press OK when you are ready to play");
    }
    public static int selectFirstCategory(Player player){ //view first player hand and select category

        int number = 0;
        hand = player.getHand();
        handCards = player.getHand().size();
        StringBuilder message = new StringBuilder();

        for(int i = 0; i < handCards; ++i){ //append each card in hand to display

            String script = "\n" + hand.get(i);
            message.append(script);
        }
        message.append("\nChoose a category (1-5): \n"); //add category question
        int count = 1;

        for(int i = 0; i < categories.length; ++i){ //append each number selection with category

            message.append(count);
            message.append("  ");
            message.append(categories[i]);
            message.append("  ");
            ++count;
        }
        do { //continue to choose the category number while selection is not among the choices
            try{
                choice = JOptionPane.showInputDialog(null, playerNames[playerNumber] + "'s cards are: " + message);
                number = Integer.parseInt(choice); //make choice an integer

            } catch (Exception e) { //catch an input that isn't an integer

                JOptionPane.showMessageDialog(null, "You must enter an integer 1-5");
            }
            if(number < 0 || number > categories.length){ //if choice is outside range

                JOptionPane.showMessageDialog(null, "You must enter an integer 1-" + categories.length);
            }
        }while(number < 1 || number > categories.length); //category choice is within range
        return number - 1; //change number value to element number
    }
    static public int checkCategory(int category){ //check if selected category is wanted

        return JOptionPane.showConfirmDialog(null, "You have chosen " + categories[category] +
                "\nIs this correct?", "Category Accept/Reject", JOptionPane.YES_NO_OPTION);
    }
    public static int selectFirstCard(){ //select first card to throw

        int count = 1;
        int number = 0;
        handCards = hand.size();
        StringBuilder message = new StringBuilder(); //build card display

        message.append("\nThe Active category is "); //print active card and chosen active category
        message.append(activeCategory);
        message.append("\n\n");
        message.append(playerNames[playerNumber] + "'s cards are: ");

        for(int i = 0; i < handCards; ++i){ //display hand with selection numbers

            String script = "\n" + count + " - " + hand.get(i);
            message.append(script);
            ++count;
        }
        message.append("\nChoose a card 1-");
        message.append(hand.size());

        do { //continue until an acceptable card is chosen
            try{
                choice = JOptionPane.showInputDialog(null, message);
                number = Integer.parseInt(choice);

            } catch (Exception e) { //catch an input that isn't an integer

                JOptionPane.showMessageDialog(null, "You must enter an integer 1-" + hand.size());
            }
            if(number < 0 || number > hand.size()){

                JOptionPane.showMessageDialog(null, "You must enter an integer 1-" + hand.size());
            }
            if(hand.get(number-1).getName().startsWith("The ")){

                JOptionPane.showMessageDialog(null, "You cannot throw a trump on the first go");
                number = -1;
            }
        }while(number < 1 || number > (hand.size() + 2)); //choice is within range
        return number - 1; //change to element number
    }

    public static int incrementPlayerNumber(){

        playerNumber = Top.playerNumber;

        ++playerNumber;

        if(playerNumber > numberOfPlayers - 1){

            playerNumber = 0;
        }
        return playerNumber;
    }
    public static int selectPlayerCard(Player player){ //player selects card from displayed hand

        hand = player.getHand(); //get current player's hand
        handCards = player.getHand().size(); //get number of cards
        int count = 1;
        int number = 0;
        StringBuilder message = new StringBuilder();

        for(int i = 0; i < handCards; ++i){ //build player card selection display

            String script = "\n" + count + ".   " + player.getHand().get(i);
            message.append(script);
            ++count;
        }
        message.append("\n");
        message.append(count);
        message.append(". Pick a card from deck");
        message.append("\n\n");
        message.append("Please enter a number 1-");
        message.append(count);

        do { //continue to choose the category number while selection is not among the choices
            try{
                choice = JOptionPane.showInputDialog(null,activeCardNotice + "\n" + playerNames[playerNumber] + "'s cards are: " + message);
                number = Integer.parseInt(choice);

            } catch (Exception e) { //catch an input that isn't an integer

                JOptionPane.showMessageDialog(null, "You must enter an integer 1-" + (handCards + 1));
            }
        }while(number < 1 || number > handCards + 2);
        return number - 1; //change value to element number
    }

    public static void firstPlayOfGame(){

        displayPlayerSequence(); //window showing the players in order of play
        playerWaitToStart(); //wait til player is ready

        do { //view cards and select active category until satisfied

            category = selectFirstCategory(players[playerNumber]); //display cards and select category
            question = checkCategory(category); //check selected category

        }while(question != 0); //loop until category is accepted

        activeCategory = categories[category]; //set active category
        card = selectFirstCard(); //select card to throw
        players[playerNumber].setPickUpCard(0); //card not picked up
        discardedCards.add(0, hand.get(card)); //add chosen card to discard pile
        hand.remove(card); //remove card from hand
        activeCard = discardedCards.get(0); //select active card
        activeCardNotice = Game.getActiveCardValues(); //add to display to show the active category and value

        gos = 1; //end first player turn
    }
    public static void checkPile(){

        System.out.println(shuffledDeck.size() + " ," + discardedCards.size());

        hold = new Card[1]; //create holding array
        hold[0] = discardedCards.get(0); //add active card to array
        discardedCards.remove(0); //remove active card from discard pile

        for (int i = 0 ; i < discardedCards.size(); ++i) { //transfer discards to shuffled deck

            shuffledDeck.add(discardedCards.get(i)); //add card to deck
            discardedCards.remove(i); //remove card from pile
        }
        Collections.shuffle(Play.shuffledDeck); //shuffle the deck
        discardedCards.add(hold[0]); //add active card to empty discard pile

    }
}
