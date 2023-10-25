import java.util.Arrays;

/**
 * A class for utilizing a max heap with other useful methods
 * for navigating the heap
 * 
 * @author Karter Melad
 * @verison Fall 2023
 */
public class MaxHeap {

    protected Task[] heap;
    protected int size;

    /**
     * Default constructor with an empty heap
     * 
     */
    public MaxHeap() {
        this.heap = new Task[0];
        this.size = 0;
    }

    /**
     * Creates a new Max Heap with a given Task
     * 
     * @param heap
     */
    public MaxHeap(Task[] newHeap) {
        this.heap = new Task[newHeap.length];
        this.size = newHeap.length;
        this.heap = Arrays.copyOf(newHeap, newHeap.length);
        this.buildMaxHeap();
    }

    /**
     * Creates the parent variable needed for heapify
     * 
     * @param i
     * @return value of (i - 1) / 2
     */
    private int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * Creates the left variable needed for heapify
     * 
     * @param i
     * @return value of 2 * i + 1
     */
    private int left(int i) {
        return 2 * i + 1;
    }

    /**
     * Creates the right variable needed for heapify
     * 
     * @param i
     * @return value of 2 * i + 2
     */
    private int right(int i) {
        return 2 * i + 2;
    }

    /**
     * Creates a max heapify for the given task
     * 
     * @param i
     */
    private void maxHeapify(int i) {
        int largest = 0;
        int l = left(i);
        int r = right(i);
        if (l < size && (heap[l].compareTo(heap[i]) == 1)) {
            largest = l;
        } else {
            largest = i;
        }
        if (r < size && (heap[r].compareTo(heap[largest]) == 1)) {
            largest = r;
        }
        if (largest != i) {
            Task temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            maxHeapify(largest);
        }
    }

    /**
     * Builds a max heap
     * 
     */
    private void buildMaxHeap() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }
    
    /**
     * Doubles the size of the array if needed and returns the maximum
     * 
     * @throws HeapException
     */
    public Task maxHeapMaximum() throws HeapException {
        if (size < 1) {
            throw new HeapException("Nothing in the heap");
        }
        return heap[0];
    }

    /**
     * Extracting the max from the heap
     * 
     * @return max
     * @throws HeapException
     */
    public Task extractMax() throws HeapException {
        Task max = maxHeapMaximum();
        heap[0] = heap[size - 1];
        size--;
        maxHeapify(0);
        return max;
    }

    /**
     * Increases the key for the heap
     * 
     * @param x
     * @param key
     * @throws HeapException
     */
    public void increaseKey(int i, Task key) throws HeapException {
        if (key.getPriority() < heap[i].getPriority()) {
            throw new HeapException("New key must be larger than current key");
        }
        heap[i] = key;
        while (i > 0 && heap[parent(i)].compareTo(heap[i]) == -1) {
            Task temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = parent(i);
        }
    }

    /**
     * Inserting a task into the heap
     * 
     * @param x
     * @throws HeapException
     */
    public void insert(Task x) throws HeapException {
        if (heap.length == size) {
            Task[] tempHeap = Arrays.copyOf(heap, heap.length * 2);
            heap = tempHeap.clone();
        }
        size++;
        Task[] tempHeap = Arrays.copyOf(heap, size);
        heap = tempHeap.clone();
        heap[size - 1] = x;
        increaseKey(size - 1, x);
    }

    /**
     * Checks if the heap is empty
     * 
     * @return true if empty, else false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Creates a string of the heap's priority levels
     * 
     * @return heap string
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(heap[i].priorityLevel);
            if (i != size-1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    /**
     * Returns the array of the heap
     * 
     * @return heap
     */
    public Task[] heapArray() {
        return heap;
    }
}
