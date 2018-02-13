package umm3601.todo;

import org.junit.Test;
import umm3601.todo.DatabaseTodo;
import umm3601.todo.Todo;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ReturnToDosByID {
  @Test
  public void returnTodoByID() throws IOException{
    DatabaseTodo db = new DatabaseTodo("src/main/data/todos.json");
    Todo todo = db.getTodo("58895985c1849992336c219b");
    assertEquals("Incorrect Todo", "Fry", todo.getOwner());
  }
}
