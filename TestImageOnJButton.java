import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tony on 20/09/2016.
 */
public class TestImageOnJButton extends JFrame implements ActionListener {

    static TestImageOnJButton panel;

    FlowLayout flow = new FlowLayout();
    ImageIcon actinoliteImage = new ImageIcon("src\\CardImages\\Actinolite.png");
    JButton actinolite = new JButton(actinoliteImage);
    ImageIcon andalusiteImage = new ImageIcon("src\\CardImages\\Andalusite.png");
    JButton andalusite = new JButton(andalusiteImage);
    ImageIcon antigoriteImage = new ImageIcon("src\\CardImages\\Antigorite.png");
    JButton antigorite = new JButton(antigoriteImage);
    ImageIcon apatiteImage = new ImageIcon("src\\CardImages\\Apatite.png");
    JButton apatite = new JButton(apatiteImage);
    ImageIcon augiteImage = new ImageIcon("src\\CardImages\\Augite.png");
    JButton augite = new JButton(augiteImage);
    ImageIcon bariteImage = new ImageIcon("src\\CardImages\\Barite.png");
    JButton barite = new JButton(bariteImage);
    ImageIcon calciteImage = new ImageIcon("src\\CardImages\\Calcite.png");
    JButton calcite = new JButton(calciteImage);
    ImageIcon cassiteriteImage = new ImageIcon("src\\CardImages\\Cassiterite.png");
    JButton cassiterite = new JButton(cassiteriteImage);

    public TestImageOnJButton(){

        super("JButton Images");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(flow);
        setSize(800, 500);

        actinolite.addActionListener(this);
        andalusite.addActionListener(this);
        antigorite.addActionListener(this);
        apatite.addActionListener(this);
        augite.addActionListener(this);
        barite.addActionListener(this);
        calcite.addActionListener(this);
        cassiterite.addActionListener(this);

        add(actinolite);
        add(andalusite);
        add(antigorite);
        add(apatite);
        add(augite);
        add(barite);
        add(calcite);
        add(cassiterite);
    }
    public static void main(String[] args) {

        panel = new TestImageOnJButton();

        panel.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {

        Object source = ae.getSource();
        if (source == actinolite) {
            actinolite.setVisible(false);
        } else if (source == andalusite) {
            andalusite.setVisible(false);
        } else if (source == apatite) {
            apatite.setVisible(false);
        } else if (source == antigorite) {
            antigorite.setVisible(false);
        } else if (source == augite) {
            augite.setVisible(false);
        } else if (source == barite) {
            barite.setVisible(false);
        } else if (source == calcite) {
            calcite.setVisible(false);
        } else if (source == cassiterite) {
            cassiterite.setVisible(false);
        }
    }
}
