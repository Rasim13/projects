package ru.itis.solution.framework;

import ru.itis.solution.Default;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class DocumentsFramework {
    public<T extends Document> T generateText(Class<T> documentClass, Object ...args) {
        List<Class<?>> argsTypes = new ArrayList<>();
        // получить типы аргументов, которые передали в метод нашего фреймворка
        for (Object argument : args) {
            argsTypes.add(argument.getClass());
        }
        // получить массив типов
        Class<?> argsTypesAsArray[] = new Class[argsTypes.size()];
        argsTypes.toArray(argsTypesAsArray);
        try {
            // на основе этого массива типов получил конструктор
            Constructor<T> constructor = documentClass.getConstructor(argsTypesAsArray);
            T document = constructor.newInstance(args);
            processDefaultAnnotation(document);
            return document;
        } catch (ReflectiveOperationException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private <T> void processDefaultAnnotation(T object) {
        Class<T> documentClass = (Class<T>) object.getClass();
        Field[] fields = documentClass.getDeclaredFields();
        for (Field field : fields) {
            Default defaultAnnotation = field.getAnnotation(Default.class);
            if (defaultAnnotation != null) {
                String value = defaultAnnotation.value();
                field.setAccessible(true);
                try {
                    field.set(object, value);
                } catch (IllegalAccessException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        }
    }


}
