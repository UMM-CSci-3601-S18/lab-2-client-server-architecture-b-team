package umm3601.user;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

public class ReturnAllToDos {
  @Test
  public void returnAllTodos() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    User[] allUsers = db.listUsers(new HashMap<>());

  }
}
