package example1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CarRepositoryFileImpl implements CarRepository {

    private String fileName;

    private static final Function<String, Car> carMapper = line -> {
        String parsedLine[] = line.split("#");
        return new Car(Integer.parseInt(parsedLine[0]),parsedLine[1],
                parsedLine[2], Integer.parseInt(parsedLine[3]),
                Integer.parseInt(parsedLine[4]));
    };

    public CarRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Car> findAll() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            List<Car> cars = reader
                    .lines()
                    .map(carMapper)
                    .collect(Collectors.toList());
            reader.close();
            return cars;
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<Car> findAllByColor(String color) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            List<Car> cars = reader
                    .lines()
                    .map(carMapper)
                    .filter(car -> car.getColor().equals(color))
                    .collect(Collectors.toList());
            reader.close();
            return cars;
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<Car> findAllByZeroMileage() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            List<Car> cars = reader
                    .lines()
                    .map(carMapper)
                    .filter(car -> car.getMileage() == 0)
                    .collect(Collectors.toList());
            reader.close();
            return cars;
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<Car> findAllUniqueModelByPrice() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            List<Car> cars = reader
                    .lines()
                    .map(carMapper)
                    .filter(car -> car.getPrice() >= 700000 && car.getPrice() <= 800000)
                    .distinct()
                    .collect(Collectors.toList());
            reader.close();
            return cars;
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<Car> findColorByMinPrice() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            List<Car> cars = Collections.singletonList(reader
                    .lines()
                    .map(carMapper)
                    .min((o1, o2) -> Integer.compare(o1.getPrice(), o2.getPrice()))
                    .get());
            reader.close();
            return cars;
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Double findAveragePrice() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
                Double averagePrice = reader
                    .lines()
                    .map(carMapper)
                    .filter(car -> car.getModel().equals("Toyota"))
                    .mapToInt(Car::getPrice)
                    .average()
                    .getAsDouble();
            reader.close();
            return averagePrice;
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
