package example;

import java.io.FileNotFoundException;
import java.util.List;

public interface CarRepository {
    List<Car> findAll() throws FileNotFoundException;
}
