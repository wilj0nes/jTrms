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
        if(xhr.readyState === 4 && xhr.status === 200){
            if(xhr.responseText === "invalid"){
                console.log("invalid login")
                document.getElementById("email").value = "";
                document.getElementById("password").value = "";
            }
            else{
                console.log(xhr.responseText);
                window.location.replace('trms.html');
                setUserInfo(xhr.responseText);
            }
        }
    };

    xhr.open("POST", "/login", true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send("LoginPOJO=" + JSON.stringify({emailInput:email, passInput:pass}));
}

function getData(){
    email = document.getElementById("email").value;
    pass = document.getElementById("password").value;
    post();
}

function setUserInfo(responseText){

    var u = JSON.parse(responseText);
    console.log(u);
    document.getElementById("header").value = "asdf";

}


window.onload = function () {
    document.getElementById("myButton").addEventListener("click", getData);
};
