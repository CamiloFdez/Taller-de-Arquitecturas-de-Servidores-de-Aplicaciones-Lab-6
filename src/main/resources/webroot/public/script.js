console.log("AREP Microframework loaded successfully 🚀");

function goHello() {
    const name = document.getElementById("nameInput").value;

    if (!name) {
        alert("Please enter a name");
        return;
    }

    window.location.href = `/App/hello?name=${encodeURIComponent(name)}`;
}