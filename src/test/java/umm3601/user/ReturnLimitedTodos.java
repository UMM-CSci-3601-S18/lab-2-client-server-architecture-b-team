package umm3601.user;
import org.junit.Test;
import umm3601.todo.DatabaseTodo;
import umm3601.todo.Todo;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ReturnLimitedTodos {
  @Test
  public void returnLimitedTodos() throws IOException {
    DatabaseTodo db = new DatabaseTodo("src/main/data/todos.json");
    Todo[] returnedTodos = db.limitTodos(10, db.listTodos(new HashMap<>()));
    assertEquals("Incorrect number of returned todos.", 10, returnedTodos.length);
  }
}
