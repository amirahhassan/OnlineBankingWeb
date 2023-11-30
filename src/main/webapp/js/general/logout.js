function logout(event){
    event.preventDefault();

    window.location.href="/"
}
document.getElementById("Logout").addEventListener("click", logout);
