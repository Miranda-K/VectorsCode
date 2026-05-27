public class Plane {

    public Vector normal;
    public double A; //x
    public double B; //y
    public double C; //z
    public double D;

    public Plane(double a, double b, double c,
                double d) {
        normal = new Vector(a, b, c);
        this.A = a;
        this.B = b;
        this.C = c;
        this.D = d;
    }

    //plugs point in (uses vector class bc same properties)
    public boolean onPlane(Vector point) {
        return (A * point.x + B * point.y + C * point.z + D==0);
    }
    public String toString() {
        return "0 = " + A + " x + " + B + "y + " + C + "z + "  + D;
    }
}