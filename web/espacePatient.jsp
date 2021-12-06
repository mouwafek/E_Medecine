<%-- 
    Document   : espacePatient
    Created on : 15 avr. 2020, 11:10:57
    Author     : mou
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.List"%>
<%@page import="com.e_medecine.entities.Patient"%>
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
    <body style="background: #abbaab;  /* fallback for old browsers */
          background: -webkit-linear-gradient(to right, #ffffff, #abbaab);  /* Chrome 10-25, Safari 5.1-6 */
          background: linear-gradient(to right, #ffffff, #abbaab); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
          ">  
        <%
            //Récupération de l'objet patient de la session
            if (session.getAttribute("patient") != null) {
        %>
        <%
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
                        <li>
                            <a href="Rendezvous.jsp">Rendez-Vous</a>
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
            <div style="background-color: #2BBBAD;" >
                <div style="text-align: center;">
                    <h4>
                        <%
                            //Récupération et affichage de la date du système
                            DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                            Date date = new Date();
                            out.println("Date d'aujourd'huit :" + format.format(date));
                        %>

                    </h4> 
                </div>  
                <div style="text-align: left;padding-bottom: 30px;padding-left: 30px;">
                    <!-- Compte-->
                    <button class="btn btn-primary dropdown-toggle mr-4" type="button" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">Mon comte</button>

                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="profilPatient.jsp">Profil</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="<%=request.getContextPath() + "/DeconnexionPatient"%>">
                            Deconnexion
                        </a>
                    </div>
                    <!-- Compte -->
                </div>
            </div>
            <!-- Gratulation -->
            <h3 style="color: #04A4CC; text-align: center; margin-top: 30px;">Bonjour <%=p.getPrenomPat()%>!</h3><br>

            <article style="display: flex; justify-content: center; margin-bottom: 20px;">
                <div class="card-deck">
                    <!-- Block fiche medcale -->
                    <div class="card" style="width: 18rem;">
                        <img src="img/profilmed.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Mon profil médical</h5>
                            <p class="card-text"> Cliquer ici pour éditer votre profil médical.</p>
                            <a href="profilMedicalPatient.jsp" class="btn btn-primary">Editer</a>
                        </div>
                    </div>
                    <!-- Block rendez-vous -->
                    <div class="card" style="width: 18rem;">
                        <img src="img/rendv.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Rendez-vous</h5>
                            <p class="card-text">Vous avez besoin d'un professionnel de santé? Prendre un rendez-vous en un clic</p>
                            <a href="#" class="btn btn-primary">Rendez-vous</a>
                        </div>
                    </div>
                    <!-- Block questions -->
                    <div class="card" style="width: 18rem;">
                        <img src="img/QR.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Questions&Réponses</h5>
                            <p class="card-text">Cliquer ici pour poser vos questions et voir les réponses des professionnels de santé</p>
                            <!-- <form method="post" action="/E_Medecine/ListerQuestion">-->
                            <a href="mesQuest.jsp"><button class="btn btn-primary">Questions</button></a>
                            <!--</form>-->
                        </div>
                    </div>
                    <!-- Block médicaments -->
                    <div class="card" style="width: 18rem;">
                        <img src="img/medicament.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Médicaments</h5>
                            <p class="card-text">Si vous vloulez faire un don ou vous avez besoin d'un médicament cliquer ici</p>
                            <a href="mesMed.jsp" class="btn btn-primary">Médicaments</a>
                        </div>
                    </div>
                </div>
            </article>
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
                //En cas d'absence d'objet dans la session : 
                this.getServletContext().getRequestDispatcher("/loginPatient.jsp").forward(request, response);
        %>
    </body>
</html>
