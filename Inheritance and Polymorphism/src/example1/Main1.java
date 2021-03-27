package example1;

public class Main1 {

    public static void main(String[] args) {
        Tank tank = new Tank(100, 2,10);
        tank.go(5);
        System.out.println(tank.getFuelAmount());

        Airplane airplane = new Airplane(350,4,30);
        airplane.go(10);
        System.out.println(airplane.getFuelAmount());
        System.out.println(airplane.getFuelConsumption());
        MilitaryAirplane militaryAirplane = new MilitaryAirplane(400, 10, 500);

        tank.fire();
        militaryAirplane.fire();

        System.out.println(tank.getBulletsCount());
        System.out.println(militaryAirplane.getBulletsCount());

    }
}
