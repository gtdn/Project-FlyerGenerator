<%@ page contentType="text/html;charset=UTF-8" %>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<form method="POST" action="formEvent">
    <h2>Créez votre flyer pour une exposition</h2>

    <div class="form-group">
      <label for="eventTitle">Nom de l'évènement</label>
      <input type="text" name="eventTitle" value="${nom}" placeholder="Salon Mondial de l'Automobile" class="form-control" id="eventTitle" minlength="15" maxlength="45" required>
    </div>

    <div class="form-group">
        <label for="eventCity">Ville</label>
        <input type="text" name="eventCity" value="${ville}" placeholder="Genève" class="form-control" id="eventCity" minlength="2" maxlength="25" required>
    </div>

    <div class="form-group">
        <label for="eventLocation">Lieu</label>
        <input type="text" name="eventLocation" value="${lieu}" placeholder="Palais des Expositions" class="form-control" id="eventLocation" maxlength="30" required>
    </div>

    <div class="form-group">
        <label for="eventPrice">Prix d'entrée</label>
        <input type="number" name="eventPrice" value="${prix}" placeholder="10" class="form-control" id="eventPrice" min="0" required>
    </div>

    <div class="form-group">
        <label for="eventDateBeg">Date de début</label>
        <input type="date" name="eventDateBeg" value="${dateDeb}" value="2020-12-29" class="form-control" id="eventDateBeg" required>
    </div>

    <div class="form-group">
        <label for="eventDateEnd">Date de fin</label>
        <input type="date" name="eventDateEnd" value="${dateFin}" value="2020-12-31" class="form-control" id="eventDateEnd" required>
    </div>

    <div class="form-group">
        <label for="eventHourBeg">Horaire de début</label>
        <input type="time" name="eventHourBeg" class="form-control" id="eventHourBeg" required>
    </div>

    <div class="form-group">
        <label for="eventHourEnd">Horaire de fin</label>
        <input type="time" name="eventHourEnd" class="form-control" id="eventHourEnd" required>
    </div>

    <div class="form-group">
        <label for="eventOrganizer">Nom organisateur</label>
        <input type="text" name="eventOrganizer" value="${nom_contact}" placeholder="Office du tourisme de Genève" class="form-control" id="eventOrganizer" required>
    </div>

    <div class="form-group">
        <label for="eventContactNumber">Numero contact</label>
        <input type="number" name="eventContactNumber" value="${numeroContact}" placeholder="0619527182" class="form-control" id="eventContactNumber" pattern="[0-9]{10}" required>
    </div>

    <div class="form-group">
        <label for="eventContactEmail">Email contact</label>
        <input type="email" name="eventContactEmail" value="${mail}" placeholder="palexpo@geneve.ch" class="form-control" id="eventContactEmail" required>
    </div>

    <div class="form-group">
        <label for="eventTheme">Thème de l'évènement</label>
        <input type="text" name="eventTheme" value="${theme}" placeholder="Automobile" class="form-control" id="eventTheme" required>
    </div>

    <div class="form-group">
        <input type="hidden" name="eventType" class="form-control" id="eventType" value="exposition" required>
    </div>

    <div class="form-group">
        <label for="img">Choisissez son background</label>
        <table class="table">
            <tbody>
              <tr>
                <td>
                    <div>
                        <label for="Expo_1">Première image</label>
                        <input type="radio" name="eventBackground" id="Expo_1" value="1" required>
                        <div>
                            <img src="img/Expo/flyer_exposition_background_1.jpg" alt="img1" width="108" height="192">
                        </div>
                    </div>
                </td>
                <td>
                    <div>
                        <label for="Expo_2">Deuxième image</label>
                        <input type="radio" name="eventBackground" id="Expo_2" value="2">
                        <div>
                            <img src="img/Expo/flyer_exposition_background_2.jpg" alt="img2" width="108" height="192">
                        </div>
                    </div>
                </td><td>
                    <div>
                        <label for="Expo_3">Troisième image</label>
                        <input type="radio" name="eventBackground" id="Expo_3" value="3">
                        <div>
                            <img src="img/Expo/flyer_exposition_background_3.jpg" alt="img3" width="108" height="192">
                        </div>
                    </div>
                </td><td>
                    <div>
                        <label for="Expo_4">Quatrième image</label>
                        <input type="radio" name="eventBackground" id="Expo_4" value="4">
                        <div>
                            <img src="img/Expo/flyer_exposition_background_4.jpg" alt="img4" width="108" height="192">
                        </div>
                    </div>
                </td>
              </tr>
            </tbody>
          </table>
    </div>

    <button id="button-form" type="submit" class="btn btn-primary">Créer</button>
</form>
