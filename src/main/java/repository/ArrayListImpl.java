package repository;

import java.util.Arrays;

public class ArrayListImpl <E> {

    private Object[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private final int DEFAULT_GROWTH_STEP = 2;

    public ArrayListImpl() {
        this.list = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public ArrayListImpl(int initialCapacity) {
        this.list = new Object[initialCapacity];
        this.size = 0;
    }

    public void add(E element) {
        if (size == list.length) {
            resize(size * DEFAULT_GROWTH_STEP);
        }
        list[size++] = element;
    }

    public E get(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) list[index];
    }

    public E remove(int index) {
        return shift(index);
    }

    private E shift(int index) {
        E removed = get(index);
        for (int i = index; i < size; i++) {
            list[i] = list[i + 1];
        }
        list[size - 1] = null;
        size--;

        return removed;
    }

    private void resize(int newSize) {
        this.list = Arrays.copyOf(list, newSize);
    }

}
