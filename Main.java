
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean on = true;
        while(on){
            Scanner input = new Scanner(System.in);
            System.out.println("Would you like to find the relationship between 2 lines (a), a line and a plane (b), or 2 planes (c)? Enter (e) to exit:");
            String answer = input.nextLine();
            if(answer.equals("a")){
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
                    s = (x2 - x1)/dx1;
                    //check if this point is on line 2 (s from line 1 is consistent with line2) with calculated coordinates using s
                    Vector intersectionPoint = new Vector(x1 + s*dx1, y1 + s*dy1, z1 + s*dz1);
                    if (line2.onLine(intersectionPoint)) {
                        System.out.println("The lines intersect.");
                        System.out.println("Intersection point: "
                            + intersectionPoint);
                    } else { //if the possible intersection point is not on line 2 (no intersect)
                        System.out.println("The lines are skew.");
                    }
                }
            }
            else if(answer.equals("b")){ //Line and Plane
                System.out.println("Enter LINE start point (x y z):");
                double x1 = input.nextDouble();
                double y1 = input.nextDouble();
                double z1 = input.nextDouble();
                System.out.println("Enter LINE direction vector (x y z):");
                double dx1 = input.nextDouble();
                double dy1 = input.nextDouble();
                double dz1 = input.nextDouble();
                System.out.println("Enter plane A B C D variables:");
                double a = input.nextDouble();
                double b = input.nextDouble();
                double c = input.nextDouble();
                double d = input.nextDouble();

                Line line = new Line(x1, y1, z1, dx1, dy1, dz1);
                Plane plane = new Plane(a, b, c, d);

                if(plane.normal.dotProduct(line.getDirection())==0){ //dot product is 0 --> parallel
                    if(plane.onPlane(line.getStart())){//if the start point of the line is on teh plane --> line within plane
                        System.out.println("The line is within the plane.");
                    }
                    else{
                        System.out.println("The line and the plane are parallel and never touch.");
                    }
                }

                else{ //skew and intersect, return point of intersection
                    //x = a(start.x + t*direction.x)
                    //at + bt+ct = -(astartx + bstarty + cstartz)
                    //t = -(astartx + bstarty + cstartz)/(a+b+c)
                    double t = -(a*x1 + b*y1 + c*z1)/(a+b+c);//CHECK WHAT IF 0
                    Vector intersectionPoint = new Vector(x1 + t*dx1, y1 + t*dy1, z1 + t*dz1);
                    System.out.println("The line and plane intersect.");
                        System.out.println("Intersection point: "
                            + intersectionPoint);
                }
            }

            
            else if(answer.equals("c")){
                System.out.println("plane and plane");
            }
            else if(answer.equals("e")){
                System.out.println("Thanks for using this program!");
                on = false;
            }
            else{
                System.out.println("Invalid input, please enter a lower case letter a, b, c, or e.");
            }
            
        }
    }
}