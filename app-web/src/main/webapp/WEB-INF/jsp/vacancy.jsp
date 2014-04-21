<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- Start of Page Container -->
<div class="page-container">
    <div class="container">
        <div class="row">

            <!-- start of page content -->
            <div class="span8 page-content">

                <ul class="breadcrumb">
                    <li><a href="<c:url value="/"/>">Каталог вакансий</a><span class="divider">/</span></li>
                    <li class="active">${vacancy.professionalArea.title}</li>
                </ul>

                <article class=" type-post format-standard hentry clearfix">

                    <h1 class="post-title">${vacancy.title}</h1>

                    <div class="post-meta clearfix">
                        <span class="date"><fmt:formatDate value="${vacancy.entranceDate}" pattern="dd-MM-yyyy"/></span>

                        <span class="category"><a
                                href="<c:url  value="/search?profArea=${vacancy.professionalArea.title}"/>"
                                title="${vacancy.professionalArea.title}">${vacancy.professionalArea.title}</a></span>

                        <c:choose>
                            <c:when test="${vacancy.sourceLink != null}">
                                        <span class="comments"><a href="<c:url value="${vacancy.sourceLink}"/>"
                                                                  title="${vacancy.sourceLink}">Источник</a></span>
                            </c:when>
                        </c:choose>

                    </div>

                    <p>${vacancy.pageContent}</p>

                </article>

                <div class="like-btn">

                                                        <span class="tags">
                                                                <c:forEach var="tag" items="${vacancy.tags}">
                                                                    <a href="<c:url value="/search?tag=${tag}"/>"
                                                                       class="btn btn-mini">${tag}</a>
                                                                </c:forEach>
                                                        </span>

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
<!-- End of Page Container -->