function getAllTodos() {
  console.log("Getting all the todos.");

  var HttpThing = new HttpClient();
  HttpThing.get("/api/todos", function(returned_json){
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getTodoByID() {
  console.log("Getting a todo by id.");

  var HttpThing = new HttpClient();
  HttpThing.get("/api/todos/" +  document.getElementById("id").value, function(returned_json){
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getTodosByOwner() {
  console.log("Getting a todos by owner.");

  var HttpThing = new HttpClient();
  HttpThing.get("/api/todos?owner=" +  document.getElementById("owner").value, function(returned_json){
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getTodosByFilter() {
  console.log("Getting a todos by owner.");

  var HttpThing = new HttpClient();
  var Status = new String

  if(document.getElementById("CheckStatus").checked === true) {
    if (document.getElementById("RadioComplete").checked === true) {
      Status = "&status=true";
    }
    else {
      Status = "&status=false"
    }
  }
  else{
    Status = ""
  }

  HttpThing.get("/api/todos?owner=" +  document.getElementById("owner").value
    + "&category=" + document.getElementById("category").value
    + "&limit=" + document.getElementById("limit").value
    + Status



    , function(returned_json){
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}




function HttpClient() {
  // We'll take a URL string, and a callback function.
  this.get = function (aUrl, aCallback) {
    var anHttpRequest = new XMLHttpRequest();

    // Set a callback to be called when the ready state of our request changes.
    anHttpRequest.onreadystatechange = function () {

      /**
       * Only call our 'aCallback' function if the ready state is 'DONE' and
       * the request status is 200 ('OK')
       *
       * See https://httpstatuses.com/ for HTTP status codes
       * See https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest/readyState
       *  for XMLHttpRequest ready state documentation.
       *
       */
      if (anHttpRequest.readyState === 4 && anHttpRequest.status === 200)
        aCallback(anHttpRequest.responseText);
    };

    anHttpRequest.open("GET", aUrl, true);
    anHttpRequest.send(null);
  }
}
