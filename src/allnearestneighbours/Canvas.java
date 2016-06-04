package allnearestneighbours;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by Vika on 04.06.2016.
 */
public class Canvas extends JPanel implements MouseListener {
    public ArrayList<Integer> pointsList = new ArrayList<>();
    @Override
    public void mouseClicked(MouseEvent e) {
        pointsList.add((e.getPoint()).x);
        pointsList.add((e.getPoint()).y);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
