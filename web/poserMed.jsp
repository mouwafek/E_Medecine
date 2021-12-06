<%-- 
    Document   : poserMed
    Created on : 28 juin 2020, 14:33:07
    Author     : mou
--%>

<%@page import="com.e_medecine.entities.Medicament"%>
<%@page import="com.e_medecine.entities.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Poser des médicaments</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="img/Logo.png" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body style="background: #00C9FF;  /* fallback for old browsers */
          background: -webkit-linear-gradient(to right, #92FE9D, #00C9FF);  /* Chrome 10-25, Safari 5.1-6 */
          background: linear-gradient(to right, #92FE9D, #00C9FF); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
          ">
        <%
            //Test d'existance de l'objet patient dans la session 
            if (session.getAttribute("patient") != null) {
        %>
        <%
            //Récupération de l'objet patient
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
            <br>
            <% //Réception de msg d'erreur
                String erreur = (String) request.getAttribute("erreur");
                if (erreur == null)
                    out.println("");
                else {%>
            <p style="color: white;text-align: center; background-color: red; max-width: 500px; margin:auto;height: 30px;">
                <%out.println(erreur);
                    }%>
            </p>
            <%
                //Récupération et Test d'existance de l'objet médicament
                //(En cas de modification)
                Medicament m = (Medicament) request.getAttribute("m");
                //Pas d'objet médicament envoyé depuis la servlet modifier ==> Ajout
                if (m == null) {
            %>
            <!--Block de dépot de médicament-->
            <article style="display: flex; justify-content: center;padding-left: 20px;padding-right: 20px;">
                <div class="card" style="margin-bottom: 25px;width: 40rem;">
                    <div class="card-body">
                        <form method="POST" action="/E_Medecine/DepotMedicament" enctype="multipart/form-data">
                            <p class="card-title" style="text-align: center;">Déposer un médicament</p>
                            Nom du médicament :
                            <input name="nom" type="text" class="form-control">
                            Forme pharmaceutique :
                            <input name="forme" type="text" class="form-control">
                            Classe thérapeutque :
                            <div class="input-group mb-3">
                                <select name="classe" class="custom-select" id="inputGroupSelect01" required="">
                                    <option selected></option>
                                    <option>Appareil digestif et métabolisme</option>
                                    <option>Sang et organes hematopoietiques</option>
                                    <option>Système cardiovasculaire</option>
                                    <option>Médicament dermatologique</option>
                                    <option>Système genito urinaire et hormones sexuelles</option>
                                    <option>Hormones systèmiques, Hormones sexuelles exclues</option>
                                    <option>Antiinfecieux généraux à usage systèmique</option>
                                    <option>Antineoplastiques et immunomodulateurs</option>
                                    <option>Muscle et squelette</option>
                                    <option>Système nerveux</option>
                                    <option>Antiparasitaire - Insecticides</option>
                                    <option>Système respiratoire</option>
                                    <option>Organes sensoriels</option>
                                </select>
                            </div>
                            Date de validité : 
                            <input style="margin-bottom:20px; " placeholder="Date de validité" type="date" id="example" class="form-control" name="dateval" required="">
                            Photo du médicament :
                            <input type="file" name="ph" class="form-control" required="">
                            <center><small id="defaultRegisterFormPasswordHelpBlock" class="form-text text-muted mb-4">
                                    Il faut que la photo soit claire et porte le nom du médicament
                                </small></center>
                            Quantité :
                            <input type="number" class="form-control" name="qt" required="">
                            <input type="submit" class="btn-success" value="Déposer">
                        </form>
                    </div>
                </div>
            </article>
            <%
            } 
                //S'il existe un objet med envoyé depuis servlet de modification ==> Modification
                else {
            %>
            <!--Meme block avec les données à modifier-->
            <article style="display: flex; justify-content: center;padding-left: 20px;padding-right: 20px;">
                <div class="card" style="margin-bottom: 25px;width: 40rem;">
                    <div class="card-body">
                        <form method="POST" action="/E_Medecine/DepotMedicament" enctype="multipart/form-data">
                            <p class="card-title" style="text-align: center;">Déposer un médicament</p>
                            Nom du médicament :
                            <input name="nom" type="text" value="<%=m.getNomMed()%>" class="form-control">
                            Forme pharmaceutique :
                            <input name="forme" type="text" value="<%=m.getFormeMed()%>" class="form-control">
                            Classe thérapeutque :
                            <div class="input-group mb-3">
                                <select name="classe" class="custom-select" id="inputGroupSelect01" required="">
                                    <option selected><%=m.getClasseTherp()%></option>
                                    <option>Appareil digestif et métabolisme</option>
                                    <option>Sang et organes hematopoietiques</option>
                                    <option>Système cardiovasculaire</option>
                                    <option>Médicament dermatologique</option>
                                    <option>Système genito urinaire et hormones sexuelles</option>
                                    <option>Hormones systèmiques, Hormones sexuelles exclues</option>
                                    <option>Antiinfecieux généraux à usage systèmique</option>
                                    <option>Antineoplastiques et immunomodulateurs</option>
                                    <option>Muscle et squelette</option>
                                    <option>Système nerveux</option>
                                    <option>Antiparasitaire - Insecticides</option>
                                    <option>Système respiratoire</option>
                                    <option>Organes sensoriels</option>
                                </select>
                            </div>
                            Date de validité : 
                            <input style="margin-bottom:20px; " value="<%=m.getDateValidite()%>" placeholder="Date allergie" type="date" id="example" class="form-control" name="dateval" required="">
                            Photo : <br>
                            <img src="getMedImage.jsp?id=<%=m.getIdMed()%>" style="width: 10rem;height: 5rem;">
                            Charger un nouvelle photo du médicament ?
                            <input type="file" name="ph" class="form-control">
                            <center><small id="defaultRegisterFormPasswordHelpBlock" class="form-text text-muted mb-4">
                                    Il faut que la photo soit claire et porte le nom du médicament
                                </small></center>
                            Quantité :
                            <input type="number" value="<%=m.getQuantite()%>" class="form-control" name="qt" required="">
                            <input type="text" name="id" value="<%=m.getIdMed().toString()%>" style="display: none;">
                            <input type="submit" class="btn-success" value="Modifier">
                        </form>
                    </div>
                </div>
            </article>
            <%}%>
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
        <script src="js/javascript.js" ></script>
        <script src="js/jquery.js" ></script>
        <%
            } else
                this.getServletContext().getRequestDispatcher("/loginPatient.jsp").forward(request, response);
        %>
    </body>
</html>
