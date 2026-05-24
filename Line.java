public class Line {

    private Vector start;
    private Vector direction;

    public Line(double startX, double startY, double startZ,
                double dirX, double dirY, double dirZ) {
        start = new Vector(startX, startY, startZ);
        direction = new Vector(dirX, dirY, dirZ);
    }

    public Vector getStart() {
        return start;
    }

    public Vector getDirection() {
        return direction;
    }

    public boolean onLine(Vector v) {
        Vector difference = v.subtract(start);
        // if difference v is colinear with direction then the point lies on the line
        return difference.isColinear(direction);

    public String toString() {
        return "l = " + start + " + t" + direction;
    }
}