package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class OrderByBody {
  @Test
  public void orderByBody() throws IOException {
    DatabaseTodo db = new DatabaseTodo("src/main/data/todos.json");
    Todo[] todos = db.listTodos(new HashMap<>());
    todos = db.orderTodosByBody(todos);
    assertTrue(0 >= (todos[0].body).compareTo(todos[1].body));
  }
}
