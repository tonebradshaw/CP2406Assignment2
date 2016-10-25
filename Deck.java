import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Collections;

/**
 * Created by tony on 12/08/2016.
 */
public class Deck implements ActionListener {

    protected Card [] cards;
    protected JButton [] jbuttons;

    private ImageIcon actinoliteImage = new ImageIcon("src\\CardImages\\Actinolite.png");
    private JButton actinolite = new JButton(actinoliteImage);
    private ImageIcon andalusiteImage = new ImageIcon("src\\CardImages\\Andalusite.png");
    private JButton andalusite = new JButton(andalusiteImage);
    private ImageIcon antigoriteImage = new ImageIcon("src\\CardImages\\Antigorite.png");
    private JButton antigorite = new JButton(antigoriteImage);
    private ImageIcon apatiteImage = new ImageIcon("src\\CardImages\\Apatite.png");
    private JButton apatite = new JButton(apatiteImage);
    private ImageIcon augiteImage = new ImageIcon("src\\CardImages\\Augite.png");
    private JButton augite = new JButton(augiteImage);
    private ImageIcon bariteImage = new ImageIcon("src\\CardImages\\Barite.png");
    private JButton barite = new JButton(bariteImage);
    private ImageIcon berylImage = new ImageIcon("src\\CardImages\\Beryl.png");
    private JButton beryl = new JButton(berylImage);
    private ImageIcon biotiteImage = new ImageIcon("src\\CardImages\\Biotite.png");
    private JButton biotite = new JButton(biotiteImage);
    private ImageIcon calciteImage = new ImageIcon("src\\CardImages\\Calcite.png");
    private JButton calcite = new JButton(calciteImage);
    private ImageIcon cassiteriteImage = new ImageIcon("src\\CardImages\\Cassiterite.png");
    private JButton cassiterite = new JButton(cassiteriteImage);
    private ImageIcon chalcopyriteImage = new ImageIcon("src\\CardImages\\Chalcopyrite.png");
    private JButton chalcopyrite = new JButton(chalcopyriteImage);
    private ImageIcon chloriteImage = new ImageIcon("src\\CardImages\\Chlorite.png");
    private JButton chlorite = new JButton(chloriteImage);
    private ImageIcon chromiteImage = new ImageIcon("src\\CardImages\\Chromite.png");
    private JButton chromite = new JButton(chromiteImage);
    private ImageIcon corundumImage = new ImageIcon("src\\CardImages\\Corundum.png");
    private JButton corundum = new JButton(corundumImage);
    private ImageIcon diamondImage = new ImageIcon("src\\CardImages\\Diamond.png");
    private JButton diamond = new JButton(diamondImage);
    private ImageIcon dolomiteImage = new ImageIcon("src\\CardImages\\Dolomite.png");
    private JButton dolomite = new JButton(dolomiteImage);
    private ImageIcon epidoteImage = new ImageIcon("src\\CardImages\\Epidote.png");
    private JButton epidote = new JButton(epidoteImage);
    private ImageIcon fluoriteImage = new ImageIcon("src\\CardImages\\Fluorite.png");
    private JButton fluorite = new JButton(fluoriteImage);
    private ImageIcon galenaImage = new ImageIcon("src\\CardImages\\Galena.png");
    private JButton galena= new JButton(galenaImage);
    private ImageIcon garnetImage = new ImageIcon("src\\CardImages\\Garnet.png");
    private JButton garnet = new JButton(garnetImage);
    private ImageIcon geothiteImage = new ImageIcon("src\\CardImages\\Geothite.png");
    private JButton geothite = new JButton(geothiteImage);
    private ImageIcon gibbsiteImage = new ImageIcon("src\\CardImages\\Gibbsite.png");
    private JButton gibbsite = new JButton(gibbsiteImage);
    private ImageIcon glaucophaneImage = new ImageIcon("src\\CardImages\\Glaucophane.png");
    private JButton glaucophane = new JButton(glaucophaneImage);
    private ImageIcon goldImage = new ImageIcon("src\\CardImages\\Gold.png");
    private JButton gold = new JButton(goldImage);
    private ImageIcon graphiteImage = new ImageIcon("src\\CardImages\\Graphite.png");
    private JButton graphite = new JButton(graphiteImage);
    private ImageIcon gypsumImage = new ImageIcon("src\\CardImages\\Gypsum.png");
    private JButton gypsum = new JButton(gypsumImage);
    private ImageIcon haliteImage = new ImageIcon("src\\CardImages\\Halite.png");
    private JButton halite = new JButton(haliteImage);
    private ImageIcon hematiteImage = new ImageIcon("src\\CardImages\\Hematite.png");
    private JButton hematite = new JButton(hematiteImage);
    private ImageIcon horneblendeImage = new ImageIcon("src\\CardImages\\Horneblende.png");
    private JButton horneblende = new JButton(horneblendeImage);
    private ImageIcon ilmeniteImage = new ImageIcon("src\\CardImages\\Ilmenite.png");
    private JButton ilmenite= new JButton(ilmeniteImage);
    private ImageIcon kaoliniteImage = new ImageIcon("src\\CardImages\\Kaolinite.png");
    private JButton kaolinite = new JButton(kaoliniteImage);
    private ImageIcon kyaniteImage = new ImageIcon("src\\CardImages\\Kyanite.png");
    private JButton kyanite = new JButton(kyaniteImage);
    private ImageIcon magnesiteImage = new ImageIcon("src\\CardImages\\Magnesite.png");
    private JButton magnesite = new JButton(magnesiteImage);
    private ImageIcon magnetiteImage = new ImageIcon("src\\CardImages\\Magnetite.png");
    private JButton magnetite = new JButton(magnetiteImage);
    private ImageIcon molybdeniteImage = new ImageIcon("src\\CardImages\\Molybdenite.png");
    private JButton molybdenite = new JButton(molybdeniteImage);
    private ImageIcon monaziteImage = new ImageIcon("src\\CardImages\\Monazite.png");
    private JButton monazite = new JButton(monaziteImage);
    private ImageIcon muscoviteImage = new ImageIcon("src\\CardImages\\Muscovite.png");
    private JButton muscovite = new JButton(muscoviteImage);
    private ImageIcon olivineImage = new ImageIcon("src\\CardImages\\Olivine.png");
    private JButton olivine = new JButton(olivineImage);
    private ImageIcon orthoclaseImage = new ImageIcon("src\\CardImages\\Orthoclase.png");
    private JButton orthoclase = new JButton(orthoclaseImage);
    private ImageIcon orthopyroxeneImage = new ImageIcon("src\\CardImages\\Orthopyroxene.png");
    private JButton orthopyroxene = new JButton(orthopyroxeneImage);
    private ImageIcon plagioclaseImage = new ImageIcon("src\\CardImages\\Plagioclase.png");
    private JButton plagioclase = new JButton(plagioclaseImage);
    private ImageIcon pyriteImage = new ImageIcon("src\\CardImages\\Pyrite.png");
    private JButton pyrite = new JButton(pyriteImage);
    private ImageIcon pyrrhotiteImage = new ImageIcon("src\\CardImages\\Pyrrhotite.png");
    private JButton pyrrhotite = new JButton(pyrrhotiteImage);
    private ImageIcon quartzImage = new ImageIcon("src\\CardImages\\Quartz.png");
    private JButton quartz = new JButton(quartzImage);
    private ImageIcon rutileImage = new ImageIcon("src\\CardImages\\Rutile.png");
    private JButton rutile = new JButton(rutileImage);
    private ImageIcon sideriteImage = new ImageIcon("src\\CardImages\\Siderite.png");
    private JButton siderite = new JButton(sideriteImage);
    private ImageIcon sillimaniteImage = new ImageIcon("src\\CardImages\\Sillimanite.png");
    private JButton sillimanite = new JButton(sillimaniteImage);
    private ImageIcon sphaleriteImage = new ImageIcon("src\\CardImages\\Sphalerite.png");
    private JButton sphalerite = new JButton(sphaleriteImage);
    private ImageIcon stauroliteImage = new ImageIcon("src\\CardImages\\Staurolite.png");
    private JButton staurolite = new JButton(stauroliteImage);
    private ImageIcon talcImage = new ImageIcon("src\\CardImages\\Talc.png");
    private JButton talc = new JButton(talcImage);
    private ImageIcon the_gemmologistImage = new ImageIcon("src\\CardImages\\The_Gemmologist.png");
    private JButton the_gemmologist = new JButton(the_gemmologistImage);
    private ImageIcon the_geologistImage = new ImageIcon("src\\CardImages\\The_Geologist.png");
    private JButton the_geologist = new JButton(the_geologistImage);
    private ImageIcon the_geophysicistImage = new ImageIcon("src\\CardImages\\The_Geophysicist.png");
    private JButton the_geophysicist = new JButton(the_geophysicistImage);
    private ImageIcon the_minerImage = new ImageIcon("src\\CardImages\\The_Miner.png");
    private JButton the_miner = new JButton(the_minerImage);
    private ImageIcon the_mineralogistImage = new ImageIcon("src\\CardImages\\The_Mineralogist.png");
    private JButton the_mineralogist = new JButton(the_mineralogistImage);
    private ImageIcon the_petrologistImage = new ImageIcon("src\\CardImages\\The_Petrologist.png");
    private JButton the_petrologist = new JButton(the_petrologistImage);
    private ImageIcon titaniteImage = new ImageIcon("src\\CardImages\\Titanite.png");
    private JButton titanite = new JButton(titaniteImage);
    private ImageIcon topazImage = new ImageIcon("src\\CardImages\\Topaz.png");
    private JButton topaz = new JButton(topazImage);
    private ImageIcon tourmalineImage = new ImageIcon("src\\CardImages\\Tourmaline.png");
    private JButton tourmaline = new JButton(tourmalineImage);
    private ImageIcon zirconImage = new ImageIcon("src\\CardImages\\Zircon.png");
    private JButton zircon = new JButton(zirconImage);

