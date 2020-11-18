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
        <label for="price">Choisissez le graphisme de votre flyer</label>
        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
            <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
                <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="First slide">
            </div>
            <div class="carousel-item">
                <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Second slide">
            </div>
            <div class="carousel-item">
                <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Third slide">
            </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
    <button id="button-form" type="submit" class="btn btn-primary">Submit</button>
</form>
