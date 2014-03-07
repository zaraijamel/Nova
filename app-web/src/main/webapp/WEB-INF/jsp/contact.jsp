<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Start of Page Container -->
<div class="page-container">
    <div class="container">
        <div class="row">

            <!-- start of page content -->
            <div class="span8 page-content">

                <article class="type-page hentry clearfix">
                    <h1 class="post-title">
                        <a href="#">Contact</a>
                    </h1>
                    <hr>
                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p>
                </article>


                <form id="contact-form" class="row" action="contact_form_handler.php" method="post">

                    <div class="span2">
                        <label for="name">Your Name <span>*</span> </label>
                    </div>
                    <div class="span6">
                        <input type="text" name="name" id="name" class="required input-xlarge" value="" title="* Please provide your name">
                    </div>

                    <div class="span2">
                        <label for="email">Your Email <span>*</span></label>
                    </div>
                    <div class="span6">
                        <input type="text" name="email" id="email" class="email required input-xlarge" value="" title="* Please provide a valid email address">
                    </div>

                    <div class="span2">
                        <label for="reason">Subject </label>
                    </div>
                    <div class="span6">
                        <input type="text" name="reason" id="reason" class="input-xlarge" value="">
                    </div>

                    <div class="span2">
                        <label for="message">Your Message <span>*</span> </label>
                    </div>
                    <div class="span6">
                        <textarea name="message" id="message" class="required span6" rows="6" title="* Please enter your message"></textarea>
                    </div>

                    <div class="span6 offset2 bm30">
                        <input type="submit" name="submit" value="Send Message" class="btn btn-inverse">
                        <img src="images/loading.gif" id="contact-loader" alt="Loading...">
                    </div>

                    <div class="span6 offset2 error-container"></div>
                    <div class="span8 offset2" id="message-sent"></div>

                </form>
            </div>
            <!-- end of page content -->


            <!-- start of sidebar -->
            <aside class="span4 page-sidebar">

                <section class="widget">
                    <div class="support-widget">
                        <h3 class="title">Support</h3>
                        <p class="intro">Need more support? If you did not found an answer, contact us for further help.</p>
                    </div>
                </section>

                <section class="widget">
                    <h3 class="title">Latest Articles</h3>
                    <ul class="articles">
                        <li class="article-entry standard">
                            <h4><a href="single.html">Integrating WordPress with Your Website</a></h4>
                            <span class="article-meta">25 Feb, 2013 in <a href="#" title="View all posts in Server &amp; Database">Server &amp; Database</a></span>
                            <span class="like-count">66</span>
                        </li>
                        <li class="article-entry standard">
                            <h4><a href="single.html">WordPress Site Maintenance</a></h4>
                            <span class="article-meta">24 Feb, 2013 in <a href="#" title="View all posts in Website Dev">Website Dev</a></span>
                            <span class="like-count">15</span>
                        </li>
                        <li class="article-entry video">
                            <h4><a href="single.html">Meta Tags in WordPress</a></h4>
                            <span class="article-meta">23 Feb, 2013 in <a href="#" title="View all posts in Website Dev">Website Dev</a></span>
                            <span class="like-count">8</span>
                        </li>
                        <li class="article-entry image">
                            <h4><a href="single.html">WordPress in Your Language</a></h4>
                            <span class="article-meta">22 Feb, 2013 in <a href="#" title="View all posts in Advanced Techniques">Advanced Techniques</a></span>
                            <span class="like-count">6</span>
                        </li>
                    </ul>
                </section>


            </aside>
            <!-- end of sidebar -->
        </div>
    </div>
</div>
<!-- End of Page Container -->