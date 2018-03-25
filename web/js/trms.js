window.onload = function () {
    document.getElementById("submit").addEventListener("click", submitData);
    document.getElementById("logout").addEventListener("click", logout);
    getUser();
};

var user, requests;

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
    //document.getElementById("user-id").value = user.userID;
    document.getElementById("firstname").value = user.firstName;
    document.getElementById("lastname").value = user.lastName;

    if(user.type === 2){
        document.getElementById("scroll-tab-2").style.display = "none";
        document.getElementById("all-requests").style.display = "none";
    }

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if(xhr.readyState === 4 && xhr.status === 200){
            requests = JSON.parse(xhr.responseText);
            console.log(requests);
        }
    }
    xhr.open("GET", "/trms", true);
    xhr.send();
}

function submitData() {
    console.log("submitData()");

    window.location.replace("trms.html");

    var email = document.getElementById("email").value;
    var firstName = document.getElementById("firstname").value;
    var lastName = document.getElementById("lastname").value;
    var address = document.getElementById("address").value;
    var city = document.getElementById("city").value;
    var state = document.getElementById("state").value;
    var zip = document.getElementById("zip").value;
    var description = document.getElementById("description").value;
    var dateAndTime = document.getElementById("date-time").value;
    var cost = document.getElementById("cost").value;
    var gradingFormat = document.getElementById("grading-format").value;
    var eventType = document.getElementById("event-type").value;
    var justification = document.getElementById("justification").value;

    // var newRequest = {
    //     email: email,
    //     firstName: firstName,
    //     lastName: lastName,
    //     address: address,
    //     city: city,
    //     state: state,
    //     zip: zip,
    //     description: description,
    //     dateAndTime: dateAndTime,
    //     cost: cost,
    //     gradingFormat: gradingFormat,
    //     eventType: eventType,
    //     justification: justification
    // };
    // var xhr = new XMLHttpRequest();
    // xhr.onreadystatechange = function () {
    //     if(xhr.readyState === 4 && xhr.status === 200){
    //         console.log(xhr.responseText);
    //     }
    // };
    //
    // xhr.open("POST", "/request", true);
    // xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    // xhr.send("request=" + JSON.stringify(newRequest));
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
