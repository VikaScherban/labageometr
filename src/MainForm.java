import allnearestneighbours.PointsPanel;

import javax.swing.*;

public class MainForm extends JFrame {

    private JPanel panelRoot;
    private JButton buttonVoronoi;
    private JButton buttonFile;
    private JButton buttonPoints;
    private JTextField textFieldPointsAmount;
    private JCheckBox checkBoxNeighbours;
    private JCheckBox checkBoxConvexHull;
    private JCheckBox checkBoxDiagram;
    private JTextArea pointsTextArea;

    public MainForm() {
        super("Nearest neighbours");

        setContentPane(panelRoot);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        buttonPoints.addActionListener(e -> {
            String val = textFieldPointsAmount.getText();
            Integer n = 10;
            try {
                n = Integer.valueOf(val);
            } catch (Exception ex) {
            }
            if (n > 0) {
                Main.getRandomPoints(n);
            }
        });

        buttonFile.addActionListener(e -> {
            String pointsArea = pointsTextArea.getText();

            Main.getData(pointsArea);
            int n = Main.points.size();
        });

        buttonVoronoi.addActionListener(e -> {
            if (Main.points != null){
                PointsPanel.printNeighbours = checkBoxNeighbours.isSelected();
                PointsPanel.printConvexHull = checkBoxConvexHull.isSelected();
                PointsPanel.printDiagram = checkBoxDiagram.isSelected();
                double sec = Main.getNearestNeighboursVoronoi();
            }
        });

    }

}
