<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
                        <li><a href="<c:url value="/resume"/>">Резюме</a></li>
                        <li><a href="#">Мой профайл</a></li>
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

        <form:form id="search-form" class="search-form clearfix" method="get" action="/search"
                   autocomplete="off" commandName="vacancySearchParam">
            <div>

                <form:input class="search-term required" type="text" id="s" name="searchTerm"
                            placeholder="Введите текст для поиска"
                            value="${vacancySearchParam.searchTerm}"
                            path="searchTerm"/>
                <input class="search-btn" type="submit" value="Найти"/>

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
                                            От&nbsp;
                                            <form:input path="compensationFrom"/>
                                            &nbsp;до&nbsp;
                                            <form:input path="compensationTo"/>
                                        </label>
                                    </td>
                                </tr>

                                <tr>
                                    <td class="header">Требуемый опыт работы:</td>
                                    <td></td>
                                    <td>
                                        <c:forEach var="item" items="${vacancySearchExperience}">
                                            <label>
                                                <form:checkbox path="vacancySearchExperiences" value="${item}"/>
                                                    ${item.description}
                                            </label>
                                        </c:forEach>
                                    </td>
                                </tr>

                                <tr>
                                    <td class="header">График работы:</td>
                                    <td></td>
                                    <td>
                                        <c:forEach var="item" items="${vacancySearchWorkSchedule}">
                                            <label>
                                                <form:checkbox path="vacancySearchWorkSchedules" value="${item}"/>
                                                    ${item.description}
                                            </label>
                                        </c:forEach>
                                    </td>
                                </tr>

                                <tr>
                                    <td class="header">Тип занятости:</td>
                                    <td></td>
                                    <td>
                                        <c:forEach var="item" items="${vacancySearchEducation}">
                                            <label>
                                                <form:checkbox path="vacancySearchEducations" value="${item}"/>
                                                    ${item.description}
                                            </label>
                                        </c:forEach>
                                    </td>
                                </tr>

                                <tr>
                                    <td class="header">Выводить:</td>
                                    <td></td>
                                    <td>
                                        <c:forEach var="item" items="${vacancySearchPeriod}">
                                            <label>
                                                <form:radiobutton path="vacancySearchPeriod" value="${item}"/>
                                                    ${item.description}
                                            </label>
                                        </c:forEach>
                                    </td>
                                </tr>

                                <tr>
                                    <td class="header">Сортировать:</td>
                                    <td>
                                    </td>
                                    <td>
                                        <c:forEach var="item" items="${vacancySearchSort}">
                                            <label>
                                                <form:radiobutton path="vacancySearchSort" value="${item}"/>
                                                    ${item.description}
                                            </label>
                                        </c:forEach>
                                    </td>
                                </tr>

                            </table>
                        </div>

                    </div>
                </div>
            </div>
        </form:form>
    </div>
</div>
<!-- End of Search Wrapper -->