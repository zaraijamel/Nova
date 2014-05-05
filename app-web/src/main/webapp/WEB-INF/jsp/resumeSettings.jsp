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

                <div class="faqs clearfix">

                    <form:form method="POST" action="/resume/generate" commandName="resumeSettings">

                        <!-- start of page content -->
                        <div class="span8 page-content">
                            <div class="row-fluid top-cats">
                                <c:forEach varStatus="rt" var="resumeTemplate" items="${resumeTemplates}">
                                    <section class="span4">
                                        <h4 class="category"><form:radiobutton path="resumeTemplate"
                                                                               value="${resumeTemplate}"/>${resumeTemplate.name}</h4>

                                        <a href="<c:url value="/resources/images/resumeTemplates/${resumeTemplate.imageName}.png"/>"
                                           rel="prettyPhoto">
                                            <img
                                                    style="max-width: 150px; max-height: 200px; border-width: 1px; border-color: #000000"
                                                    src="<c:url value="/resources/images/resumeTemplates/${resumeTemplate.imageName}.png"/>"/>
                                        </a>

                                    </section>
                                </c:forEach>
                            </div>
                        </div>

                        <hr>

                        <table>
                            <tr>
                                <td>Формат сохранения резюме:</td>
                                <td style="width: 20px"></td>
                                <c:forEach var="resumeFormat" items="${resumeFormats}">
                                    <td style="padding-right: 20px">
                                        <label>
                                            <form:radiobutton path="resumeFormat" value="${resumeFormat}"/>
                                                ${resumeFormat.name}
                                        </label>
                                    </td>
                                </c:forEach>
                            </tr>
                        </table>

                        <br/>
                        <br/>

                        <!-- end of page content -->

                        <input type="submit" value="Сгенерировать" class="btn btn-inverse"/>

                    </form:form>


                </div>

            </div>

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