package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class FilterByOwnerStatusContains {
  @Test
  public void filterOSCo() throws IOException{
    DatabaseTodo db = new DatabaseTodo("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] returnedTodos = db.filterTodosByOwner(allTodos, "Workman");
    Todo[] returnedTodos2 = db.filterTodosByStatus(returnedTodos, "true");
    Todo[] returnedTodos3 = db.filterTodosByContains(returnedTodos2, "sit n");
    assertEquals("Not expected number of todos.", 2, returnedTodos3.length);
  }
}
