var xhr = new XMLHttpRequest();
window.onload = function () {
    getPeople();
}

function getPeople(){
    xhr.open("POST", "Controller?action=GetFriends", true);
    xhr.onreadystatechange = getDataPeople;
    xhr.send(null);
    setTimeout(getPeople, 2000);
}

function getDataPeople () {
    if (xhr.status == 200) {
        if (xhr.readyState == 4) {
            var serverResponse = JSON.parse(xhr.responseText);
            var tbody = document.getElementById('friends-table-body');
            while(tbody.hasChildNodes()) {
                tbody.removeChild(tbody.firstChild);
            }
            for(var friend in serverResponse) {
                var row = tbody.insertRow(-1);
                var cell1 = row.insertCell(0);
                var cell2 = row.insertCell(1);
                var cell3 = row.insertCell(2);
                cell1.innerHTML = serverResponse[friend].firstName;
                cell2.innerHTML = serverResponse[friend].status;
                cell3.innerHTML = '<button class="startChatBtn" id="' + serverResponse[friend].userId + '" onclick="openChat(\'' + serverResponse[friend].userId + '\')">Message</button>'
                console.log(cell3.innerHTML);
            }
            xhr.abort();
        }
    }
}
function addFriend(friendId){
    xhr.open("POST", "Controller?action=AddFriend&friendId=" + friendId.value, true);
    //xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.onreadystatechange = getDataPeople;
    xhr.send(null);
    friendId.value = '';
}

