package ru.itis.example;

import ru.itis.example.Unit;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {



    public static void main(String[] args) throws Exception {
	// получение класса как объекта
        // ~ получить информацию о самом классе
        Class<?> unitClass = Unit.class;
        // получит массив методов, которые есть в классе Unit
        Method[] methods = unitClass.getDeclaredMethods();
        // распечатаем информацию об этих методах
        for (Method method: methods) {
            System.out.println(method.getName() + " " + method.getReturnType());
        }

        // создаю объект на основе пустого (без параметров) конструктора
        Unit newUnit = (Unit) unitClass.newInstance();
        System.out.println(newUnit);

        // получение конструктора
        Constructor<?> unitConstructor = unitClass.getConstructor(String.class);
        Unit anotherUnit = (Unit) unitConstructor.newInstance("Rasim");
        System.out.println(anotherUnit);

        Constructor<?> anotherUnitConstructor = unitClass.getConstructor(String.class, Double.TYPE, Double.TYPE);
        Unit someUnit = (Unit) anotherUnitConstructor.newInstance("Rasim", 1000, 500);
        System.out.println(someUnit);

        Unit unit = new Unit("Максим", 850, 1000);
        Method damageMethod = unitClass.getMethod("damage", int.class);
        damageMethod.invoke(unit, 100);
        System.out.println(unit);

        Field[] fields = unitClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + " " + field.getType());
        }

        Field field = unitClass.getDeclaredField("name");
        field.setAccessible(true);
        field.set(unit, "Максимилиан");
        System.out.println(unit);



    }
}
