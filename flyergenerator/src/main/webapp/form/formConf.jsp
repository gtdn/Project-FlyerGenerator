<%@ page contentType="text/html;charset=UTF-8" %>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<form method="POST" action="formEvent">
    <h2>Créez votre flyer pour une conférence</h2>

    <div class="form-group">
      <label for="eventTitle">Nom de l'évènement</label>
      <input type="text" name="eventTitle" value="${nom}" placeholder="Pour un optimisme obstiné sur le climat" class="form-control" id="eventTitle" maxlength="45" required>
    </div>

    <div class="form-group">
        <label for="eventCity">Ville</label>
        <input type="text" name="eventCity" value="${ville}" placeholder="Paris" class="form-control" id="eventCity" minlength="2" maxlength="16" required>
    </div>

    <div class="form-group">
        <label for="eventLocation">Lieu</label>
        <input type="text" name="eventLocation" value="${lieu}" placeholder="Salons de l'Aveyron" class="form-control" id="eventLocation" maxlength="30" required>
    </div>

    <div class="form-group">
        <label for="eventPrice">Prix d'entrée</label>
        <input type="number" name="eventPrice" value="${prix}" placeholder="10" class="form-control" id="eventPrice" min="0">
    </div>

    <div class="form-group">
        <label for="eventDateBeg">Date</label>
        <input type="date" name="eventDateBeg" value="${date}" class="form-control" id="eventDateBeg" required>
    </div>

    <div class="form-group">
        <label for="eventHourBeg">Horaire</label>
        <input type="time" name="eventHourBeg" class="form-control" id="eventHourBeg" required>
    </div>

    <div class="form-group">
        <label for="eventOrganizer">Nom de l'organisateur</label>
        <input type="text" name="eventOrganizer" value="${nom_orga}" placeholder="Frydays for Future" class="form-control" maxlength="20" id="eventOrganizer">
    </div>

    <div class="form-group">
        <label for="eventSpeaker1">Intervenants (Séparer les intervanants avec des virgules, 3 max)</label>
        <input type="text" name="eventSpeaker1" value="${intervenants}" placeholder="Greta Thunberg" class="form-control" id="eventSpeaker1" required>
    </div>

    <div class="form-group">
        <label for="eventContactNumber">Numero contact</label>
        <input type="tel" name="eventContactNumber" value="${numeroContact}" placeholder="0619527182" class="form-control" id="eventContactNumber" pattern="[0-9]{10}" required>
    </div>

    <div class="form-group">
        <label for="eventContactEmail">Email contact</label>
        <input type="email" name="eventContactEmail" value="${mail}" placeholder="fridaysforfuture@outlook.com" class="form-control" id="eventContactEmail" required>
    </div>

    <div class="form-group">
        <label for="eventDescription">Description de l'évènement</label>
        <input type="text" name="eventDescription" value="${description}" placeholder="Conférence sur le climat et les enjeux des années à venir..." class="form-control" id="eventDescription" maxlength="120" required>
    </div>

    <div class="form-group">
        <input type="hidden" name="eventType" class="form-control" id="eventType" value="conference" required>
    </div>

    <div class="form-group">
        <label for="img">Choisissez son background</label>
        <table class="table">
            <tbody>
              <tr>
                <td>
                    <div>
                        <label for="Conf_1">Première image</label>
                        <input type="radio" name="eventBackground" id="Conf_1" value="1" required>
                        <div>
                            <img src="img/Conf/flyer_conference_background_1.jpg" alt="img1" width="108" height="192">
                        </div>
                    </div>
                </td>
                <td>
                    <div>
                        <label for="Conf_2">Deuxième image</label>
                        <input type="radio" name="eventBackground" id="Conf_2" value="2">
                        <div>
                            <img src="img/Conf/flyer_conference_background_2.jpg" alt="img2" width="108" height="192">
                        </div>
                    </div>
                </td><td>
                    <div>
                        <label for="Conf_3">Troisième image</label>
                        <input type="radio" name="eventBackground" id="Conf_3" value="3">
                        <div>
                            <img src="img/Conf/flyer_conference_background_3.jpg" alt="img3" width="108" height="192">
                        </div>
                    </div>
                </td><td>
                    <div>
                        <label for="Conf_4">Quatrième image</label>
                        <input type="radio" name="eventBackground" id="Conf_4" value="4">
                        <div>
                            <img src="img/Conf/flyer_conference_background_4.jpg" alt="img4" width="108" height="192">
                        </div>
                    </div>
                </td>
              </tr>
            </tbody>
          </table>
    </div>
    <button id="button-form" type="submit" class="btn btn-primary">Créer</button>
</form>
