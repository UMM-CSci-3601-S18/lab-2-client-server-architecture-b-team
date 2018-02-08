function getAllTodos() {
  console.log("Getting all the todos.");

  var HttpClient = new HttpClient();
  HttpClient.get("/api/todos", function(returned_json){
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}
