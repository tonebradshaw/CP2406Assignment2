import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tony on 21/09/2016.
 */
public class GameView extends JFrame implements ActionListener {

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
    ImageIcon berylImage = new ImageIcon("src\\CardImages\\Beryl.png");
    JButton beryl = new JButton(berylImage);
    ImageIcon biotiteImage = new ImageIcon("src\\CardImages\\Biotite.png");
    JButton biotite = new JButton(biotiteImage);
    ImageIcon calciteImage = new ImageIcon("src\\CardImages\\Calcite.png");
    JButton calcite = new JButton(calciteImage);
    ImageIcon cassiteriteImage = new ImageIcon("src\\CardImages\\Cassiterite.png");
    JButton cassiterite = new JButton(cassiteriteImage);
    ImageIcon chalcopyriteImage = new ImageIcon("src\\CardImages\\Chalcopyrite.png");
    JButton chalcopyrite = new JButton(chalcopyriteImage);
    ImageIcon chloriteImage = new ImageIcon("src\\CardImages\\Chlorite.png");
    JButton chlorite = new JButton(chloriteImage);
    ImageIcon chromiteImage = new ImageIcon("src\\CardImages\\Chromite.png");
    JButton chromite = new JButton(chromiteImage);
    ImageIcon corundumImage = new ImageIcon("src\\CardImages\\Corundum.png");
    JButton corundum = new JButton(corundumImage);
    ImageIcon diamondImage = new ImageIcon("src\\CardImages\\Diamond.png");
    JButton diamond = new JButton(diamondImage);
    ImageIcon dolomiteImage = new ImageIcon("src\\CardImages\\Dolomite.png");
    JButton dolomite = new JButton(dolomiteImage);
    ImageIcon epidoteImage = new ImageIcon("src\\CardImages\\Epidote.png");
    JButton epidote = new JButton(epidoteImage);
    ImageIcon fluoriteImage = new ImageIcon("src\\CardImages\\Fluorite.png");
    JButton fluorite = new JButton(fluoriteImage);
    ImageIcon galenaImage = new ImageIcon("src\\CardImages\\Galena.png");
    JButton galena= new JButton(galenaImage);
    ImageIcon garnetImage = new ImageIcon("src\\CardImages\\Garnet.png");
    JButton garnet = new JButton(garnetImage);
    ImageIcon geothiteImage = new ImageIcon("src\\CardImages\\Geothite.png");
    JButton geothite = new JButton(geothiteImage);
    ImageIcon gibbsiteImage = new ImageIcon("src\\CardImages\\Gibbsite.png");
    JButton gibbsite = new JButton(gibbsiteImage);
    ImageIcon glaucophaneImage = new ImageIcon("src\\CardImages\\Glaucophane.png");
    JButton glaucophane = new JButton(glaucophaneImage);
    ImageIcon goldImage = new ImageIcon("src\\CardImages\\Gold.png");
    JButton gold = new JButton(goldImage);
    ImageIcon graphiteImage = new ImageIcon("src\\CardImages\\Graphite.png");
    JButton graphite = new JButton(graphiteImage);
    ImageIcon gypsumImage = new ImageIcon("src\\CardImages\\Gypsum.png");
    JButton gypsum = new JButton(gypsumImage);
    ImageIcon haliteImage = new ImageIcon("src\\CardImages\\Halite.png");
    JButton halite = new JButton(haliteImage);
    ImageIcon hematiteImage = new ImageIcon("src\\CardImages\\Hematite.png");
    JButton hematite = new JButton(hematiteImage);
    ImageIcon horneblendeImage = new ImageIcon("src\\CardImages\\Horneblende.png");
    JButton horneblende = new JButton(horneblendeImage);
    ImageIcon ilmeniteImage = new ImageIcon("src\\CardImages\\Ilmenite.png");
    JButton ilmenite= new JButton(ilmeniteImage);
    ImageIcon kaoliniteImage = new ImageIcon("src\\CardImages\\Kaolinite.png");
    JButton kaolinite = new JButton(kaoliniteImage);
    ImageIcon kyaniteImage = new ImageIcon("src\\CardImages\\Kyanite.png");
    JButton kyanite = new JButton(kyaniteImage);
    ImageIcon magnesiteImage = new ImageIcon("src\\CardImages\\Magnesite.png");
    JButton magnesite = new JButton(magnesiteImage);
    ImageIcon magnetiteImage = new ImageIcon("src\\CardImages\\Magnetite.png");
    JButton magnetite = new JButton(magnetiteImage);
    ImageIcon molybdeniteImage = new ImageIcon("src\\CardImages\\Molybdenite.png");
    JButton molybdenite = new JButton(molybdeniteImage);
    ImageIcon monaziteImage = new ImageIcon("src\\CardImages\\Monazite.png");
    JButton monazite = new JButton(monaziteImage);
    ImageIcon muscoviteImage = new ImageIcon("src\\CardImages\\Muscovite.png");
    JButton muscovite = new JButton(muscoviteImage);
    ImageIcon olivineImage = new ImageIcon("src\\CardImages\\Olivine.png");
    JButton olivine = new JButton(olivineImage);
    ImageIcon orthoclaseImage = new ImageIcon("src\\CardImages\\Orthoclase.png");
    JButton orthoclase = new JButton(orthoclaseImage);
    ImageIcon orthopyroxeneImage = new ImageIcon("src\\CardImages\\Orthopyroxine.png");
    JButton orthopyroxine = new JButton(orthopyroxeneImage);
    ImageIcon plagioclaseImage = new ImageIcon("src\\CardImages\\Plagioclase.png");
    JButton plagioclase = new JButton(plagioclaseImage);
    ImageIcon pyriteImage = new ImageIcon("src\\CardImages\\Pyrite.png");
    JButton pyrite = new JButton(pyriteImage);
    ImageIcon pyrrhotiteImage = new ImageIcon("src\\CardImages\\Pyrrhotite.png");
    JButton pyrrhotite = new JButton(pyrrhotiteImage);
    ImageIcon quartzImage = new ImageIcon("src\\CardImages\\Quartz.png");
    JButton quartz = new JButton(quartzImage);
    ImageIcon rutileImage = new ImageIcon("src\\CardImages\\Rutile.png");
    JButton rutile = new JButton(rutileImage);
    ImageIcon sideriteImage = new ImageIcon("src\\CardImages\\Siderite.png");
    JButton siderite = new JButton(sideriteImage);
    ImageIcon sillimaniteImage = new ImageIcon("src\\CardImages\\Sillimanite.png");
    JButton sillimanite = new JButton(sillimaniteImage);
    ImageIcon sphaleriteImage = new ImageIcon("src\\CardImages\\Sphalerite.png");
    JButton sphalerite = new JButton(sphaleriteImage);
    ImageIcon stauroliteImage = new ImageIcon("src\\CardImages\\Staurolite.png");
    JButton staurolite = new JButton(stauroliteImage);
    ImageIcon talcImage = new ImageIcon("src\\CardImages\\Talc.png");
    JButton talc = new JButton(talcImage);
    ImageIcon the_gemmologistImage = new ImageIcon("src\\CardImages\\The_Gemmologist.png");
    JButton the_gemmologist = new JButton(the_gemmologistImage);
    ImageIcon the_geologistImage = new ImageIcon("src\\CardImages\\The_Geologist.png");
    JButton the_geologist = new JButton(the_geologistImage);
    ImageIcon the_geophysicistImage = new ImageIcon("src\\CardImages\\The_Geophysicist.png");
    JButton the_geophysicist = new JButton(the_geophysicistImage);
    ImageIcon the_minerImage = new ImageIcon("src\\CardImages\\The_Miner.png");
    JButton the_miner = new JButton(the_minerImage);
    ImageIcon the_mineralogistImage = new ImageIcon("src\\CardImages\\The_Mineralogist.png");
    JButton the_mineralogist = new JButton(the_mineralogistImage);
    ImageIcon the_petrologistImage = new ImageIcon("src\\CardImages\\The_Petrologist.png");
    JButton the_petrologist = new JButton(the_petrologistImage);
    ImageIcon titaniteImage = new ImageIcon("src\\CardImages\\Titanite.png");
    JButton titanite = new JButton(titaniteImage);
    ImageIcon topazImage = new ImageIcon("src\\CardImages\\Topaz.png");
    JButton topaz = new JButton(topazImage);
    ImageIcon tourmalineImage = new ImageIcon("src\\CardImages\\Tourmaline.png");
    JButton tourmaline = new JButton(tourmalineImage);
    ImageIcon zirconImage = new ImageIcon("src\\CardImages\\Zircon.png");
    JButton zircon = new JButton(zirconImage);

