<%@ page contentType="text/html;charset=UTF-8" %>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<form method="GET" action="validation.jsp">
    <h2>Formulaire Exposition</h2>

    <div class="form-group">
      <label for="name">Nom de l'évènement</label>
      <input type="text" class="form-control" id="name">
    </div>

    <div class="form-group">
      <label for="location">Lieu</label>
      <input type="text" class="form-control" id="location">
    </div>
    <div class="form-group">
        <label for="prix">Prix</label>
        <input type="number" class="form-control" id="prix">
    </div>
    <div class="form-group">
        <label for="img">Background Flyer</label>
        <input type="image" class="form-control" id="img">
    </div>
    <div class="form-group">
        <label for="horBeg">Horaire Commencement</label>
        <input type="time" class="form-control" id="horBeg">
    </div>
    <div class="form-group">
        <label for="horEnd">Horaire de fin</label>
        <input type="time" class="form-control" id="horEnd">
    </div>
    <div class="form-group">
        <label for="dateBeg">Date de debut</label>
        <input type="date" class="form-control" id="dateBeg">
    </div>
    <div class="form-group">
        <label for="dateEnd">Date de fin</label>
        <input type="date" class="form-control" id="dateEnd">
    </div>
    <div class="form-group">
        <label for="contactName">Nom contact</label>
        <input type="text" class="form-control" id="contactName">
    </div>
    <div class="form-group">
        <label for="contactNumber">Numero contact</label>
        <input type="number" class="form-control" id="contactNumber">
    </div>
    <div class="form-group">
        <label for="contactEmail">Email contact</label>
        <input type="email" class="form-control" id="contactEmail">
    </div>
    <div class="form-group">
        <label for="theme">Theme</label>
        <input type="text" class="form-control" id="theme">
    </div>
    <div class="form-group">
        <label for="price">Choissiser le graphisme de votre flyer</label>
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
