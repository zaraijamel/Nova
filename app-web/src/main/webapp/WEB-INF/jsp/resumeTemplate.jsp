<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Start of Page Container -->
<div class="page-container">
    <div class="container">
        <div class="row">
            <div class="span8 main-listing">

                <article class=" page type-page hentry clearfix">

                    <h1 class="post-title"><a href="#">Настройки резюме</a></h1>
                    <hr>
                    <p>Это первое, что необходимо иметь при поиске работы.
                        Можно сказать, что при устройстве на работу, обязательное предоставление резюме, это один из
                        элементов
                        современных правил делового этикета, но одновременно это одно из самых эффективных средств
                        рекламы на рынке
                        труда.
                        Резюме - это краткий вывод из сказанного, написанного или прочитанного, сжато излагающий
                        основные положения.</p>
                </article>


                <form:form method="POST" action="/resume/generate" commandName="resumeSettings">

                    <!-- start of page content -->
                    <div class="span8 page-content">

                        <article class=" page type-page hentry clearfix">
                            <h1 class="post-title">Шаблон резюме</h1>
                            <hr>
                            <p>Здесь вы можете выбрать шаблон резюме.</p>
                        </article>

                        <div class="row-fluid top-cats">
                            <c:forEach varStatus="rt" var="resumeTemplate" items="${resumeTemplates}">
                                <section class="span4">
                                    <h4 class="category"><form:radiobutton path="resumeTemplate"
                                                                           value="${resumeTemplate}"/>${resumeTemplate.name}</h4>

                                    <a href="<c:url value="/resources/images/resumeTemplates/${resumeTemplate.imageName}.png"/>" rel="prettyPhoto">
                                        <img src="<c:url value="/resources/images/resumeTemplates/${resumeTemplate.imageName}.png"/>"/>
                                    </a>

                                    <div class="category-description">
                                        <p>${resumeTemplate.description}</p>
                                    </div>
                                </section>
                            </c:forEach>
                        </div>
                    </div>

                    <table>
                        <tr>
                            <td class="header">Формат шаблона:</td>
                            <td></td>
                            <td>
                                <c:forEach var="resumeFormat" items="${resumeFormats}">
                                    <label>
                                        <form:radiobutton path="resumeFormat" value="${resumeFormat}"/>
                                            ${resumeFormat.name}
                                    </label>
                                </c:forEach>
                            </td>
                        </tr>
                    </table>

                    <!-- end of page content -->

                    <input type="submit" value="Сгенерировать"/>

                </form:form>


                <!-- start of sidebar -->
                <aside class="span4 page-sidebar">

                    <section class="widget">
                        <div class="support-widget">
                            <h3 class="title">Генератор резюме</h3>

                            <p class="intro">Хотите создать резюме? <a href="<c:url value="/resume"/>">Создать.</a></p>
                        </div>
                    </section>

                    <section class="widget">
                        <div class="quick-links-widget">
                            <h3 class="title">Полезные ссылки</h3>
                            <ul id="menu-quick-links" class="menu clearfix">
                                <li><a href="<c:url value="/"/>">Домашнаяя страница</a></li>
                                <li><a href="<c:url value="/catalog"/>">Каталог вакансий</a></li>
                                <li><a href="<c:url value="/catalog"/>">Создание резюме</a></li>
                                <li><a href="<c:url value="/catalog"/>">Мой профайл</a></li>
                                <li><a href="<c:url value="/contact"/>">Контакты</a></li>
                            </ul>
                        </div>
                    </section>

                </aside>
                <!-- end of sidebar -->
            </div>
        </div>
    </div>
</div>
<!-- End of Page Container -->
