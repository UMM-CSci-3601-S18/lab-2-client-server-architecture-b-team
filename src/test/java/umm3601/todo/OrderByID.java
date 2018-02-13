package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class OrderByID {
  @Test
  public void orderByID() throws IOException {
    DatabaseTodo db = new DatabaseTodo("src/main/data/todos.json");
    Todo[] todos = db.listTodos(new HashMap<>());
    todos = db.orderTodosById(todos);
    assertTrue(0 > (todos[0]._id).compareTo(todos[1]._id));
  }
}
