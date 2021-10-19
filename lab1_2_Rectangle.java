import java.util.Scanner;
import java.lang.Math;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int width = in.nextInt();
        int height = in.nextInt();
        Rectangle r = new Rectangle(new Point(x, y), new Dimension(width, height));
        Rectangle r2 = new Rectangle(new Point(x, y), new Dimension(width, height));
        int dx = in.nextInt();
        int dy = in.nextInt();
        r.move(dx, dy);
        double widthScale = in.nextDouble();
        double heightScale = in.nextDouble();
        r.resize(widthScale, heightScale);
        System.out.println(r);
        System.out.printf("%.2f\n", r.area());
        System.out.printf("%.2f\n", r.distance(r2));
        in.close();
    }
}

/* 请在这里填写答案 */

/**
 * Represents a point in 2D, with x and y, like (x,y).
 */
class Point {
    private int x;
    private int y;

    /**
     * Creates a point with coordinate at (x,y)
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString() The generated string as: "(x,y)"
     */
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    /**
     * Moves the point with dx and dy.
     * 
     * @param dx the distance to be moved at x-axis
     * @param dy the distance to be moved at y-axis
     */
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    /**
     * Calculate the distance between this and p.
     * 
     * @param p the other point.
     * @return the distance between this and p.
     */
    public double distance(Point p) {
        return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
    }
}

/**
 * A dimension in 2D, with width and height.
 */
class Dimension {
    private int width;
    private int height;

    /**
     * Creates a dimension with specified width and height.
     * 
     * @param width  the width of the dimension
     * @param height the height of the dimension
     */
    public Dimension(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString() The generated string as: "width by height"
     */
    @Override
    public String toString() {
        return width + " by " + height;
    }

    /**
     * Resizes the dimension with scales at width and height. Although the scales
     * are in double, the result should be integers as well.
     * 
     * @param widthScale  the scale at width
     * @param heightScale the scale at height
     */
    public void resize(double widthScale, double heightScale) {
        width *= widthScale;
        height *= heightScale;
    }

    /**
     * Calculate the area of this dimension.
     * 
     * @return the area of this dimension.
     */
    public int area() {
        return width * height;
    }
}

/**
 * Represents a rectangle, with a point at its top-left and a dimension.
 *
 */
class Rectangle {
    private Point topleft;
    private Dimension size;

    /**
     * Creates a rectangle.
     * 
     * @param topleft the coordinate of its top-left
     * @param size    the dimension of its size
     */
    public Rectangle(Point topleft, Dimension size) {
        this.topleft = topleft;
        this.size = size;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString() The generated string as:
     * "Rectangle at (x,y):width by height"
     */
    public String toString() {
        return "Rectangle at " + topleft.toString() + ":" + size.toString();
    }

    /**
     * Moves the rectangle some distance.
     * 
     * @param dx the distance to be moved at x-axis
     * @param dy the distance to be moved at y-axis
     */
    public void move(int dx, int dy) {
        topleft.move(dx, dy);
    }

    /**
     * Resizes the rectangle at both width and height
     * 
     * @param widthScale  the scale at width
     * @param heightScale the scale at height
     */
    public void resize(double widthScale, double heightScale) {
        size.resize(widthScale, heightScale);
    }

    /**
     * Calculates the area of this rectangle.
     * 
     * @return the area of this rectangle.
     */
    public double area() {
        return size.area();
    }

    /**
     * Calculates the distance between this rectangle and r.
     * 
     * @param r the other rectangle
     * @return the distance between this rectangle and r.
     */
    public double distance(Rectangle r) {
        return topleft.distance(r.topleft);
    }
}