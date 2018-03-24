var string, email, pass;

var user = {
    userID: null,
    firstName: null,
    lastName: null,
    funds: null,
    userType: null,
    email: null,
    password: null
};

function post(){

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        //console.log("ready state: " + xhr.readyState);
        //console.log("status: " + xhr.status);

        if(xhr.readyState === 4 && xhr.status === 200){
            console.log("response text: " + xhr.responseText);
            //getData();
        }
    };

    xhr.open("POST", "/s", true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send("LoginPOJO=" + JSON.stringify({emailInput:email, passInput:pass}));
}

function getData(){
    email = document.getElementById("email").value;
    pass = document.getElementById("password").value;
    //string = "[email: " + email + ", Password: " + email + "]";
    //console.log(string);
    post();
}


window.onload = function () {
    document.getElementById("myButton").addEventListener("click", getData);
};
