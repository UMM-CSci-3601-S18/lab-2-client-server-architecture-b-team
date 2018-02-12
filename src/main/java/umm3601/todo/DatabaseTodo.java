package umm3601.todo;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class DatabaseTodo {

  private Todo[] allTodos;

  public DatabaseTodo(String todoDataFile) throws IOException {
    Gson gson = new Gson();
    FileReader reader = new FileReader(todoDataFile);
    allTodos = gson.fromJson(reader, Todo[].class);
  }

  /* Get single to-do specified by id
  * Else, return null */

  public Todo getTodo(String id) {
    return Arrays.stream(allTodos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
  }

/*Get an array of all the todos satisfying the queries in the params*/

  public Todo[] listTodos(Map<String, String[]> queryParams) {
    Todo[] filteredTodos = allTodos;

    //Filter by owner
    if(queryParams.containsKey("owner")) {
      String targetOwner = queryParams.get("owner")[0];
      filteredTodos = filterTodosByOwner(filteredTodos, targetOwner);
    }

    //Filter by completion status
    if(queryParams.containsKey("status")) {
      String targetStatus = queryParams.get("status")[0];
      filteredTodos = filterTodosByStatus(filteredTodos, targetStatus);
    }

    // Filter by category
    if(queryParams.containsKey("category")) {
      String targetCategory = queryParams.get("category")[0];
      filteredTodos = filterTodosByCategory(filteredTodos, targetCategory);
    }

    //Filter by contains
    if(queryParams.containsKey("contains")) {
      String targetContains = queryParams.get("contains")[0];
      filteredTodos = filterTodosByContains(filteredTodos, targetContains);
    }

    //limit # of responses
    if(queryParams.containsKey("limit")) {
      String targetNumber = queryParams.get("limit")[0];
      int targetInt = 301;
      try {
        targetInt = Integer.parseInt(targetNumber);
      }
      catch (Exception e) {
        e.printStackTrace();
        System.out.println("'limit' field's value could not be parsed into an integer.");
      }
      filteredTodos = limitTodos(targetInt, filteredTodos);
    }

    //Order by Tag
    if(queryParams.containsKey("orderBy")) {
      String targetOrderBy = queryParams.get("orderBy")[0];

      if(targetOrderBy.equals("id")){
        filteredTodos = OrderTodosById(filteredTodos);
      }
      else{
        if(targetOrderBy.equals("owner")){
          filteredTodos = OrderTodosByOwner(filteredTodos);
        }
        else{
          filteredTodos = OrderTodosByCategory(filteredTodos);
        }
      }

    }



    //More Filters here


    return filteredTodos;
  }

  /* Create an array of todos based on filter
  * Takes an array of todos and a filter param and returns an array of todos */

  private Todo[] limitTodos(int numberOfTodos, Todo[] todos) {
    return Arrays.copyOf(todos, numberOfTodos);
  }

  private Todo[] filterTodosByOwner(Todo[] todos, String targetOwner) {
    return Arrays.stream(todos).filter(x -> x.owner.equals(targetOwner)).toArray(Todo[]::new);
  }

  private Todo[] filterTodosByStatus(Todo[] todos, String targetStatus) {
    return Arrays.stream(todos).filter(x -> x.status.equals(targetStatus)).toArray(Todo[]::new);
  }

  private Todo[] filterTodosByID(Todo[] todos, String targetID) {
    return Arrays.stream(todos).filter(x -> x._id.equals(targetID)).toArray(Todo[]::new);
  }

  private Todo[] filterTodosByCategory(Todo[] todos, String targetCategory) {
    return Arrays.stream(todos).filter(x -> x.category.equals(targetCategory)).toArray(Todo[]::new);
  }

  private Todo[] filterTodosByContains(Todo[] todos, String targetContains) {
    return Arrays.stream(todos).filter(x -> x.body.contains(targetContains)).toArray(Todo[]::new);
  }


  private Todo[] OrderTodosById(Todo[] todos) {
    return Arrays.stream(todos).sorted(Comparator.comparing(Todo::getId)).toArray(Todo[]::new);
  }

  private Todo[] OrderTodosByOwner(Todo[] todos) {
    return Arrays.stream(todos).sorted(Comparator.comparing(Todo::getOwner)).toArray(Todo[]::new);
  }

  private Todo[] OrderTodosByCategory(Todo[] todos) {
    return Arrays.stream(todos).sorted(Comparator.comparing(Todo::getCategory)).toArray(Todo[]::new);
  }


}
