import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    JPanel mainPnl; // Add to JFrame
    JPanel iconPnl; // Top
    JPanel displayPnl; // Center
    JPanel controlPnl; // Bottom

    JTextArea displayTA;
    JScrollPane scroller;

    JLabel titleLbl;
    ImageIcon icon;

    JButton fortuneBtn;
    JButton quitBtn;
    ArrayList<String> fortunes;
    int lastFortuneIndex = -1;
    public FortuneTellerFrame() {

        //Fortunes arraylist
        fortunes = new ArrayList<>();
        fortunes.add("You will make a million dollars this year");
        fortunes.add("You will live until 88 years old");
        fortunes.add("You will fly to Sri Lanka and meet an elephant");
        fortunes.add("You will learn how to make Pasta Carbonara");
        fortunes.add("You will be the first person to step on pluto");
        fortunes.add("You will learn how to become a waterbender");
        fortunes.add("You will drive a BMW");
        fortunes.add("You will drive a 2013 Honda Accord");
        fortunes.add("You will grow gills and live underwater");
        fortunes.add("You will raise 14 children");
        fortunes.add("You will become one with the couch");
        fortunes.add("You will create a new lotion out of plastic waste");

        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createIconPanel();
        mainPnl.add(iconPnl, BorderLayout.NORTH);

        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.CENTER);

        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);
        add(mainPnl);
        setSize(400,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    private void createIconPanel() {
        iconPnl = new JPanel();
        icon = new ImageIcon("src/FortuneTeller.jpg");

        titleLbl = new JLabel("Fortune Teller", icon, JLabel.CENTER);


        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);

        iconPnl.add(titleLbl);
    }
    private void createDisplayPanel() {
        displayPnl = new JPanel();
        displayTA = new JTextArea(10,25);
        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        displayPnl.add(scroller);
    }
    private void createControlPanel() {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1,2));

        fortuneBtn = new JButton("Read My Fortune");
        fortuneBtn.addActionListener((ActionEvent ae) -> {
            String fortune = getRandomFortune();
            displayTA.append(fortune + "\n");
        });


        quitBtn = new JButton("Quit!");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        controlPnl.add(fortuneBtn);
        controlPnl.add(quitBtn);
    }

    private String getRandomFortune() {
        int index = lastFortuneIndex;
        while(index == lastFortuneIndex) {
            index = new Random().nextInt(fortunes.size());
        }
        lastFortuneIndex = index;
        return fortunes.get(index);
    }
}
