
/*
file name:      ShuffleTests.java
Authors:        Ike Lage & Max Bender & Allen Harper
last modified:  02/26/2024

Gent Makstuaj
Purpose: Create a unique ArrayList object
*/

@

SuppressWarnings("unchecked")
public class ArrayList<E> {

    /**
     * This array stores the actual contents of the ArrayList
     */
    E[] arr;

    /**
     * This stores the number of items in the ArrayList (note: this is distinct from
     * the capacity)
     */
    int size;

    /**
     * This stores the index of the first item in the list. This index is not
     * necessarily 0.
     */
    int firstIndex;

    public ArrayList() {
        arr = (E[]) new Object[16];
        size = 0;

        // firstIndex is initialized to -1 to reflect the fact that there are originally
        // no contents in this array.
        firstIndex = -1;
    }

    /**
     * Returns the number of items in the ArrayList.
     * 
     * @return the number of items in the ArrayList.
     */
    public int size() {
        return size;
    }

    /**
     * Returns the capacity of the underlying array of this ArrayList.
     * 
     * @return the capacity of the underlying array of this ArrayList.
     */
    public int capacity() {
        return arr.length;
    }

    private void ensureCapacity() {
        if (size == capacity()) {
            resizeArray(capacity() * 2);
        }
    }

    /**
     * Allocates an array of the specified {@code newCapacity}, copies over all
     * contents of {@code arr} into this new array, and resets {@code arr} to this
     * new array.
     * 
     * @param newSize the new capacity for {@code arr}.
     */
    private void resizeArray(int newCapacity) {
        E[] newArr = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newArr[i] = arr[(firstIndex + i) % capacity()];
        }

        // in the for loop above, we shift everything back to index 0.
        firstIndex = 0;

        arr = newArr;
    }

    /**
     * Returns the item at the specified {@code index}.
     * 
     * @param index the index to be inspected.
     * @return the item at the specified {@code index}.
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index " + index + " out of bounds for an array of " + size + " items.");
        }
        return arr[(firstIndex + index) % capacity()];
    }

    /**
     * This method adds the specified {@code item} into the ArrayList, setting it as
     * the first entry.
     * 
     * @param item
     */
    public void addFirst(E item) {
        ensureCapacity();
        if (size == 0) {
            firstIndex = 0;
        } else {
            firstIndex = (firstIndex - 1 + capacity()) % capacity();
        }
        arr[firstIndex] = item;
        size++;
    }

    public void addLast(E item) {
        ensureCapacity();
        if (size == 0) {
            firstIndex = 0;
        }
        int index = (firstIndex + size) % capacity();
        arr[index] = item;
        size++;
    }

    public E removeFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Cannot remove from an empty array.");
        }
        E item = arr[firstIndex];
        arr[firstIndex] = null;
        if (size == 1) {
            firstIndex = -1;
        } else {
            firstIndex = (firstIndex + 1) % capacity();
        }
        size--;
        return item;
    }

    public E removeLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Cannot remove from an empty array.");
        }
        int lastIndex = (firstIndex + size - 1) % capacity();
        E item = arr[lastIndex];
        arr[lastIndex] = null;
        if (size == 1) {
            firstIndex = -1;
        }
        size--;
        return item;
    }
}