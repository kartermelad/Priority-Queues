public class Tester {

    public static void main(String args[]) throws HeapException {
        Task task1 = new Task(20, TaskInterface.TaskType.FISHING, 0, 0, "Test");
        Task task2 = new Task(10, TaskInterface.TaskType.FISHING, 0, 0, "Test");
        Task task3 = new Task(14, TaskInterface.TaskType.FISHING, 0, 0, "Test");
        Task task4 = new Task(9, TaskInterface.TaskType.FISHING, 0, 0, "Test");
        Task task5 = new Task(7, TaskInterface.TaskType.FISHING, 0, 0, "Test");
        Task task6 = new Task(13, TaskInterface.TaskType.FISHING, 0, 0, "Test");
        Task task7 = new Task(3, TaskInterface.TaskType.FISHING, 0, 0, "Test");
        Task task8 = new Task(2, TaskInterface.TaskType.FISHING, 0, 0, "Test");
        Task task9 = new Task(8, TaskInterface.TaskType.FISHING, 0, 0, "Test");
        Task task10 = new Task(1, TaskInterface.TaskType.FISHING, 0, 0, "Test");
        Task task11 = new Task(11, TaskInterface.TaskType.FISHING, 0, 0, "Test");
        Task[] tasks = {task1, task2, task3, task4, task5, task6, task7, task8, task9, task10};
        MaxHeap heap = new MaxHeap(tasks);
        System.out.println(heap.toString());
        heap.insert(task11);
        System.out.println(heap.toString());
    }
    
}
