
var string;

function getData(){
    var email = document.getElementById("email");
    var password = document.getElementById("password");
    string = "[email: " + email.value + ", Password: " + password.value + "]";
}

function post(){
    console.log(string);
    // document.getElementById("myButton").addEventListener("click", post(), false);

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        //console.log("ready state: " + xhr.readyState);
        //console.log("status: " + xhr.status);

        if(xhr.readyState === 4 && xhr.status === 200){
            console.log("somethingit ag");
            console.log(xhr.responseText);
            getData();
        }

    };

    xhr.open("GET", "/s", true);
    xhr.send("Send me");
}



window.onload = function () {
    document.getElementById("myButton").addEventListener("click", post());
};
