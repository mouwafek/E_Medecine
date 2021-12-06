<%-- 
    Document   : telecharger
    Created on : 17 juin 2020, 17:31:34
    Author     : mou
--%>

<%@page import="com.e_medecine.entities.Allergie"%>
<%@page import="com.e_medecine.entities.PatientAl"%>
<%@page import="com.e_medecine.beans.AllergieModel"%>
<%@page import="com.e_medecine.beans.PatientAlModel"%>
<%@page import="com.e_medecine.entities.AntecedentChirurgical"%>
<%@page import="com.e_medecine.entities.PatientCh"%>
<%@page import="com.e_medecine.beans.AntChModel"%>
<%@page import="com.e_medecine.beans.PatientChModel"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.e_medecine.beans.MaldieModel"%>
<%@page import="com.e_medecine.entities.Maladie"%>
<%@page import="com.e_medecine.entities.PatientM"%>
<%@page import="java.util.List"%>
<%@page import="com.e_medecine.beans.PatientMmodel"%>
<%@page import="com.e_medecine.entities.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Consulter Profil</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="img/Logo.png" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body style="background: #8e9eab;  /* fallback for old browsers */
          background: -webkit-linear-gradient(to bottom, #eef2f3, #8e9eab);  /* Chrome 10-25, Safari 5.1-6 */
          background: linear-gradient(to bottom, #eef2f3, #8e9eab); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
          ">
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
        <main>
            <br>
            <br>
            <br>
            <div class="container">

                <div style="">
                    <div>
                        <p style="margin-top: 30px;margin-left: 50px;">
                            <strong>E-Medecine</strong>
                        </p>
                    </div>
                    <div style="text-align: center;width:auto;height: 250px;margin-right:100px;margin-left: 100px;margin-bottom: 30px;
                         margin-top: 60px;background: #136a8a;  /* fallback for old browsers */
                         background: -webkit-linear-gradient(to bottom, #267871, #136a8a);  /* Chrome 10-25, Safari 5.1-6 */
                         background: linear-gradient(to bottom, #267871, #136a8a); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
                         border-radius: 100px;">
                        <h1 style="color: white;padding-top: 90px;">Mon profil médical</h1>
                    </div>
                    <div style="text-align: center;padding-top: 50px;padding-left: 20px;padding-right: 20px;margin-bottom: 50px;">
                        <em><h3>Afin de profiter au maximum de votre visite médicale, prenez le temps de noter vos maladies et de
                                faire l’inventaire de vos médicaments et de vos allergies. Ces renseignements aideront les professionnels de santé
                                que vous consulterez à poser le bon diagnostic et à vous traiter efficacement.</h3></em>
                    </div> 
                </div>
                <hr>
                <div style="text-align: center;">
                    <h2 style="margin-bottom: 20px;">Informations personnelles</h2>
                    <div class="table-responsive text-nowrap">

                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Nom</th>
                                    <th scope="col">Prénom</th>
                                    <th scope="col">Age</th>
                                    <th scope="col">Poid</th>
                                    <th scope="col">Taille</th>
                                    <th scope="col">Groupe sanguin</th>
                                    <th scope="col">Travail</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><%=p.getNomPat()%></td>
                                    <td><%=p.getPrenomPat()%></td>
                                    <td>
                                        <%
                                            int a = Integer.parseInt(p.getDateNaisPat().toString().substring(0, 4));
                                            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                                            Date date = new Date();
                                            int as = Integer.parseInt(format.format(date).substring(6));
                                            int age = as - a;
                                            out.println(age);
                                        %>
                                    </td>
                                    <td><%=p.getPoid() + " Kg"%></td>
                                    <td><%=p.getAge() + " cm"%></td>
                                    <td><%=p.getGroupeSanguin()%></td>
                                    <td><%=p.getTravail()%></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <hr>
                    <h2 style="margin-bottom: 20px;">Antécédents personnels de maladies</h2>
                    <div class="table-responsive text-nowrap">

                        <table class="table">
                            <%
                                PatientMmodel pmm = new PatientMmodel();
                                MaldieModel mm = new MaldieModel();
                                List<PatientM> pml = pmm.listerPatientM(p.getIdPat());
                                if (pml.isEmpty()) {
                                    out.println("Pas de maladies");
                                } else {
                            %>
                            <thead>
                                <tr>
                                    <th scope="col">Type</th>
                                    <th scope="col">Maladie</th>
                                    <th scope="col">Age de début</th>
                                    <th scope="col">Date de début</th>
                                    <th scope="col">Date de fin</th>
                                    <th scope="col">Traitement</th>
                                    <th scope="col">Arrêt au travail</th>
                                </tr>
                            </thead>
                            <%for (int i = 0; i < pml.size(); i++) {
                                    PatientM pm = pml.get(i);
                                    int id_m = pm.getId().getIdM();
                                    Maladie m = mm.listerMaladie(id_m).get(0);
                            %>
                            <tbody>
                                <tr>
                                    <td><%=m.getTypeM()%></td>
                                    <td><%=m.getNomM()%></td>
                                    <td>
                                        <%
                                            out.println(age);
                                        %>
                                    </td>
                                    <td><%=pm.getDateDM()%></td>
                                    <td>
                                        <%
                                            if (pm.getDateFM() == null) {
                                                out.println("....");
                                            } else {
                                                out.println(pm.getDateFM());
                                            }
                                        %>

                                    </td>
                                    <td><%=pm.getTraitement()%></td>
                                    <td>
                                        <%
                                            if (pm.getArretTrav() == Boolean.TRUE) {
                                                out.println("Oui");
                                            } else {
                                                out.println("Non");
                                            }
                                        %>
                                    </td>
                                </tr>
                                <%
                                        }
                                    }
                                %>
                            </tbody>
                        </table>
                    </div>
                    <hr>
                    <h2 style="margin-bottom: 20px;">Chirurgies</h2>
                    <div class="table-responsive text-nowrap">

                        <table class="table">
                            <%
                                PatientChModel pcm = new PatientChModel();
                                AntChModel acm = new AntChModel();
                                List<PatientCh> pch = pcm.listerPatientCh(p.getIdPat());
                                if (pch.isEmpty()) {
                                    out.println("Pas de chirurgies");
                                } else {
                            %>
                            <thead>
                                <tr>
                                    <th scope="col">Chirurgie</th>
                                    <th scope="col">Raison</th>
                                    <th scope="col">Date</th>
                                    <th scope="col">Hôpital</th>
                                </tr>
                            </thead>
                            <%for (int i = 0; i < pch.size(); i++) {
                                    PatientCh pc = pch.get(i);
                                    int id_ch = pc.getId().getIdCh();
                                    AntecedentChirurgical ac = acm.listerAntCh(id_ch).get(0);
                            %>
                            <tbody>
                                <tr>
                                    <td><%=ac.getNomOp()%></td>
                                    <td><%=pc.getRaison()%></td>
                                    <td><%=pc.getDateOp()%></td>
                                    <td><%=pc.getLocal()%></td>
                                </tr>
                                <%
                                        }
                                    }
                                %>
                            </tbody>
                        </table>
                    </div>
                    <hr>
                    <h2 style="margin-bottom: 20px;">Liste des allergies</h2>
                    <div class="table-responsive text-nowrap">

                        <table class="table">
                            <%
                                PatientAlModel plm = new PatientAlModel();
                                AllergieModel alm = new AllergieModel();
                                List<PatientAl> pal = plm.listerPatientAl(p.getIdPat());
                                if (pal.isEmpty()) {
                                    out.println("Pas d'allergies");
                                } else {
                            %>
                            <thead>
                                <tr>
                                    <th scope="col">Médicament ou produit</th>
                                    <th scope="col">Date de début</th>
                                    <th scope="col">Type de réaction</th>
                                    <th scope="col">Etat de réaction</th>
                                </tr>
                            </thead>
                            <%for (int i = 0; i < pal.size(); i++) {
                                    PatientAl pl = pal.get(i);
                                    int id_al = pl.getId().getIdAl();
                                    Allergie al = alm.listerAllergie(id_al).get(0);
                            %>
                            <tbody>
                                <tr>
                                    <td><%=al.getProduitAl()%></td>
                                    <td><%=pl.getDateDAl()%></td>
                                    <td><%=pl.getTypeReact()%></td>
                                    <td><%=pl.getEtatReact()%></td>
                                </tr>
                                <%
                                        }
                                    }
                                %>
                            </tbody>
                        </table>
                    </div>
                    <hr>
                    <h2>Informations supplémentaires</h2>
                    <div>
                        <h3>Habitudes de vie</h3>
                        Tabac : <select>
                            <option>Rien</option>
                            <option>Cigarette</option>
                        </select>
                        <br>
                        Act ph  :<select>
                            <option></option>
                        </select>
                    </div>
                </div>

            </div>
            <div style="text-align: center;margin-bottom: 30px;margin-top: 30px;">
                <button type="button" id="print" class="btn btn-danger">Télécharger</button>
            </div>
        </main>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="js/javascript.js" ></script>
        <script src="js/jquery.js" ></script>
        <script src="js/printThis.js" ></script>
        <script>
            $('#print').click(function () {
                $('.container').printThis();
            });
        </script>
        <%            } else
                this.getServletContext().getRequestDispatcher("/loginPatient.jsp").forward(request, response);
        %>
    </body>
</html>
