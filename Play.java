import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Play {

    static ArrayList <Card> discardedCards;
    static ArrayList <Card> shuffledDeck = new ArrayList<>();

    static int numberOfPlayers, card, number, machineType;

    static String [] playerNames;
    static Card [] hold;
    static Player [] players;

    static Boolean onSK;

    public static void main(String[] args) {

        UIManager.put("OptionPane.messageFont", new Font("System", Font.PLAIN, 18)); //set JOptionPane message font
        UIManager.put("OptionPane.buttonFont", new Font("System", Font.PLAIN, 16)); //set JOptionPane button font

        if (JOptionPane.showConfirmDialog(null, "Are you using a touchscreen", " Give On Screen Keyboard if necessary", JOptionPane.YES_NO_OPTION) == 0){ //check whether to display keyboard

            onSK = true; //using touchscreen

        } else {

             onSK = false; //not using touchscreen
        }
        Deck deck = new Deck(); //create card deck

        for (int i = 0; i < deck.DECK_SIZE; ++i) { //convert Deck array to shuffledDeck ArrayList

            shuffledDeck.add(deck.cards[i]);
        }
        Collections.shuffle(shuffledDeck); //shuffle the deck
        playerNames = new String[numberOfPlayers]; //array containing player's names
        discardedCards = new ArrayList<>(); //arrayList containing the discard pile
        players = new Player[numberOfPlayers]; //array containing Player objects

        //start game
        GameDisplay game = new GameDisplay();
        game.setVisible(true);
    }
    public static void fillThreeHands(){ //add cards to first three players hands

        GameDisplay.playerOne.getHand().add(shuffledDeck.get(0));
        shuffledDeck.remove(0);
        GameDisplay.playerTwo.getHand().add(shuffledDeck.get(0));
        shuffledDeck.remove(0);
        GameDisplay.playerThree.getHand().add(shuffledDeck.get(0));
        shuffledDeck.remove(0);
    }
    public static void fillFourHands(){ //add cards to first four players hands

        fillThreeHands();
        GameDisplay.playerFour.getHand().add(shuffledDeck.get(0));
        shuffledDeck.remove(0);
    }
    public static void fillFiveHands(){ //add cards to first five players hands

        fillFourHands();
        GameDisplay.playerFive.getHand().add(shuffledDeck.get(0));
        shuffledDeck.remove(0);
    }
    public static void displayPlayerSequence(){ //display the players names in order of play

        if (GameDisplay.numberOfPlayers == 3) {

            String playerSequence = "The order of play is " + GameDisplay.playerNames[GameDisplay.playerNumber] + ", " + GameDisplay.playerNames[GameDisplay.incrementPlayerNumber()] + ", "
                    + GameDisplay.playerNames[GameDisplay.incrementPlayerNumber()];
            GameDisplay.incrementPlayerNumber(); //complete playerNumber cycle
            JOptionPane.showMessageDialog(null, playerSequence);

        } else if (GameDisplay.numberOfPlayers == 4) {

            String playerSequence = "The order of play is " + GameDisplay.playerNames[GameDisplay.playerNumber] + ", " + GameDisplay.playerNames[GameDisplay.incrementPlayerNumber()] + ", "
                    + GameDisplay.playerNames[GameDisplay.incrementPlayerNumber()] + ", " + GameDisplay.playerNames[GameDisplay.incrementPlayerNumber()];
            GameDisplay.incrementPlayerNumber(); //complete playerNumber cycle
            JOptionPane.showMessageDialog(null, playerSequence);

        } else if (GameDisplay.numberOfPlayers == 5) {

            String playerSequence = "The order of play is " + GameDisplay.playerNames[GameDisplay.playerNumber] + ", " + GameDisplay.playerNames[GameDisplay.incrementPlayerNumber()] + ", "
                    + GameDisplay.playerNames[GameDisplay.incrementPlayerNumber()] + ", " + GameDisplay.playerNames[GameDisplay.incrementPlayerNumber()] + ", " + GameDisplay.playerNames[GameDisplay.incrementPlayerNumber()];
            GameDisplay.incrementPlayerNumber(); //complete playerNumber cycle
            JOptionPane.showMessageDialog(null, playerSequence);
        }
    }
    public static void playerWaitToStart(){ //wait for player to respond so cards are not visible to other players

        JOptionPane.showMessageDialog(null, GameDisplay.playerNames[GameDisplay.playerNumber] + " press OK when you are ready to play");
    }
    public static void transferPile(){ //transfer discard pile to shuffled deck and shuffle

        hold = new Card[1]; //create holding array
        hold[0] = discardedCards.get(0); //add active card to array
        discardedCards.remove(0); //remove active card from discard pile

        for (int i = discardedCards.size() - 1; i >= 0; --i) { //transfer discards to shuffled deck

            shuffledDeck.add(discardedCards.get(i)); //add card to deck
            discardedCards.remove(i); //remove card from pile
        }
        Collections.shuffle(shuffledDeck); //shuffle the deck
        discardedCards.add(hold[0]); //add active card to empty discard pile
    }
}
