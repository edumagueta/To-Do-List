package service;

import model.Task;
import model.TaskStatus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TaskService {
    private final List<Task> tasks = new ArrayList<>();

    public  void addTask(Task task){
        tasks.add(task);
        System.out.println("Tarefa adicionada: " + task);
    }

    public List<Task> listTasks(){
        return tasks.stream().sorted(Comparator.comparing(Task::getDeadline)).toList();
    }

    public List<Task> filterTasks(TaskStatus status){
        return tasks.stream().filter(task -> task.getStatus() == status).toList();
    }

    public Optional<Task> getTaskTitle(String title){
        return tasks.stream().filter(task -> task.getTitle().equalsIgnoreCase(title)).findFirst();
    }

    public void updateTaskStatus(String keyword, TaskStatus newStatus){
        tasks.stream().filter(task -> task.getTitle().trim().toLowerCase().contains(keyword))
                .findFirst().ifPresentOrElse(task -> task.setStatus(newStatus),
                        () -> System.out.println("Tarefa não encontrada!"));
    }
}