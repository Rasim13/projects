package OOP1;

public class Main {
    public static void main(String[] args) {
        Ball ball = new Ball(4.5);
        Cylinder cylinder = new Cylinder(2, 2);
        Pyramid pyramid = new Pyramid(100, 100);

        Box box = new Box(1000);

        box.add(ball);
        box.add(cylinder);
        box.add(pyramid);
    }
}
