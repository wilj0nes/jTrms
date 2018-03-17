window.onload = function () {
    console.log("loaded");

    var submit = document.getElementById("submit");
    var firstName = document.getElementById("firstname");
    var lastName = document.getElementById("lastname");

    submit.addEventListener("click", function(){
        console.log(firstName.value);
    });

};
