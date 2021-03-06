package umm3601.todo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import spark.Request;
import spark.Response;

import static umm3601.Util.*;

public class TodoController {
  private final Gson gson;
  private DatabaseTodo database;

  public TodoController(DatabaseTodo database) {
    gson = new Gson();
    this.database = database;
  }

  public JsonObject getTodo(Request req, Response res) {
    res.type("application/json");
    String id = req.params("id");
    id = id.replace("id=", "");
    Todo todo = database.getTodo(id);
    if (todo != null) {
      return buildSuccessJsonResponse("todo", gson.toJsonTree(todo));
    } else {
      String message = "Todo with ID " + id + " wasn't found.";
      return buildFailJsonResponse("id", message);
    }
  }

  public JsonObject getTodos(Request req, Response res) {
    res.type("application/json");
    Todo[] todos = database.listTodos(req.queryMap().toMap());
    if(todos != null) {
      return buildSuccessJsonResponse("todos", gson.toJsonTree(todos));
    }
    else {
      String message = "No todos matching the search criteria were found.";
      return buildFailJsonResponse("path", message);
    }
  }
}
