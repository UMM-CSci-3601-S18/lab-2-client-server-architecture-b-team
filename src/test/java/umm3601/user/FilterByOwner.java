package umm3601.user;

import org.junit.Test;
import umm3601.todo.DatabaseTodo;
import umm3601.todo.Todo;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class FilterByOwner {
  @Test
  public void filterOwner() throws IOException{
    DatabaseTodo db = new DatabaseTodo("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] returnedTodos = db.filterTodosByOwner(allTodos, "Fry");
    assertEquals("Not expected number of todos.", 61, returnedTodos.length);
  }
}
