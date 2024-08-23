package org.example.javaDeepDive1.fridayEx2308;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaskList<T extends Task> implements Iterable<T> {
    private List<T> taskList = new ArrayList<>();
    private final LocalDate today = LocalDate.now();

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }

    public void addTask(T task) {
        taskList.add(task);
    }

    public List<T> getTasks(){
        return taskList;
    }

    public List<T> filterTasks(String keyword) {
        return taskList.stream()
                .filter(taskList -> taskList.getTitle().contains(keyword) || taskList.getDescription().contains(keyword))
                .collect(Collectors.toList());
    }

    public List<T> sortByDueDate() {
        return taskList.stream()
                // Can be written like this, or with the comparator
                //.sorted((task1, task2) -> task1.getDueDate().compareTo(task2.getDueDate()))
                .sorted(Comparator.comparing(Task::getDueDate))
                .collect(Collectors.toList());
    }

    public List<T> getTasksDueToday() {
        return taskList.stream()
                .filter(task -> task.getDueDate().equals(today))
                .collect(Collectors.toList());
    }

    public List<T> getOverdueTasks() {
        return taskList.stream()
                .filter(task -> task.getDueDate().isBefore(today))
                .collect(Collectors.toList());
    }

    public void printTasks() {
        taskList.forEach(System.out::println);
    }

}
