package umm3601.todo;

import org.junit.Test;
import umm3601.todo.DatabaseTodo;
import umm3601.todo.Todo;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ReturnAllToDos {
  @Test
  public void returnAllTodos() throws IOException {
    DatabaseTodo db = new DatabaseTodo("src/main/data/todos.json");
    Todo[] todos = db.listTodos(new HashMap<>());
    assertEquals("Not expected number of todos.", 300, todos.length);
    //assertEquals("Expected trait not present: id", todos[0]);
  }
}
