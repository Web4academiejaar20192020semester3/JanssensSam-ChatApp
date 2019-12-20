<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<jsp:include page="head.jsp">
        <jsp:param name="title" value="Home" />
    </jsp:include>
<script type="text/javascript" src="js/blog.js"></script>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Blog" />
</jsp:include>
<main>
    <div class="topic">
        <h3>Projectweek</h3>
        <p>"Was het een interessante projectweek?"</p>
        <br>
        <p>comments:</p>
        <div id="messages1"></div>
        <div class="topicInputFields">
            <h5>Name</h5>
            <input type="text" id="nameinput1"/>
            <br>
            <h5>Rating (../10)</h5>
            <input type="text" id="ratinginput1"/>
            <br>
            <h5>Comment</h5>
            <input type="text" id="messageinput1"/>
        </div>
        <button class="send-button" type="button" onclick="send(1);" >Send</button>
    </div>
    <div class="topic">
        <h3>Plannen voor vandaag</h3>
        <p>Wat zijn jouw plannen voor vandaag?</p>
        <br>
        <div id="messages2"></div>
        <div class="topicInputFields">
            <h5>Name</h5>
            <input type="text" id="nameinput2"/>
            <br>
            <h5>Rating (../10)</h5>
            <input type="text" id="ratinginput2"/>
            <br>
            <h5>Comment</h5>
            <input type="text" id="messageinput2"/>
        </div>
        <button class="send-button" type="button" onclick="send(2);" >Send</button>
    </div>
    <div class="topic">
        <h3>Muziek</h3>
        <p>Naar welke muziek ben je momenteel an het luisteren?</p>
        <br>
        <div id="messages3"></div>
        <div class="topicInputFields">
            <h5>Name</h5>
            <input type="text" id="nameinput3"/>
            <br>
            <h5>Rating (../10)</h5>
            <input type="text" id="ratinginput3"/>
            <br>
            <h5>Comment</h5>
            <input type="text" id="messageinput3"/>
        </div>
        <button class="send-button" type="button" onclick="send(3);" >Send</button>
    </div>
    <div class="topic">
        <h3>Examenvragen</h3>
        <p>Wat zijn de examenvragen voor het vak web4?</p>
        <br>
        <div id="messages4"></div>
        <div class="topicInputFields">
            <h5>Name</h5>
            <input type="text" id="nameinput4"/>
            <br>
            <h5>Rating (../10)</h5>
            <input type="text" id="ratinginput4"/>
            <br>
            <h5>Comment</h5>
            <input type="text" id="messageinput4"/>
        </div>
        <button class="send-button" type="button" onclick="send(4);" >Send</button>
    </div>
    <div class="topic">
        <h3>Kerstversiering</h3>
        <p>Welke kleur heeft de versiering in jouw kerstboom?</p>
        <br>
        <div id="messages5"></div>
        <div class="topicInputFields">
            <h5>Name</h5>
            <input type="text" id="nameinput5"/>
            <br>
            <h5>Rating (../10)</h5>
            <input type="text" id="ratinginput5"/>
            <br>
            <h5>Comment</h5>
            <input type="text" id="messageinput5"/>
        </div>
        <button class="send-button" type="button" onclick="send(5);" >Send</button>
    </div>
    <div class="topic">
        <h3>Kerstversiering</h3>
        <p>Welke kleur heeft de versiering in jouw kerstboom?</p>
        <br>
        <div id="messages6"></div>
        <div class="topicInputFields">
            <h5>Name</h5>
            <input type="text" id="nameinput6"/>
            <br>
            <h5>Rating (../10)</h5>
            <input type="text" id="ratinginput6"/>
            <br>
            <h5>Comment</h5>
            <input type="text" id="messageinput6"/>
        </div>
        <button class="send-button" type="button" onclick="send(6);" >Send</button>
    </div>
    <div class="topic">
        <h3>Kerstversiering</h3>
        <p>Welke kleur heeft de versiering in jouw kerstboom?</p>
        <br>
        <div id="messages7"></div>
        <div class="topicInputFields">
            <h5>Name</h5>
            <input type="text" id="nameinput7"/>
            <br>
            <h5>Rating (../10)</h5>
            <input type="text" id="ratinginput7"/>
            <br>
            <h5>Comment</h5>
            <input type="text" id="messageinput7"/>
        </div>
        <button class="send-button" type="button" onclick="send(7);" >Send</button>
    </div>
</main>
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
</body>
</html>