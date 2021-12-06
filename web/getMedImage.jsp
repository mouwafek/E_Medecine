<%@page import="java.sql.Blob"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
    //Infos de connexion
    String connectionURL = "jdbc:mysql://localhost:3306/medec";
    String user = "root";
    String pass = "";

    Connection con = null;
    
    //Récupération de l'identifiant de l'image
    String id = request.getParameter("id");
    try {
        //Connexion au BD
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(connectionURL, user, pass);
        
        //Exécution de la requette de recherche selon id
        PreparedStatement ps = con.prepareStatement("select * from medicament where ID_MED=?");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            //Récupération du blob de l'image
            Blob blob = rs.getBlob("PHOTO_MED");
            //Convertion du blob en array of bytes
            byte byteArray[] = blob.getBytes(1, (int) blob.length());
            //Convertion du type d'apparition en image de type gif
            response.setContentType("image/gif");
            OutputStream os = response.getOutputStream();
            os.write(byteArray);
            os.flush();
            os.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
%>