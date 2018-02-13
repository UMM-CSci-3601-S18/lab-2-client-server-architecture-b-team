package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class FilterByCategory {
  @Test
  public void filterCategory() throws IOException{
    DatabaseTodo db = new DatabaseTodo("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] returnedTodos = db.filterTodosByCategory(allTodos, "homework");
    assertEquals("Not expected number of todos.", 79, returnedTodos.length);
  }
}
