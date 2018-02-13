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
  console.log("Getting todos by owner.");

  var HttpThing = new HttpClient();
  HttpThing.get("/api/todos?owner=" +  document.getElementById("owner").value, function(returned_json){
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getTodosByFilter() {
  console.log("Getting todos by filter.");

  var HttpThing = new HttpClient();

  /* variables used to determine if a filter should be used */
  var Limit = String;
  var Owner = String;
  var Status = String;
  var Contains = String;
  var Category = String;
  var Order = String;


  /* if statements determine whether a filter should be used and what value it should have */

  //Limit
  if(document.getElementById("limit").value === "" || document.getElementById("limit").value === "0") {
    Limit = "";
  }
  else{
    Limit = "&limit=" + document.getElementById("limit").value;
  }

  //owner
  if(document.getElementById("owner").value === "") {
    Owner = "";
  }
  else{
    Owner = "&owner=" + document.getElementById("owner").value;
  }

  //status
  if(document.getElementById("CheckStatus").checked === true) {
    if (document.getElementById("RadioComplete").checked === true) {
      Status = "&status=true";
    }
    else {
      Status = "&status=false";
    }
  }
  else{
    Status = "";
  }

  //contains
  if(document.getElementById("contains").value === "") {
    Contains = "";
  }
  else{
    Contains = "&contains=" + document.getElementById("contains").value;
  }

  //category
  if(document.getElementById("category").value === "") {
    Category = "";
  }
  else{
    Category = "&category=" + document.getElementById("category").value;
  }

  //order
  if(document.getElementById("CheckOrder").checked === true) {
    if (document.getElementById("RO_Id").checked === true) {
      Order = "&orderBy=id";
    }
    else {
      if(document.getElementById("RO_Owner").checked === true){
      Order = "&orderBy=owner";
      }
      else {
        if(document.getElementById("RO_Category").checked === true){
        Order = "&orderBy=category"
        }
        else{
          if(document.getElementById("RO_Status").checked === true){
            Order = "&orderBy=status"
          }
          else {
            Order = "&orderBy=body"
          }
        }
      }
    }
  }
  else{
    Order = "";
  }

    HttpThing.get("/api/todos?"
      + Limit
      + Owner
      + Status
      + Category
      + Order
      + Contains

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
