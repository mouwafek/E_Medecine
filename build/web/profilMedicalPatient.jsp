<%-- 
    Document   : profilMedicalPatient
    Created on : 9 juin 2020, 17:00:52
    Author     : mou
--%>

<%@page import="com.e_medecine.entities.Medicament"%>
<%@page import="com.e_medecine.dao.ProfessionnelSanteDAO"%>
<%@page import="com.e_medecine.entities.ProfessionnelSante"%>
<%@page import="com.e_medecine.beans.PatientModel"%>
<%@page import="com.e_medecine.entities.PatientAl"%>
<%@page import="java.util.List"%>
<%@page import="com.e_medecine.entities.Allergie"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.e_medecine.entities.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Profil médical patient</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="img/Logo.png" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body>
        <%
            //Récupération du  patient dans la session
            if (session.getAttribute("patient") != null) {

                Patient p = (Patient) session.getAttribute("patient");
        %>
        <!--Header-->
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
        <main style="background: #2980B9;  /* fallback for old browsers */
              background: -webkit-linear-gradient(to right, #FFFFFF, #6DD5FA, #2980B9);  /* Chrome 10-25, Safari 5.1-6 */
              background: linear-gradient(to right, #FFFFFF, #6DD5FA, #2980B9); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
              ">
            <br>
            <br>
            <br>
            <% //Réception des msg d'erreur et de succées Block allergie
                String sucal = (String) request.getAttribute("s");
                if (sucal == null)
                    out.println("");
                else {%>
            <p style="color: white;text-align: center; background-color: green; max-width: 500px; margin:auto;height: 30px;">
                <%out.println(sucal);
                    }%>
            </p>
            <% String erral = (String) request.getAttribute("e");
                if (erral == null)
                    out.println("");
                else {%>
            <p style="color: white;text-align: center; background-color: red; max-width: 500px; margin:auto;height: 30px;">
                <%out.println(erral);
                    }%>
            </p>
            <% //Réception des msg d'erreur et de succées Block Antécédents ch
                String ch = (String) request.getAttribute("sch");
                if (ch == null)
                    out.println("");
                else {%>
            <p style="color: white;text-align: center; background-color: green; max-width: 500px; margin:auto;height: 30px;">
                <%out.println(ch);
                    }%>
            </p>
            <% String ech = (String) request.getAttribute("ech");
                if (ech == null)
                    out.println("");
                else {%>
            <p style="color: white;text-align: center; background-color: red; max-width: 500px; margin:auto;height: 30px;">
                <%out.println(ech);
                    }%>
            </p>
            <% //Réception des msg d'erreur et de succées Block Infos Pers
                String sinf = (String) request.getAttribute("sinf");
                if (sinf == null)
                    out.println("");
                else {%>
            <p style="color: white;text-align: center; background-color: green; max-width: 500px; margin:auto;height: 30px;">
                <%out.println(sinf);
                    }%>
            </p>
            <% String erinf = (String) request.getAttribute("erinf");
                if (erinf == null)
                    out.println("");
                else {%>
            <p style="color: white;text-align: center; background-color: green; max-width: 500px; margin:auto;height: 30px;">
                <%out.println(erinf);
                    }%>
            </p>
            <% //Réception des msg d'erreur et de succées Block Maladie
                String malsuc = (String) request.getAttribute("malsuc");
                if (malsuc == null)
                    out.println("");
                else {%>
            <p style="color: white;text-align: center; background-color: green; max-width: 500px; margin:auto;height: 30px;">
                <%out.println(malsuc);
                    }%>
            </p>
            <% String convien = (String) request.getAttribute("convien");
                if (convien == null)
                    out.println("");
                else {%>
            <p style="color: white;text-align: center; background-color: red; max-width: 500px; margin:auto;height: 30px;">
                <%out.println(convien);
                    }%>
            </p>
            <% String df = (String) request.getAttribute("df");
                if (df == null)
                    out.println("");
                else {%>
            <p style="color: white;text-align: center; background-color: red; max-width: 500px; margin:auto;height: 30px;">
                <%out.println(df);
                    }%>
            </p>
            <% String chronique = (String) request.getAttribute("chronique");
                if (chronique == null)
                    out.println("");
                else {%>
            <p style="color: white;text-align: center; background-color: red; max-width: 500px; margin:auto;height: 30px;">
                <%out.println(chronique);
                    }%>
            </p>
            <% String autr = (String) request.getAttribute("autr");
                if (autr == null)
                    out.println("");
                else {%>
            <p style="color: white;text-align: center; background-color: red; max-width: 500px; margin:auto;height: 30px;">
                <%out.println(autr);
                    }%>
            </p>
            <% String mal = (String) request.getAttribute("mal");
                if (mal == null)
                    out.println("");
                else {%>
            <p style="color: white;text-align: center; background-color: red; max-width: 500px; margin:auto;height: 30px;">
                <%out.println(mal);
                    }%>
            </p>
            <% String dfinull = (String) request.getAttribute("dfinull");
                if (dfinull == null)
                    out.println("");
                else {%>
            <p style="color: white;text-align: center; background-color: red; max-width: 500px; margin:auto;height: 30px;">
                <%out.println(dfinull);
                    }%>
            </p>
            <div style="background: #1f4037;  /* fallback for old browsers */
                 background: -webkit-linear-gradient(to right, #99f2c8, #1f4037);  /* Chrome 10-25, Safari 5.1-6 */
                 background: linear-gradient(to right, #99f2c8, #1f4037); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
                 width: auto;border-radius: 100px;height: 550px;margin-left: 10px;margin-right: 10px;display: list-item; justify-content: center;">
                <div style="text-align: center;padding-top: 50px;padding-left: 20px;padding-right: 20px;">
                    <em><h2>Ici vous pouvez ajouter des informations sur votre santé
                            pour bien construire votre profil médical
                            afin d'aider les professionnels de santé 
                            à bien comprendre votre situation</h2></em>
                </div> 
                <div style="text-align: center;">
                    <img src="img/profileMed.jpg" style="width: 350px;height: 200px;-webkit-border-radius:50px;
                         -moz-border-radius:50px;
                         border-radius:50px;">
                </div>
            </div>
            <!-- Block Allergie / Antécédent chirurgucal / Maladie-->
            <div style="margin-bottom: 20px;margin-top: 20px;">
                <article style="display: flex; justify-content: center;">
                    <div class="card-deck">
                        <!-- Block Allergie -->
                        <div class="card" style="width: 25rem;background-color: #2BBBAD;">
                            <div class="card-body">
                                <form method="post" action="/E_Medecine/AjoutAllergie">
                                    <h5 class="card-title">Avez-vous une nouvelle allergie? </h5>
                                    Premier date d'allergie : 
                                    <input style="margin-bottom:20px; " placeholder="Date allergie" type="date" id="example" class="form-control" name="dateall" required="">
                                    Type de réaction :
                                    <div class="input-group mb-3">
                                        <select name="typer" class="custom-select" id="inputGroupSelect01" required="">
                                            <option selected></option>
                                            <option>Immédiate</option>
                                            <option>Retardée</option>
                                        </select>
                                    </div>
                                    Etat de réaction :
                                    <div class="input-group mb-3">
                                        <select name="etatr" class="custom-select" id="inputGroupSelect01" required="">
                                            <option selected></option>
                                            <option>Grave</option>
                                            <option>Normale</option>
                                        </select>
                                    </div>
                                    Médicament ou produit causant l'allergie :
                                    <input type="text"  class="form-control" name="prod" required="">
                                    <p style="text-align: center;">
                                        <input type="submit" value="Ajouter" class="btn btn-primary" style="margin-top: 20px;">
                                    </p>
                                </form>
                            </div>
                        </div>
                        <!-- Block info pers -->
                        <div class="card" style="width: 25rem;background-color: #33b5e5;">
                            <div class="card-body">
                                <form method="post" action="/E_Medecine/AjoutInfoPers">
                                    <h5 class="card-title">Informations personnelles : </h5>
                                    Poid : 
                                    <input type="text" maxlength="3" style="margin-bottom: 20px;" Value="<%
                                        if (p.getPoid() != null) {
                                            out.println(p.getPoid());
                                        } else {
                                            out.println("");
                                        }
                                           %>" placeholder="<%
                                                                                                                if (p.getPoid() != null) {
                                                                                                                    out.println(p.getPoid() + " Kg");
                                                                                                                } else {
                                                                                                                    out.println("Poid en Kg");
                                                                                                                }
                                           %>"id="exampleForm2" class="form-control" name="poid" required="">
                                    Taille : 
                                    <input type="text" maxlength="3" style="margin-bottom: 20px;" value="<%
                                        if (p.getAge() != null) {
                                            out.println(p.getAge());
                                        } else {
                                            out.println("");
                                        }
                                           %>" placeholder="<%
                                                                                                                if (p.getAge() != null) {
                                                                                                                    out.println(p.getAge() + " cm");
                                                                                                                } else {
                                                                                                                    out.println("Taille en cm");
                                                                                                                }
                                           %>"id="exampleForm2" class="form-control" name="taille" required="">
                                    Groupe sanguin :(Attention! vous ne pouvez pas le modifier après!)
                                    <div class="input-group mb-3">
                                        <select name="GS" class="custom-select" id="inputGroupSelect01" >
                                            <option selected>Choisir</option>
                                            <option>AB+</option>
                                            <option>AB-</option>
                                            <option>A+</option>
                                            <option>A-</option>
                                            <option>B+</option>
                                            <option>B-</option>
                                            <option>O+</option>
                                            <option>O-</option>
                                        </select>
                                    </div>
                                    Que travailler vous ? :
                                    <input type="text" id="exampleForm2" class="form-control" name="trav" required="">

                                    <p style="text-align: center;">
                                        <input type="submit" value="Mettre à jour" class="btn btn-primary" style="margin-top: 20px;">
                                    </p>
                                </form>
                            </div>
                        </div>
                        <!-- Antécédent chirurgucal -->
                        <div class="card" style="width: 25rem;background-color: #2BBBAD;">
                            <div class="card-body">
                                <form method="post" action="/E_Medecine/AjoutAntCh">
                                    <h5 class="card-title">Vos antécédents  chirurgicaux</h5>
                                    Nom de l'opération : 
                                    <div class="input-group mb-3">
                                        <select name="nom" class="custom-select" id="inputGroupSelect01" required="">
                                            <option selected></option>
                                            <option>Chirurgie vasculaire </option>
                                            <option>Chirurgie digestive</option>
                                            <option>Chirurgie infantile</option>
                                            <option>Chirurgie plastique ou esthétique</option>
                                            <option>Chirurgie maxillo faciale et stomatologie</option>
                                            <option>Chirurgie ophtalmologique</option>
                                            <option>ORL ou Oto-rhino-laryngologie</option>
                                            <option>Chirurgie urologique</option>
                                            <option>Autre</option>
                                        </select>
                                    </div>
                                    Date de l'opération : 
                                    <input placeholder="Date allergie" style="margin-bottom: 20px;" type="date" id="example" class="form-control" name="dateop" required="">
                                    Raison :
                                    <input type="text" id="exampleForm2" style="margin-bottom: 20px;" class="form-control" name="raison" required="">
                                    Nom de l'Hopital/Clinique :
                                    <input type="text" id="exampleForm2" class="form-control" name="hop" required="">
                                    <p style="text-align: center;">
                                        <input type="submit" value="Ajouter" class="btn btn-primary" style="margin-top: 20px;">
                                    </p>
                                </form>
                            </div>
                        </div>

                    </div>
                </article>
            </div>
            <!-- Maladie-->
            <div style="margin-bottom: 20px;margin-top: 20px;">
                <article style="display: flex; justify-content: center;">
                    <div class="card-deck">
                        <!-- Maladie -->
                        <div class="card" style="width: 25rem;background-color: #2BBBAD;">
                            <div class="card-body">
                                <form method="post" action="/E_Medecine/AjoutMaladie">
                                    <h5 class="card-title">Vous avez une nouvelle maladie ?</h5>
                                    Type de maladie : 
                                    <div class="input-group mb-3">
                                        <select id="typem" name="typem" class="custom-select" id="inputGroupSelect01" required="">
                                            <option selected></option>
                                            <option>Maladie chronique </option>
                                            <option>Maladie psychiatrique</option>
                                            <option>Traumatisme</option>
                                            <option>Temporaire</option>
                                        </select>
                                    </div>
                                    Nom de maladie : 
                                    <div class="input-group mb-3">
                                        <select id="nom" name="nom" class="custom-select" id="inputGroupSelect01" required="">
                                            <option selected></option>
                                            <option>Diabète(chronique)</option>
                                            <option>Hypertension artérielle(chronique)</option>
                                            <option>Maladie cardiaque(chronique)</option>
                                            <option>Asthme(chronique)</option>
                                            <option>Hypercholestérolémie(chronique)</option>
                                            <option>Arthrite(chronique)</option>
                                            <option>Ostéoporose(chronique)</option>
                                            <option>Hypothyroïdie(chronique)</option>
                                            <option>Maladie génétique(chronique)</option>
                                            <option>Maladie psychiatrique(chronique)</option>
                                            <option>Cancer(chronique)</option>
                                            <option>Maladie neurologique(chronique)</option>
                                            <option>Dépression(psychiatrique)</option>
                                            <option>Anxiété(psychiatrique)</option>
                                            <option>Manie(psychiatrique)</option>
                                            <option>Panique(psychiatrique)</option>
                                            <option>Hyperactivité(psychiatrique)</option>
                                            <option>Bipolarité(psychiatrique)</option>
                                            <option>Entorse(traumatique)</option>
                                            <option>Fracture(traumatique)</option>
                                            <option>Autre</option>
                                        </select>
                                        <input type="text" placeholder="Autre" name="autre">
                                    </div>
                                    Date de début de maladie : 
                                    <input placeholder="Date d maladie" type="date" id="example" class="form-control" name="datedmal" required="">
                                    Date de fin de maladie si elle est soignée : 
                                    <input placeholder="Date f maladie" type="date" id="example" class="form-control" name="datefmal">
                                    Traitement : 
                                    <input type="text" id="exampleForm2" class="form-control" name="trtm" required="">
                                    Vous avez arrêté à travailler ?
                                    <div class="input-group mb-3">
                                        <select name="arrT" class="custom-select" id="inputGroupSelect01" required="">
                                            <option selected></option>
                                            <option>Oui</option>
                                            <option>Non</option>
                                        </select>
                                    </div>
                                    <p style="text-align: center;">
                                        <input type="submit" value="Ajouter" class="btn btn-primary" style="margin-top: 20px;">
                                    </p>
                                </form>
                            </div>
                        </div>
                        <div class="card" style="width: 25rem;background-color: #33b5e5;">
                            <div class="card-body">
                                <h5 class="card-title">Consulter votre profil médical</h5>
                                <p>Cliquer ici pour voir et télécharger votre profil médical</p>
                                <p style="text-align: center;">
                                    <a href="telecharger.jsp"><button type="button" class="btn btn-success">Mon profil</button></a>
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
