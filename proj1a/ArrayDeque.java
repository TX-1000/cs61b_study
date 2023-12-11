public class ArrayDeque<T> {
    private T[] my_array;
    private int maxsize;
    private int size;
    private int front;

    // constructor
    public ArrayDeque() {
        maxsize = 8;
        size = 0;
        front = 0;
        my_array = (T[]) new Object[8];
    }


/*     public void show() {
        System.out.println("maxsize:" + maxsize + "  size:" + size + "  front:" + front);
    } */
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
        int new_maxsize = Integer.min(maxsize * 2, Integer.MAX_VALUE);
        T[] new_array = (T[]) new Object[new_maxsize];
        for (int i = 0; i < size; i++) {
            new_array[(front+i+new_maxsize)%new_maxsize] = my_array[(front+i+maxsize)%maxsize];
        }
        maxsize = new_maxsize;
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
        size += 1;
        doubleSpace();
        // pull back every number first
        my_array[(front-1+maxsize)%maxsize] = n;
        front = (front-1+maxsize)%maxsize;
    }

    public void addLast(T n) {
        size += 1;
        doubleSpace();
        my_array[(front+size-1+maxsize)%maxsize] = n; 
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(my_array[(front+i+maxsize)%maxsize] + "  ");
        }
        System.out.print('\n');
    }

    // cout from 0
    public T get(int index) {
        assert (index>=0 & index<size) : "下标越界";
        return my_array[(front+index+maxsize)%maxsize];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T removeFirst() {
        T tmp = my_array[front];
        front = (front+1+maxsize)%maxsize;
        size -= 1;
        halfSpace();
        return tmp;
    }

    public T removeLast() {
        size -= 1;
        T tmp = my_array[size];
        my_array[(front+size+maxsize)%maxsize] = null;
        halfSpace();
        return tmp;
    }
}
