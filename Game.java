import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * Created by tony on 25/09/2016.
 */
public class Game {

    static String [] cleavageHierarchy = {"none", "poor/none", "1 poor", "2 poor", "1 good", "1 good, 1 poor", "2 good", "3 good",
            "1 perfect", "1 perfect, 1 good", "1 perfect, 2 good", "2 perfect, 1 good", "3 perfect", "4 perfect", "6 perfect"};
    static String [] crustalAbundanceHierarchy = {"ultratrace", "trace", "low", "moderate", "high", "very high"};
    static String [] economicValueHierarchy = {"trivial", "low", "moderate", "high", "very high", "I'm rich!"};
    static String [] categories = {"Hardness", "Specific Gravity", "Cleavage", "Crustal Abundance", "Economic Value"};

    static int gos, compare, number;

    public Game(){
    }
    public static int compareValues(Card card){ //compare active card and chosen card

        compare = 0;

        if (Play.discardedCards.get(0).getName().startsWith("The ")){ //card follows trump card

            compare = 1;

        } else if (card.getName().startsWith("The ")) { //trump card was discarded

            GameDisplay.choice = ((TrumpCard) card).getCategory();
            resetPass();
            compare = 1;

        } else if (GameDisplay.choice.equals("Hardness")){ //compare hardness values

            if (((MineralCard)card).getHardness() > ((MineralCard)Play.discardedCards.get(0)).getHardness()){

                compare = 1;
            }
        } else if (GameDisplay.choice.equals("Specific Gravity")) { //compare specific gravity values or pass Magnetite card

            if (((MineralCard)card).getSpecificGravity() > ((MineralCard)Play.discardedCards.get(0)).getSpecificGravity() || card.getName().equals("Magnetite")) {

                compare = 1;
            }
        } else if (GameDisplay.choice.equals("Cleavage")) { //compare cleavage values

            int index1 = Arrays.asList(cleavageHierarchy).indexOf(((MineralCard) card).getCleavage()); //get index number of played card in array
            int index2 = Arrays.asList(cleavageHierarchy).indexOf(((MineralCard) Play.discardedCards.get(0)).getCleavage()); //get index number of active card in array

            if (index1 > index2){ // if card cleavage is higher than active card

                compare = 1;
            }
        } else if (GameDisplay.choice.equals("Crustal Abundance")) { //compare crustal abundance values

            int index1 = Arrays.asList(crustalAbundanceHierarchy).indexOf(((MineralCard) card).getCrustalAbundance()); //get index number of played card in array
            int index2 = Arrays.asList(crustalAbundanceHierarchy).indexOf(((MineralCard) Play.discardedCards.get(0)).getCrustalAbundance()); //get index number of active card in array

            if (index1 > index2){ // if card crustal abundance is higher than active card

                compare = 1;
            }
        } else if (GameDisplay.choice.equals("Economic Value")) { //compare economic value values

            int index1 = Arrays.asList(economicValueHierarchy).indexOf(((MineralCard) card).getEconomicValue()); //get index number of played card in array
            int index2 = Arrays.asList(economicValueHierarchy).indexOf(((MineralCard) Play.discardedCards.get(0)).getEconomicValue()); //get index number of active card in array

            if (index1 > index2){ // if card economic value is higher than active card

                compare = 1;
            }
        }
        if (compare == 0){

            JOptionPane.showMessageDialog(null, "You cannot throw that card" +
                    "\n\nCheck Category\nCheck Value\nTry again");
        }
        return compare;
    }
    public static String firstHand(){

        do {
            String category = JOptionPane.showInputDialog(null, "You need to choose the Category before discarding\n" +
                    "1) Hardness \n2) Specific Gravity\n3) Cleavage\n4) Crustal Abundance\n5) Economic Value");
            try {
                number = Integer.parseInt(category);

            } catch (Exception et){

                JOptionPane.showMessageDialog(null, "You must enter a number 1-5");
            }
            if (number < 0 || number > 5){

                JOptionPane.showMessageDialog(null, "You must enter a number 1-5");
            }
        } while (number < 1 || number > 5);

        gos = 1;
        return categories[number - 1];
    }
    public static void resetPass(){ //reset all pass values for all players

        GameDisplay.holdPlayerNumber = GameDisplay.playerNumber; //hold playerNumber to reset after cycle

        switch(GameDisplay.numberOfPlayers){ //reset for different player number

            case 3:
                GameDisplay.players[GameDisplay.playerNumber].setPickUpCard(0);
                GameDisplay.players[GameDisplay.incrementPlayerNumber()].setPickUpCard(0);
                GameDisplay.players[GameDisplay.incrementPlayerNumber()].setPickUpCard(0);
                break;

            case 4:
                GameDisplay.players[GameDisplay.playerNumber].setPickUpCard(0);
                GameDisplay.players[GameDisplay.incrementPlayerNumber()].setPickUpCard(0);
                GameDisplay.players[GameDisplay.incrementPlayerNumber()].setPickUpCard(0);
                GameDisplay.players[GameDisplay.incrementPlayerNumber()].setPickUpCard(0);
                break;

            case 5:
                GameDisplay.players[GameDisplay.playerNumber].setPickUpCard(0);
                GameDisplay.players[GameDisplay.incrementPlayerNumber()].setPickUpCard(0);
                GameDisplay.players[GameDisplay.incrementPlayerNumber()].setPickUpCard(0);
                GameDisplay.players[GameDisplay.incrementPlayerNumber()].setPickUpCard(0);
                GameDisplay.players[GameDisplay.incrementPlayerNumber()].setPickUpCard(0);
                break;
        }
        GameDisplay.playerNumber = GameDisplay.holdPlayerNumber;
    }
    public static void gameOver(){ //display game over, winner and end game

        if (GameDisplay.players[GameDisplay.playerNumber].getHand().size() == 0){

            JOptionPane.showMessageDialog(null, "Game Over");
            JOptionPane.showMessageDialog(null, "The Winner is " + GameDisplay.players[GameDisplay.playerNumber].getName());

            System.exit(0);
        }
    }
}
