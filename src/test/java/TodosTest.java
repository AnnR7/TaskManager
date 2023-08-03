import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

//    @Test
//    public void shouldFindMatchesTasksOfSimpleTask() {     //Находится одна задача
//
//        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
//
//        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
//        Epic epic = new Epic(55, subtasks);
//
//        Meeting meeting = new Meeting(
//                555,
//                "Выкатка 3й версии приложения",
//                "Приложение НетоБанка",
//                "Во вторник после обеда"
//        );
//
//        Todos todos = new Todos();
//
//        todos.add(simpleTask);
//        todos.add(epic);
//        todos.add(meeting);
//
//        Task[] expected = {simpleTask};
//        Task[] actual = todos.search("Позвонить родителям");
//        Assertions.assertArrayEquals(expected, actual);
//    }
//    @Test
//    public void shouldFindMatchesTasksOfSubtask() {       //Находится одна задача
//
//        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
//
//        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
//        Epic epic = new Epic(55, subtasks);
//
//        Meeting meeting = new Meeting(
//                555,
//                "Выкатка 3й версии приложения",
//                "Приложение НетоБанка",
//                "Во вторник после обеда"
//        );
//
//        Todos todos = new Todos();
//
//        todos.add(simpleTask);
//        todos.add(epic);
//        todos.add(meeting);
//
//        Task[] expected = {epic};
//        Task[] actual = todos.search("Яйца");
//        Assertions.assertArrayEquals(expected, actual);
//    }
    @Test
    public void shouldFindMatchesTasks() {      //Находится одна задача

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Приложение НетоБанка");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotFindMatchesTasks() {      //Ни одна задача не подходит

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Кефир");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindMatchesTwoTasks() {      //Находятся две задачи

        SimpleTask simpleTask = new SimpleTask(5, "Молоко");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,

                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("Молоко");
        Assertions.assertArrayEquals(expected, actual);
    }
}