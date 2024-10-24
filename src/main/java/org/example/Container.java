package org.example;
public class Container {
    private Object[] elems;
    private int size;
    private static final int initialCapacity = 10;


    public Container() {
        elems = new Object[initialCapacity];
        size = 0;
    }

    public Container(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero");
        }
        elems = new Object[capacity];
        size = 0;
    }

    public int getSize()
    {
        return size;
    }

    private void resize()
    {
        int newCapacity = elems.length*2;
        Object[] newElements=new Object[newCapacity];
        System.arraycopy(elems, 0,newElements, 0, elems.length);
        elems=newElements;
    }

}
