public class Cube extends ThreeDshape {

    private double side;

    public Cube(double side) {
        this.side = side;
    }

    public Cube(String color, double side) {
        super(color);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return 6 * side * side;
    }

    @Override
    public double getVolume() {
        return side * side * side;
    }

    @Override
    public double getPeremi() {
        return 0;
    }

    @Override
    public String howToDrwa() {
        return "Draw Cube";
    }

    @Override
    public String toString() {
        return "Cube{side=" + side + ", color=" + getColor() + "}"; // [cite: 36]
    }
}