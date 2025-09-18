import java.util.*;
class TaskManager {
    
    private static class Task {
        int userId, taskId, priority;
        Task(int u, int t, int p) { userId = u; taskId = t; priority = p; }
    }
       private final NavigableSet<Task> set = new TreeSet<>(
        Comparator.<Task>comparingInt(t -> t.priority)
                  .thenComparingInt(t -> t.taskId)
    );


    private final Map<Integer, Task> byId = new HashMap<>();

    public TaskManager(List<List<Integer>> tasks) {
        for(List<Integer> task :tasks){
            add(task.get(0),task.get(1),task.get(2));
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        set.add(task);
        byId.put(taskId, task);
    }
    
    public void edit(int taskId, int newPriority) {
        Task t = byId.get(taskId);          
        set.remove(t);                      
        t.priority = newPriority;           
        set.add(t);                         
    }
    
    public void rmv(int taskId) {
        Task t = byId.remove(taskId); 
        set.remove(t);
    }
    
    public int execTop() {
        if (set.isEmpty()) return -1;
        Task top = set.pollLast();          
        byId.remove(top.taskId);
        return top.userId;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */