<%@ page contentType="text/html;charset=UTF-8" %>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<form method="POST" action="formEvent">
    <h2>Créez votre flyer pour une compétition</h2>

    <div class="form-group">
      <label for="eventTitle">Nom de l'évènement</label>
      <input type="text" name="eventTitle" value="${nom}" placeholder="The 8 Mile Show" class="form-control" id="eventTitle" maxlength="45" required>
    </div>

    <div class="form-group">
        <label for="eventCity">Ville</label>
        <input type="text" name="eventCity" value="${ville}" placeholder="Detroit" class="form-control" id="eventCity" minlength="2" maxlength="20" required>
    </div>

    <div class="form-group">
        <label for="eventLocation">Lieu</label>
        <input type="text" name="eventLocation" value="${lieu}" placeholder="Bar Shelter" class="form-control" id="eventLocation" maxlength="30" required>
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
        <label for="eventAsso">Nom de l'association</label>
        <input type="text" name="eventAsso" value="${nom_asso}" placeholder="Shady Records" class="form-control" id="eventAsso" maxlength="25" required>
    </div>

    <div class="form-group">
        <label for="eventOrganizer">Nom de l'organisateur</label>
        <input type="text" name="eventOrganizer" value="${nom_orga}" placeholder="Shady Records" class="form-control" id="eventOrganizer" maxlength="25" required>
    </div>

    <div class="form-group">
        <label for="eventSpeaker1">Artistes (Séparer les intervanants avec des virgules, 3 max)</label>
        <input type="text" name="eventSpeaker1" value="${artistes}" placeholder="Slim Shady" class="form-control" id="eventSpeaker1" required>
    </div>

    <div class="form-group">
        <label for="eventContactNumber">Numero contact</label>
        <input type="number" name="eventContactNumber" value="${numeroContact}" placeholder="0617283971" class="form-control" id="eventContactNumber" pattern="[0-9]{10}" required>
    </div>

    <div class="form-group">
        <label for="eventContactEmail">Email contact</label>
        <input type="email" name="eventContactEmail" value="${mail}" placeholder="shady.records@gmail.com" class="form-control" id="eventContactEmail" required>
    </div>

    <div class="form-group">
        <input type="hidden" name="eventType" class="form-control" id="eventType" value="spectacle" required>
    </div>


    <div class="form-group">
        <label for="img">Choisissez son background</label>
        <table class="table">
            <tbody>
              <tr>
                <td>
                    <div>
                        <label for="Spec_1">Première image</label>
                        <input type="radio" name="eventBackground" id="Spec_1" value="1" required>
                        <div>
                            <img src="img/Spectacle/flyer_spectacle_background_1.jpg" alt="img1" width="108" height="192">
                        </div>
                    </div>
                </td>
                <td>
                    <div>
                        <label for="Spec_2">Deuxième image</label>
                        <input type="radio" name="eventBackground" id="Spec_2" value="2">
                        <div>
                            <img src="img/Spectacle/flyer_spectacle_background_2.jpg" alt="img2" width="108" height="192">
                        </div>
                    </div>
                </td><td>
                    <div>
                        <label for="Spec_3">Troisième image</label>
                        <input type="radio" name="eventBackground" id="Spec_3" value="3">
                        <div>
                            <img src="img/Spectacle/flyer_spectacle_background_3.jpg" alt="img3" width="108" height="192">
                        </div>
                    </div>
                </td><td>
                    <div>
                        <label for="Spec_4">Quatrième image</label>
                        <input type="radio" name="eventBackground" id="Spec_4" value="4">
                        <div>
                            <img src="img/Spectacle/flyer_spectacle_background_4.jpg" alt="img4" width="108" height="192">
                        </div>
                    </div>
                </td>
              </tr>
            </tbody>
          </table>
    </div>
    <button id="button-form" type="submit" class="btn btn-primary">Créer</button>
</form>
