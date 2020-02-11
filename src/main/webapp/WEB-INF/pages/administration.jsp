<!DOCTYPE html>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<html >
<head>
    <title><spring:message code="header.administration"/></title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="administration-page-resources/images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="administration-page-resources/vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="administration-page-resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="administration-page-resources/vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="administration-page-resources/vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="administration-page-resources/vendor/perfect-scrollbar/perfect-scrollbar.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="administration-page-resources/css/util.css">
    <link rel="stylesheet" type="text/css" href="administration-page-resources/css/main.css">
    <link rel="stylesheet" href="foopicker-master/css/foopicker.css">
    <link rel="stylesheet" href="js-timepicker-master/js-timepicker.css">
    <!--===============================================================================================-->
</head>
<body>
<c:import url="header.jsp"/>

<div class="container-table100">
    <div class="wrap-table100">
        <c:if test="${networks != null}">
            <div class="wrap-table100">
                <h3>Nodes</h3>
                <div class="table">
                    <div class="row header">
                        <div class="cell">
                            ID
                        </div>
                        <div class="cell">
                            Name
                        </div>
                        <div class="cell">
                            Description
                        </div>
                        <div class="cell">
                            Params
                        </div>
                        <div class="cell">
                            NodeType
                        </div>
                    </div>
                    <c:forEach items="${networks}" var="network">
                        <div class="row">
                            <div class="cell" data-title="ID">
                                <c:out value="${network.id}"/>
                            </div>
                            <div class="cell" data-title="Name">
                                <c:out value="${network.name}"/>
                            </div>
                            <div class="cell" data-title="Description">
                                <c:out value="${network.description}"/>
                            </div>
                            <div class="cell" data-title="Params">
                                <c:out value="${network.params}"/>
                            </div>
                            <div class="cell" data-title="NodeType">
                                <c:out value="${network.nodeType}"/>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <c:forEach items="${networks}" var="network">
                <c:if test="${not empty network.childrenNodes}">
                <h3>Network: <c:out value="${network.name}"/></h3>
                <h3>Substations</h3>
                <div class="wrap-table100">
                    <div class="table">
                        <div class="row header">
                        <div class="cell">
                            ID
                        </div>
                        <div class="cell">
                            Name
                        </div>
                        <div class="cell">
                            Description
                        </div>
                        <div class="cell">
                            Params
                        </div>
                        <div class="cell">
                            NodeType
                        </div>
                    </div>
                    <c:forEach items="${network.childrenNodes}" var="substation">
                        <div class="row">
                            <div class="cell" data-title="ID">
                                <c:out value="${substation.id}"/>
                            </div>
                            <div class="cell" data-title="Name">
                                <c:out value="${substation.name}"/>
                            </div>
                            <div class="cell" data-title="Description">
                                <c:out value="${substation.description}"/>
                            </div>
                            <div class="cell" data-title="Params">
                                <c:out value="${substation.params}"/>
                            </div>
                            <div class="cell" data-title="NodeType">
                                <c:out value="${substation.nodeType}"/>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                </c:if>
            </c:forEach>
        </c:if>
                </div>
    </div>
</div>

<!--===============================================================================================-->
<script src="administration-page-resources/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="administration-page-resources/vendor/bootstrap/js/popper.js"></script>
<script src="administration-page-resources/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="administration-page-resources/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="administration-page-resources/js/main.js"></script>
<script src="foopicker-master/foopicker.js"></script>
<script src="js-timepicker-master/js-timepicker.js"></script>
<script type="text/javascript">
</script>

</body>
</html>