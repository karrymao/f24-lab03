package edu.cmu.cs.cs214.rec04;

public class SortedIntList extends AbstractIntList {
    private final static int CAPACITY = 10;
    private int[] list;
    private int size;

    public SortedIntList() {
        list = new int[CAPACITY];
        size = 0;
    }

    @Override
    public boolean add(int num) {
        if (size >= CAPACITY) {
            return false;
        }
        int i;
        for (i = 0; i < size; i++) {
            if (num >= list[i]) {
                break;
            }
        }
        for (int j = size; j > i; j--) {
            list[j] = list[j - 1];
        }
        list[i] = num;
        size++;
        return true;
    }

    @Override
    public int get(int index) {
        return list[index];
    }

    @Override
    public boolean remove(int num) {
        int i;
        for (i = 0; i < size; i++) {
            if (list[i] == num) {
                break;
            }
        }
        if (i == size) {
            return false;
        }
        for (; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        size--;
        return true;
    }

    @Override
    public boolean removeAll(IntegerList list) {
        boolean success = false;
        for (int i = 0; i < list.size(); i++) {
            success |= this.remove(list.get(i));
        }
        return success;
    }

    @Override
    public int size() {
        return size;
    }
}