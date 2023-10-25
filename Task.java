/**
 * Creates a task
 * 
 * @author Karter Melad
 * @version Fall 2023
 */
public class Task implements TaskInterface, Comparable<Task> {

    int priorityLevel;
    TaskType taskType;
    int waitingTime;
    int hourCreated;
    String description;

    /**
     * Creates a new task with the given parameters
     * 
     * @param priorityLevel
     * @param taskType
     * @param waitingTime
     * @param hourCreated
     * @param description
     */
    public Task(int priorityLevel, TaskType taskType, int waitingTime, int hourCreated, String description) {
        this.priorityLevel = priorityLevel;
        this.taskType = taskType;
        this.waitingTime = waitingTime;
        this.hourCreated = hourCreated;
        this.description = description;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public String toString() {
        return taskType + getTaskDescription() + " at Hour: " + getHourCreated() + ":00";
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public int getPriority() {
        return priorityLevel;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public void setPriority(int priority) {
        priorityLevel = priority;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public TaskInterface.TaskType getTaskType() {
        return taskType;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public String getTaskDescription() {
        return description;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public void incrementWaitingTime() {
        waitingTime++;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public void resetWaitingTime() {
        waitingTime = 0;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public int getWaitingTime() {
        return waitingTime;
    }

    /**
     * Gets the hour the task was created
     * 
     * @return hour created
     */
    public int getHourCreated() {
        return hourCreated;
    }

    /**
     * Compares tasks by priority level, if priority level is
     * equal it will go by hour created
     * 
     * @param task
     * @return the task that is of a higher priority
     */
    @Override
    public int compareTo(Task task) {
        if (task.getPriority() > this.getPriority()) {
            return -1;
        } else if (task.getPriority() < this.getPriority()) {
            return 1;
        } else if (task.getPriority() == this.getPriority()) {
            if (task.getHourCreated() < this.getHourCreated()) {
                return -1;
            } else {
                return 1;
            }
        } else {
            return 0;
        }
    }
}
