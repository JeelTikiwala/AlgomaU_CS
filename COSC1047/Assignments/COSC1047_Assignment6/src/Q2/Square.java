package Q2;
/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC1047_Assignment6*/


class Square extends GeometricObject implements Colorable {
    private double side;

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        super(color, filled);
        setSide(side);
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public double getArea() {
        return Math.pow(side, 2);
    }

    public double getPerimeter() {
        return side * 4;
    }

    public String howToColor() {
        return "Color all four sides";
    }

    public String toString() {
        return super.toString() + "\nSide: " + side + "\nArea: " + getArea()
                + "\nPerimeter: " + getPerimeter();
    }
}
