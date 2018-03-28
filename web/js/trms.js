var user, requests;

window.onload = function () {
    document.getElementById("submit").addEventListener("click", submitData);
    document.getElementById("logout").addEventListener("click", logout);
    getUser();
};


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
    document.getElementById("title").innerText = user.firstName + " " + user.lastName;
    document.getElementById("header-title").innerText = "Hello, " + user.firstName;

    // Auto-fill user details
    document.getElementById("email").value = user.email;
    document.getElementById("firstname").value = user.firstName;
    document.getElementById("lastname").value = user.lastName;

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if(xhr.readyState === 4 && xhr.status === 200){
            requests = JSON.parse(xhr.responseText);
            if(requests !== null){
                console.log(requests);
                populateTables("table-body-personal", requests, false); // this populates personal requests
                populateTables("table-body-all", requests, true);
            }
            else{
                console.log("can't find requests for this user");
            }
        }
    };
    xhr.open("GET", "/trms", true);
    xhr.send();

    if(user.type === 2){
        document.getElementById("scroll-tab-2").style.display = "none";
        document.getElementById("all-requests").style.display = "none";
    }
}

// function getAllRequests(){
//     console.log("getAllRequests()");
//     var xhr = new XMLHttpRequest();
//     xhr.onreadystatechange = function () {
//         if(xhr.readyState === 4 && xhr.status === 200){
//             allRequests = JSON.parse(xhr.responseText);
//             if(allRequests !== null){
//                 console.log(allRequests);
//                 populateTables("table-body-all", allRequests); // this populates personal requests
//             }
//             else{
//                 console.log("can't find allRequests");
//             }
//         }
//     };
//     xhr.open("POST", "/requestAll", true);
//     xhr.send();
// }

function populateTables(tableId, requests, personalize){

    //console.log("--> " + tableId);

    for(var i = 0; i < requests.length; i++){


        if(personalize || requests[i].ownerID === user.id){

            var tableBody = document.getElementById(tableId);
            var row = tableBody.insertRow(-1);

                // Request ID
                var id = row.insertCell(-1);
                id.innerHTML = requests[i].id;


                // Date created
                var date = row.insertCell(-1);
                date.innerHTML = undefined;

                // Cost
                var cost = row.insertCell(-1);
                cost.innerHTML = String(requests[i].cost);

                // description
                var description = row.insertCell(-1);
                description.innerHTML = requests[i].description;

                // address
                var address = row.insertCell(-1);
                address.innerHTML = String(requests[i].address);

                // city
                var city = row.insertCell(-1);
                city.innerHTML = requests[i].city;

                // state
                var state = row.insertCell(-1);
                state.innerHTML = requests[i].state;

                // zip
                var zip = row.insertCell(-1);
                zip.innerHTML = String(requests[i].zip);

                // grading format
                var gradingFormat = row.insertCell(-1);
                gradingFormat.innerHTML = String(requests[i].format);

                // justification
                var justification = row.insertCell(-1);
                justification.innerHTML = String(requests[i].justification);

                // status
                var status = row.insertCell(-1);
                status.innerHTML = requests[i].status;
                if(status.innerHTML === "pending"){
                    status.style.backgroundColor = "yellow";
                }
                else if (status.innerHTML === "rejected"){
                    status.style.backgroundColor = "red";
                }
                else if(status.innerHTML === "approved"){
                    status.style.backgroundColor = "green";
                }

                // request type
                var type = row.insertCell(-1);
                type.innerHTML = requests[i].type;

            row.className = requests[i].id;
            row = document.addEventListener("click", editRequest(row.className), true);
        }

    }
}

function editRequest(id){
    console.log("Edit request --> " + id);
}


function submitData() {
    console.log("submitData()");

    window.location.replace("trms.html");
    document.getElementById("table-body-all").innerHTML = "";
    document.getElementById("table-body-personal").innerHTML = "";
    requests = null;

    setData();
    if(user.type !== 2){
        //getAllRequests();
    }
}

function logout(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if(xhr.readyState === 4 && xhr.status === 200){
            console.log("Logging out...");
            // user = null;
            // requests = null;
            // allRequests = null;
            window.location.replace("index.html");
        }
    }
    xhr.open("GET", "/logout", true);
    xhr.send();
}