    static int compare;
    static Object jbuttonSource;
    static final int DECK_SIZE = 60;
    static Card selectedCard;

    public Deck() { //create deck of cards with trumps spread evenly throughout; add JButtons and ImageIcons to constructor

        cards = new Card[DECK_SIZE];
        jbuttons = new JButton[DECK_SIZE];

        cards[0] = new MineralCard("Quartz", "Sio2", "tectosilicate", "hexagonal",
                "igneous metamorphic sedimentary", 7.0, 2.65, "poor/none", "high", "moderate", quartz, quartzImage);
        jbuttons[0] = quartz;

        cards[1] = new MineralCard("Plagioclase", "NaAlSi3O8 - CaAl2Si2O8", "tectosilicate", "triclinic",
                "igneous metamorphic sedimentary", 6.5, 2.8, "1 perfect, 1 good", "very high", "moderate", plagioclase, plagioclaseImage);
        jbuttons[1] = plagioclase;

        cards[2] = new MineralCard("Orthoclase", "KAlSi3O8", "tectosilicate", "monoclinic",
                "igneous metamorphic sedimentary", 6.5, 2.6, "1 perfect, 1 good", "high", "moderate", orthoclase, orthoclaseImage);
        jbuttons[2] = orthoclase;

        cards[3] = new MineralCard("Biotite", "K(Fe,Mg)3AlSi3O10(OH)2", "phyllosilicate", "monoclinic",
                "igneous metamorphic", 3.0, 3.3, "1 perfect", "moderate", "low", biotite, biotiteImage);
        jbuttons[3] = biotite;

        cards[4] = new MineralCard("Muscovite", "KAl3Si3O10(OH)2", "phyllosilicate", "monoclinic",
                "igneous metamorphic", 3.0, 2.9, "1 perfect", "moderate", "moderate", muscovite, muscoviteImage);
        jbuttons[4] = muscovite;

        cards[5] = new TrumpCard("The Miner", "Economic Value", the_miner, the_minerImage);
        jbuttons[5] = the_miner;

        cards[6] = new MineralCard("Hornblende", "Ca2(Mg,Fe)4Al2Si7O22(OH)2", "inosilicate", "monoclinic",
                "igneous metamorphic", 6.0, 3.5, "2 good", "moderate", "trivial", horneblende, horneblendeImage);
        jbuttons[6] = horneblende;

        cards[7] = new MineralCard("Actinolite", "Ca2(Mg,Fe)5Si8O22(OH)2", "inosilicate", "monoclinic",
                "metamorphic", 6.0, 3.5, "2 good", "low", "low", actinolite, actinoliteImage);
        jbuttons[7] = actinolite;

        cards[8] = new MineralCard("Glaucophane", "Na2(Mg,Fe)3Al2Si8O22(OH)2", "inosilicate", "monoclinic",
                "metamorphic", 6.0, 3.2, "2 good", "low", "trivial", glaucophane, glaucophaneImage);
        jbuttons[8] = glaucophane;

        cards[9] = new MineralCard("Olivine", "(Mg,Fe)2SiO4", "nesosilicate", "orthorombic",
                "igneous metamorphic mantle", 7.0, 4.4, "2 poor", "high", "low", olivine, olivineImage);
        jbuttons[9] = olivine;

        cards[10] = new MineralCard("Garnet", "(Fe,Mg,Ca,Mn)3(Al,Fe)2Si3O12", "nesosilicate", "isometric",
                "igneous metamorphic mantle", 7.5, 4.3, "none", "moderate", "moderate", garnet, garnetImage);
        jbuttons[10] = garnet;

        cards[11] = new MineralCard("Titanite", "CaTiSiO5", "nesosilicate", "monoclinic",
                "igneous metamorphic", 5.5, 3.6, "3 good", "low", "low", titanite, titaniteImage);
        jbuttons[11] = titanite;

        cards[12] = new MineralCard("Zircon", "ZrSiO4", "nesosilicate", "tetragonal",
                "igneous metamorphic sedimentary", 7.5, 4.7, "2 poor", "trace", "moderate", zircon, zirconImage);
        jbuttons[12] = zircon;

        cards[13] = new MineralCard("Augite", "Ca(Mg,Fe)Si2O6", "inosilicate", "monoclinic",
                "igneous metamorphic", 6.5, 3.6, "2 good", "high", "trivial", augite, augiteImage);
        jbuttons[13] = augite;

        cards[14] = new MineralCard("Orthopyroxene", "(Mg,Fe)2Si2O6", "inosilicate", "orthorombic",
                "igneous metamorphic mantle", 6.0, 3.9, "2 good", "high", "trivial", orthopyroxene, orthopyroxeneImage);
        jbuttons[14] = orthopyroxene;

        cards[15] = new TrumpCard("The Petrologist", "Crustal Abundance", the_petrologist, the_petrologistImage);
        jbuttons[15] = the_petrologist;

        cards[16] = new MineralCard("Chlorite", "(Mg,Fe)5Al2Si3O10(OH)8", "phyllosilicate", "monoclinic",
                "metamorphic", 3.0, 3.3, "1 perfect", "moderate", "low", chlorite, chloriteImage);
        jbuttons[16] = chlorite;

        cards[17] = new MineralCard("Antigorite", "(Mg,Fe)3Si2O5(OH)4", "phyllosilicate", "monoclinic",
                "metamorphic mantle", 4.0, 2.6, "1 perfect", "low", "low", antigorite, antigoriteImage);
        jbuttons[17] = antigorite;

        cards[18] = new MineralCard("Talc", "Mg3Si4O10(OH)2", "phyllosilicate", "monoclinic",
                "metamorphic", 1.0, 2.8, "1 perfect", "low", "moderate", talc, talcImage);
        jbuttons[18] = talc;

        cards[19] = new MineralCard("Kaolinite", "Al2Si2O5(OH)4", "phyllosilicate", "triclinic",
                "sedimentary", 2.5, 2.7, "1 perfect", "moderate", "high", kaolinite, kaoliniteImage);
        jbuttons[19] = kaolinite;

        cards[20] = new MineralCard("Andalusite", "Al2SiO5", "nesosilicate", "orthorhombic",
                "metamorphic", 7.0, 3.15, "2 good", "low", "moderate", andalusite, andalusiteImage);
        jbuttons[20] = andalusite;

        cards[21] = new MineralCard("Kyanite", "Al2SiO5", "nesosilicate", "triclinic",
                "metamorphic", 7.0, 3.7, "1 perfect, 1 good", "trace", "moderate", kyanite, kyaniteImage);
        jbuttons[21] = kyanite;

        cards[22] = new MineralCard("Sillimanite", "Al2SiO5", "nesosilicate", "orthorhombic",
                "igneous metamorphic", 7.5, 3.25, "1 perfect, 1 good", "low", "low", sillimanite, sillimaniteImage);
        jbuttons[22] = sillimanite;

        cards[23] = new MineralCard("Staurolite", "(Fe,Mg)2Al9Si4O22(OH)2", "nesosilicate", "monoclinic",
                "metamorphic", 7.0, 3.8, "1 good", "trace", "low", staurolite, stauroliteImage);
        jbuttons[23] = staurolite;

        cards[24] = new MineralCard("Epidote", "Ca2(Al,Fe)3Si3O12(OH)", "sorosilicate", "monoclinic",
                "igneous metamorphic", 6.5, 3.5, "1 perfect", "moderate", "trivial", epidote, epidoteImage);
        jbuttons[24] = epidote;

        cards[25] = new TrumpCard("The Gemmologist", "Hardness", the_gemmologist, the_gemmologistImage);
        jbuttons[25] = the_gemmologist;

        cards[26] = new MineralCard("Tourmaline", "Na(Mg,Fe)3Al6B3Si6O27(OH)4", "cyclosilicate", "hexagonal",
                "metamorphic", 7.5, 3.2, "2 poor", "trace", "moderate", tourmaline, tourmalineImage);
        jbuttons[26] = tourmaline;

        cards[27] = new MineralCard("Topaz", "Al2SiO4(F,OH)2", "nesosilicate", "orthorhombic",
                "metamorphic sedimentary", 8.0, 3.6, "1 perfect", "ultratrace", "low", topaz, topazImage);
        jbuttons[27] = topaz;

        cards[28] = new MineralCard("Beryl", "Be3Al2Si6O18", "cyclosilicate", "hexagonal",
                "igneous metamorphic", 8.0, 2.9, "1 poor", "trace", "moderate", beryl, berylImage);
        jbuttons[28] = beryl;

        cards[29] = new MineralCard("Pyrite", "FeS2", "sulfide", "isometric",
                "igneous metamorphic", 6.5, 5.0, "2 poor", "low", "moderate", pyrite, pyriteImage);
        jbuttons[29] = pyrite;

        cards[30] = new MineralCard("Pyrrhotite", "Fe1-xS", "sulfide", "monoclinic",
                "igneous metamorphic", 4.5, 4.6, "none", "low", "moderate", pyrrhotite, pyrrhotiteImage);
        jbuttons[30] = pyrrhotite;

        cards[31] = new MineralCard("Chalcopyrite", "CuFeS2", "sulfide", "tetragonal",
                "igneous metamorphic", 4.0, 4.3, "2 poor", "low", "very high", chalcopyrite, chalcopyriteImage);
        jbuttons[31] = chalcopyrite;

        cards[32] = new MineralCard("Galena", "PbS", "sulfide", "isometric",
                "metamorphic", 2.5, 7.6, "3 perfect", "trace", "high", galena, galenaImage);
        jbuttons[32] = galena;

        cards[33] = new MineralCard("Sphalerite", "(Zn,Fe)S", "sulfide", "isometric",
                "metamorphic", 4.0, 4.1, "6 perfect", "trace", "high", sphalerite, sphaleriteImage);
        jbuttons[33] = sphalerite;

        cards[34] = new MineralCard("Molybdenite", "MoS2", "sulfide", "hexagonal",
                "igneous metamorphic", 1.5, 4.7, "1 perfect", "trace", "high", molybdenite, molybdeniteImage);
        jbuttons[34] = molybdenite;

        cards[35] = new TrumpCard("The Mineralogist", "Cleavage", the_mineralogist, the_mineralogistImage);
        jbuttons[35] = the_mineralogist;

        cards[36] = new MineralCard("Gold", "Au", "native element", "isometric",
                "metamorphic sedimentary", 3.0, 19.3, "none", "ultratrace", "I'm rich!", gold, goldImage);
        jbuttons[36] = gold;

        cards[37] = new MineralCard("Diamond", "C", "native element", "isometric",
                "igneous metamorphic sedimentary", 10.0, 3.5, "4 perfect", "ultratrace", "I'm rich!", diamond, diamondImage);
        jbuttons[37] = diamond;

        cards[38] = new MineralCard("Graphite", "C", "native element", "hexagonal",
                "metamorphic sedimentary", 2.0, 2.2, "1 perfect", "trace", "moderate", graphite, graphiteImage);
        jbuttons[38] = graphite;

        cards[39] = new MineralCard("Halite", "NaCl", "halide", "isometric",
                "sedimentary", 2.5, 2.2, "3 perfect", "trace", "moderate", halite, haliteImage);
        jbuttons[39] = halite;

        cards[40] = new MineralCard("Fluorite", "CaF2", "halide", "isometric",
                "metamorphic", 4.0, 3.2, "4 perfect", "trace", "moderate", fluorite, fluoriteImage);
        jbuttons[40] = fluorite;

        cards[41] = new MineralCard("Gypsum", "CaSo4(H2O)2", "sulfate", "monoclinic",
                "metamorphic sedimentary", 2.0, 2.3, "1 perfect, 2 good", "trace", "high", gypsum, gypsumImage);
        jbuttons[41] = gypsum;

        cards[42] = new MineralCard("Barite", "BaSO4", "sulfate", "orthorhombic",
                "metamorphic sedimentary", 3.5, 4.5, "2 perfect, 1 good", "trace", "moderate", barite, bariteImage);
        jbuttons[42] = barite;

        cards[43] = new MineralCard("Apatite", "Ca5(PO4)3(OH,F,Cl)", "phosphate", "hexagonal",
                "igneous metamorphic sedimentary", 5.0, 3.2, "2 poor", "low", "high", apatite, apatiteImage);
        jbuttons[43] = apatite;

        cards[44] = new MineralCard("Monazite", "(La,Ce,Nd)PO4", "phosphate", "monoclinic",
                "igneous metamorphic sedimentary", 5.0, 5.3, "1 good, 1 poor", "trace", "moderate", monazite, monaziteImage);
        jbuttons[44] = monazite;

        cards[45] = new TrumpCard("The Geophysicist", "Specific Gravity", the_geophysicist, the_geophysicistImage);
        jbuttons[45] = the_geophysicist;

        cards[46] = new MineralCard("Calcite", "CaCO3", "carbonate", "hexagonal",
                "igneous metamorphic sedimentary", 3.0, 2.7, "3 perfect", "moderate", "high", calcite, calciteImage);
        jbuttons[46] = calcite;

        cards[47] = new MineralCard("Dolomite", "CaMg(CO3)2", "carbonate", "hexagonal",
                "metamorphic sedimentary", 4.0, 2.9, "3 perfect", "low", "low", dolomite, dolomiteImage);
        jbuttons[47] = dolomite;

        cards[48] = new MineralCard("Magnesite", "MgCO3", "carbonate", "hexagonal",
                "metamorphic sedimentary", 4.0, 3.0, "3 perfect", "low", "moderate", magnesite, magnesiteImage);
        jbuttons[48] = magnesite;

        cards[49] = new MineralCard("Siderite", "FeCO3", "carbonate", "hexagonal",
                "metamorphic sedimentary", 4.5, 4.0, "3 perfect", "trace", "moderate", siderite, sideriteImage);
        jbuttons[49] = siderite;

        cards[50] = new MineralCard("Magnetite", "Fe3O4", "oxide (spinel)", "isometric",
                "igneous metamorphic sedimentary", 6.0, 5.2, "none", "moderate", "very high", magnetite, magnetiteImage);
        jbuttons[50] = magnetite;

        cards[51] = new MineralCard("Hematite", "Fe2O3", "oxide", "hexagonal",
                "metamorphic sedimentary", 6.0, 5.3, "none", "trace", "high", hematite, hematiteImage);
        jbuttons[51] = hematite;

        cards[52] = new MineralCard("Chromite", "(Fe,Mg)Cr2O4", "oxide (spinal)", "isometric",
                "igneous sedimentary", 5.5, 5.1, "none", "low", "high", chromite, chromiteImage);
        jbuttons[52] = chromite;

        cards[53] = new MineralCard("Ilmenite", "TiFeO3", "oxide", "hexagonal",
                "igneous metamorphic sedimentary", 6.0, 4.8, "none", "low", "moderate", ilmenite, ilmeniteImage);
        jbuttons[53] = ilmenite;

        cards[54] = new MineralCard("Rutile", "TiO2", "oxide", "tetragonal",
                "metamorphic sedimentary", 6.5, 4.3, "2 good", "low", "high", rutile, rutileImage);
        jbuttons[54] = rutile;

        cards[55] = new TrumpCard("The Geologist", "Any", the_geologist, the_geologistImage);
        jbuttons[55] = the_geologist;

        cards[56] = new MineralCard("Corundum", "Al2O3", "oxide", "hexagonal",
                "metamorphic sedimentary", 9.0, 4.0, "none", "trace", "moderate", corundum, corundumImage);
        jbuttons[56] = corundum;

        cards[57] = new MineralCard("Cassiterite", "SnO2", "oxide", "tetragonal",
                "igneous metamorphic sedimentary", 7.0, 7.1, "1 good, 1 poor", "trace", "high", cassiterite, cassiteriteImage);
        jbuttons[57] = cassiterite;

        cards[58] = new MineralCard("Gibbsite", "Al(OH)3", "hydroxide", "monoclinic",
                "metamorphic sedimentary", 3.5, 2.4, "1 perfect", "low", "high", gibbsite, gibbsiteImage);
        jbuttons[58] = gibbsite;

        cards[59] = new MineralCard("Geothite", "FeO(OH)", "hydroxide", "orthorhombic",
                "sedimentary", 5.5, 4.3, "1 perfect, 1 good", "moderate", "moderate", geothite, geothiteImage);
        jbuttons[59] = geothite;

        for(int i = 0; i < DECK_SIZE; ++i){ //add actionListeners to all JButtons

            jbuttons[i].addActionListener(this);
        }
    }
    public void actionPerformed(ActionEvent ae){ //when card is clicked

        jbuttonSource = ae.getSource(); //set which card is clicked

        for (int select = 0; select < DECK_SIZE; ++select) {

            if (jbuttons[select] == jbuttonSource) { //find JButton source position in jbutton array

                selectedCard = cards[select]; //clicked card is in the same position in cards array

                if (GameDisplay.gos == 0){ //if card discarded on first play of the game

                    if (selectedCard.getName().startsWith("The ")){ //stop trump card being thrown on first play

                        JOptionPane.showMessageDialog(null, "You cannot throw a Trump Card on the first play");

                    } else { //mineral card thrown on first play

                        int index = GameDisplay.players[GameDisplay.playerNumber].getHand().indexOf(selectedCard);
                        GameDisplay.players[GameDisplay.playerNumber].getHand().remove(index); //remove card from hand
                        Play.discardedCards.add(0, selectedCard); //add card to discard pile
                        GameDisplay.gos = 1; //first play of the game complete
                        GameDisplay.nextPlayer(); //move to next player
                    }
                } else {

                    compare = 0;

                    if (selectedCard.getName().equals("The Geologist")){ //select category for any

                        GameDisplay.choice = Game.firstHand();
                        compare = 1;
                        Game.resetPass(); //reset the possibility of passing
                        Game.gameOver(); //check if hand is empty

                    } else {

                        compare = Game.compareValues(selectedCard); //check if card can be thrown
                    }
                    if (compare == 1) { //card can be thrown

                        int index = GameDisplay.players[GameDisplay.playerNumber].getHand().indexOf(selectedCard);
                        GameDisplay.players[GameDisplay.playerNumber].getHand().remove(index); //remove card from hand
                        GameDisplay.players[GameDisplay.playerNumber].setPickUpCard(0);
                        Play.discardedCards.add(0, selectedCard); //add card to discard pile

                        if (GameDisplay.players[GameDisplay.playerNumber].getHand().size() == 0){ //discard last card before showing the win
                            jbuttons[select].setVisible(false);
                        }
                        Game.gameOver(); //check if hand is empty
                        GameDisplay.nextPlayer();
                    }
                }
            }
        }
    }
}

