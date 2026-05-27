public class Vector {

    public double x;
    public double y;
    public double z;

    //constructor
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector add(Vector other) {
        return new Vector(
            this.x + other.x,
            this.y + other.y,
            this.z + other.z
        );
    }

    public Vector subtract(Vector other) {
        return new Vector(
            this.x - other.x,
            this.y - other.y,
            this.z - other.z
        );
    }

    public boolean isColinear(Vector other) {
        //instead of checking if ratios are same (x1/x2 = y1/y2), to avoid floating point error --> cross multiply & check x1y2 = y1x2
        boolean xy = (this.x * other.y == this.y * other.x);
        boolean xz = (this.x * other.z == this.z * other.x);
        boolean yz = (this.y * other.z == this.z * other.y);
        return xy && xz && yz;
        
        
    }

    public Vector crossProduct(Vector other) {
        double newX = this.y * other.z - this.z * other.y;
        double newY = this.z * other.x - this.x * other.z;
        double newZ = this.x * other.y - this.y * other.x;
        return new Vector(newX, newY, newZ);
    } 

    public double dotProduct(Vector other){
        return (this.x * other.x + this.y * other.y + this.z * other.z);
    
    }

    public String toString() {
        return "<" + x + ", " + y + ", " + z + ">";
    }
}