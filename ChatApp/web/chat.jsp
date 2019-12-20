<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="css/sample.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript" src="js/status.js"></script>
<script type="text/javascript" src="js/friends.js"></script>
<script type="text/javascript" src="js/chat.js"></script>
<jsp:include page="head.jsp">
        <jsp:param name="title" value="Chat" />
    </jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Chat" />
</jsp:include>
<main>
    <div id="currentStatus">${status}</div>

    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody id="friends-table-body">

        </tbody>
    </table>

    <button id="changeStatusBtn">Change Status</button>
    <div id="statusWrapper">
        <select id="status" onchange="setStatus(this.options[this.selectedIndex].value)">
            <option id="Online">Online</option>
            <option id="Away">Away</option>
            <option id="Offline">Offline</option>
        </select>
        <br>
        <input type="text" id="customStatus">
        <button id="statusbtn" onclick="setStatus(document.getElementById('customStatus').value)">Use custom status</button>
    </div>
    <br><br>

    <button id="friend-button">New Friend</button>
    <br><br>
    <div id="add-friend-area">
        <p>
            <label for="emailFriend">e-mailadres</label>
            <input type="text" id="emailFriend">
        </p>
        <button onclick="addFriend(document.getElementById('emailFriend'))">Add friend</button>
    </div>

    <button class="open-button chat-title" onclick="openForm()">Chat</button>

    <div class="chat-popup" id="myForm">
        <form class="form-container">
            <h1 class="chat-title">Chat</h1>
            <div class="conversation">
                <%--  chat-berichten  --%>
            </div>
            <label for="msg"><b>Message</b></label>
            <textarea class="content" placeholder="Type message.." id="msg" required></textarea>

            <button type="button" class="btn" onclick="sendMessage()">Send</button>
            <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
        </form>
    </div>

</main>
</body>
</html>
