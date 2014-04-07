<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                                <span class="article-meta"><fmt:formatDate value="${vacancy.entranceDate}"
                                                                           pattern="yyyy-MM-dd"/> in <a href="#"
                                                                                                        title="View all posts in Server &amp; Database">Server
                                    &amp; Database</a></span>
                                    <span class="like-count">66</span>
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
                                <span class="article-meta">${vacancy.entranceDate} in <a href="#"
                                                                                         title="View all posts in Server &amp; Database">Server
                                    &amp; Database</a></span>
                                    <span class="like-count">66</span>
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
                    <div class="quick-links-widget">
                        <h3 class="title">Полезные ссылки</h3>
                        <ul id="menu-quick-links" class="menu clearfix">
                            <li><a href="<c:url value="/"/>">Домашнаяя страница</a></li>
                            <li><a href="<c:url value="/catalog"/>">Каталог вакансий</a></li>
                            <li><a href="<c:url value="/contact"/>">Контакты</a></li>
                        </ul>
                    </div>
                </section>

                <section class="widget">
                    <h3 class="title">Tags</h3>

                    <div class="tagcloud">
                        <c:forEach var="tag" items="${tags}">
                            <a href="<c:url value="/search?tag=${tag}"/>" class="btn btn-mini">${tag}</a>
                        </c:forEach>
                    </div>
                </section>

            </aside>
            <!-- end of sidebar -->
        </div>
    </div>
</div>
<!-- End of Page Container -->