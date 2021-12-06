<%-- 
    Document   : espaceDocteur
    Created on : 5 juin 2020, 18:00:54
    Author     : mou
--%>

<%@page import="com.e_medecine.entities.Horaire"%>
<%@page import="java.util.List"%>
<%@page import="com.e_medecine.beans.HoraireModel"%>
<%@page import="com.e_medecine.entities.Cabinet"%>
<%@page import="com.e_medecine.beans.CabinetModel"%>
<%@page import="com.e_medecine.entities.ProfessionnelSante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Espace membre</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="img/Logo.png" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body>
        <%
            //Récupération de l'objet patient de la session
            if (session.getAttribute("prof") != null) {
        %>
        <%
            ProfessionnelSante prof = (ProfessionnelSante) session.getAttribute("prof");
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
                            <a class="nav-link" href="index.jsp">Accueil<span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Rendezvous.jsp">Rendez-Vous/Patients</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Avis.jsp">Avis</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="question.jsp">Questions</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Mon compte
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">Profil</a>
                                <a class="dropdown-item" href="cabinet.jsp">Cabinet</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="<%=request.getContextPath() + "/DeconnexionProfessionnel"%>">
                                    Deconnexion
                                </a>
                            </div>
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
            <br>
            <!-- Gratulation -->
            <h3 style="color: #04A4CC; text-align: center; margin-top: 30px;">Bonjour <%=prof.getPrenomProf()%>!</h3><br>
            <%
                CabinetModel cm = new CabinetModel();
                Cabinet c = cm.existeCabinet1(prof.getIdProf()).get(0);
                HoraireModel hm = new HoraireModel();
                List<Horaire> lh = hm.listeHoraire(c.getIdCab());
                %>
                <div style="text-align: center;background-color: red; width: 80%;margin-left: 10%;border-radius: 10px;">
                <%
                for (int i = 0; i < lh.size(); i++) {
                    Horaire h = lh.get(i);
                    if (h.getHMD() == null && h.getHMU() == null) {
                %>
                <p style="color: white;">
                    Veuiller Régler votre horaire du jour <%=h.getJour()%> dans la section "Cabinet" pour que vos patient peuvent prendre des rendez-vous chez-vous !
                </p>
            <%
                    }
                }
            %>
                </div>
                
        </main>
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
        <script src="js/javascript.js" ></script>
        <script src="js/jquery.js" ></script>
        <%
            } else
                //En cas d'absence d'objet dans la session : 
                this.getServletContext().getRequestDispatcher("/loginDocteur.jsp").forward(request, response);
        %>
    </body>
</html>
