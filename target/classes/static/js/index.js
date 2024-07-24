var username = document.getElementById("username");
var password = document.getElementById("password");



function handleValidateUsername(){
    var valueUserName = username.value;
    var usernamePattern = /^[A-Z]+$/;
    console.log(valueUserName);
    if(usernamePattern.test(valueUserName)){
        return true;
    }
    else {
        return false;
    }
}

username.addEventListener("change", ()=> {
    if(!handleValidateUsername()){
        alert("sai định dạng tên username chỉ được viết hoa hết tất cả");
        username.value = "";
    }
})
