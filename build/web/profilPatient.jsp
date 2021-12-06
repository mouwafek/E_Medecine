<%-- 
    Document   : profilPatient
    Created on : 9 juin 2020, 15:05:54
    Author     : mou
--%>

<%@page import="com.e_medecine.entities.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Profil patient</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="img/Logo.png" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body>
        <%
            //Récupération de l'çbjet dans la session
            if(session.getAttribute("patient") != null){
                
            Patient p = (Patient) session.getAttribute("patient");
            %>
         <header style="z-index: 1000; position: fixed; width: 100%;">
            <nav id="navbarmed" class="navbar navbar-expand-lg navbar-dark bg-dark">
                <a class="navbar-brand" href="index.jsp">
                    <img src="img/Logo.png" width="30" height="30" class="d-inline-block align-top" alt="">
                    <strong>E-Medecine</strong>
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div style="justify-content: flex-end;" class="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul class="navbar-nav">
                        <li class="nav-item active" style="color : white; important;">
                            <a class="nav-link" href="espacePatient.jsp">Accueil<span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="professionnelSante.jsp">Professionnel de santé</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Rendezvous.jsp">Rendez-Vous</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="medicament.jsp">Médicaments</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="question.jsp">Questions</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="contact.jsp">Contact</a>
                        </li>
                    </ul>
                </div>
            </nav>
            <div data-spy="scroll" data-target="#navbarmed" data-offset="0">

            </div>
        </header>
        <main>
            <br>
            <br>
            <br>
            <%
                String m  = (String) request.getAttribute("m");
                if(m == null)
                    out.println("");
                else{
                    out.println(m);}
            %>
            Voulez vous modifier vos données ?
            <form method="post" action="/E_Medecine/ProfilPatient">
                <table>
                    <tr>
                        <td>
                            Email : <%=p.getEmailPat()%>
                        </td>
                        <td>
                            <input type="email" placeholder="Nouveau email" name="mail">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Nouveau mot de passe :
                        </td>
                        <td>
                            <input type="password" placeholder="Nouveau email" name="pwd">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Votre adresse :
                        </td>
                        <td>
                            <textarea placeholder="<%
                                                    if(p.getAdressePat() == null)
                                                    out.println("Ajouter votre adresse");
                                                    else
                                                    out.println(p.getAdressePat());
                                                    %>" name="adrs" ></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Mot de passe actuel :
                        </td>
                        <td>
                            <input type="password" placeholder="Nouveau email" name="pwdact" required="">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                               <input type="submit" value="Modifier">
                        </td>

                    </tr>
                </table>
                
            </form>
        </main>
        <footer>
            <!-- Footer -->
            <footer class="page-footer font-small stylish-color-dark pt-4 bg-dark">

                <!-- Footer Links -->
                <div class="container text-center text-md-left">

                    <!-- Grid row -->
                    <div class="row">

                        <!-- Grid column -->
                        <div class="col-md-4 mx-auto">

                            <!-- Content -->
                            <h5 class="font-weight-bold text-uppercase mt-3 mb-4" style="color:white !important;">E-Medecine</h5>
                            <p style="color:white !important;">Faites vos actes maintenant! 
                                Bénéficier des meilleures services!</p>

                        </div>
                        <!-- Grid column -->

                        <hr class="clearfix w-100 d-md-none">

                        <!-- Grid column -->
                        <div class="col-md-2 mx-auto">

                            <!-- Links -->
                            <h5 class="font-weight-bold text-uppercase mt-3 mb-4" style="color:white !important;">Liens</h5>

                            <ul class="list-unstyled">
                                <li>
                                    <a href="professionnelSante.jsp">Professionnel de santé</a>
                                </li>
                                <li>
                                    <a href="Rendezvous.jsp">Rendez-Vous</a>
                                </li>
                                <li>
                                    <a href="medicament.jsp">Médicaments</a>
                                </li>
                                <li>
                                    <a href="question.jsp">Qestions</a>
                                </li>
                                <li>
                                    <a href="contact.jsp">Contact</a>
                                </li>
                            </ul>

                        </div>


                        <!-- Grid column -->

                    </div>
                    <!-- Grid row -->

                </div>
                <!-- Footer Links -->

                <hr>

                <!-- Call to action -->
                <ul class="list-unstyled list-inline text-center py-2">
                    <li class="list-inline-item">
                        <h5 style="color:white !important;" class="mb-1">Enregistrer gratuitement</h5>
                    </li>
                    <li class="list-inline-item">
                        <a href="index.jsp" class="btn btn-danger btn-rounded">S'inscrire!</a>
                    </li>
                </ul>
                <!-- Call to action -->

                <!-- Copyright -->
                <div class="footer-copyright text-center py-3" style="color:white !important;">© 2020 Copyright:
                    <a href="index.jsp"> E-Medecine.com</a>
                </div>
                <!-- Copyright -->

            </footer>
            <!-- Footer -->
            
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
            <script src="js/javascript.js" />
            <script src="js/jquery.js" />
            <%
                } else
                    this.getServletContext().getRequestDispatcher("/loginPatient.jsp").forward(request, response);
            %>
    </body>
</html>
