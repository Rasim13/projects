public class ArrayList implements List {
    private static final int DEFAULT_SIZE = 10;

    private int elements[];
    private int count;

    public ArrayList() {
        this.elements = new int[DEFAULT_SIZE];
        this.count = 0;
    }

    @Override
    public int get(int index) {
        if(index >= 0 && index < count){
            return elements[index];
        }
        return -1;
    }

    @Override
    public void removeAt(int index) {
        if(index >= 0 && index < count) {
            int positionOfRemovingByIndex = 0;
            for(int i = 0; i < count; i++){
                if(i == index){
                    positionOfRemovingByIndex = i;
                    break;
                }
            }
            for(int i = positionOfRemovingByIndex; i < count; i++){
                elements[i] = elements[i + 1];
            }
            count--;
        } else {
            System.out.println(-1);
        }
    }

    @Override
    public int indexOf(int element) {
        for(int i = 0; i < count; i++){
            if(elements[i] == element){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int element) {
        int positionElement = - 1;
        for(int i = 0; i < count; i++){
            if(elements[i] == element){
                positionElement = i;
            }
        }
        return positionElement;
    }

    @Override
    public void add(int element) {
        if(count == elements.length){
            int[] newArray = new int[elements.length + elements.length / 2];
            for(int i = 0; i < count; i++){
                newArray[i] = elements[i];
            }
            elements = newArray;
        }
        elements[count] = element;
        count++;

    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean contains(int element) {
        for(int i = 0; i < count; i++){
            if(elements[i] == element){
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeFirst(int element) {
        int positionOfRemovingElement = - 1;
        for(int i = 0; i < count; i++){
            if(elements[i] == element){
                positionOfRemovingElement = i;
                break;
            }
        }
        for(int i = positionOfRemovingElement; i < count - 1; i++){
            elements[i] = elements[i + 1];
        }
        count--;
    }

    @Override
    public void removeLast(int element) {
        int positionOfRemovingElement = - 1;
        for(int i = 0; i < count; i++){
            if(elements[i] == element) {
                positionOfRemovingElement = i;
            }
        }
        for(int i = positionOfRemovingElement; i < count - 1; i++){
            elements[i] = elements[i + 1];
        }
        count--;
    }

    @Override
    public void removeAll(int element) {
        int positionOfRemovingElement = 0;

        for (int i = 0; i < count; i++) {

            if (elements[i] == element) {

                positionOfRemovingElement = i;

                for(int j = positionOfRemovingElement; j < count; j++) {

                    elements[j] = elements[j + 1];
                }
                count--;
            }
        }

    }

    private class ArrayListIterator implements Iterator {

        private int currentPosition;

        @Override
        public int next() {
            int nextValue = elements[currentPosition];
            currentPosition++;
            return nextValue;
        }

        @Override
        public boolean hasNext() {
            return currentPosition < count;
        }
    }


    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }
}
