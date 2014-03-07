<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en-US"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en-US"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en-US"> <![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en-US"> <!--<![endif]-->
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- TODO title -->
    <title><tiles:insertAttribute name="title"/></title>

    <link rel="shortcut icon" href="<c:url value="/resources/images/favicon.png"/>"/>

    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
          rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet'
          type='text/css'>

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
    <link rel='stylesheet' id='bootstrap-css-css' href='<c:url value="/resources/css/bootstrap.css?ver=1.0"/>'
          type='text/css' media='all'/>
    <link rel='stylesheet' id='responsive-css-css' href='<c:url value="/resources/css/responsive.css?ver=1.0"/>'
          type='text/css' media='all'/>
    <link rel='stylesheet' id='pretty-photo-css-css'
          href='<c:url value="/resources/js/prettyphoto/prettyPhoto.css?ver=3.1.4"/>' type='text/css'
          media='all'/>
    <link rel='stylesheet' id='main-css-css' href='<c:url value="/resources/css/main.css?ver=1.0"/>' type='text/css'
          media='all'/>

    <!--[if lt IE 9]>
    <script src="js/html5.js"></script>
    <![endif]-->

</head>
<body>

<tiles:insertAttribute name="header"/>

<tiles:insertAttribute name="body"/>

<tiles:insertAttribute name="footer"/>

<tiles:insertAttribute name="footer-bottom"/>

<a href="#top" id="scroll-top"></a>

<!-- script -->
<script type='text/javascript' src='<c:url value="/resources/js/jquery-1.8.3.min.js"/>'></script>
<script type='text/javascript' src='<c:url value="/resources/js/jquery.easing.1.3.js"/>'></script>
<script type='text/javascript' src='<c:url value="/resources/js/prettyphoto/jquery.prettyPhoto.js"/>'></script>
<script type='text/javascript' src='<c:url value="/resources/js/jflickrfeed.js"/>'></script>
<script type='text/javascript' src='<c:url value="/resources/js/jquery.liveSearch.js"/>'></script>
<script type='text/javascript' src='<c:url value="/resources/js/jquery.form.js"/>'></script>
<script type='text/javascript' src='<c:url value="/resources/js/jquery.validate.min.js"/>'></script>
<script type='text/javascript' src="<c:url value="/resources/js/jquery-twitterFetcher.js"/>"></script>
<script type='text/javascript' src='<c:url value="/resources/js/custom.js"/>'></script>

</body>
</html>