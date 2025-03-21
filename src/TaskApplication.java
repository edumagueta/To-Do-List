import model.Task;
import model.TaskStatus;
import service.NotificationService;
import service.TaskService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TaskApplication {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("\n------Menu------");
            System.out.println("1 - Adiciona tarefa");
            System.out.println("2 - Lista tarefas");
            System.out.println("3 - Filtrar tarefas por status");
            System.out.println("4 - Atualiza status da tarefa");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.print("Título: ");
                    String title = scanner.nextLine();

                    System.out.print("Descrição: ");
                    String description = scanner.nextLine();

                    System.out.print("Prazo final (dd/MM/yyyy): ");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate deadline = LocalDate.parse(scanner.nextLine(), formatter);

                    try {
                        Task task = new Task(title, description, deadline, TaskStatus.PENDENTE);
                        taskService.addTask(task);
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                }

                case 2 -> {
                    System.out.println("\nLista de Tarefas:");
                    taskService.listTasks().forEach(System.out::println);
                }

                case 3 -> {
                    System.out.println("Escolha um Status para filtrar (PENDING, IN_PROGRESS, COMPLETED): ");
                    TaskStatus status = TaskStatus.valueOf(scanner.nextLine().toUpperCase());
                    taskService.filterTasks(status).forEach(System.out::println);
                }

                case 4 -> {
                    System.out.print("Escreva o título da tarefa: ");
                    String keyword = scanner.nextLine().toLowerCase();

                    System.out.print("Novo status (PENDING, IN_PROGRESS, COMPLETED): ");
                    TaskStatus newStatus = TaskStatus.valueOf(scanner.nextLine().toUpperCase());
                    taskService.updateTaskStatus(keyword, newStatus);
                }

                case 5 -> {
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Opção Inválida");
            }

            NotificationService.checkDeadlines(taskService.listTasks());
        }
    }
}