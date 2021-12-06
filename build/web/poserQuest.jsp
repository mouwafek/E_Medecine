<%-- 
    Document   : poserQuest
    Created on : 18 juin 2020, 15:06:08
    Author     : mou
--%>

<%@page import="com.e_medecine.entities.Specialite"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="com.e_medecine.beans.SpecialiteModel"%>
<%@page import="com.e_medecine.entities.Question"%>
<%@page import="com.e_medecine.entities.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Poser des questions</title>
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
            //Test d'exixstance de l'objet patient dans la session
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
            <%
                //Récupération et Test d'existance de l'objet question
                //(En cas de modification)
                Question q = (Question) request.getAttribute("q");
                //Pas d'objet question envoyé depuis la servlet modifier ==> Ajout
                if (q == null) {
            %>
            <div style="text-align: center;">
                <em><h2>Poser votre ici en spécifiant la catégorie, la question d'une façon détaillée,
                        et n'oubliant pas de mentionner votre poid et taille si vous n'avez pas les rempli
                        dans la section "Profil médical"</h2></em>
            </div>
            <!--Block d'ajout de question-->
            <form method="post" action="/E_Medecine/AjoutQuest">
                <article style="display: flex; justify-content: center;padding-left: 20px;padding-right: 20px;">
                    <div class="card" style="margin-bottom: 25px;width: 40rem;background-color: #83a4d4;">
                        <div class="card-body">
                            <p class="card-title">Catégorie :</p>
                            <div class="input-group mb-3">
                                <select name="cat" class="custom-select" id="inputGroupSelect01" required="">
                                    <option selected></option>
                                    <%
                                        SpecialiteModel sm = new SpecialiteModel();
                                        List<Specialite> ls = sm.listerSpecialite();
                                    for(int i = 0;i<ls.size();i++ ){
                                    %>
                                    <option><%=ls.get(i).getNomSpec()%></option>
                                  <%}%>
                                </select>
                            </div>

                        </div>
                    </div>
                </article>

                <article style="display: flex; justify-content: center;padding-left: 20px;padding-right: 20px;">
                    <div class="card" style="margin-bottom: 25px;width: 40rem;height: 20rem;background-color: #2BBBAD;">
                        <div class="card-body">
                            <p class="card-title">Question :</p>
                            <div class="form-group">
                                <textarea name="quest" style="height: 12rem;"class="form-control rounded-0" id="exampleFormControlTextarea2" rows="3" placeholder="Ecrire votre question" required=""></textarea>
                            </div>
                        </div>
                    </div>
                </article>
                <article style="display: flex; justify-content: center;padding-left: 20px;padding-right: 20px;">
                    <div class="card" style="margin-bottom: 25px;width: 40rem;height: 15rem;background-color: #2BBBAD;">
                        <div class="card-body">
                            <p>Taille en cm:</p>
                            <%
                                if (p.getAge() == null) {
                            %>
                            <input name="taille" type="text" maxlength="3" class="form-control" placeholder="Taille en cm" required="">
                            <%
                            } else {
                            %>
                            <input name="taille" value="<%=p.getAge()%>" type="text" class="form-control" disabled="">
                            <%
                    }%>
                            <p style="margin-top: 15px;">Poid en Kg :</p>
                            <%
                                if (p.getPoid() == null) {
                            %>
                            <input name="poid" type="text" maxlength="3" class="form-control" placeholder="Poid en Kg" required="">
                            <%
                            } else {
                            %>
                            <input name="poid" value="<%=p.getPoid()%>" type="text" class="form-control" disabled="">
                            <%
                    }%>
                        </div>
                    </div>
                </article>
                <article style="display: flex; justify-content: center;padding-left: 20px;padding-right: 20px;">
                    <!-- Send button -->
                    <button style="width: 40rem;margin-bottom: 40px;" class="btn btn-info btn-block" type="submit">Envoyer</button>
                </article>
            </form>
            <%
            } 
                //S'il existe un objet question envoyé depuis servlet de modification ==> Modification
                else {
            %>
            <!--Meme block avec les données à modifier-->
            <div style="text-align: center;">
                <em><h2>Vous voulez modifier votre question ?</h2></em>
            </div>
            <form method="post" action="/E_Medecine/AjoutQuest">
                <article style="display: flex; justify-content: center;padding-left: 20px;padding-right: 20px;">
                    <div class="card" style="margin-bottom: 25px;width: 40rem;background-color: #83a4d4;">
                        <div class="card-body">
                            <p class="card-title">Catégorie :</p>
                            <input name="cat" list="cat" type="text" value="<%=q.getCategorie()%>" class="form-control">
                        </div>
                    </div>
                </article>

                <article style="display: flex; justify-content: center;padding-left: 20px;padding-right: 20px;">
                    <div class="card" style="margin-bottom: 25px;width: 40rem;height: 20rem;background-color: #2BBBAD;">
                        <div class="card-body">
                            <p class="card-title">Question :</p>
                            <div class="form-group">
                                <textarea name="quest" style="height: 12rem;"class="form-control rounded-0" id="exampleFormControlTextarea2" rows="3" required=""><%=q.getQuestion()%></textarea>
                            </div>
                        </div>
                    </div>
                </article>
                <article style="display: flex; justify-content: center;padding-left: 20px;padding-right: 20px;">
                    <div class="card" style="margin-bottom: 25px;width: 40rem;height: 15rem;background-color: #2BBBAD;">
                        <div class="card-body">
                            <p>Taille en cm:</p>
                            <%
                                if (p.getAge() == null) {
                            %>
                            <input name="taille" type="text" maxlength="3" class="form-control" placeholder="Taille en cm" required="">
                            <%
                            } else {
                            %>
                            <input name="taille" value="<%=p.getAge()%>" type="text" class="form-control" disabled="">
                            <%
                    }%>
                            <p style="margin-top: 15px;">Poid en Kg :</p>
                            <%
                                if (p.getPoid() == null) {
                            %>
                            <input name="poid" type="text" maxlength="3" class="form-control" placeholder="Poid en Kg" required="">
                            <%
                            } else {
                            %>
                            <input name="poid" value="<%=p.getPoid()%>" type="text" class="form-control" disabled="">
                            <%
                    }%>
                        </div>
                    </div>
                </article>
                <input type="text" name="id" value="<%=q.getIdQ().toString()%>" style="display: none;">
                <article style="display: flex; justify-content: center;padding-left: 20px;padding-right: 20px;">
                    <!-- Send button -->
                    <button style="width: 40rem;margin-bottom: 40px;" class="btn btn-info btn-block" type="submit">Modifier</button>
                </article>
            </form>
            <%
                        }%>
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
        <script>
            // Material Select Initialization
            $(document).ready(function () {
                $('.mdb-select').materialSelect();
            });
        </script>
        <%
            } else
                //response.sendRedirect("/loginPatient.jsp");
                this.getServletContext().getRequestDispatcher("/loginPatient.jsp").forward(request, response);
        %>
    </body>
</html>
