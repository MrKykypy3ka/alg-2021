

package ru.bgpu.lec.list;

public class LecList {

    private LecListItem first = null;
    private LecListItem last = null;
    private int size = 0;

    public void addFirst(Object value) {
        LecListItem item = new LecListItem(value);
        if(first == null) {
            first = item;
            last = item;
        } else {
            item.setNext(first);
            first = item;
        }
        size++;
    }

    public void addLast(Object value) {
        LecListItem item = new LecListItem(value);
        if(first == null) {
            first = item;
        } else {
            last.setNext(item);
        }
        last = item;
        size++;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        String out = "[";
        LecListItem current = first;
        while (current != null) {
            out += current.getValue();
            if(current.getNext() != null) {
                out += ",";
            }
            current = current.getNext();
        }
        return out+"]";
    }

    public Object getFirst() {
        if(first != null) {
            return first.getValue();
        }
        return null;
    }

    public Object getLast() {
        if(first != null) {
            return first.getValue();
        }
        return null;
    }

    public Object getByIndex(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        LecListItem current = first;
        int currentIndex = 0;
        while (current != null && currentIndex++ < index) {
            current = current.getNext();
        }
        return current.getValue();
    }

    public void addByIndex(Object value, int index) {
        if(index < 0) {
            throw new IndexOutOfBoundsException();
        }
        LecListItem current = first;
        int currentIndex = 0;
        while (current != null && currentIndex++ < index-1) {
            current = current.getNext();
        }
        if(current == null) {
            addLast(value);
        } else {
            LecListItem item = new LecListItem(value);
            item.setNext(current.getNext());
            current.setNext(item);
            size++;
        }
    }

}
