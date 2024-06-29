import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void isQueryTrueSimpleTask() {
        Task simpleTask = new SimpleTask(1, "Изучить материал");

        boolean expected = true;
        boolean actual = simpleTask.matches("Изучить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void isQueryFalseSimpleTask() {
        Task simpleTask = new SimpleTask(1, "Изучить материал");

        boolean expected = false;
        boolean actual = simpleTask.matches("Мзучить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void isQueryTrueEpic() {
        String[] subtasks = {"Просмотреть лекции", "Законспектировать", "Изучить материал", "Выполнить задание"};
        Task epic = new Epic(2, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("лекции");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void isQueryFalseEpic() {
        String[] subtasks = {"Просмотреть лекции", "Законспектировать", "Изучить материал", "Выполнить задание"};
        Task epic = new Epic(2, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("домашка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void isQueryTrueMeetingTopic() {
        Task meeting = new Meeting(
                3,
                "Разборный вебинар",
                "Исключения, Интерфейсы, Generics и Collections Framework",
                "09.07.24 в 18:00(мск)");

        boolean expected = true;
        boolean actual = meeting.matches("вебинар");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void isQueryTrueMeetingProject() {
        Task meeting = new Meeting(
                3,
                "Разборный вебинар",
                "Исключения, Интерфейсы, Generics и Collections Framework",
                "09.07.24 в 18:00(мск)");

        boolean expected = true;
        boolean actual = meeting.matches("Framework");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void isQueryFalseMeetingStart() {
        Task meeting = new Meeting(
                3,
                "Разборный вебинар",
                "Исключения, Интерфейсы, Generics и Collections Framework",
                "09.07.24 в 18:00(мск)");

        boolean expected = false;
        boolean actual = meeting.matches("09.07.24 в 18:00(мск)");

        Assertions.assertEquals(expected, actual);
    }
}
