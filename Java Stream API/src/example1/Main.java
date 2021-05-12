package example1;

public class Main {
    public static void main(String[] args) {
        CarRepository carRepository = new CarRepositoryFileImpl("D:\\Java\\Projects\\zamaltdinov_javaitis13\\Java Stream API\\BaseOfCar.txt");
        System.out.println(carRepository.findAveragePrice());
    }
}
