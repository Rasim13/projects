package example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepositoryFilesImpl implements CarRepository {

    private String fileName;

    public CarRepositoryFilesImpl(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public List<Car> findAll() throws FileNotFoundException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            List<Car> cars = reader
                    .lines()
                    .map(line -> {
                        String parsedLine[] = line.split("#");
                        return new Car(Integer.parseInt(parsedLine[0]),parsedLine[1],
                                parsedLine[2], Integer.parseInt(parsedLine[3]),
                                Integer.parseInt(parsedLine[4]));
                    }).collect(Collectors.toList());
            return cars;
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
