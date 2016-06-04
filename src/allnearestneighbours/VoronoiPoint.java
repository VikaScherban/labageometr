package allnearestneighbours;

public class VoronoiPoint extends Point {

    VoronoiEdge firstEdge;

    public VoronoiPoint(double x, double y) {
        super(x, y);
    }

    public VoronoiPoint(Point point) {
        super(point.x, point.y, point.color);
    }
}
