import javax.swing.*;

/**
 * Created by tony on 21/08/2016.
 */
public class TestTrumpCard { //create and print a trump card

    public static void main(String[] args) {

        ImageIcon the_petrologistImage = new ImageIcon("src\\CardImages\\The_Petrologist.png");
        JButton the_petrologist = new JButton(the_petrologistImage);

        TrumpCard trumpCard = new TrumpCard("The Petrologist", "Crustal Abundance", the_petrologist, the_petrologistImage);

        System.out.println(trumpCard);
    }
}
