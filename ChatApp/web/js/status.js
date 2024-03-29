var xhr = new XMLHttpRequest();
window.onload= function () {
    getStatus();
}

function getStatus() {
    xhr.open("GET", "Controller?action=GetUserFromSession", true);
    //alert("getStatus called!!");
    xhr.onreadystatechange = getStatusData;
    xhr.send(null);
}

function setStatus(status){
    if(xhr.responseText !== "Online" || xhr.responseText !== "Away" || xhr.responseText !== "Offline") {
        document.getElementById("customStatus").text = status;
    }
    xhr.open("POST", "Controller?action=ChangeStatus&status=" + status, true);
    xhr.onreadystatechange = getData;
    xhr.send();
}

function getData () {
    console.log(xhr.status);
    console.log("responsetext: " + xhr.responseText)
    if (xhr.status == 200) {
        console.log(xhr.readyState);
        if (xhr.readyState == 4) {
            document.getElementById("currentStatus").innerHTML = xhr.responseText;
        }
    }
}

