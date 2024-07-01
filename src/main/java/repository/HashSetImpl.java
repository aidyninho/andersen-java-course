package repository;

import java.util.HashMap;
import java.util.Iterator;

public class HashSetImpl <E> implements Iterable<E> {

    private HashMap<E, Object> map;
    private final Object PRESENT = new Object();

    public HashSetImpl() {
        this.map = new HashMap<>();
    }

    public void add(E element) {
        if (!contains(element)) {
            map.put(element, PRESENT);
        }
    }

    public boolean contains(E element) {
        return map.containsKey(element);
    }

    public void remove(E element) {
        map.remove(element);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }
}
