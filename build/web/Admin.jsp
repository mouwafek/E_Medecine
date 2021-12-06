<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Message</title>
    </head>
    <body>
        Aujourd'huit est : <%
        String jour  = (String) request.getAttribute("jour");
        out.println(jour);
        %>
        
        test hfml : <%
        String hfml  = (String) request.getAttribute("hfml");
        out.println(hfml);
        %>
        <form action="/E_Medecine/AjoutSpec" method="post">
            spec : <input type="text" name="spec" >
            <input type="submit" value="ajout">
        </form>
        <form action="/E_Medecine/TestDate" method="post">
            date : 
            <input placeholder="Date nais" type="date" id="example" class="form-control" name="d" required="">
            <input name="hfml" type="time">
            <input type="submit" value="Verif">
        </form>
    </body>
</html>