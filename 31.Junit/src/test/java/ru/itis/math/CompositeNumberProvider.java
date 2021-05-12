package ru.itis.math;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class CompositeNumberProvider implements ArgumentsProvider {

    private Random random = new Random();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        List<Arguments> numbers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int first = random.nextInt(100);
            int second = random.nextInt(100);

            if (first == 1) {
                first += 1;
            } else if (first == 0) {
                first += 2;
            }

            if (second == 1) {
                second += 1;
            } else if (second == 0) {
                second += 2;
            }


            numbers.add(Arguments.of(first * second));
        }
        return numbers.stream();
    }
}