    public GameView(){

        FlowLayout flow = new FlowLayout();

        actinolite.addActionListener(this);
        andalusite.addActionListener(this);
        antigorite.addActionListener(this);
        apatite.addActionListener(this);
        augite.addActionListener(this);
        barite.addActionListener(this);
        beryl.addActionListener(this);
        biotite.addActionListener(this);
        calcite.addActionListener(this);
        cassiterite.addActionListener(this);
        chalcopyrite.addActionListener(this);
        chlorite.addActionListener(this);
        chromite.addActionListener(this);
        corundum.addActionListener(this);
        diamond.addActionListener(this);
        dolomite.addActionListener(this);
        epidote.addActionListener(this);
        fluorite.addActionListener(this);
        galena.addActionListener(this);
        garnet.addActionListener(this);
        geothite.addActionListener(this);
        gibbsite.addActionListener(this);
        glaucophane.addActionListener(this);
        gold.addActionListener(this);
        graphite.addActionListener(this);
        gypsum.addActionListener(this);
        halite.addActionListener(this);
        hematite.addActionListener(this);
        horneblende.addActionListener(this);
        ilmenite.addActionListener(this);
        kaolinite.addActionListener(this);
        kyanite.addActionListener(this);
        magnesite.addActionListener(this);
        magnetite.addActionListener(this);
        molybdenite.addActionListener(this);
        monazite.addActionListener(this);
        muscovite.addActionListener(this);
        olivine.addActionListener(this);
        orthoclase.addActionListener(this);
        orthopyroxine.addActionListener(this);
        plagioclase.addActionListener(this);
        pyrite.addActionListener(this);
        pyrrhotite.addActionListener(this);
        quartz.addActionListener(this);
        rutile.addActionListener(this);
        siderite.addActionListener(this);
        sillimanite.addActionListener(this);
        sphalerite.addActionListener(this);
        staurolite.addActionListener(this);
        talc.addActionListener(this);
        the_gemmologist.addActionListener(this);
        the_geologist.addActionListener(this);
        the_geophysicist.addActionListener(this);
        the_miner.addActionListener(this);
        the_mineralogist.addActionListener(this);
        the_petrologist.addActionListener(this);
        titanite.addActionListener(this);
        topaz.addActionListener(this);
        tourmaline.addActionListener(this);
        zircon.addActionListener(this);

        add(actinolite);
        add(andalusite);
        setLayout(flow);
    }
    public void actionPerformed(ActionEvent ae){

        Object source = ae.getSource();

        if (source == actinolite) {
            actinolite.setVisible(false);
        }
    }
}
