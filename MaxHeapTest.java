import org.junit.Assert;
import org.junit.Test;

/**
 * @author Karter Melad
 * @version Fall 2023
 *          Tests for the MaxHeap class
 */
public class MaxHeapTest {

    // Tasks created for the tester
    Task task1 = new Task(1, TaskInterface.TaskType.FARM_MAINTENANCE, 0, 0, "Test1");
    Task task2 = new Task(4, TaskInterface.TaskType.FISHING, 0, 0, "Test2");
    Task task3 = new Task(3, TaskInterface.TaskType.MINING, 0, 0, "Test3");
    Task task4 = new Task(5, TaskInterface.TaskType.SOCIALIZING, 0, 0, "Test4");

    /**
     * Checks the heap to see if it is a max heap
     * 
     * @param 
     * @return true if a max heap
     * @throws HeapException
     */
    public boolean checkIfMaxHeap(Task[] newHeap) throws HeapException {
        boolean maxHeap = false;
        for(int i = 0; i < newHeap.length; i++) {
            if (newHeap[(i-1)/2].getPriority() < newHeap[i].getPriority()) {
                maxHeap = false;
                throw new HeapException("Error: not a max heap");
            }
            else {
                maxHeap = true;
            }
        }
        return maxHeap;
    }

    /**
     * Checks to see if the array is sorted
     * 
     * @param newHeap
     * @return true if sorted
     * @throws HeapException
     */
    public boolean checkIfSorted(MaxHeap heap) throws HeapException {
        boolean sorted = false;
        for(int i = 0; i < heap.size; i++) {
            Task max = heap.extractMax();
            if (max.getPriority() < heap.extractMax().getPriority()) {
                throw new HeapException("Error: not sorted");
            }
            else {
                sorted = true;
            }
        }
        return sorted;
    }

    @Test
    public void isEmpty() {
        MaxHeap heap = new MaxHeap();
        Assert.assertTrue(heap.isEmpty());
    }

    @Test
    public void isEmpty_2() throws HeapException {
        MaxHeap heap = new MaxHeap();
        heap.insert(task1);
        Assert.assertFalse(heap.isEmpty());
    }

    @Test
    public void insert() throws HeapException {
        MaxHeap heap = new MaxHeap();
        heap.insert(task1);
        heap.insert(task2);
        Assert.assertTrue(heap.extractMax() == task2);
    }

    @Test
    public void extractMax_1() throws HeapException {
        MaxHeap heap = new MaxHeap();
        heap.insert(task1);
        heap.insert(task2);
        Task max1 = heap.extractMax();
        Task max2 = heap.extractMax();
        Assert.assertEquals("FISHINGTest2 at Hour: 0:00", max1.toString());
        Assert.assertEquals("FARM_MAINTENANCETest1 at Hour: 0:00", max2.toString());
    }

    @Test
    public void extractMax_2() throws HeapException {
        MaxHeap heap = new MaxHeap();
        heap.insert(task1);
        heap.insert(task2);
        heap.insert(task3);
        Task max1 = heap.extractMax();
        Task max2 = heap.extractMax();
        Task max3 = heap.extractMax();
        Assert.assertEquals("FISHINGTest2 at Hour: 0:00", max1.toString());
        Assert.assertEquals("MININGTest3 at Hour: 0:00", max2.toString());
        Assert.assertEquals("FARM_MAINTENANCETest1 at Hour: 0:00", max3.toString());
    }

    @Test
    public void increaseKey_1() throws HeapException {
        MaxHeap heap = new MaxHeap();
        heap.insert(task1);
        heap.insert(task2);
        task1.setPriority(8);
        heap.increaseKey(1, task1);
        Task[] tasks = {task1, task2};
        Assert.assertArrayEquals(tasks, heap.heapArray());
    }

    @Test
    public void increaseKey_2() throws HeapException {
        MaxHeap heap = new MaxHeap();
        heap.insert(task1);
        heap.insert(task3);
        heap.insert(task4);
        task1.setPriority(8);
        heap.increaseKey(1, task1);
        Task[] task = {task1, task4, task3};
        Assert.assertArrayEquals(task, heap.heapArray());
    }

    @Test
    public void insertAscending() throws HeapException {
        Task[] tasks = {task1, task3, task2, task4};
        MaxHeap heap = new MaxHeap(tasks);
        Assert.assertTrue(checkIfMaxHeap(heap.heapArray()));
        Assert.assertTrue(checkIfSorted(heap));
    }

    @Test
    public void insertDescending() throws HeapException {
        Task[] tasks = {task4, task2, task3, task1};
        MaxHeap heap = new MaxHeap(tasks);
        Assert.assertTrue(checkIfMaxHeap(heap.heapArray()));
        Assert.assertTrue(checkIfSorted(heap));
    }

    @Test
    public void insertRandom() throws HeapException {
        Task[] tasks = {task3, task1, task4, task2};
        MaxHeap heap = new MaxHeap(tasks);
        Assert.assertTrue(checkIfMaxHeap(heap.heapArray()));
        Assert.assertTrue(checkIfSorted(heap));
    }
}



