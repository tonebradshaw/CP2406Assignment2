import javax.swing.*;

/**
 * Created by tony on 21/08/2016.
 */
public class TestMineralCard {

    public static void main(String[] args) { //create and print a mineral card

        ImageIcon quartzImage = new ImageIcon("src\\CardImages\\Quartz.png");
        JButton quartz = new JButton(quartzImage);

        MineralCard mineralCard = new MineralCard("Quartz", "Sio2", "tectosilicate", "hexagonal",
                "igneous metamorphic sedimentary", 7.0, 2.65, "poor/none", "high", "moderate", quartz, quartzImage);

        System.out.println(mineralCard);
    }
}
