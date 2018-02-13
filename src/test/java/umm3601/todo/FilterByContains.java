package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class FilterByContains {
  @Test
  public void filterContains() throws IOException{
    DatabaseTodo db = new DatabaseTodo("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] returnedTodos = db.filterTodosByContains(allTodos, "sunt ad");
    assertEquals("Not expected number of todos.", 5, returnedTodos.length);
  }
}
