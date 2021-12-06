<%-- 
    Document   : inscriptionDocteur
    Created on : 1 juin 2020, 11:06:15
    Author     : mou
--%>

<%@page import="com.e_medecine.entities.Specialite"%>
<%@page import="java.util.List"%>
<%@page import="com.e_medecine.beans.SpecialiteModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Inscription docteur</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="img/logo1.png" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body style="background: #00C9FF;  /* fallback for old browsers */
          background: -webkit-linear-gradient(to right, #92FE9D, #00C9FF);  /* Chrome 10-25, Safari 5.1-6 */
          background: linear-gradient(to right, #92FE9D, #00C9FF); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
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
            <%  /*Récupération des messages d'erreurs en cas d'existance des memes 
                données d'un autre prof ou cabinet*/
                String mes = (String) request.getAttribute("m");
                if (mes == null)
                    out.println("");
                else {%>
            <p style="background-color:red; text-align: center;"><%out.println(mes);
                }%></p>
                <% String cab = (String) request.getAttribute("cab");
                    if (cab == null)
                        out.println("");
                    else {%>
            <p style="background-color:red; text-align: center;"><%out.println(cab);
                }%></p>
            
            <% //Message d'erreur en cas de faut horaire 
                String lner = (String) request.getAttribute("lner");
                    if (lner == null)
                        out.println("");
                    else {%>
            <p style="background-color:red; text-align: center;"><%out.println(lner);
                }%></p>
            <!-- Formulaire d'infos cabinet-->
            <div style="margin-bottom: 20px;margin-top: 20px;">
                <article style="display: flex; justify-content: center;margin-left: 20px;margin-right: 20px;">
                    <div class="form" style="width: 60rem;background-color: white;padding-left: 15px;padding-right: 15px;border-radius: 10px;">
                        <form method="post" action="/E_Medecine/InscriptionProf" enctype="multipart/form-data">
                            <h2 style="text-align: center;margin-top: 20px;">Informations du cabinet</h2>
                            Gouvernorat :
                            <div class="input-group mb-3">
                                <select name="gouv" class="custom-select" id="inputGroupSelect01" required="">
                                    <option selected></option>
                                    <option>Ariana</option>
                                    <option>Béja</option>
                                    <option>Ben Arous</option>
                                    <option>Bizerte</option>
                                    <option>Gabès</option>
                                    <option>Gafsa</option>
                                    <option>Jendouba</option>
                                    <option>Kairouan</option>
                                    <option>Kasserine</option>
                                    <option>Kébili</option>
                                    <option>Le Kef</option>
                                    <option>Mahdia</option>
                                    <option>Manouba</option>
                                    <option>Médenine</option>
                                    <option>Monastir</option>
                                    <option>Nabeul</option>
                                    <option>Sfax</option>
                                    <option>Sidi Bouzid</option>
                                    <option>Siliana</option>
                                    <option>Sousse</option>
                                    <option>Tataouine</option>
                                    <option>Tozeur</option>
                                    <option>Tunis</option>
                                    <option>Zaghouan</option>
                                </select>
                            </div>
                            Délégation :
                            <input type="text"  class="form-control" name="del" required="">
                            Adresse complète :
                            <textarea name="adcab" class="form-control" required=""></textarea>
                            Téléphone fixe :
                            <input type="text"  class="form-control" name="telf" required="">
                            Description :
                            <textarea name="desc" class="form-control" required=""></textarea>
                            Jours de travail : <br>
                            <table border="3">
                                <tr>
                                    <td>Jour</td>
                                    <td>Lundi</td>
                                    <td>Mardi</td>
                                    <td>Mercredi</td>
                                    <td>Jeudi</td>
                                    <td>Vendredi</td>
                                    <td>Samedi</td>
                                    <td>Dimanche</td>
                                </tr>
                                <tr>
                                    <td>Disponibilité</td>
                                    <td>
                                        <select name="dispLundi">
                                            <option selected="">Fermé</option>
                                            <option>Ouvert</option>
                                        </select>
                                    </td>
                                    <td>
                                        <select name="dispMardi">
                                            <option selected="">Fermé</option>
                                            <option>Ouvert</option>
                                        </select>
                                    </td>
                                    <td>
                                        <select name="dispMercredi">
                                             <option selected="">Fermé</option>
                                            <option>Ouvert</option>
                                        </select>
                                    </td>
                                    <td>
                                        <select name="dispJeudi">
                                             <option selected="">Fermé</option>
                                            <option>Ouvert</option>
                                        </select>
                                    </td>
                                    <td>
                                        <select name="dispVendredi">
                                             <option selected="">Fermé</option>
                                            <option>Ouvert</option>
                                        </select>
                                    </td>
                                    <td>
                                        <select name="dispSamedi">
                                             <option selected="">Fermé</option>
                                            <option>Ouvert</option>
                                        </select>
                                    </td>
                                    <td>
                                        <select name="dispDimanche">
                                             <option selected="">Fermé</option>
                                            <option>Ouvert</option>
                                        </select>
                                    </td>
                            </table>
                            Prix par visite en dinar :
                            <input type="text"  class="form-control" name="prix" required="">
                            Acceptez-vous le paiment par carte bancaire? :
                            <div class="input-group mb-3">
                                <select name="cb" class="custom-select" id="inputGroupSelect01" required="">
                                    <option selected></option>
                                    <option>Oui</option>
                                    <option>Non</option>
                                </select>
                            </div>
                    </div>
                </article>
            </div>
            <!-- Formulaire d'infos professionnel de santé-->
            <div style="margin-bottom: 20px;margin-top: 20px;">
                <article style="display: flex; justify-content: center;margin-left: 20px;margin-right: 20px;">
                    <div class="form" style="width: 70rem;background-color: white;padding-left: 15px;padding-right: 15px;border-radius: 10px;">
                        <h2 style="text-align: center;margin-top: 20px;">Informations personnelles</h2>
                        Nom :
                        <input type="text" id="exampleForm2" class="form-control" name="nom" required="">
                        Prénom :
                        <input type="text" id="exampleForm2" class="form-control" name="pren" required="">
                        Email :
                        <input type="email" id="exampleForm2" class="form-control" name="mail" required="">
                        Mot de passe :
                        <input type="password" id="exampleForm2" class="form-control" name="pass" required="">
                        Date de naissance : 
                        <input placeholder="Date nais" type="date" id="example" class="form-control" name="dnais" required="">
                        Genre :
                        <div class="input-group mb-3">
                            <select name="genre" class="custom-select" id="inputGroupSelect01" required="">
                                <option selected></option>
                                <option>Male</option>
                                <option>Femelle</option>
                            </select>
                        </div>
                        Adresse physisque :
                        <textarea name="adrsph" class="form-control" required=""></textarea>
                        Téléphone mobile :
                        <input type="text" id="exampleForm2" class="form-control" name="tel" required="">
                        Spécialité :
                        <div class="input-group mb-3">
                            <select name="spec" class="custom-select" id="inputGroupSelect01" required="">
                                <option selected></option>
                                <%
                                    SpecialiteModel sm = new SpecialiteModel();
                                    List<Specialite> ls = sm.listerSpecialite();
                                    for (int i = 0; i < ls.size(); i++) {
                                %>
                                <option><%=ls.get(i).getNomSpec()%></option>
                                <%}%>
                            </select>
                        </div>
                        Diplome(s) et expériences :
                        <textarea name="dip" class="form-control" required=""></textarea>
                        Photo d'identité :
                        <input type="file" name="ident" class="form-control" required="">
                        Vous faites des visites à domicile aux patients?
                        <div class="input-group mb-3">
                            <select name="vdom" class="custom-select" id="inputGroupSelect01" required="">
                                <option selected></option>
                                <option>Oui</option>
                                <option>Non</option>
                            </select>
                        </div>
                        <p style="text-align: center;">
                            <input type="submit" value="S'inscrire" class="btn btn-primary" style="margin-top: 20px;">
                        </p>
                        </form>
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

    </script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="js/javascript.js" />
    <script src="js/jquery.js" />
</body>
</html>
