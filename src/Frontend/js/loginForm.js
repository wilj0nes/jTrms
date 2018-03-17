function post(){

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        console.log(xhr.readyState);

        if(xhr.readyState === 4 && xhr.status === 200){
            console.log(xhr.responseText);

        }

    }

}



window.onload = function () {
    console.log("loaded");

    var submit = document.getElementById("submit");
    var email = document.getElementById("email");
    var password = document.getElementById("password");

    submit.addEventListener("click", function(){
        console.log("email: " + email.value + ", Password: " + password.value);
    });

};
