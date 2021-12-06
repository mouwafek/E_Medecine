<%-- 
    Document   : mesRendVPatient
    Created on : 5 juin 2020, 22:54:21
    Author     : mou
--%>

<%@page import="com.e_medecine.entities.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        if(session.getAttribute("patient") != null)
        {
        %>
        rndv expire////rndv à venir
        <%
        Patient p = (Patient) session.getAttribute("patient");
        %>
        Vous etes né le <%=p.getDateNaisPat()%>
        <%
        }
        else
        this.getServletContext().getRequestDispatcher("/loginPatient.jsp").forward(request, response);
        %>
        <br>
        <br>
        <br>
        <br>
        
    </body>
</html>
