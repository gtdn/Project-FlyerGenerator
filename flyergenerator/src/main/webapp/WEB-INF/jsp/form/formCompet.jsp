<%@ page contentType="text/html;charset=UTF-8" %>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<form method="POST" action="formEvent">
    <h2>Créez votre flyer pour une compétition</h2>

    <div class="form-group">
      <label for="eventTitle">Nom de l'évènement</label>
      <input type="text" name="eventTitle" placeholder="Coupe de France de bucheronnage" class="form-control" id="eventTitle" minlength="15" maxlength="45" required>
    </div>

    <div class="form-group">
        <label for="eventCity">Ville</label>
        <input type="text" name="eventCity" placeholder="La Rochelle" class="form-control" id="eventCity" minlength="2" maxlength="25" required>
    </div>

    <div class="form-group">
        <label for="eventLocation">Lieu</label>
        <input type="text" name="eventLocation" placeholder="Parc de Mireuil" class="form-control" id="eventLocation" maxlength="30" required>
    </div>

    <div class="form-group">
        <label for="eventPrice">Prix d'entrée</label>
        <input type="number" name="eventPrice" placeholder="10" class="form-control" id="eventPrice" min="0">
    </div>

    <div class="form-group">
        <label for="eventCashPrize">Cashprize du gagnant</label>
        <input type="text" name="eventCashPrize" placeholder="Pack de bières / 15€" class="form-control" id="eventCashPrize" maxlength="25">
    </div>

    <div class="form-group">
        <label for="img">Background Flyer (à voir plus tard)</label>
        <input type="image" class="form-control" id="img">
    </div>

    <div class="form-group">
        <label for="eventDateBeg">Date</label>
        <input type="date" name="eventDateBeg" value="2020-12-29" class="form-control" id="eventDateBeg" required>
    </div>

    <div class="form-group">
        <label for="eventHourBeg">Horaire</label>
        <input type="time" name="eventHourBeg" class="form-control" id="eventHourBeg" required>
    </div>

    <div class="form-group">
        <label for="eventOrganizer">Nom de l'organisateur</label>
        <input type="text" name="eventOrganizer" placeholder="Fédération Française de Bucheronnage" class="form-control" id="eventOrganizer">
    </div>

    <div class="form-group">
        <label for="eventContactNumber">Numero contact</label>
        <input type="number" name="eventContactNumber" placeholder="0617283971" class="form-control" id="eventContactNumber" required>
    </div>

    <div class="form-group">
        <label for="eventContactEmail">Email contact</label>
        <input type="email" name="eventContactEmail" placeholder="roger.legrobra@gmail.com" class="form-control" id="eventContactEmail" required>
    </div>

    <div class="form-group">
        <label for="eventHashtag">Hashtag de l'évènement</label>
        <input type="text" name="eventHashtag" placeholder="bucheronnageCompetition" class="form-control" id="eventPrice" required>
    </div>

    <div class="form-group">
        <label for="eventDescription">Description de l'évènement</label>
        <input type="text" name="eventDescription" placeholder="Affrontez les plus grands bûcherons de France..." class="form-control" id="eventDescription" maxlength="120">
    </div>

    <div class="form-group">
        <input type="hidden" name="eventType" class="form-control" id="eventType" value="competition" required>
    </div>

    <div class="form-group">
        <label for="img">Choississez son background</label>
        <table class="table">
            <tbody>
              <tr>
                <td>
                    <div>
                        <input type="radio" name="Compet" id="Compet_1">
                        <label>Première image</label>
                        <div>
                            <img src="../../img/Compet/Compet_1.jpg" alt="img1" width="108" height="192">
                        </div>
                    </div>
                </td>
                <td>
                    <div>
                        <input type="radio" name="Compet" id="Compet_2">
                        <label>Deuxième image</label>
                        <div>
                            <img src="../../img/Compet/Compet_2.jpg" alt="img2" width="108" height="192">
                        </div>
                    </div>
                </td><td>
                    <div>
                        <input type="radio" name="Compet" id="Compet_3">
                        <label>Troisième image</label>
                        <div>
                            <img src="../../img/Compet/Compet_3.jpg" alt="img3" width="108" height="192">
                        </div>
                    </div>
                </td><td>
                    <div>
                        <input type="radio" name="Compet" id="Compet_4">
                        <label>Quatrième image</label>
                        <div>
                            <img src="../../img/Compet/Compet_4.jpg" alt="img4" width="108" height="192">
                        </div>
                    </div>
                </td>
              </tr>
            </tbody>
          </table>
    </div>
    <button id="button-form" type="submit" class="btn btn-primary">Submit</button>
</form>
