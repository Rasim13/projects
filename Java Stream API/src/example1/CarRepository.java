package example1;

import java.util.List;

public interface CarRepository {
    List<Car> findAll();
    List<Car> findAllByColor(String color);
    List<Car> findAllByZeroMileage();
    List<Car> findAllUniqueModelByPrice();
    List<Car> findColorByMinPrice();
    Double findAveragePrice();
}
