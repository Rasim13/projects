// печатает события, которые происходят в конкретном Sequence
// ДОБАВЛЕН ЭЛЕМЕНТ - значение
public class SequenceObserver {

    public void printRemoveByIndex(int index){
        System.out.println("Удален индекс " + index);
    }

    public void printAddNumber(int number){
        System.out.println("Добавлен число " + number);
    }

    public void printInsertNumber(int index, int number){
        System.out.println("Вставлено число " + number + " в индекс " + index);
    }

    public void printNumberGetByIndex(int index){
        System.out.println("Получено число по индексу " + index);
    }

    public void printReplaceNumber(int index, int number){
        System.out.println("Элемент под индексом " + index + " заменен на число " + number);
    }

    public void printRemoveByValue(int number){
        System.out.println("Удален элемент " + number);
    }
}
