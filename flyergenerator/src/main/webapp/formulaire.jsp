
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<div style="background-color: #e3e3e3">
    <form action="pageUtilisateur.jsp">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="id">id</label>
            <input type="text" class="form-control" id="id" placeholder="id">
        </div>
        <div class="form-group col-md-6">
            <label for="name">name</label>
            <input type="text" class="form-control" id="name" placeholder="name">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="idUser">idUser</label>
            <input type="text" class="form-control" id="idUser" placeholder="idUser">
        </div>
        <div class="form-group col-md-6">
            <label for="type">type</label>
            <input type="text" class="form-control" id="type" placeholder="type">
        </div>
    </div>
    <div class="form-group">
        <label for="pathImageBackground">pathImageBackground</label>
        <input type="text" class="form-control" id="pathImageBackground" placeholder="pathImageBackground">
    </div>
    <div class="form-group">
        <label for="Lieu">lieu</label>
        <input type="text" class="form-control" id="Lieu" placeholder="Apartment, studio, or floor">
    </div>
    <div class="form-group">
        <label for="prix">prix</label>
        <input type="text" class="form-control" id="prix" placeholder="xx euro">
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="heurDeb">heurDeb</label>
            <input type="text" class="form-control" id="heurDeb" placeholder="19h">
        </div>
        <div class="form-group col-md-6">
            <label for="heurFin">heurFin</label>
            <input type="text" class="form-control" id="heurFin" placeholder="21h">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="dateDeb">dateDeb</label>
            <input type="text" class="form-control" id="dateDeb" placeholder="1er Sep.">
        </div>
        <div class="form-group col-md-6">
            <label for="dateFin">dateFin</label>
            <input type="text" class="form-control" id="dateFin" placeholder="1er Sep.">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="listPerso">listPerso</label>
            <input type="text" class="form-control" id="listPerso" placeholder="Tom">
        </div>
        <div class="form-group col-md-6">
            <label for="contacts">contacts</label>
            <input type="text" class="form-control" id="contacts" placeholder="06xxxxxxxx">
        </div>
    </div>

    <button type="submit" class="btn btn-primary">Valider</button>
</form>
</div>