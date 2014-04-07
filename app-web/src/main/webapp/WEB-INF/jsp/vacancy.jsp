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
                    <li><a href="#">Knowledge Base Theme</a><span class="divider">/</span></li>
                    <li><a href="#" title="View all posts in Server &amp; Database">Server &amp; Database</a> <span
                            class="divider">/</span></li>
                    <li class="active">Integrating WordPress with Your Website</li>
                </ul>

                <article class=" type-post format-standard hentry clearfix">

                    <h1 class="post-title">${vacancy.title}</h1>

                    <div class="post-meta clearfix">
                        <span class="date"><fmt:formatDate value="${vacancy.entranceDate}" pattern="yyyy-MM-dd"/></span>
                        <span class="category"><a
                                href="<c:url  value="/search?profArea=${vacancy.professionalArea.title}"/>"
                                title="${vacancy.professionalArea.title}">${vacancy.professionalArea.title}</a></span>
                        <span class="comments"><a href="#" title="Comment on Integrating WordPress with Your Website">3
                            Comments</a></span>
                    </div>

                    <p>${vacancy.pageContent}</p>

                </article>

                <div class="like-btn">

                    <form id="like-it-form" action="#" method="post">
                        <span class="like-it ">66</span>
                        <input type="hidden" name="post_id" value="99">
                        <input type="hidden" name="action" value="like_it">
                    </form>

                                                        <span class="tags">
                                                                <strong>Tags:&nbsp;&nbsp;</strong><a href="#" rel="tag">basic</a>, <a
                                                                href="#" rel="tag">setting</a>, <a
                                                                href="http://knowledgebase.inspirythemes.com/tag/website/"
                                                                rel="tag">website</a>
                                                        </span>

                </div>

            </div>
            <!-- end of page content -->


            <!-- start of sidebar -->
            <aside class="span4 page-sidebar">

                <section class="widget">
                    <h3 class="title">Featured Articles</h3>
                    <ul class="articles">
                        <li class="article-entry standard">
                            <h4><a href="single.html">Integrating WordPress with Your Website</a></h4>
                <span class="article-meta">25 Feb, 2013 in <a href="#" title="View all posts in Server &amp; Database">Server
                    &amp; Database</a></span>
                            <span class="like-count">66</span>
                        </li>
                        <li class="article-entry standard">
                            <h4><a href="single.html">WordPress Site Maintenance</a></h4>
                <span class="article-meta">24 Feb, 2013 in <a href="#" title="View all posts in Website Dev">Website
                    Dev</a></span>
                            <span class="like-count">15</span>
                        </li>
                        <li class="article-entry video">
                            <h4><a href="single.html">Meta Tags in WordPress</a></h4>
                <span class="article-meta">23 Feb, 2013 in <a href="#" title="View all posts in Website Dev">Website
                    Dev</a></span>
                            <span class="like-count">8</span>
                        </li>
                        <li class="article-entry image">
                            <h4><a href="single.html">WordPress in Your Language</a></h4>
                <span class="article-meta">22 Feb, 2013 in <a href="#" title="View all posts in Advanced Techniques">Advanced
                    Techniques</a></span>
                            <span class="like-count">6</span>
                        </li>
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

                <section class="widget">
                    <h3 class="title">Recent Comments</h3>
                    <ul id="recentcomments">
                        <li class="recentcomments"><a href="#" rel="external nofollow" class="url">John Doe</a> on <a
                                href="#">Integrating
                            WordPress with Your Website</a></li>
                        <li class="recentcomments">saqib sarwar on <a href="#">Integrating WordPress with Your
                            Website</a></li>
                        <li class="recentcomments"><a href="#" rel="external nofollow" class="url">John Doe</a> on <a
                                href="#">Integrating
                            WordPress with Your Website</a></li>
                        <li class="recentcomments"><a href="#" rel="external nofollow" class="url">Mr WordPress</a> on
                            <a href="#">Installing
                                WordPress</a></li>
                    </ul>
                </section>

            </aside>
            <!-- end of sidebar -->
        </div>
    </div>
</div>
<!-- End of Page Container -->