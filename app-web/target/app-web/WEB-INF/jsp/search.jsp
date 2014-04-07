<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- Start of Page Container -->
<div class="page-container">
    <div class="container">
        <div class="row">

            <!-- start of page content -->
            <div class="span8 main-listing">

                <c:forEach var="vacancy" items="${vacancies}">
                    <article class="format-standard type-post hentry clearfix">

                        <header class="clearfix">

                            <h3 class="post-title">
                                <a href="<c:url value="/vacancy/${vacancy.id}"/>">${vacancy.title}</a>
                            </h3>

                            <div class="post-meta clearfix">
                                <span class="date"><fmt:formatDate value="${vacancy.entranceDate}"
                                                                   pattern="yyyy-MM-dd"/></span>
                                <span class="category"><a
                                        href="<c:url  value="/search?profArea=${vacancy.professionalArea.title}"/>"
                                        title="${vacancy.professionalArea.title}">${vacancy.professionalArea.title}</a></span>
                                <c:choose>
                                    <c:when test="${vacancy.sourceLink} != null">
                                        <span class="comments"><a href="<c:url value="${vacancy.sourceLink}"/>"
                                                                  title="${vacancy.sourceLink}">Источник</a></span>
                                    </c:when>
                                </c:choose>
                            </div>
                            <!-- end of post meta -->

                        </header>

                        <c:choose>
                            <c:when test="${vacancy.employer.logoUrl} != null">
                                <img src="<c:url value="${vacancy.employer.logoUrl}"/>"/>
                            </c:when>
                        </c:choose>


                        <p>${vacancy.description}<a class="readmore-link"
                                                    href="<c:url value="/vacancy/${vacancy.id}"/>">Подробнее</a></p>

                    </article>
                </c:forEach>

                <c:url var="firstUrl" value="/search?searchTerm=${searchTerm}&page=1"/>
                <c:url var="lastUrl" value="/search?searchTerm=${searchTerm}&page=${pagination.totalPages}"/>
                <c:url var="prevUrl" value="/search?searchTerm=${searchTerm}&page=${pagination.currentPage - 1}"/>
                <c:url var="nextUrl" value="/search?searchTerm=${searchTerm}&page=${pagination.currentPage + 1}"/>

                <div id="pagination">
                    <c:choose>
                        <c:when test="${pagination.currentPage == 1}">
                            <a href="#" class="btn disabled">&lt;&lt;</a>
                            <a href="#" class="btn disabled">&lt;</a>
                        </c:when>
                        <c:otherwise>
                            <a href="${firstUrl}" class="btn">&lt;&lt;</a>
                            <a href="${prevUrl}" class="btn">&lt;</a>
                        </c:otherwise>
                    </c:choose>
                    <c:forEach var="i" begin="${pagination.beginPage}" end="${pagination.endPage}">
                        <c:url var="pageUrl" value="/search?searchTerm=${searchTerm}&page=${i}"/>
                        <c:choose>
                            <c:when test="${i == pagination.currentPage}">
                                <a href="${pageUrl}" class="btn active"><c:out value="${i}"/></a>
                            </c:when>
                            <c:otherwise>
                                <a href="${pageUrl}" class="btn"><c:out value="${i}"/></a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:choose>
                        <c:when test="${pagination.currentPage == pagination.totalPages}">
                            <a href="#" class="btn disabled">&gt;</a>
                            <a href="#" class="btn disabled">&gt;&gt;</a>
                        </c:when>
                        <c:otherwise>
                            <a href="${nextUrl}" class="btn">&gt;</a>
                            <a href="${lastUrl}" class="btn">&gt;&gt;</a>
                        </c:otherwise>
                    </c:choose>
                </div>

            </div>
            <!-- end of page content -->


            <!-- start of sidebar -->
            <aside class="span4 page-sidebar">

                <section class="widget">
                    <h3 class="title">Новые объявления</h3>
                    <ul class="articles">
                        <c:forEach var="vacancy" items="${newestVacancies}">
                            <li class="article-entry standard">
                                <h4><a href="<c:url value="/vacancy/${vacancy.id}"/>">${vacancy.title}</a></h4>
                                <span class="article-meta"><fmt:formatDate value="${vacancy.entranceDate}"
                                                                           pattern="yyyy-MM-dd"/> in <a href="#"
                                                                                                        title="View all posts in Server &amp; Database">Server
                                    &amp; Database</a></span>
                            </li>
                        </c:forEach>
                    </ul>
                </section>

                <section class="widget"><h3 class="title">Categories</h3>
                    <ul>
                        <li><a href="#" title="Lorem ipsum dolor sit amet,">Advanced Techniques</a></li>
                        <li><a href="#" title="Lorem ipsum dolor sit amet,">Designing in WordPress</a></li>
                        <li><a href="#" title="Lorem ipsum dolor sit amet,">Server &amp; Database</a></li>
                        <li><a href="#" title="Lorem ipsum dolor sit amet, ">Theme Development</a></li>
                        <li><a href="#" title="Lorem ipsum dolor sit amet,">Website Dev</a></li>
                        <li><a href="#" title="Lorem ipsum dolor sit amet,">WordPress for Beginners</a></li>
                        <li><a href="#" title="Lorem ipsum dolor sit amet, ">WordPress Plugins</a></li>
                    </ul>
                </section>

            </aside>
            <!-- end of sidebar -->
        </div>
    </div>
</div>
<!-- End of Page Container -->