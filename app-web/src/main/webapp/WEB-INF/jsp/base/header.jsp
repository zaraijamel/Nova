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
                        <li><a href="<c:url value="/search"/>">Каталог вакансий</a></li>
                        <li><a href="#">Резюме</a>
                            <ul class="sub-menu">
                                <li><a href="<c:url value="/resume"/>">Blue Skin</a></li>
                                <li><a href="green-skin.html">Green Skin</a></li>
                            </ul>
                        </li>
                        <li><a href="#">Мой профайл</a>
                            <ul class="sub-menu">
                                <li><a href="full-width.html">Full Width</a></li>
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

                    <div class="search-filter">
                        <table>
                            <tr>
                                <td class="header">Уровень заработной платы</td>
                                <td></td>
                                <td>
                                    <label>
                                        <input type="text"/>
                                    </label>
                                </td>
                            </tr>

                            <tr>
                                <td class="header">Требуемый опыт работы:</td>
                                <td></td>
                                <td>
                                    <label><input type="radio" value="test1">Не имеет значения</label>
                                    <label><input type="radio" value="test2">Нет опыта</label>
                                    <label><input type="radio" value="test3">От 1 года до 3 лет</label>
                                    <label><input type="radio" value="test4">От 3 до 6 лет</label>
                                    <label><input type="radio" value="test4">Более 6 лет</label>
                                </td>
                            </tr>

                            <tr>
                                <td class="header">График работы:</td>
                                <td></td>
                                <td>
                                    <label><input type="checkbox" value="test1">Полный день</label>
                                    <label><input type="checkbox" value="test2">Сменный график</label>
                                    <label><input type="checkbox" value="test3">Удаленная работа</label>
                                </td>
                            </tr>

                            <tr>
                                <td class="header">Тип занятости:</td>
                                <td></td>
                                <td>
                                    <label><input type="checkbox" value="test1">Полная занятость</label>
                                    <label><input type="checkbox" value="test2">Частичная занятость</label>
                                    <label><input type="checkbox" value="test3">Временная работа</label>
                                </td>
                            </tr>

                            <tr>
                                <td class="header">Выводить:</td>
                                <td></td>
                                <td>
                                    <label><input type="radio" value="test1">За месяц</label>
                                    <label><input type="radio" value="test2">За недели</label>
                                    <label><input type="radio" value="test3">За 3 дня</label>
                                    <label><input type="radio" value="test4">За 1 день</label>
                                </td>
                            </tr>

                            <tr>
                                <td class="header">Сортировать:</td>
                                <td></td>
                                <td>
                                    <label><input type="radio" value="test1">Зарплате</label>
                                    <label><input type="radio" value="test2">Дате создания</label>
                                    <label><input type="radio" value="test3">Соответствую</label>
                                </td>
                            </tr>

                        </table>
                    </div>

                </div>
            </div>
        </form>
    </div>
</div>
<!-- End of Search Wrapper -->