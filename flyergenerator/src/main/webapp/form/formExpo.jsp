<%@ page contentType="text/html;charset=UTF-8" %>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<form method="POST" action="formEvent">
    <h2>Formulaire Exposition</h2>

    <div class="form-group">
      <label for="name">Nom de l'évènement</label>
      <input type="text" name="eventTitle" placeholder="Salon Mondial de l'Automobile" class="form-control" id="name" maxlength="45" required>
    </div>

    <div class="form-group">
        <label for="location">Ville</label>
        <input type="text" name="eventCity" class="form-control" id="location" maxlength="25" required>
    </div>

    <div class="form-group">
        <label for="location">Lieu</label>
        <input type="text" name="eventLocation" class="form-control" id="location" maxlength="30" required>
    </div>

    <div class="form-group">
        <label for="prix">Prix d'entrée</label>
        <input type="number" name="eventPrice" class="form-control" id="prix" min="0">
    </div>

    <div class="form-group">
        <label for="img">Background Flyer</label>
        <input type="image" class="form-control" id="img">
    </div>

    <div class="form-group">
        <label for="dateBeg">Date de début</label>
        <input type="date" name="eventDateBeg" class="form-control" id="dateBeg" required>
    </div>

    <div class="form-group">
        <label for="dateEnd">Date de fin</label>
        <input type="date" name="eventDateEnd" class="form-control" id="dateEnd" required>
    </div>

    <div class="form-group">
        <label for="contactName">Nom contact</label>
        <input type="text" name="eventContactName" class="form-control" id="contactName">
    </div>

    <div class="form-group">
        <label for="contactNumber">Numero contact</label>
        <input type="number" name="eventContactNumber" class="form-control" id="contactNumber" required>
    </div>

    <div class="form-group">
        <label for="contactEmail">Email contact</label>
        <input type="email" name="eventContactEmail" class="form-control" id="contactEmail" required>
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
