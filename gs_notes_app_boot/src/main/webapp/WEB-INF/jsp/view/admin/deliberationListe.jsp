<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>


<jsp:include page="../fragments/adminHeader.jsp" />

<div class="container">

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">

            <jsp:include page="../fragments/menu.jsp" />

        </div>
    </nav>

    <br>
<div>
    <h3>Choisissez votre annee scolaire et votre niveau</h3>
</div>


    <br>
    <br>
    <br>

    <form  action="${pageContext.request.contextPath}/admin/exportNote" method ="post">
        <div class="col-md-4 offset-md-3">
        <label id ="anne" class="form-label"><h5>L'année d'inscription:</h5></label>
        <input  type="text" name="annee" id="annee"  class="form-control" placeholder="saisit l'annee">
         <br>

         <br>
        <select name="idNiveau" id="id Niveau" class="form-select">
            <c:forEach items="${niveauList}" var="n">
            <option value="${n.getIdNiveau()}"><c:out value="${n.getTitre()}" /></option>
            </c:forEach>
        </select>

            <br>
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>




</div>