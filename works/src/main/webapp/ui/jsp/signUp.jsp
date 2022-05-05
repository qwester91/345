<%@ page language="java"
contentType="text/html;charset=UTF-8"
 pageEncoding="UTF-8"%>

<h1>Скажи мне кто ты, и я скажу тебе кто твой друг </h1>
      <form action = <%=request.getContextPath() + "/api/user"%> method = "POST">
         Login:      <input type = "text" name = "login">
         <br /><br />
         Password:      <input type = "text" name = "password">
         <br /><br />
         Name:       <input type = "text" name = "name">
         <br /><br />
         Date Of Birth:     <input type = "date" name = "dateOfBirth"/>
         <br /><br />
         <input type = "submit" value = "Создать Пользователя" />
      </form>

      <%if(request.getParameter("err") != null){
          response.getWriter().write(request.getParameter("err"));
          }%>



