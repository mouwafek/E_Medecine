<%-- 
    Document   : inscriptionPatient
    Created on : 10 avr. 2020, 06:58:50
    Author     : mou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Inscription patient</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="img/logo1.png" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body style="background: #2980B9;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #FFFFFF, #6DD5FA, #2980B9);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #FFFFFF, #6DD5FA, #2980B9); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
">
        <header style="z-index: 1000; position: fixed; width: 100%;">
            <nav id="navbarmed" class="navbar navbar-expand-lg navbar-dark bg-dark">
                <a class="navbar-brand" href="index.jsp">
                    <img src="img/logo1.png" width="30" height="30" class="d-inline-block align-top" alt="">
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
            <!-- Réception des msg err-->
            <% String mes = (String) request.getAttribute("m");
                if (mes == null)
                    out.println("");
                else {%>
            <p style="color: red"><%out.println(mes);
                }%></p>        
            <h1 style="text-align: center;">Veuiller remplir ce formulaire</h1>
            <br>
            <!-- Formulaire inscription patient -->
            <form style="max-width: 620px; margin: auto;" class="text-center border border-light p-5" method="POST" action="/E_Medecine/InscriptionPatient">
                <p class="h4 mb-4">S'inscrire</p>
                <div class="form-row mb-4">
                    <div class="col">
                        <!-- Nom -->
                        <input type="text" id="defaultRegisterFormFirstName" class="form-control" placeholder="Votre nom" name="nom" required="">
                    </div>
                    <div class="col">
                        <!-- Prénom -->
                        <input type="text" id="defaultRegisterFormLastName" class="form-control" placeholder="Votre prénom" name="prenom" required="">
                    </div>
                </div>
                <!-- E-mail -->
                <input type="email" id="defaultRegisterFormEmail" class="form-control mb-4" placeholder="E-mail" name="email" required="">
                <!-- Mot de passe -->
                <input type="password" id="defaultRegisterFormPassword" class="form-control" placeholder="Mot de passe" aria-describedby="defaultRegisterFormPasswordHelpBlock" name="password" required="">
                <small id="defaultRegisterFormPasswordHelpBlock" class="form-text text-muted mb-4">
                    Au mois 8 caractères et un chiffre
                </small>
                <!-- Numéro -->
                <input type="text" maxlength="8" id="defaultRegisterPhonePassword" class="form-control" placeholder="Numéro de téléphone" aria-describedby="defaultRegisterFormPhoneHelpBlock" name="tel" required="">
                <!-- Genre -->
                <div  style="margin-top: 20px;" class="input-group mb-3">
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="inputGroupSelect01">Genre</label>
                    </div>
                    <select name="genre" class="custom-select" id="inputGroupSelect01" required="">
                        <option selected></option>
                        <option>Male</option>
                        <option>Femelle</option>
                    </select>
                </div>
                <!-- Date de naissance-->
                Date de naissance :
                <input style="margin-top: 20px;" placeholder="Date de naissance" type="date" id="example" class="form-control" name="datenais" required="">
                <!-- Bouton s'inscrire -->
                <button class="btn btn-info my-4 btn-block" type="submit">S'inscrire</button>
                <!-- Termes de services -->
                <p>En cliquant sur
                    <em>S'inscrire</em> vous acceptez nos
                    <a href="" target="_blank">termes de service</a>
                <hr>
                Vous avez déja un compte ? <a href="loginPatient.jsp">Se connecter</a>
            </form>
        </main>
        <!-- Footer -->
        <footer style="margin-top: 20px;" class="page-footer font-small stylish-color-dark pt-4 bg-dark">

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
        <script src="js/javascript.js"></script>
        <script src="js/jquery.js"></script>
    </body>
</html>
