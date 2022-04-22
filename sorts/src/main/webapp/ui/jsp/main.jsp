<%@ page language="java"
contentType="text/html;charset=UTF-8"
 pageEncoding="UTF-8"%>

<h1><%if(request.getParameter("who") != null){
response.getWriter().write(request.getParameter("who") + ", ");
}%>добро пожаловать в убогий мессенджер
    <%if(request.getParameter("reg") != null){
    response.getWriter().write(request.getParameter("reg"));
}%>
    <%if(request.getParameter("mess") != null){
        response.getWriter().write(request.getParameter("mess"));
    }%></h1>

<a href=<%= request.getContextPath() + "/ui/signUp"%>>Регистрация</a></br>
<a href=<%= request.getContextPath() + "/ui/signIn"%>>Вход в систему</a></br>
<a href=<%= request.getContextPath() + "/ui/user/message"%>>отправить мессагу</a></br>
<a href=<%= request.getContextPath() + "/ui/user/chats"%>>получить мессаги</a></br>
<a href=<%= request.getContextPath() + "/ui/admin/statistics"%>>что-то для админа</a>