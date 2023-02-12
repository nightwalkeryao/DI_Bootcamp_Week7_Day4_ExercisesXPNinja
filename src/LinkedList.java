import java.util.Optional;

public class LinkedList<T> {
    private Item<T> head;
    private Item<T> tail;
    private Item<T>[] items;
    private int size;
    private int maxSize = 1;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.items = new Item[maxSize];
        size = 0;
    }

    private LinkedList<T> growSize() {
        this.maxSize++;
        Item<T>[] temp = new Item[maxSize];
        for (int i = 0; i < items.length; i++) {
            temp[i] = items[i];
        }
        this.items = temp;

        return this;
    }

    public LinkedList<T> add(T data) {
        if(this.size == this.maxSize)
            this.growSize();
        Item<T> item = new Item<T>(null, 0, data);
        if(tail.equals(null)) {
            this.head = item;
        } else {
            item.setIndex(this.tail.getIndex() + 1);
            item.setPreviousIndex(this.tail.getIndex());
            this.tail.setNextIndex(item.getIndex());
        }
        this.tail = item;
        this.size++;
        this.items[size] = item;

        return this;
    }

    public Optional<Item<T>> get(int index) {
        Optional<Item<T>> item = null;
        for (int i = 0; i <= size; i++) {
            if (items[i].getIndex() == index)
                item = Optional.ofNullable(items[i]);
        }
        return item;
    }

    public LinkedList<T> remove(int index) {
        for (int i = 0; i < size; i++) {
            if(items[i].getIndex() == index) {
                items[i] = null;
            }
        }
        // Continue implementation of remove here

        // if(this.size == this.maxSize)
        //     this.growSize();
        // Item item = new Item(null, 0, data);
        // if(tail.equals(null)) {
        //     this.head = item;
        // } else {
        //     item.setIndex(this.tail.getIndex() + 1);
        //     item.setPreviousIndex(this.tail.getIndex());
        //     this.tail.setNextIndex(item.getIndex());
        // }
        // this.tail = item;
        // this.size++;
        // this.items[size] = item;

        return this;
    }

    public static void main(String[] args) {
        // code here
    }
}
