public class Vector {
    private int x;
    private int y;
    private int z;

    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int quadrant() {
        int a = 0;
        if (x == 0 | y == 0 | z == 0) {
            a = -1;
        } else if (x > 0 & y > 0 & z > 0) {
            a = 1;
        } else if (x < 0 & y > 0 & z > 0) {
            a = 2;
        } else if (x < 0 & y < 0 & z > 0) {
            a = 3;
        } else if (x > 0 & y < 0 & z > 0) {
            a = 4;
        } else if (x > 0 & y > 0 & z < 0) {
            a = 5;
        } else if (x < 0 & y > 0 & z < 0) {
            a = 6;
        } else if (x < 0 & y < 0 & z < 0) {
            a = 7;
        } else if (x > 0 & y < 0 & z < 0) {
            a = 8;
        }
        return a;
    }

    public double modulus() {
        long k = (long)x * x;
        long m = (long)y * y;
        long n = (long)z * z;
        double l = Math.pow(k+ m+ n, 0.5);
        return l;
    }

    public String toString() {
        return String.format("(%d,%d,%d)", x, y, z);
    }

    public Vector add(Vector vector) {
        x += vector.x;
        y += vector.y;
        z += vector.z;
        return new Vector(x, y, z);
    }

    public double area(Vector vector) {
        double a = Math.pow(y * vector.z - z * vector.y, 2);
        double b = Math.pow(x * vector.z - z * vector.x, 2);
        double c = Math.pow(x * vector.y - y * vector.x, 2);
        double area = 0.5 * Math.pow(a + b + c, 0.5);
        return area;
    }

    public static Vector add(Vector a, Vector b) {
        return new Vector(a.x + b.x, a.y + b.y, a.z + b.z);
    }

    public static double area(Vector a, Vector b) {
        double o = Math.pow(a.y * b.z - a.z * b.y, 2);
        double p = Math.pow(a.x * b.z - a.z * b.x, 2);
        double q = Math.pow(a.x * b.y - a.y * b.x, 2);
        double area = 0.5 * Math.pow(o + p + q, 0.5);
        return area;
    }


}