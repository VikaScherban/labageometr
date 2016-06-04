package allnearestneighbours;

import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


public class GraphicInterface {

    private JFrame mainFrame;
    private JPanel headerPanel;
    private Canvas canvas;

    private JLabel xCoordLabel;
    private JLabel yCoordLabel;
    private JLabel startPoint;
    private JLabel endPoint;


    private JTextField xCoordStart;
    private JTextField yCoordStart;
    private JTextField xCoordEnd;
    private JTextField yCoordEnd;


    public GraphicInterface(){
        prepareGUI();
    }

    private void prepareGUI(){
        mainFrame = new JFrame("Java SWING");
        mainFrame.setLayout(new FlowLayout());

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        headerPanel = new JPanel();
        headerPanel.setLayout(new GridBagLayout());
        canvas = new Canvas();
        canvas.addMouseListener(canvas);

        JButton readButton = new JButton("Go");
        readButton.setActionCommand("Go");
        readButton.addActionListener(new ButtonClickListener());

        xCoordStart = new JTextField(3);
        xCoordEnd = new JTextField(3);
        yCoordStart = new JTextField(3);
        yCoordEnd = new JTextField(3);

        xCoordLabel = new JLabel("X coord:");
        yCoordLabel = new JLabel("Y coord:");
        startPoint = new JLabel("First point");
        endPoint = new JLabel("Second point");

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        headerPanel.add(startPoint, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        headerPanel.add(xCoordLabel, constraints);
        constraints.gridy = 1;
        constraints.gridx = 1;
        headerPanel.add(xCoordStart, constraints);
        constraints.gridy = 1;
        constraints.gridx = 2;
        headerPanel.add(yCoordLabel, constraints);
        constraints.gridy = 1;
        constraints.gridx = 3;
        headerPanel.add(yCoordStart, constraints);

        xCoordLabel = new JLabel("X coord:");
        yCoordLabel = new JLabel("Y coord:");

        constraints.gridy = 2;
        constraints.gridx = 0;
        headerPanel.add(endPoint, constraints);

        constraints.gridy = 3;
        constraints.gridx = 0;
        headerPanel.add(xCoordLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 3;
        headerPanel.add(xCoordEnd, constraints);
        constraints.gridx = 2;
        constraints.gridy = 3;
        headerPanel.add(yCoordLabel, constraints);
        constraints.gridx = 3;
        constraints.gridy = 3;
        headerPanel.add(yCoordEnd, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 4;
        constraints.anchor = GridBagConstraints.CENTER;
        headerPanel.add(readButton, constraints);
        headerPanel.setMaximumSize(new Dimension(400, 400));
        headerPanel.setBackground(Color.GRAY);

        headerPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Request Panel"));

        mainFrame.add(canvas);
        //mainFrame.add(headerPanel);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }


    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Go")) {
                try {
                    int x = Integer.parseInt(xCoordStart.getText());
                    int y = Integer.parseInt(yCoordStart.getText());

                } catch (Exception ex) {
                    System.out.println("Wrong arguments. Try again");
                }
            }
        }
    }

}
