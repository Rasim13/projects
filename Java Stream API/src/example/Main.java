package example;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        CarRepository carRepository = new CarRepositoryFilesImpl("D:\\Java\\Projects\\zamaltdinov_javaitis13\\Java Stream API\\BaseOfCar.txt");
        System.out.println(carRepository.findAll());
    }
}
