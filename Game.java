import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * Created by tony on 25/09/2016.
 */
public class Game {

    static Card activeCard;
    static StringBuilder stringBuilder;

    static String [] cleavageHierarchy = {"none", "poor/none", "1 poor", "2 poor", "1 good", "1 good, 1 poor", "2 good", "3 good",
            "1 perfect", "1 perfect, 1 good", "1 perfect, 2 good", "2 perfect, 1 good", "3 perfect", "4 perfect", "6 perfect"};
    static String [] crustalAbundanceHierarchy = {"ultratrace", "trace", "low", "moderate", "high", "very high"};
    static String [] economicValueHierarchy = {"trivial", "low", "moderate", "high", "very high", "I'm rich!"};
    static String [] categories = {"Hardness", "Specific Gravity", "Cleavage", "Crustal Abundance", "Economic Value"};
    static Player [] players;

    static int gos, compare, category, question, number, playerNumber;
    static String activeCategory;

    public Game(){
    }
    static String getActiveCardValues(){ //build message at top of selection display panel

        stringBuilder = new StringBuilder(); //build message

        if(activeCard.getName().startsWith("The ")){ //check if active card is a trump card
            stringBuilder.append("Active Card is: "); //add active card name
            stringBuilder.append(activeCard.getName());
            if(!((TrumpCard)activeCard).getCategory().equals("all")){ //if active card category is not "all"

                activeCategory = ((TrumpCard)activeCard).getCategory(); //select trump card category as active category
            }
            if(activeCard.getName().equals("The Geophysicist")){ //if trump card is The Geophysicist
                stringBuilder.append("\nYou may also throw the \"Magnetite\" card");
                activeCategory = "Specific Gravity"; //select specific gravity as the active category
            } else if(activeCard.getName().equals("The Geologist")){ //if active card category is "all", player needs to choose category
                do { //view cards and select active category until satisfied

                    category = Play.selectFirstCategory(players[playerNumber]); //display cards and select category
                    question = Play.checkCategory(category); //check selected category

                }while(question != 0); //until category is accepted

                activeCategory = categories[category];
            }
            stringBuilder.append("\nThe Active category is "); //add category to message
            stringBuilder.append(activeCategory);
            stringBuilder.append("\n");

            return stringBuilder.toString();

        }else { //message if active card is a mineral card
            stringBuilder.append("Active Card is: ");
            stringBuilder.append(activeCard.getName());
            stringBuilder.append( ". ");
            stringBuilder.append("\nThe Active category is ");
            stringBuilder.append(activeCategory);
            stringBuilder.append(".\n"); //print active card and chosen active category

            //select message for each category
            if(activeCategory.equals("Hardness")){
                stringBuilder.append("Your ");
                stringBuilder.append(activeCategory);
                stringBuilder.append(" value needs to be > ");
                stringBuilder.append(((MineralCard) activeCard).getHardness());
            }else if(activeCategory.equals("Specific Gravity")){
                stringBuilder.append("Your ");
                stringBuilder.append(activeCategory);
                stringBuilder.append(" value needs to be > ");
                stringBuilder.append(((MineralCard) activeCard).getSpecificGravity());
            }else if(activeCategory.equals("Cleavage")){
                stringBuilder.append("Your ");
                stringBuilder.append(activeCategory);
                stringBuilder.append(" value needs to be > ");
                stringBuilder.append(((MineralCard)activeCard).getCleavage());
            }else if(activeCategory.equals("Crustal Abundance")){
                stringBuilder.append("Your ");
                stringBuilder.append(activeCategory);
                stringBuilder.append(" value needs to be > ");
                stringBuilder.append(((MineralCard)activeCard).getCrustalAbundance());
            }else if(activeCategory.equals("Economic Value")){
                stringBuilder.append("Your ");
                stringBuilder.append(activeCategory);
                stringBuilder.append(" value needs to be > ");
                stringBuilder.append(((MineralCard)activeCard).getEconomicValue());
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public static int compareValues(Card card){ //compare active card and chosen card

        if(activeCard.getName().startsWith("The ") || card.getName().startsWith("The ")){ //skip trump cards

            compare = 1;

        }else if(activeCategory.equals("Hardness")){ //compare hardness values

            if(((MineralCard)card).getHardness() > ((MineralCard)activeCard).getHardness()){

                compare = 1;
            }
        }else if(activeCategory.equals("Specific Gravity")) { //compare specific gravity values or pass Magnetite card

            if (((MineralCard) card).getSpecificGravity() > ((MineralCard) activeCard).getSpecificGravity() || card.getName().equals("Magnetite")) {

                compare = 1;
            }
        }else if(activeCategory.equals("Cleavage")) { //compare cleavage values

            int index1 = Arrays.asList(cleavageHierarchy).indexOf(((MineralCard) card).getCleavage()); //get index number of played card in array
            int index2 = Arrays.asList(cleavageHierarchy).indexOf(((MineralCard) activeCard).getCleavage()); //get index number of active card in array

            if (index1 > index2){ // if card cleavage is higher than active card

                compare = 1;
            }
        }else if(activeCategory.equals("Crustal Abundance")) { //compare crustal abundance values

            int index1 = Arrays.asList(crustalAbundanceHierarchy).indexOf(((MineralCard) card).getCrustalAbundance()); //get index number of played card in array
            int index2 = Arrays.asList(crustalAbundanceHierarchy).indexOf(((MineralCard) activeCard).getCrustalAbundance()); //get index number of active card in array

            if (index1 > index2){ // if card crustal abundance is higher than active card

                compare = 1;
            }
        }else if(activeCategory.equals("Economic Value")) { //compare economic value values

            int index1 = Arrays.asList(economicValueHierarchy).indexOf(((MineralCard) card).getEconomicValue()); //get index number of played card in array
            int index2 = Arrays.asList(economicValueHierarchy).indexOf(((MineralCard) activeCard).getEconomicValue()); //get index number of active card in array

            if (index1 > index2){ // if card economic value is higher than active card

                compare = 1;
            }
        }
        if(compare == 0){

            JOptionPane.showMessageDialog(null, "You cannot throw that card" +
                    "\nCheck Category\nCheck Value\nTry again");
        }
        return compare;
    }
    public static String firstHand(){

        do {
            String category = JOptionPane.showInputDialog(null, "You need to choose the Category before discarding\n" +
                    "1) Hardness \n2) Specific Gravity\n3) Cleavage\n4) Crustal Abundance\n5) Economic Value");
            try{
                number = Integer.parseInt(category);

            }catch (Exception et){

                JOptionPane.showMessageDialog(null, "You must enter a number 1-5");
            }
            if(number < 0 || number > 5){

                JOptionPane.showMessageDialog(null, "You must enter a number 1-5");
            }
        }while(number < 1 || number > 5);

        gos = 1;
        return categories[number - 1];
    }

}
