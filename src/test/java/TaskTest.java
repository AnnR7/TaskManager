import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void matchesSimpleTaskTitle() {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить родителям");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void notMatchesSimpleTaskTitle() {

        SimpleTask simpleTask = new SimpleTask(6, "Полить цветы");

        boolean expected = false;
        boolean actual = simpleTask.matches("Позвонить родителям");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void matchesEpicSubtask() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(5, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Хлеб");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void notMatchesEpicSubtask() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(5, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Кефир");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void matchesMeetingProject() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Приложение НетоБанка");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void matchesMeetingTopic() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Выкатка 3й версии приложения");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void notMatchesMeeting() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches("Купить молоко");

        Assertions.assertEquals(expected, actual);
    }
}