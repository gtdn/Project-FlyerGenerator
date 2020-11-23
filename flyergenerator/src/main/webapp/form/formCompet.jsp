<%@page pageEncoding="UTF-8"%>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<form method="POST" action="formEvent">
    <h2>Créez votre flyer pour une compétition</h2>

    <div class="form-group">
      <label for="eventTitle">Nom de l'évènement</label>
      <input type="text" name="eventTitle" value="${nom}" placeholder="Porsche Cup Event" class="form-control" id="eventTitle" minlength="5" maxlength="30" required>
    </div>

    <div class="form-group">
        <label for="eventCity">Ville</label>
        <input type="text" name="eventCity" value="${ville}" placeholder="La Ciotat" class="form-control" id="eventCity" minlength="2" maxlength="25" required>
    </div>

    <div class="form-group">
        <label for="eventLocation">Lieu</label>
        <input type="text" name="eventLocation" value="${lieu}" placeholder="Circuit Paul Ricard - Le Castellet" class="form-control" id="eventLocation" maxlength="35" required>
    </div>

    <div class="form-group">
        <label for="eventPrice">Prix d'entrée</label>
        <input type="number" name="eventPrice" value="${prix}" placeholder="20" class="form-control" id="eventPrice" min="0" required>
    </div>

    <div class="form-group">
        <label for="eventCashPrize">Cashprize du gagnant</label>
        <input type="text" name="eventCashPrize" value="${cashPrize}" placeholder="Pack de bières / 150€ / ..." class="form-control" id="eventCashPrize" maxlength="25" required>
    </div>

    <div class="form-group">
        <label for="eventDateBeg">Date</label>
        <input type="date" name="eventDateBeg" value="${date}" value="2020-12-29" class="form-control" id="eventDateBeg" required>
    </div>

    <div class="form-group">
        <label for="eventHourBeg">Horaire</label>
        <input type="time" name="eventHourBeg" class="form-control" id="eventHourBeg" required>
    </div>

    <div class="form-group">
        <label for="eventOrganizer">Nom de l'organisateur</label>
        <input type="text" name="eventOrganizer" value="${nom_orga}" placeholder="Porsche Cup Suisse" class="form-control" id="eventOrganizer" maxlength="20" required>
    </div>

    <div class="form-group">
        <label for="eventContactNumber">Numero contact</label>
        <input type="tel" name="eventContactNumber" value="${numeroContact}" placeholder="0617283971" class="form-control" id="eventContactNumber" pattern="[0-9]{10}" required>
    </div>

    <div class="form-group">
        <label for="eventContactEmail">Email contact</label>
        <input type="email" name="eventContactEmail" value="${mail}" placeholder="porsche@cup.ch" class="form-control" id="eventContactEmail" required>
    </div>

    <div class="form-group">
        <label for="eventHashtag">Hashtag de l'évènement</label>
        <input type="text" name="eventHashtag" value="${hashtag}" placeholder="thisisahashtag" class="form-control" id="eventPrice" maxlength="20" required>
    </div>

    <div class="form-group">
        <label for="eventDescription">Description de l'évènement</label>
        <input type="text" name="eventDescription" value="${description}" placeholder="Affrontez les meilleurs pilotes sur l'un des plus beaux circuits de France" class="form-control" id="eventDescription" maxlength="120" required>
    </div>

    <div class="form-group">
        <input type="hidden" name="eventType" class="form-control" id="eventType" value="competition" required>
    </div>

    <div class="form-group">
        <label for="img">Choisissez son background</label>
        <table class="table">
            <tbody>
              <tr>
                <td>
                    <div>
                        <label for="Compet_1">Première image</label>
                        <input type="radio" name="eventBackground" id="Compet_1" value="1" required>
                        <div>
                            <img src="img/Compet/flyer_competition_background_1.jpg" alt="img1" width="108" height="192">
                        </div>
                    </div>
                </td>
                <td>
                    <div>
                        <label for="Compet_2">Deuxième image</label>
                        <input type="radio" name="eventBackground" id="Compet_2" value="2">
                        <div>
                            <img src="img/Compet/flyer_competition_background_2.jpg" alt="img2" width="108" height="192">
                        </div>
                    </div>
                </td><td>
                    <div>
                        <label for="Compet_3">Troisième image</label>
                        <input type="radio" name="eventBackground" id="Compet_3" value="3">
                        <div>
                            <img src="img/Compet/flyer_competition_background_3.jpg" alt="img3" width="108" height="192">
                        </div>
                    </div>
                </td><td>
                    <div>
                        <label for="Compet_4">Quatrième image</label>
                        <input type="radio" name="eventBackground" id="Compet_4" value="4">
                        <div>
                            <img src="img/Compet/flyer_competition_background_4.jpg" alt="img4" width="108" height="192">
                        </div>
                    </div>
                </td>
              </tr>
            </tbody>
          </table>
    </div>
    <button id="button-form" type="submit" class="btn btn-primary">Créer</button>
</form>
