package umm3601.todo;

import org.junit.Test;
import umm3601.todo.DatabaseTodo;
import umm3601.todo.Todo;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class FilterByCompleteness {
  @Test
  public void filterCompleteness() throws IOException {
    DatabaseTodo db = new DatabaseTodo("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] returnedTodos = db.filterTodosByStatus(allTodos, "true");
    for(int i = 0; i < returnedTodos.length; i++) {
      assertEquals("Got an incorrect todo, on iteration " + i, "true", returnedTodos[i].getStatus());
    }
  }
}
