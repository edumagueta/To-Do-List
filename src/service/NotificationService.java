package service;

import model.Task;
import model.TaskStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class NotificationService {
    public static void checkDeadlines(List<Task> tasks){
        CompletableFuture.runAsync(() -> { tasks.stream()
                .filter(task -> task.getDeadline().equals(LocalDate.now().plusDays(1)) && task.getStatus() != TaskStatus.CONCLUIDA)
                .forEach(task -> System.out.println("\nLembrete: Tarefa: " + task.getTitle() + " é para amanhã!!"));
        });
    }
}