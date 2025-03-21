package model;

import java.time.LocalDate;

public class Task {
    private String title;
    private String description;
    private LocalDate deadline;
    private TaskStatus status;

    public Task(String title, String description, LocalDate deadline, TaskStatus status){

        if (title == null || title.trim().length() < 10)
            throw new IllegalArgumentException("Título precisa ter pelo menos 10 caracteres");
        if (deadline.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Prazo Final não pode estar no passado");

        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.status = status != null ? status : TaskStatus.PENDENTE;
    }

    public String getTitle(){
        return title;
    }

    public LocalDate getDeadline(){
        return deadline;
    }

    public TaskStatus getStatus(){
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void updateStatus(TaskStatus newStatus){
        this.status = newStatus;
    }

    @Override
    public String toString() {
        return String.format("Task[title='%s', deadline=%s, status=%s]", title, deadline, status);
    }
}