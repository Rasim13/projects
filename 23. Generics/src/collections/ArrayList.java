package collections;

public class ArrayList<T> {
    private static final int DEFAULT_SIZE = 10;

    private T elements[];
    private int count;

    public ArrayList() {
        this.elements =(T[]) new Object[DEFAULT_SIZE];
        this.count = 0;
    }

    public T get(int index) {
        if(index >= 0 && index < count){
            return elements[index];
        }
        return null;
    }

    public void add(T element) {
        if(count == elements.length){
            T[] newArray = (T[]) new Object[elements.length + elements.length / 2];
            for(int i = 0; i < count; i++){
                newArray[i] = elements[i];
            }
            elements = newArray;
        }
        elements[count] = element;
        count++;

    }
    
    public int size() {
        return count;
    }

    public void removeFirst(T element) {
        int positionOfRemovingElement = - 1;
        for(int i = 0; i < count; i++){
            if(elements[i].equals(element)) {
                positionOfRemovingElement = i;
                break;
            }
        }
        for(int i = positionOfRemovingElement; i < count - 1; i++){
            elements[i] = elements[i + 1];
        }
        count--;
    }
}
