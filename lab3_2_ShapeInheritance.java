import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // int x = in.nextInt();
        // int y = in.nextInt();
        // int width = in.nextInt();
        // int height = in.nextInt();
        // Rectangle r = new Rectangle(new Point(x, y), new Dimension(width, height));
        // Ellipse e = new Ellipse(new Point(x, y), new Dimension(width, height));
        // int dx = in.nextInt();
        // int dy = in.nextInt();
        // r.move(dx, dy);
        // double widthScale = in.nextDouble();
        // double heightScale = in.nextDouble();
        // r.resize(widthScale, heightScale);
        // System.out.println(r);
        // System.out.printf("%.2f\n", r.area());
        // System.out.printf("%.2f\n", r.distance(e));
        // in.close();

        Rectangle r = new Rectangle(new Point(0, 0), new Dimension(2, 3));
        r.move(-1, 0);
        System.out.println(r);
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

class Shape {
    protected Point center;
    protected Dimension size;

    /**
     * Creates a shape.
     * 
     * @param center the coordinate of its center
     * @param size   the dimension of its size
     */
    public Shape(Point center, Dimension size) {
        this.center = center;
        this.size = size;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return String.format("at %s:%s", center, size);
    }

    /**
     * Moves the shape some distance.
     * 
     * @param dx the distance to be moved at x-axis
     * @param dy the distance to be moved at y-axis
     */
    public void move(int dx, int dy) {
        center.move(dx, dy);
    }

    /**
     * Resizes the shape at both width and height
     * 
     * @param widthScale  the scale at width
     * @param heightScale the scale at height
     */
    public void resize(double widthScale, double heightScale) {
        size.resize(widthScale, heightScale);
    }

    /**
     * Calculates the distance between this shape and r.
     * 
     * @param r the other shape
     * @return the distance between this shape and r.
     */
    public double distance(Shape r) {
        return center.distance(r.center);
    }

    /**
     * Calculates the area of this shape.
     * 
     * @return the area of this shape.
     */
    public double area() {
        return size.area();
    }
}

/**
 * Represents a rectangle, with a point at its top-left and a dimension.
 *
 */
class Rectangle extends Shape {
    /**
     * Creates a rectangle.
     * 
     * @param center the coordinate of its center
     * @param size   the dimension of its size
     */
    public Rectangle(Point center, Dimension size) {
        super(center, size);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "Rectangle " + super.toString();
    }
}

class Ellipse extends Shape {
    /**
     * Creates a ellipse.
     * 
     * @param center the coordinate of its center
     * @param size   the dimension of its size
     */
    public Ellipse(Point center, Dimension size) {
        super(center, size);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "Ellipse " + super.toString();
    }

    /**
     * Calculates the area of this ellipse.
     * 
     * @return the area of this ellipse.
     */
    @Override
    public double area() {
        return size.area() * Math.PI / 4.0;
    }
}