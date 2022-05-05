<%@ page contentType="text/html;charset=UTF-8"
         language="java"
          pageEncoding="UTF-8" %>
<html>
<head>
    <title>Отправить сообщение</title>
</head>
<body>
<form action = <%=request.getContextPath() + "/api/message"%> method = "POST">
<fieldset>
    <legend>Отправить сообщение</legend>
    <label for="to">кому:<em>*</em></label>
    <input id="to" input type = "text" name = "to"><br>
    <label for="message">Введите текст сообщения</br></label>
    <textarea id="message" input type = "text" name = "message"></textarea>
</fieldset>
<input type = "submit" value = "Отправить" />
</form>

<%if(request.getParameter("mess") != null){
    response.getWriter().write(request.getParameter("mess"));
}%>
</body>
</html>
