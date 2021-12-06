<%-- 
    Document   : mesMed
    Created on : 24 juin 2020, 21:52:44
    Author     : mou
--%>

<%@page import="com.e_medecine.entities.Medicament"%>
<%@page import="java.util.List"%>
<%@page import="com.e_medecine.beans.MedicamentModel"%>
<%@page import="com.e_medecine.entities.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Mes médicaments</title>
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
            // Test d'existence de l'objet patient dans la session
            if (session.getAttribute("patient") != null) {
        %>
        <%
            //s'il existe on le récupère
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
            <br><br>
            <br><br>
            <% //Réception de msg de succée d'ajout
                String Message = (String) request.getAttribute("Message");
                if (Message == null)
                    out.println("");
                else {%>
            <p style="color: white;text-align: center; background-color: green; max-width: 500px; margin:auto;height: 30px;">
                <%out.println(Message);
                    }%>
            </p>
            <% //Réception de msg de succée de suppression
                String sup = (String) request.getAttribute("sup");
                if (sup == null)
                    out.println("");
                else {%>
            <p style="color: white;text-align: center; background-color: green; max-width: 500px; margin:auto;height: 30px;">
                <%out.println(sup);
                    }%>
            </p>
            <div style="margin-bottom: 20px;margin-top: 20px;">
                <article style="display: flex; justify-content: center;">
                    <div class="card-deck">
                        <!-- Image de contexte -->
                        <div class="card" style="width: 25rem;">
                            <div class="card-body">
                                <img src="img/medic.jpg" style="width: 360px;height: 190px;">
                            </div>
                        </div>
                        <!-- Block d'opérations de dépot et de recherche-->
                        <div class="card" style="width: 25rem;border-right: 10px;">
                            <div class="card-body">
                                <p style="margin-top: 20px;text-align: center;">Vous voulez faire un don? Vous avez du médicaments à donner à qui a besoins?</p>
                                <p style="text-align: center;">
                                    <a href="poserMed.jsp"><button style="width: 20rem;margin-top: 0rem;" type="button" class="btn btn-success">Faire un don</button></a>
                                </p>
                                <p style="text-align: center;">
                                    <a href="chercherMed.jsp"><button style="width: 20rem;margin-top: 0rem;" type="button" class="btn btn-info">Chercher médicament</button></a>
                                </p>
                            </div>
                        </div>
                    </div>
                </article>
            </div>
            <hr>
            <!--Liste des médicaments déposés si elle existe-->
            <div style="text-align: center;">
                <h1>Mes Dons de médicaments</h1>
                <hr style="background-color: green;width: 80%;height: 2px;">
                <%
                    //Récupération de la liste des médicaments selon l'id du patient
                    //dans la session
                    MedicamentModel mm = new MedicamentModel();
                    List<Medicament> lm = mm.listerMedicament(p.getIdPat());
                    //Test sur la liste : si elle est vide on affiche un message 
                    // Si non on affiche les médicaments déposés un par un
                    if (lm.isEmpty()) {
                        out.println("Vous n'avez pas des dons de médicaments pour le moments");
                    } else {
                        for (int i = 0; i < lm.size(); i++) {
                            //A chaque fois récupération de l'élément de la liste 
                            // dans l'objet médicament
                            Medicament m = lm.get(i);
                %>
                <article style="display: flex; justify-content: center;margin-bottom: 15px;margin-top: 15px;padding-left: 20px;padding-right: 20px;">
                    <div class="card" style="width: 40rem;background-color: #2BBBAD;">
                        <div class="card-body">
                            <!-- Affichage de l'image selon son id-->
                            <p><img class="card-img-top" src="getMedImage.jsp?id=<%=m.getIdMed()%>" style="width: 15rem;height: 10rem;"></p>
                            Nom médicament :
                            <input class="form-control" type="text" value="<%=m.getNomMed()%>" disabled="">
                            Forme pharmaceutique :
                            <input class="form-control" type="text" value="<%=m.getFormeMed()%>" disabled="">
                            Classe thérapeutique :
                            <input class="form-control" type="text" value="<%=m.getClasseTherp()%>" disabled="">
                            Date de validité : 
                            <input style="margin-bottom:20px; " value="<%=m.getDateValidite()%>" type="text" id="example" class="form-control" disabled="">
                            Quantité :
                            <input type="text" class="form-control" value="<%=m.getQuantite()%>" disabled="">
                            <table cellpadding = 3>
                                <tr>
                                    <td>
                                        <form method="post" action="/E_Medecine/ModifierMed">
                                            <input type="text" name="id" value="<%=m.getIdMed()%>" style="display: none;">
                                            <button type="submit" class="btn btn-primary">Modifier</button></a>
                                        </form>
                                    </td>
                                    <td>
                                        <form method="post" action="/E_Medecine/SupprimerMed">
                                            <input type="text" name="id" value="<%=m.getIdMed()%>" style="display: none;">
                                            <button type="submit" class="btn btn-danger">Supprimer</button></a>
                                        </form>                                    
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </article>
                <%
                        }
                    }
                %>
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
