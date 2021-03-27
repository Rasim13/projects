public interface Collection {
    /**
     * Добавление элемента в коллекцию
     * @param element добавляемый элемент
     */
    void add(int element);

    /**
     * Возвращает количество элементов коллекции
     * @return количество элементов, 0 - если коллекция пустая
     */
    int size();

    /**
     * Проверяет наличие элемента в коллекции
     * @param element искомый элемент
     * @return true - если элемент присутствует в коллекции, false - в противном случае
     */
    boolean contains(int element);

    /**
     * Удаляет первое вхождение элемента в коллекцию
     * {2, 3, 3, 4, 4, 5, 3} -> removeFirst(3) -> {2, 3, 4, 4, 5, 3}
     * @param element удаляемый элемент
     */
    void removeFirst(int element);

    /**
     * Удаляет последнее вхождение элемента в коллекцию
     * {2, 3, 3, 4, 4, 5, 3} -> removeLast(3) -> {2, 3, 3, 4, 4, 5}
     * @param element удаляемый элемент
     */
    void removeLast(int element);

    /**
     * Удаляет все вхождения элемента в коллекцию
     * {2, 3, 3, 4, 4, 5, 3} -> removeAll(3) -> {2, 4, 4, 5}
     * @param element удаляемый элемент
     */
    void removeAll(int element);

    /**
     * Возвращает итератор по коллекции
     * @return объект-итератор
     */
    Iterator iterator();
}
