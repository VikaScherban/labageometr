import allnearestneighbours.*;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    static List<Point> points;
    static VoronoiDiagram voronoiDiagram;

    public static void getRandomPoints(int n) {
        points = new ArrayList<>();
        while (n-- > 0) {
            Point point = new Point();
            boolean ok = true;
            for (Point p : points) {
                if (point.distanceTo(p) < 1) {
                    ok = false;
                    break;
                }
            }
            if (ok)
                points.add(point);
            else n++;
        }
    }

    static void getData(String filePoint) {
        File file = new File("E:/points.txt");
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try {
                out.print(filePoint);
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
            points = new ArrayList<>();
        try (FileInputStream inp = new FileInputStream("E:/points.txt")) {
            Scanner in = new Scanner(new InputStreamReader(inp, "UTF-8"));
            while (in.hasNext()) {
                Double a = in.nextDouble();
                Double b = in.nextDouble();
                points.add(new Point(a, b));
            }
        } catch (Exception ignored) {
        }
    }

    public static PointsPanel printNeighbours() {
        JFrame pointsFrame = new JFrame("Points");
        //pointsFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        PointsPanel panel = new PointsPanel(points);
        pointsFrame.getContentPane().add(panel);
        pointsFrame.pack();
        pointsFrame.setVisible(true);
        return panel;
    }

    public static PointsPanel printNeighbours(VoronoiDiagram diagram) {
        JFrame voronoiFrame = new JFrame("Diagram");
        //voronoiFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        PointsPanel panel = new PointsPanel(diagram);
        voronoiFrame.getContentPane().add(panel);
        voronoiFrame.pack();
        voronoiFrame.setVisible(true);
        return panel;
    }

    public static double getNearestNeighboursBruteForce() {
        long startTime = System.nanoTime();
        for (Point point : points) {
            points.stream().filter(otherPoint -> point != otherPoint && point.distanceTo(otherPoint) <
                    point.distanceTo(point.getNearestNeighbour())).forEach(point::setNearestNeighbour);
        }
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1000000000.0;
        System.out.println(duration + " seconds");
        printNeighbours();
        return duration;
    }

    public static double getNearestNeighboursVoronoi() {
        double duration = 0;
        boolean done = false;
        while (!done) {
            try {
                long startTime = System.nanoTime();
                Collections.sort(points);
                //points.forEach(Point::print);
                List<VoronoiPoint> voronoiPoints = points.stream().map(VoronoiPoint::new).collect(Collectors.toList());
                voronoiDiagram = new VoronoiDiagram(voronoiPoints);
                done = true;

                long endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000000.0;
                System.out.println(duration + " seconds");
                printNeighbours(voronoiDiagram);
            } catch (Exception e) {
                int n = points.size();
                points.clear();
                getRandomPoints(n);
            }
        }
        return duration;
    }

    public static void main(String[] args) {

        GraphicInterface graphicInterface;
        new MainForm();

    }
}
