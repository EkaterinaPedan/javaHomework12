import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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


    @Test
    public void shouldSearchInTodos() {
        SimpleTask simpleTask = new SimpleTask(1, "Изучить материал");

        String[] subtasks = {"Просмотреть лекции", "Законспектировать", "Изучить материал", "Выполнить задание"};
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Разборный вебинар",
                "Исключения, Интерфейсы, Generics и Collections Framework",
                "09.07.24 в 18:00(мск)");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Изучить материал");

        Todos todos = new Todos();

        todos.add(simpleTask);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search(simpleTask.getTitle());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInEpic() {
        String[] subtasks = {"Просмотреть лекции", "Законспектировать", "Изучить материал", "Выполнить задание"};
        Epic epic = new Epic(2, subtasks);

        Todos todos = new Todos();

        todos.add(epic);

        Task[] expected = {epic};
        Task[] actual = todos.search("лекции");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInMeetingTopic() {
        Meeting meeting = new Meeting(
                3,
                "Разборный вебинар",
                "Исключения, Интерфейсы, Generics и Collections Framework",
                "09.07.24 в 18:00(мск)");

        Todos todos = new Todos();

        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search(meeting.getTopic());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInMeetingProject() {
        Meeting meeting = new Meeting(
                3,
                "Разборный вебинар",
                "Исключения, Интерфейсы, Generics и Collections Framework",
                "09.07.24 в 18:00(мск)");

        Todos todos = new Todos();

        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search(meeting.getProject());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchInMeetingStart() {
        Meeting meeting = new Meeting(
                17,
                "Поиск ошибок в обновлении",
                "Планировщик задач",
                "в 9:00 утра по МСК");

        Todos todos = new Todos();

        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search(meeting.getStart());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInSimpleTaskAndEpic() {
        SimpleTask simpleTask = new SimpleTask(1, "Изучить материал");

        String[] subtasks = {"Просмотреть лекции", "Законспектировать", "Изучить материал", "Выполнить задание"};
        Epic epic = new Epic(2, subtasks);

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);


        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("Изучить материал");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInMeetingAndEpic() {
        String[] subtasks = {"Просмотреть вебинар", "Законспектировать", "Изучить материал", "Выполнить задание"};
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Разборный вебинар",
                "Исключения, Интерфейсы, Generics и Collections Framework",
                "09.07.24 в 18:00(мск)");

        Todos todos = new Todos();

        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic, meeting};
        Task[] actual = todos.search("вебинар");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetId() {
        String[] subtasks = {"Просмотреть лекции", "Законспектировать", "Изучить материал", "Выполнить задание"};
        Epic epic = new Epic(2, subtasks);

        Task task = new Task(2);

        int expected = epic.getId();
        int actual = task.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSubtasks() {
        String[] subtasks = {"Просмотреть лекции", "Законспектировать", "Изучить материал", "Выполнить задание"};
        Epic epic = new Epic(2, subtasks);

        String[] expected = subtasks;
        String[] actual = epic.getSubtasks();

        Assertions.assertArrayEquals(expected, actual);
    }
}
