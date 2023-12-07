public class ArrayDeque<T> {
    private T[] my_array;
    private int maxsize;
    private int size;

    // constructor
    public ArrayDeque() {
        maxsize = 8;
        size = 0;
        my_array = (T[]) new Object[8];
    }

    /* public ArrayDeque(T[] t_array) {
        maxsize = 8;
        size = t_array.length;
        while (maxsize < size) maxsize *= 2;
        my_array = (T[]) new Object[maxsize];
        for (int i = 0; i < t_array.length; i++) {
            my_array[i] = t_array[i];
        }
    } */

    // double space, integrating cond(may cause surprise)
    private void doubleSpace() {
        assert size < Integer.MAX_VALUE : "overflow";
        // assert when doubleSpace, there must be item to be inserted. 
        if (size < maxsize) return;
        maxsize = Integer.min(maxsize *= 2, Integer.MAX_VALUE);
        T[] new_array = (T[]) new Object[maxsize];
        for (int i = 0; i < size; i++) {
            new_array[i] = my_array[i];
        }
        my_array = new_array;
    }

    // half space, intergrating cond
    private void halfSpace() {
        if (maxsize <= 8) return;
        if (size >= maxsize / 4) return;
        maxsize = Integer.max(8, maxsize / 2);
        T[] new_array = (T[]) new Object[maxsize];
        for (int i = 0; i < size; i++) {
            new_array[i] = my_array[i];
        }
        my_array = new_array;
    }

    public void addFirst(T n) {
        doubleSpace();
        // pull back every number first
        for (int i = size; i >= 0; i--) my_array[i+1] = my_array[i];
        my_array[0] = n;
        size += 1;
    }

    public void addLast(T n) {
        doubleSpace();
        my_array[size] = n;
        size += 1;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(my_array[i] + "  ");
        }
        System.out.print('\n');
    }

    // cout from 0
    public T get(int index) {
        assert (index>=0 & index<size) : "下标越界";
        return my_array[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T removeFirst() {
        T tmp = my_array[0];
        for (int i = 0; i < size-1; i++) {
            my_array[i] = my_array[i+1];
        }
        size -= 1;
        halfSpace();
        return tmp;
    }

    public T removeLast() {
        size -= 1;
        T tmp = my_array[size];
        my_array[size] = null;
        halfSpace();
        return tmp;
    }
}
