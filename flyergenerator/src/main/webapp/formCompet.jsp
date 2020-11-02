<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<form>
    <h2> Formulaire Competition </h2>
    <div class="form-group">
      <label for="name">Nom de l'evenement</label>
      <input type="email" class="form-control" id="name">
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
        <label for="hashTag">Hashtag</label>
        <input type="text" class="form-control" id="hashTag">
    </div>    
    <div class="form-group">
        <label for="resume">Resume</label>
        <input type="text" class="form-control" id="resume">
    </div>
    <div class="form-group">
        <label for="price">Prix du la competition</label>
        <input type="text" class="form-control" id="price">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>