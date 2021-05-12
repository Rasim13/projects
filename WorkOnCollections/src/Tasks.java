import java.util.*;

public class Tasks {
    public static void main(String[] args) {
        String randomText = "Задача организации, в особенности же начало повседневной работы" +
                " по формированию позиции позволяет выполнить важнейшие задания по разработке модели развития! " +
                "Практический опыт показывает, что социально-экономическое развитие создаёт предпосылки качественно " +
                "новых шагов для системы масштабного изменения ряда параметров?" +
                " Равным образом постоянное информационно-техническое обеспечение " +
                "нашей деятельности представляет собой интересный эксперимент проверки " +
                "системы масштабного изменения ряда параметров.";
        Map<Character,Integer> frequencyMap = getFrequencyOfTextCharacters(randomText);
        System.out.println(frequencyMap);

        List<String> listToClear = new ArrayList<>(Arrays.asList("Павел", "Алексей", "Павел", "Иван","Анна", "Евгений", "Анна"));
//        Collection<String> clearCollection = clearCollectionFromDuplicateElements(listToClear);
//        System.out.println(clearCollection);
    }

        static Collection<?> clearCollectionFromDuplicateElements(List<?> listToClear) {
//        List<String> result = new ArrayList<>();
//        for (String currentElement: listToClear) {
//            if (!result.contains(currentElement)) {
//                result.add(currentElement);
//            }
//        }
//        return result;

        return new HashSet<>(listToClear);
    }


     static Map<Character, Integer> getFrequencyOfTextCharacters(String randomText) {
        randomText = randomText.toLowerCase();
        Integer pointer = null;
        Map<Character, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < randomText.length(); i++) {
            Character character  = randomText.charAt(i);
            if ((pointer = resultMap.get(character)) != null) {
                resultMap.put(character, ++pointer);
            } else {
                resultMap.put(character, 1);
            }
        }
        return resultMap;
    }
}
