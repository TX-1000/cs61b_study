public class LinkedListDeque <T> {
    // it is a circular setinel LLD
    private class Node {
        private T item;
        private Node prev;
        private Node next;
        /**constructor for Node */
        public Node(T n, Node pprev, Node nnext) {
            item = n;
            prev = pprev;
            next = nnext;
        }

        // constructor for setinel
        public Node(Node pprev, Node nnext) {
            item = null;
            prev = pprev;
            next = nnext;
        }
    }

    private Node setinel;
    int size;

    // constructor for LLD without input
    public LinkedListDeque() {
        setinel = new Node(null,null);
        setinel.next = setinel;
        setinel.prev = setinel;
        size = 0;
    }

    // constructor for LLD with an array of input
    public LinkedListDeque(T... ns) {
        setinel = new Node(setinel, setinel);
        size = 0;
        Node p = setinel;
        for (T n : ns) {
            p.next = new Node(n,p,setinel);
            p = p.next;
            size += 1;
        }
    }

    // constructor for LLD by copy
    public LinkedListDeque(LinkedListDeque<T> lld) {
        setinel = new Node(setinel, setinel);
        size = 0;
        Node p1 = setinel;
        for (Node p2 = lld.setinel.next ; p2 != lld.setinel ; p2 = p2.next) {
            p1.next = new Node(p2.item, p1, setinel);
            size += 1;
        }
    }

    public void addFirst(T n) {
        Node newNode = new Node(n, setinel, setinel.next);
        setinel.next.prev = newNode;
        setinel.next = newNode;
        size += 1;
    }

    public void addLast(T n) {
        Node newNode = new Node(n, setinel.prev, setinel);
        setinel.prev.next = newNode;
        setinel.prev = newNode;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        for (Node p = setinel.next ; p != setinel ; p = p.next) {
            System.out.print(p.item + "  ");
        }
        System.out.print('\n');
    }

    // 首先确保有节点可以删除，并记得修改size
    public T removeFirst() {
        if (size == 0) return null;
        T tmp = setinel.next.item;
        setinel.next.next.prev = setinel;
        setinel.next = setinel.next.next;
        size -= 1;
        return tmp;
    }
    
    public T removeLast() {
        if (size == 0) return null;
        T tmp = setinel.prev.item;
        setinel.prev.prev.next = setinel;
        setinel.prev = setinel.prev.prev;
        size -= 1;
        return tmp;
    }

    // 首先确保不越界(或许可以把越界转换为正常？)
    public T get(int index) {
        if (index <= 0) return null;
        if (index > size) return null;
        Node p = setinel;
        for (int i = 0 ; i < index ; i++) p = p.next;
        return p.item;
    }

    public T getRecursive(int index) {
        // impossible to do this without more arg
        return get(index);
    }

    public int size() {
        return size;
    }


}
