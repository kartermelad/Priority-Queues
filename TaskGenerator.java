import java.util.Random;

/**
 * Generates tasks for the Stardew game
 * 
 * @author Karter Melad
 * @version Fall 2023
 */
public class TaskGenerator implements TaskGeneratorInterface {

    private Random rand;
    private int currentEnergyStorage;
    private double taskGenProb;

    /**
     * A loaded constructor using a seed for the random number generator
     * 
     * @param taskGenerationProbability
     * @param seed
     */
    public TaskGenerator(double taskGenerationProbability, long seed) {
        this.taskGenProb = taskGenerationProbability;
        this.currentEnergyStorage = DEFAULT_ENERGY;
        this.rand = new Random(seed);
    }

    /**
     * A loaded constructor for a new Task Generator
     * 
     * @param taskGenerationProbability
     */
    public TaskGenerator(double taskGenerationProbability) {
        this.taskGenProb = taskGenerationProbability;
        this.currentEnergyStorage = DEFAULT_ENERGY;
        this.rand = new Random();
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public Task getNewTask(int hourCreated, TaskInterface.TaskType taskType, String taskDescription) {
        Task newTask = new Task(0, taskType, 0, hourCreated, taskDescription);
        return newTask;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public void decrementEnergyStorage(TaskInterface.TaskType taskType) {
        currentEnergyStorage -= taskType.getEnergyPerHour();
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public void resetCurrentEnergyStorage() {
        currentEnergyStorage = DEFAULT_ENERGY;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public int getCurrentEnergyStorage() {
        return currentEnergyStorage;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public void setCurrentEnergyStorage(int newEnergyNum) {
        currentEnergyStorage = newEnergyNum;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public boolean generateTask() {
        return rand.nextDouble() < taskGenProb;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public int getUnlucky(Task task, double unluckyProbability) {
        if(unluckyProbability <= task.getTaskType().getPassingOutProbability()) {
            if(unluckyProbability <= task.getTaskType().getDyingProbability() && task.getTaskType() == TaskInterface.TaskType.MINING) {
                currentEnergyStorage = (int) (currentEnergyStorage * 0.25);
                task.setPriority(0);
                return 2;
            } else {
                currentEnergyStorage = currentEnergyStorage / 2;
                return 1;
            }
        } else {
            return 0;
        }
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public String toString(Task task, TaskInterface.TaskType taskType) {
        if(taskType == Task.TaskType.MINING) {
            return "    Mining " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() + ")";
        }
        if(taskType == Task.TaskType.FISHING) {
            return "    Fishing " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() + ")";
        }
        if(taskType == Task.TaskType.FARM_MAINTENANCE) {
            return "    Farm Maintenance " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() + ")";
        }
        if(taskType == Task.TaskType.FORAGING) {
            return "    Foraging " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() + ")";
        }
        if(taskType == Task.TaskType.FEEDING) {
            return "    Feeding " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() + ")";
        }
        if(taskType == Task.TaskType.SOCIALIZING) {
            return "    Socializing " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() + ")";
        }
        else {
            return "nothing to see here...";
        }
    }
}
