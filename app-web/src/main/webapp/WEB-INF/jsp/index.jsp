<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- Start of Page Container -->
<div class="page-container">
    <div class="container">
        <div class="row">

            <!-- start of page content -->
            <div class="span8 page-content">

                <!-- Basic Home Page Template -->
                <div class="row separator">
                    <section class="span4 articles-list">
                        <h3>Новые объявления</h3>
                        <ul class="articles">

                            <c:forEach var="vacancy" items="${newestVacancies}">
                                <li class="article-entry standard">
                                    <h4><a href="<c:url value="/vacancy/${vacancy.id}"/>">${vacancy.title}</a></h4>
                                    <h4>
                                        <c:choose>
                                            <c:when test="${vacancy.employer.url != null}">
                                                <a href="${vacancy.employer.url}">${vacancy.employer.title}</a>
                                            </c:when>
                                            <c:otherwise>
                                                ${vacancy.employer.title}
                                            </c:otherwise>
                                        </c:choose>
                                    </h4>
                                <span class="article-meta"><fmt:formatDate value="${vacancy.entranceDate}"
                                                                           pattern="dd-MM-yyyy"/>
                                    <c:choose>
                                        <c:when test="${vacancy.area != null}">
                                            &nbsp;из&nbsp;${vacancy.area}
                                        </c:when>
                                    </c:choose>
                                </span>
                                </li>
                            </c:forEach>

                        </ul>
                    </section>


                    <section class="span4 articles-list">
                        <h3>Ближайшие объявления</h3>
                        <ul class="articles">
                            <c:forEach var="vacancy" items="${nearestVacancies}">
                                <li class="article-entry standard">
                                    <h4><a href="<c:url value="/vacancy/${vacancy.id}"/>">${vacancy.title}</a></h4>
                                    <h4>
                                        <c:choose>
                                            <c:when test="${vacancy.employer.url != null}">
                                                <a href="${vacancy.employer.url}">${vacancy.employer.title}</a>
                                            </c:when>
                                            <c:otherwise>
                                                ${vacancy.employer.title}
                                            </c:otherwise>
                                        </c:choose>
                                    </h4>
                                <span class="article-meta"><fmt:formatDate value="${vacancy.entranceDate}"
                                                                           pattern="dd-MM-yyyy"/>
                                <c:choose>
                                    <c:when test="${vacancy.area != null}">
                                        &nbsp;из&nbsp;${vacancy.area}
                                    </c:when>
                                </c:choose>
                                </span>
                                </li>
                            </c:forEach>
                        </ul>
                    </section>
                </div>
            </div>
            <!-- end of page content -->


            <!-- start of sidebar -->
            <aside class="span4 page-sidebar">

                <section class="widget">
                    <div class="support-widget">
                        <h3 class="title">Генератор резюме</h3>

                        <p class="intro">Хотите создать резюме? <a href="<c:url value="/resume"/>">Создать.</a></p>
                    </div>
                </section>

                <section class="widget">
                    <div class="support-widget">
                        <h3 class="title">Подписка на рассылку</h3>

                        <form:form action="/subscribe" method="POST">
                            <p class="intro">Введиет email и критерии поиска (через запятую).</p>

                            <label>Email<input type="text" name="email" placeholder="Email"/></label>

                            <label>Критерии<input type="text" name="criteria" placeholder="Критерии"/></label>

                            <input class="btn btn-inverse" type="submit" value="Подписаться"/>
                        </form:form>
                    </div>
                </section>

                <section class="widget">
                    <h3 class="title">Теги</h3>

                    <div class="tagcloud">
                        <c:forEach var="tag" items="${tags}">
                            <a href="<c:url value="/search?tag=${tag}"/>" class="btn btn-mini">${tag}</a>
                        </c:forEach>
                    </div>
                </section>

                <section class="widget">
                    <!-- <div id="map" style="width: 600px; height: 400px"></div> -->
                </section>

            </aside>
            <!-- end of sidebar -->
        </div>
    </div>
</div>
<!-- End of Page Container -->