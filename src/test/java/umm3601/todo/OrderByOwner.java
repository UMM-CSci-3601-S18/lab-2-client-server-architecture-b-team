package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class OrderByOwner {
  @Test
  public void orderByOwner() throws IOException {
    DatabaseTodo db = new DatabaseTodo("src/main/data/todos.json");
    Todo[] todos = db.listTodos(new HashMap<>());
    todos = db.orderTodosByOwner(todos);
    assertTrue(0 >= (todos[0].owner).compareTo(todos[1].owner));
  }
}
