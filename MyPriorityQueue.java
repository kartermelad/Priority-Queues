/**
 * 
 * @author Karter Melad
 * @version Fall 2023
 */
public class MyPriorityQueue extends MaxHeap implements PriorityQueueInterface {

    /**
     * A super constructor for easier MyPriorityQueue implementation
     */
    public MyPriorityQueue() {
        super();
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public void enqueue(Object task) {
        try {
            super.insert((Task) task);
        } 
        catch(HeapException h) {
            h.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public Task dequeue() {
        try {
            Task task = super.extractMax();
            return task;
        }
        catch(HeapException h) {
            h.printStackTrace();
            return null;
        }
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public void update(int timeToIncrementPriority, int maxPriority) {
        try {
            for(int i = 0; i < size; i++) {
            heap[i].waitingTime++;
                if(heap[i].waitingTime >= timeToIncrementPriority) {
                    heap[i].waitingTime = 0;
                    if(heap[i].getPriority() < maxPriority) {
                        heap[i].priorityLevel++;
                        increaseKey(i, heap[i]);
                    }
                }
            }
        }
        catch(HeapException h) {
            h.printStackTrace();
        }
    }
    
}
