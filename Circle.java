public class Circle extends Shape {
    private double raduis;

    public Circle(double raduis) {
        this.raduis = raduis;
    }

    public Circle(String color, double raduis) {
        super(color);
        this.raduis = raduis;
    }

    public double getRaduis() {
        return raduis;
    }

    @Override
    public double getArea() {
        return Math.PI * raduis * raduis;
    }

    @Override
    public double getPeremi() {
        return 2 * Math.PI * raduis;
    }

    @Override
    public String howToDrwa() {
        return "Draw Circle";
    }
}