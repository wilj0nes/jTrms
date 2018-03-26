window.onload = function () {
    document.getElementById("submit").addEventListener("click", submitData);
    document.getElementById("logout").addEventListener("click", logout);
    getUser();
};

var user, requests, allRequests;

function getUser(){
    console.log("getUser()");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if(xhr.readyState === 4 && xhr.status === 200){
            user = JSON.parse(xhr.responseText);
            console.log(user);
            setData();
        }
    };

    xhr.open("POST", "/trms", true);
    xhr.send();
}


function setData() {
    document.getElementById("title").innerText = user.firstName;
    document.getElementById("header-title").innerText = user.firstName + " " + user.lastName;

    // Auto fill user details
    document.getElementById("email").value = user.email;
    document.getElementById("firstname").value = user.firstName;
    document.getElementById("lastname").value = user.lastName;

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if(xhr.readyState === 4 && xhr.status === 200){
            requests = JSON.parse(xhr.responseText);
            console.log(requests);
            populateTables("table-body-personal", requests); // this populates personal requests
        }
    };
    xhr.open("GET", "/trms", true);
    xhr.send();

    if(user.type === 2){
        document.getElementById("scroll-tab-2").style.display = "none";
        document.getElementById("all-requests").style.display = "none";
    }
    else{
        getAllRequests();
    }
}

// TODO make new Servlet for returning ALL requests
function getAllRequests(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if(xhr.readyState === 4 && xhr.status === 200){
            allRequests = JSON.parse(xhr.responseText);
            console.log(allRequests);
            populateTables("table-body-all", allRequests); // this populates personal requests
        }
    };
    xhr.open("GET", "/request", true);
    xhr.send();
}

function populateTables(tableId, list){

    for(var i = 0; i < list.length; i++){

        var tableBody = document.getElementById(tableId);
        var row = tableBody.insertRow(-1);

            // Request ID
            var id = row.insertCell(-1);
            id.innerHTML = list[i].id;

            // Date created
            var date = row.insertCell(-1);
            date.innerHTML = undefined;

            // Cost
            var cost = row.insertCell(-1);
            cost.innerHTML = String(list[i].cost);

            // description
            var description = row.insertCell(-1);
            description.innerHTML = list[i].description;

            // address
            var address = row.insertCell(-1);
            address.innerHTML = String(list[i].address);

            // city
            var city = row.insertCell(-1);
            city.innerHTML = list[i].city;

            // state
            var state = row.insertCell(-1);
            state.innerHTML = list[i].state;

            // zip
            var zip = row.insertCell(-1);
            zip.innerHTML = String(list[i].zip);

            // grading format
            var gradingFormat = row.insertCell(-1);
            gradingFormat.innerHTML = String(list[i].format);

            // justification
            var justification = row.insertCell(-1);
            justification.innerHTML = String(list[i].justification);

            // status
            var status = row.insertCell(-1);
            status.innerHTML = list[i].status;

            // request type
            var type = row.insertCell(-1);
            type.innerHTML = list[i].type;
    }
}


function submitData() {
    console.log("submitData()");

    window.location.replace("trms.html");
    document.getElementById("table-body-all").innerHTML = "";
    document.getElementById("table-body-personal").innerHTML = "";
    requests = null;
    allRequests = null;

    setData();
    getAllRequests();

    //populateTables("table-body-all"); // this populates personal requests
    //populateTables("table-body-personal");
}

function logout(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if(xhr.readyState === 4 && xhr.status === 200){
            console.log("Logging out");
            user = undefined;
            window.location.replace("index.html");
        }
    }
    xhr.open("GET", "/logout", true);
    xhr.send();
}
