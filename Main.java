
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter line 1 START point (x y z):");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double z1 = input.nextDouble();

        System.out.println("Enter line 1 DIRECTION vector (x y z):");
        double dx1 = input.nextDouble();
        double dy1 = input.nextDouble();
        double dz1 = input.nextDouble();

        System.out.println("Enter line 2 START point (x y z):");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double z2 = input.nextDouble();

        System.out.println("Enter line 2 DIRECTION vector (x y z):");
        double dx2 = input.nextDouble();
        double dy2 = input.nextDouble();
        double dz2 = input.nextDouble();

        //creating objects
        Line line1 = new Line(x1, y1, z1, dx1, dy1, dz1);
        Line line2 = new Line(x2, y2, z2, dx2, dy2, dz2);

        
        //check if colinear
        if (line1.getDirection().isColinear(line2.getDirection())) {

            //check if coincident (is a point of one line on the other line)
            if (line2.onLine(line1.getStart())) {
                System.out.println("The lines are coincident.");
            } else {
                System.out.println("The lines are parallel.");
            }

        }
        
        //if not colinear
        else {

            //solve start1 + s(direction1) = start2 + t(direction2)
            double s;
            //use x coordinate to first solve for s and then check if consistent wiht all variables
            s = (x2 - x1) / dx1;
            //calculate point with s 
            double intersectX = x1 + s * dx1;
            double intersectY = y1 + s * dy1;
            double intersectZ = z1 + s * dz1;

            //check if this point is on line 2 (s from line 1 is consistent with line2)
            Vector intersectionPoint = new Vector(intersectX, intersectY, intersectZ);
            if (line2.onLine(intersectionPoint)) {
                System.out.println("The lines intersect.");
                System.out.println("Intersection point: "
                    + intersectionPoint);
            } else { //if the possible intersection point is not on line 2 (no intersect)
                System.out.println("The lines are skew.");
            }
        }
    }
}