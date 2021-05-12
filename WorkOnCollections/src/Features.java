import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.*;

public class Features {
    public static void main(String[] args) {
//        List<String> myList = new ArrayList<>(Arrays.asList("Алексей", "Павел", "Иван","Анна", "Евгений", "Анна"));
//
//        String[] randomString = {"Привет", "Как дела", "Не отвлекай", "Я работаю", "Все супер", "Пошли отдыхать", "Завтра на работу"};
//        List<String> list = getFilledList(randomString);
//        for (String str:list) {
//            System.out.println(str);
//        }
//
//        List<Integer> numbers = getNumbers(list);
//
//        for (Integer str:numbers) {
//            System.out.println(str);
//        }

//        List<String> middle = getMiddleOfAnotherList(myList);
//        System.out.println(middle);
//        System.out.println(myList);
//        // метод, который принимает на вход середину листа, считает частотный словарь символов
//        List<String> middle = myList.subList(2,4);
//        Map<Character, Integer> frequencyMap = getFrequencyForList(middle);
//        System.out.println(middle);
//        System.out.println(frequencyMap);
//
//        // метод, удаляющий эту середину листа
//        middle.clear();
//        System.out.println(myList);
//
//        // Выясните, начинается ли List с 2 определнных элементов
//        List<String> listToCheck = new ArrayList<>(Arrays.asList("Алексей", "Павел"));
//        System.out.println(myList.subList(0,2).containsAll(listToCheck));

        //Найти 10 минимальных значений из неосортированного массива списка используя PriorityQueue
//        List<Integer> integerList = new ArrayList<>();
//        Random random = new Random();
//        for (int i = 0; i < 10000; i++) {
//            integerList.add(random.nextInt(10000));
//        }
//        List<Integer> minimalList = sortValuesByPriorityQueue(integerList, 100);
//        Collections.sort(minimalList);
//        System.out.println(minimalList);
////        Collections.sort(integerList);
////        System.out.println(integerList.stream().limit(10).collect(Collectors.toList()));
//        List<Integer> resultList = sortAllCollectionAndGetFirstNValues(integerList);
//
//        //Проверить наличие повторяющихся элементов в списке используя Set, не используя метода contains, equals, и итератор по списку
//        //Все копии добавить в Map<?,?>, содержащий в качестве ключа сам элемент а в качестве значения количество этих элементов в списке
//        Map<Integer, Integer> keyCounterMap = new HashMap<>();
//        Set<Integer> resultSet = new HashSet<>();
//        //наличие повторяющихся элементов
//        System.out.println(Tasks.clearCollectionFromDuplicateElements(resultList).size() != resultList.size());
//        System.out.println(resultList);
//        resultList.forEach((value) ->{
//            //операция add вернёт на false (в интерфейсе set) если в коллекции уже содержится такой элемент
//            if(resultSet.add(value)){
//                keyCounterMap.put(value, 1);
//            } else {
//                Integer integer = keyCounterMap.get(value);
//                keyCounterMap.put(value, ++integer);
//            }
//        });
//        System.out.println(keyCounterMap);
//        System.out.println(resultSet);

        //Развернуть Map (поменять местами ключ и значение)
        HashMap<Integer, String> map = getFilledHashmap();
        System.out.println(map);
        HashMap<String, Integer> reverseMap = getReverseMap(map);
        System.out.println(reverseMap);

    }

    public static HashMap<String, Integer> getReverseMap(HashMap<Integer, String> map) {
        HashMap<String, Integer> rev = new HashMap<>();
        for (Map.Entry<Integer, String> entry: map.entrySet()) {
            rev.put(entry.getValue(), entry.getKey());
        }
        return rev;
    }

    public static HashMap<Integer, String> getFilledHashmap() {
        HashMap<Integer, String> map1 = new HashMap<>();
        map1.put(1 , "Hello");
        map1.put(2 , "How are you?");
        map1.put(3 , "Perfect");
        map1.put(4 , "Good");
     return map1;
    }

    private static List<Integer> getNumbers(List<String> list) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(0);
        integerList.add(list.size() / 2);
        integerList.add(list.size() - 1);
       return integerList;
    }

    private static List<String> getFilledList(String[] randomString) {
        int size = 1000;
        List<String> randomList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            randomList.add(randomString[random.nextInt(randomString.length)]);
        }
        return randomList;
    }

    private static List<Integer> sortAllCollectionAndGetFirstNValues(List<Integer> integerList) {
        integerList.sort((val1, val2) -> val1.compareTo(val2));
        return integerList.subList(0, 100);
    }

    private static List<Integer> sortValuesByPriorityQueue(List<Integer> integerList, int count) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer integer:integerList) {
            if (priorityQueue.size() < count) {
                // наполняем пока у нас в очереди не станет необходимое количество элементов
                priorityQueue.add(integer);
                // если у нас самый верхний элемент (например тот который должен зайти к врачу) больше чем тот который мы хотим добавить

            } else if (priorityQueue.peek().compareTo(integer) > 0) {
                // удалим этот элемент (тот который больше)
                priorityQueue.poll();
                // добавим тот который меньше
                priorityQueue.add(integer);
            }
        }
        List<Integer> list = new ArrayList<>(priorityQueue);
        return list;
    }

    private static Map<Character, Integer> getFrequencyForList(List<String> stringList) {
        Integer pointer = null;
        Map<Character, Integer> resultMap = new HashMap<>();
        for (String string: stringList) {
            Map<Character, Integer> currentMap = Tasks.getFrequencyOfTextCharacters(string);
            for(Map.Entry<Character, Integer> keyValuePair: currentMap.entrySet()) {
                if((pointer = resultMap.get(keyValuePair.getKey())) != null) {
                    resultMap.put(keyValuePair.getKey(),pointer + keyValuePair.getValue());
                } else {
                    resultMap.put(keyValuePair.getKey(), keyValuePair.getValue());
                }

            }
        }
        return resultMap;
    }

    private static List<String> getMiddleOfAnotherList(List<String> myList) {
       List<String> resultList = new ArrayList<>();
        for (int i = 2; i <= 4 ; i++) {
            resultList.add(myList.get(i));
        }
        return resultList;
    }


}
