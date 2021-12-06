<%-- 
    Document   : index
    Created on : 1 juin 2020, 10:25:36
    Author     : mou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Accueil</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="img/Logo.png" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body style="background: #2980B9;  /* fallback for old browsers */
          background: -webkit-linear-gradient(to right, #FFFFFF, #6DD5FA, #2980B9);  /* Chrome 10-25, Safari 5.1-6 */
          background: linear-gradient(to right, #FFFFFF, #6DD5FA, #2980B9); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
          ">
        <%
            //Récupération de l'objet patient de la session

            if (session.getAttribute("patient") != null) {

            //Envoie vers la espace patient
            this.getServletContext().getRequestDispatcher("/espacePatient.jsp").forward(request, response);
        } else if(session.getAttribute("prof") != null){
        //Envoie vers l'espace docteur
            this.getServletContext().getRequestDispatcher("/espaceDocteur.jsp").forward(request, response);
        }
            else {
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
                            <a class="nav-link" href="professionnelSante.jsp">Professionnel de santé</a>
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
            <br>

            <h3 style="color:#04A4CC; text-align: center;">Bienvenu dans E-Medecine !</h3><br>
            <a href="#con">
                <p style="text-align: center;"><button type="button" class="btn btn-info">Connexion / Inscription</button></p>
            </a>
            <!-- Slide show -->
            <article style="display: flex; justify-content: center;">
                <div style="max-width: 1200px;" id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="img/acc1.jpg" class="d-block w-100" alt="...">
                        </div>
                        <div class="carousel-item">
                            <img src="img/acc2.jpg" class="d-block w-100" alt="...">
                        </div>
                        <div class="carousel-item">
                            <img src="img/acc3.jpg" class="d-block w-100" alt="...">
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>  
            </article>
            <!-- Slide show -->
            <!--Grid row-->
            <div class="row" style="margin-top: 30px;">

                <!--Trouver un docteur-->
                <div class="col-md-6 mb-4">
                    <!-- Card -->
                    <div class="card gradient-card">
                        <div class="card-image" style="background-color: green;">
                            <!-- Content -->
                            <a href="professionnelSante.jsp">
                                <div class="text-white d-flex h-100 mask blue-gradient-rgba">
                                    <div class="first-content align-self-center p-3">
                                        <h3 class="card-title">Trouver un docteur</h3>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <!-- Content -->
                        <div class="card-body white">
                            <h4 class="text-uppercase font-weight-bold my-4">Details</h4>
                            <p  align="justify">Ici vous pouvez trouver un médecin ou un spécialiste de santé le plus proche de votre région, vous pouvez consulter l'annuaire des professionnels de santé selon les critères que vous choisssez (région, spécialité, nom)</p>
                        </div>
                    </div>
                    <!-- Card -->
                </div>
                <!--Trouver un docteur-->

                <!--Prendre un rendez-vous-->
                <div class="col-md-6 mb-4">
                    <!-- Card -->
                    <div class="card gradient-card">
                        <div class="card-image" style="background-color: green;">
                            <!-- Content -->
                            <a href="Rendezvous.jsp">
                                <div class="text-white d-flex h-100 mask purple-gradient-rgba">
                                    <div class="first-content align-self-center p-3">
                                        <h3 class="card-title">Prendre un rendez-vous</h3>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <!-- Content -->
                        <div class="card-body white">
                            <h4 class="text-uppercase font-weight-bold my-4">Details</h4>
                            <p align="justify">Comme étant un patient vous pouvez  prendre un rendez-vous en ligne gratuitement, en toute rapidité et simplicité. A coté d'avoir un profil médical en ligne pour aider votre docteur à bien comprendre votre situation</p>
                        </div>
                    </div>
                    <!-- Card -->
                </div>
                <!--Prendre un rendez-vous-->

                <!--Poser question-->
                <div class="col-md-6 mb-4">
                    <!-- Card -->
                    <div class="card gradient-card">
                        <div class="card-image" style="background-color: green;">
                            <!-- Content -->
                            <a href="question.jsp">
                                <div class="text-white d-flex h-100 mask peach-gradient-rgba">
                                    <div class="first-content align-self-center p-3">
                                        <h3 class="card-title">Poser question</h3>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <!-- Content -->
                        <div class="card-body white animated">
                            <h4 class="text-uppercase font-weight-bold my-4">Details</h4>
                            <p align="justify">Les patients peuvent poser leurs propres questions de leurs problèmes de façon anonyme et sécurisée et les spécialistes de santé de leurs place les répondent et les guident chaccun selon sa spécialité</p>
                        </div>
                    </div>
                    <!-- Card -->
                </div>
                <!--Poser question-->

                <!--Chercher un médicament-->
                <div class="col-md-6 mb-4">
                    <!-- Card -->
                    <div class="card gradient-card">
                        <div class="card-image" style="background-color: green;">
                            <!-- Content -->
                            <a href="medicament.jsp">
                                <div class="text-white d-flex h-100 mask aqua-gradient-rgba">
                                    <div class="first-content align-self-center p-3">
                                        <h3 class="card-title">Chercher un médicament</h3>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <!-- Content -->
                        <div class="card-body white">
                            <h4 class="text-uppercase font-weight-bold my-4">Details</h4>
                            <p align="justify">Ici on vous donne un éspace ou vous pouvez chercher un médicament que vous avez besoin (par exemple car il n’est pas disponible dans les pharmacies), et au même temps vous pouvez le déposer comme un don</p>
                        </div>
                        <a name="con"></a>
                    </div>
                    <!-- Card -->
                </div>
                <!--Chercher un médicament-->
            </div>


            <!-- Block connexion / inscription prof et patient-->
            <div style="margin-bottom: 20px;margin-top: 20px;">
                <article style="display: flex; justify-content: center;">
                    <div class="card-deck">
                        <!-- Patient -->
                        <div class="card" style="width: 27rem;">
                            <img src="img/patient.jpg" style="height: 250px;" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">Vous êtes un patient ?</h5>
                                <p class="card-text">Trouver un docteur de votre choix, prendre un rendez-vous, construire votre profil médical</p>
                                <p style="text-align: center;">
                                    <a href="loginPatient.jsp" class="btn btn-primary">Se connecter</a>
                                    <a href="inscriptionPatient.jsp" class="btn btn-primary">S'inscrire</a>
                                </p>
                            </div>
                        </div>
                        <!-- Professionnel de santé -->
                        <div class="card" style="width: 27rem;">
                            <img src="img/docteur.jpg" style="height: 250px;" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">Vous êtes un professionnel de santé ?</h5>
                                <p class="card-text">Partager vos horaires et vos coordonnées pour bien faciliter la mise en contact avec vos patients</p>
                                <!-- Button -->
                                <p style="text-align: center;">
                                    <a href="loginDocteur.jsp" class="btn btn-primary">Se connecter</a>
                                    <a href="inscriptionDocteur.jsp" class="btn btn-primary">S'inscrire</a>
                                </p>
                            </div>
                        </div>
                    </div>
                </article>
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
                    <a href="#con" class="btn btn-danger btn-rounded">S'inscrire!</a>
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
            }
        %>
    </body>
</html>
