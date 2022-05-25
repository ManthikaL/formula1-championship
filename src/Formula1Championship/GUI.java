package Formula1Championship;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


public class GUI extends JFrame
{
    JFrame driverTableFrame;
    JFrame addNewRaceFrame;
    JFrame raceTableFrame;

    JPanel panel1;
    JPanel panel2;

    JPanel driverTablePanel;

    String[] Heading;
    JTable driverTable;

    DefaultTableModel driverTableModel;

    Formula1ChampionshipManager f1Obj;

    public GUI(ArrayList<Formula1Driver> inF1DriStats, ArrayList<Races> inraceList)
    {
        f1Obj = new Formula1ChampionshipManager(inF1DriStats, inraceList);

        driverTableFrame = new JFrame();
        addNewRaceFrame = new JFrame();
        raceTableFrame = new JFrame();

        addNewRaceFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        raceTableFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        driverTableFrame.setSize(1000, 800);
        driverTableFrame.setTitle("Formula1 Championship ");
        driverTableFrame.setLayout(null);
        driverTableFrame.setVisible(true);

        panel1 = new JPanel();       //Creating tables and panels for the frame 1
        panel1.setBackground(new Color(0xa61005));
        panel1.setBounds(0, 0, 1000, 250);
        panel1.setLayout(new BorderLayout());

        driverTablePanel = new JPanel();      //Creating tables and panels for the frame 2
        driverTablePanel.setBackground(new Color(0xb0a20b));
        driverTablePanel.setBounds(0, 250, 1000, 400);
        driverTablePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "F1 Driver Details ", TitledBorder.CENTER, TitledBorder.TOP, Font.getFont("SANS_SERIF"), Color.getColor("0x010203")));
        driverTablePanel.setLayout(new BorderLayout());

        panel2 = new JPanel();        //Creating tables and panels for the frame 3
        panel2.setBackground(new Color(0x2ec04b));
        panel2.setBounds(0, 650, 1000, 100);
        panel2.setLayout(new FlowLayout());
        //ImageIcon logo = new ImageIcon("logo.png");

        JLabel label = new JLabel("Formula1 Championship");  //heading
        label.setBounds(40, 50, 50, 70);
        label.setFont(new Font("SANS_SERIF", Font.BOLD, 40));
        label.setForeground(new Color(0x010203));
        //label.setIcon(logo);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setIconTextGap(-200);

        panel1.add(label);

        displayTable();//displays the driverTable

        //display the buttons
        ascendingBtn();
        DescendingBtn();

        driverTableFrame.add(panel1);
        driverTableFrame.add(panel2);
        driverTableFrame.add(driverTablePanel);

        // setting up addNewRaceFrame to add a race
        addNewRaceFrame.setSize(1000, 900);
        addNewRaceFrame.setTitle("Formula1 Championship New Race");
        addNewRaceFrame.setLayout(null);
        addNewRaceFrame.setVisible(false);


        raceTableFrame.setSize(1000, 900);
        raceTableFrame.setTitle("Formula1 Championship Race Table");
        raceTableFrame.setLayout(null);
        raceTableFrame.setVisible(false);

    }

    public void displayTable()  //displays the JTable
    {
        Heading = new String[]{"NAME OF F1 DRIVER", "F1 Team", "Location", "1st Positions", "2nd Positions", "3rd Positions", "Total Points", "Participated Races"};   //JTable Column

        driverTableModel = new DefaultTableModel(0, 0);
        driverTable = new JTable(driverTableModel);
        driverTableModel.setColumnIdentifiers(Heading);
        driverTable.setModel(driverTableModel);

        f1DriverTable();     //Adding details to the JTable
        driverTable.setBounds(0, 250, 1000, 400);
        driverTable.setOpaque(true);
        JScrollPane sp1 = new JScrollPane(driverTable);
        sp1.setBounds(0, 250, 1000, 400);
        driverTablePanel.add(sp1);
    }

    public void ascendingBtn()   //Ascending button(button that sort points to the according order)
    {
        JButton btn1 = new JButton("Ascending Order Points");
        btn1.setBounds(200, 20, 40, 15);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Comparator<Formula1Driver> comparator = new Comparator<Formula1Driver>() {
                    public int compare(Formula1Driver F1driver1, Formula1Driver F1driver2) {
                        if (F1driver1.getNumberPoints() > F1driver2.getNumberPoints()) {
                            return 1;
                        } else if (F1driver1.getNumberPoints() == F1driver2.getNumberPoints()) {
                            if (F1driver1.getNumberFirstPosition() > F1driver2.getNumberFirstPosition()) {
                                return 1;
                            } else {
                                return -1;
                            }
                        } else {
                            return -1;
                        }
                    }
                };
                f1Obj.F1DriStats.sort(comparator);
                f1DriverTable();
            }
        });
        panel2.add(btn1);
    }

    public void DescendingBtn()  //button that sort according to descending on First Position
    {
        JButton btn2 = new JButton("Descending to FirstPosition");
        btn2.setBounds(250, 20, 40, 15);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Comparator<Formula1Driver> comparator = new Comparator<Formula1Driver>() {
                    public int compare(Formula1Driver driver1, Formula1Driver driver2) {
                        if (driver1.getNumberFirstPosition() > driver2.getNumberFirstPosition()) {
                            return -1;
                        } else {
                            return 1;
                        }
                    }
                };
                f1Obj.F1DriStats.sort(comparator);
                f1DriverTable();
            }
        });
        panel2.add(btn2);
    }

    public void f1DriverTable()
    {
        driverTableModel.setRowCount(0);
        for (int x = 0; x < f1Obj.F1DriStats.size(); x++) {
            Object[] data = new Object[]{
                    f1Obj.F1DriStats.get(x).getF1driverName(),
                    f1Obj.F1DriStats.get(x).getF1driverTeam(),
                    f1Obj.F1DriStats.get(x).getLocation(),
                    f1Obj.F1DriStats.get(x).getNumberFirstPosition(),
                    f1Obj.F1DriStats.get(x).getNumberSecondPosition(),
                    f1Obj.F1DriStats.get(x).getNumberThirdPosition(),
                    f1Obj.F1DriStats.get(x).getNumberPoints(),
                    f1Obj.F1DriStats.get(x).getNumberRaces()
            };
            driverTableModel.addRow(data);
        }
    }
}

