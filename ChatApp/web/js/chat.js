$(document).ready(function(){
    $('#statusWrapper').hide();
    $('.open-button').hide();
    $('#add-friend-area').hide();

    $('#friend-button').click(function(){
        $('#add-friend-area').toggle();
        $(this).text($(this).text() == 'New Friend' ? 'Cancel' : 'New Friend');
    });

    $('#changeStatusBtn').click(function () {
        $('#statusWrapper').toggle();
        $(this).text($(this).text() == 'Change Status' ? 'Cancel' : 'Change Status');
    });
});

/////// Chat functionality ///////

let receiver;

class Message {
    constructor(receiver, content) {
        this.receiver = receiver;
        this.content = content;
    }
}

function openChat(userId) {
    $('.open-button').show();
    $('.chat-title').text(userId);
    receiver = userId;
    getMessages(receiver);
    setInterval(getMessages, 1000);
}

function getMessages() {
    $.ajax({
        url: "Controller?action=Chat&receiver=" + receiver,
        method: "GET",
        success: function (result) {
            console.log(result);
            $( ".conversation" ).empty();
            for(let i = 0 ; i < result.length; i++){
                if (result[i].receiver === receiver) {
                    $('.conversation').append("<div class='sender'>"+ result[i].content +"</div>");
                } else {
                    $('.conversation').append("<div class='receiver'>"+ result[i].content +"</div>");
                }
            }
        }
    });
}

function sendMessage() {
    var content = $('.content').val()
    if (content){
        console.log(content);
        var message = new Message(receiver, content)
        var uri = "content=" + JSON.stringify(message);
        $.post("Controller?action=Chat", uri)
        $('.content').val('');
    }

}

function openForm() {
    document.getElementById("myForm").style.display = "block";
}

function closeForm() {
    document.getElementById("myForm").style.display = "none";
}






