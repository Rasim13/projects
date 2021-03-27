/**
 * 27.02.2021
 * 19. LinkedList
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class LinkedList implements List{
    public static class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }
    // внутренний класс
    public class LinkedListIterator implements Iterator{
        private Node current;
        public LinkedListIterator() {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        public int next() {
            // запомнили текущее значение
            int value = current.value;
            // перешли к следующему
            current = current.next;
            // вернули то, что запомнили
            return value;
        }
    }

    // поле, которое хранит ссылку на первый элемент списка
    private Node first;
    private Node last;
    private int count;

    @Override
    public void add(int value) {
        Node newNode = new Node(value);
        if (first == null) {
            this.first = newNode;
        } else {
            // следующий после последнего - новый узел
            last.next = newNode;
        }
        // новый узел теперь последний
        this.last = newNode;
        this.count++;
    }

    @Override
    public int get(int index) {
        if (index < count && index > -1) {
            Node current = this.first;
            // отсчитываем элементы
            // i = 0, 1, 2, 3, 4
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.value;
        }
        System.err.println("Вышли за пределы списка");
        return -1;
    }

    @Override
    public void removeAt(int index) throws Exception {
        if (count == 0) {
            throw new Exception("LinkedList is empty");
        }
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Invalid element");
        }

        if (first == null) {
            return;
        }
        Node current = first;
        if (index == 0) {
            first = current.next;
            return;
        }
        for (int i = 0; current != null && i < index - 1; i++) {
            current = current.next;
            if (current == null || current.next == null) {
                return;
            }
            Node next = current.next.next;
            current.next = next;
        }
        count--;
    }

    @Override
    public int indexOf(int element) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if (current.value == element) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int element) {
        Node current = first;
        int index = 0, rsl = - 1;
        while (current != null) {
            if (current.value == element) {
                 rsl = index;
            }
            current = current.next;
            index++;
        }
        return rsl;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean contains(int element) {
        for (int i = 0; i < count; i++) {
            if(get(i) == element){
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeFirst(int element) {
        // a -> b -> c -> d -> null
        // ^
        // f

        // current = a
        Node current = first;
        // removeFirst(a)
        if(current.value == element){
            // a -> b -> c -> d -> null
            //      ^
            //      f
            first = first.next;
            return;
        }
        // removeFirst(c)
        // a -> b -> c -> d -> null
        //      ^
        //      c
        while(current != null && current.next.value != element){
            current = current.next;
        }
        // a -> b -> -> d -> null
        //      ^
        //      c
        if(current.next != null){
            current.next = current.next.next;
        }

        if(current.next == null){
            this.last = current;
        }
        count--;
    }

    @Override
    public void removeLast(int element) {
        Node current = first;
        Node previous = null;
        Node next = null;
        while (current != null) {
            if (current.next != null && current.next.value == element) {
                previous = current;
                next = current.next;
            }
            current = current.next;
        }
        previous.next = next.next;
    }

    @Override
    public void removeAll(int element) {
        Node current = first, prev = null;
        while (current != null && current.value == element) {
            first = current.next;
            current = first;
        }
        while (current != null) {
            current = current.next;
            while(current != null && current.value != element){
                prev = current;
                current = current.next;
            }
        }

        if (current == null) {
            return;
        }
        prev.next = current.next;
        current = prev.next;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }
}
