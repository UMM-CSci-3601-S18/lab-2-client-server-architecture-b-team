package umm3601.user;

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
    Todo todo = db.getTodo("0"); // 0 is a placeholder
    //assertEquals("Incorrect Todo", todo.getOwner());
  }
}
