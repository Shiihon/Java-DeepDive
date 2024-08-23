package org.example.javaDeepDive1.fridayEx2308;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TaskList<Task> taskList = new TaskList<>();

        Task task1 = new Task("Buy groceries", "Buy milk, eggs, and bread", LocalDate.now().plusDays(2));
        taskList.addTask(task1);

        Task task2 = new Task("Finish project", "Complete the Java project", LocalDate.now().plusDays(5));
        taskList.addTask(task2);

        Task task3 = new Task("Submit report", "Submit the quarterly report", LocalDate.now().minusDays(3));
        taskList.addTask(task3);

        Task task4 = new Task("Pay bills", "Pay the utility bills", LocalDate.now().minusWeeks(1));
        taskList.addTask(task4);

        Task task5 = new Task("Attend meeting", "Team meeting at 10 AM", LocalDate.now());
        taskList.addTask(task5);

        GardenTask gardenTask1 = new GardenTask("Water the lawn", "Water the entire lawn area", LocalDate.now().plusDays(1), "Front yard");
        taskList.addTask(gardenTask1);

        GardenTask gardenTask2 = new GardenTask("Prune the roses", "Prune the rose bushes", LocalDate.now().minusDays(4), "Rose garden");
        taskList.addTask(gardenTask2);

        GardenTask gardenTask3 = new GardenTask("Plant new seeds", "Plant vegetable seeds in the garden", LocalDate.now().plusWeeks(2), "Vegetable garden");
        taskList.addTask(gardenTask3);

        GardenTask gardenTask4 = new GardenTask("Fertilize the plants", "Apply fertilizer to all plants", LocalDate.now().minusWeeks(2), "Backyard garden");
        taskList.addTask(gardenTask4);

        GardenTask gardenTask5 = new GardenTask("Weed the garden", "Remove weeds from the garden beds", LocalDate.now().plusDays(3), "Herb garden");
        taskList.addTask(gardenTask5);

        //Print list of tasks
        System.out.println("All tasks: ");
        taskList.printTasks();
        System.out.println();//space

        //filter tasks with keyword
        String keyword = "Weed";
        List<Task> filteredTasks = taskList.filterTasks(keyword);
        System.out.println("Tasks filtered by keyword : " + keyword + " " + filteredTasks);
        System.out.println();//space

        //Only tasks overdue
        List<Task> sortedOverdueTasks = taskList.getOverdueTasks();
        System.out.println("These are the tasks that are overdue : " + sortedOverdueTasks);
        System.out.println();//space

        //All tasks due today
        List<Task> tasksDueToday = taskList.getTasksDueToday();
        if(filteredTasks.isEmpty()){
            System.out.println("No tasks, matches the keyword");
        }
        System.out.println("Tasks due today : " + tasksDueToday);

        //Tasks sorted by due date
        List<Task> sortedByDueDate = taskList.sortByDueDate();
        System.out.println("Tasks sorted by due date: ");
        sortedByDueDate.forEach(System.out::println); //iterates over them all.
    }
}

//using @SuperBuilder(), to get the supers constructor from Task to GardenTask. Or make a constructor in GardenTask (Which is done here)
// GardenTask gardenTask1 = GardenTask.builder()
//       .title("Water the plants")
//       .gardenLocation("Kongens Have")
//       .description("Water the roses and tulips")
//       .dueDate(LocalDate.of(2024, 8, 22))
//       .build();

