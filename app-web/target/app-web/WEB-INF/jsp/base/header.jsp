<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="header-wrapper">
    <header>
        <div class="container">

            <div class="logo-container">
                <!-- Website Logo -->
                <a href="<c:url value="/"/>" title="Каталог вакансий">
                    <img src="<c:url value="/resources/images/logo.png"/>" alt="Каталог вакансий">
                </a>
                <span class="tag-line">Поиск работы</span>
            </div>

            <!-- Start of Main Navigation -->
            <nav class="main-nav">
                <div class="menu-top-menu-container">
                    <ul id="menu-top-menu" class="clearfix">
                        <li class="current-menu-item"><a href="<c:url value="/"/>">Главная страница</a></li>
                        <li><a href="<c:url value="/catalog"/>">Каталог вакансий</a></li>
                        <li><a href="#">Skins</a>
                            <ul class="sub-menu">
                                <li><a href="blue-skin.html">Blue Skin</a></li>
                                <li><a href="green-skin.html">Green Skin</a></li>
                                <li><a href="red-skin.html">Red Skin</a></li>
                                <li><a href="../index.jsp">Default Skin</a></li>
                            </ul>
                        </li>
                        <li><a href="#">More</a>
                            <ul class="sub-menu">
                                <li><a href="full-width.html">Full Width</a></li>
                                <li><a href="elements.html">Elements</a></li>
                                <li><a href="page.html">Sample Page</a></li>
                            </ul>
                        </li>
                        <li><a href="<c:url value="/contact"/>">Контакты</a></li>
                    </ul>
                </div>
            </nav>
            <!-- End of Main Navigation -->

        </div>
    </header>
</div>

<!-- Start of Search Wrapper -->
<div class="search-area-wrapper">
    <div class="search-area container">
        <h3 class="search-header">Ищите работу?</h3>

        <p class="search-tag-line">Вы можете ввести интересующие название вакансии ниже!</p>

        <form id="search-form" class="search-form clearfix" method="get" action="<c:url value="/search"/>"
              autocomplete="off">
            <input class="search-term required" type="text" id="s" name="searchTerm"
                   placeholder="Введите текст для поиска"
                   title="* Введите текст для поиска!"
                   value="${searchTerm}"/>
            <input class="search-btn" type="submit" value="Найти"/>

            <div id="search-error-container"></div>

            <div class="slide-toggle-container">
                <div class="slide-toggle-control"><span>Развернуть</span></div>
                <div class="content">

                    <fieldset style="text-align:left">
                        <legend>Период</legend>
                        <label><input type="radio" value="test1">Test 1</label>
                        <label><input type="radio" value="test2">Test 2</label>
                        <label><input type="radio" value="test3">Test 3</label>
                        <label><input type="radio" value="test4">Test 4</label>
                    </fieldset>

                </div>
            </div>
        </form>
    </div>
</div>
<!-- End of Search Wrapper -->