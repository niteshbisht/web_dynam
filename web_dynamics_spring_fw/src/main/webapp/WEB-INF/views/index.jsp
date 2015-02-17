<!DOCTYPE  html>
<html>
	<head>
		<meta charset="utf-8">
		<title>NOVA</title>
		
		<!-- CSS -->
		<link rel="stylesheet" href="resources/css/style.css"   type="text/css" media="screen" />
		<link rel="stylesheet" href="resources/css/social-icons.css"  type="text/css" media="screen" />
		<!--[if IE 8]>
			<link rel="stylesheet" type="text/css" media="screen" href="resourcex/css/ie8-hacks.css" />
		<![endif]-->
		<!-- ENDS CSS -->	
		
		<!-- GOOGLE FONTS 
		<link href='http://fonts.googleapis.com/css?family=Ubuntu' rel='stylesheet' type='text/css'>-->
		
		<!-- JS -->
		<script type="text/javascript" src="resources/js/jquery-1.5.1.min.js"></script>
		<script type="text/javascript" src="resources/js/jquery-ui-1.8.13.custom.min.js" ></script>
		<script type="text/javascript" src="resources/js/easing.js" ></script>
		<script type="text/javascript" src="resources/js/jquery.scrollTo-1.4.2-min.js" > </script>
		<script type="text/javascript" src="resources/js/jquery.cycle.all.js" ></script>
		<script type="text/javascript" src="resources/js/custom.js"  ></script>
		
		<!-- Isotope -->
		<script src="resources/js/jquery.isotope.min.js" ></script>
		
		<!--[if IE]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		
		<!--[if IE 6]>
			<script type="text/javascript" src="resources/js/DD_belatedPNG.js"></script>
			<script>
	      		/* EXAMPLE */
	      		//DD_belatedPNG.fix('*');
	    	</script>
		<![endif]-->
		<!-- ENDS JS -->
		
		
		<!-- Nivo slider -->
		<link rel="stylesheet" href="resources/css/nivo-slider.css"  type="text/css" media="screen" />
		<script src="resources/js/nivo-slider/jquery.nivo.slider.js"  type="text/javascript"></script>
		<!-- ENDS Nivo slider -->
		
		<!-- tabs -->
		<link rel="stylesheet" href="resources/css/tabs.css"  type="text/css" media="screen" />
		<script type="text/javascript" src="resources/js/tabs.js" ></script>
  		<!-- ENDS tabs -->
  		
  		<!-- prettyPhoto -->
		<script type="text/javascript" src="resources/js/prettyPhoto/js/jquery.prettyPhoto.js" ></script>
		<link rel="stylesheet" href="resources/js/prettyPhoto/css/prettyPhoto.css"  type="text/css" media="screen" />
		<!-- ENDS prettyPhoto -->
		
		<!-- superfish -->
		<link rel="stylesheet" media="screen" href="resources/css/superfish.css"  /> 
		<link rel="stylesheet" media="screen" href="resources/css/superfish-left.css"  /> 
		<script type="text/javascript" src="resources/js/superfish-1.4.8/js/hoverIntent.js" ></script>
		<script type="text/javascript" src="resources/js/superfish-1.4.8/js/superfish.js" ></script>
		<script type="text/javascript" src="resources/js/superfish-1.4.8/js/supersubs.js"  ></script>
		<!-- ENDS superfish -->
		
		<!-- poshytip -->
		<link rel="stylesheet" href="resources/js/poshytip-1.0/src/tip-twitter/tip-twitter.css"  type="text/css" />
		<link rel="stylesheet" href="resources/js/poshytip-1.0/src/tip-yellowsimple/tip-yellowsimple.css"  type="text/css" />
		<script type="text/javascript" src="resources/js/poshytip-1.0/src/jquery.poshytip.min.js" ></script>
		<!-- ENDS poshytip -->
		
		<!-- Tweet -->
		<link rel="stylesheet" href="resources/css/jquery.tweet.css"  media="all"  type="text/css"/> 
		<script src="resources/js/tweet/jquery.tweet.js"  type="text/javascript"></script> 
		<!-- ENDS Tweet -->
		
		<!-- Fancybox -->
		<link rel="stylesheet" href="resources/js/jquery.fancybox-1.3.4/fancybox/jquery.fancybox-1.3.4.css"  type="text/css" media="screen" />
		<script type="text/javascript" src="resources/js/jquery.fancybox-1.3.4/fancybox/jquery.fancybox-1.3.4.pack.js" ></script>
		<!-- ENDS Fancybox -->
		
		

	</head>
	
	<body class="home">

			<!-- HEADER -->
			<div id="header">
				<!-- wrapper-header -->
				<div class="wrapper">
					<a href="./index.jsp"><img id="logo" src="resources/img/logo.png"  alt="Nova" /></a>
					<!-- search -->
					<div class="top-search">
						<form  method="get" id="searchform" action="#">
							<div>
								<input type="text" value="Search..." name="s" id="s" onfocus="defaultInput(this)" onblur="clearInput(this)" />
								<input type="submit" id="searchsubmit" value=" " />
							</div>
						</form>
					</div>
					<!-- ENDS search -->
				<a href="/login"> proceed to login</a>
				</div>
				<!-- ENDS wrapper-header -->					
			</div>
			<!-- ENDS HEADER -->
			
			
			<!-- Menu -->
			<div id="menu">
			
			
			
				<!-- ENDS menu-holder -->
				<div id="menu-holder">
					<!-- wrapper-menu -->
					<div class="wrapper">
						<!-- Navigation -->
						<ul id="nav" class="sf-menu">
							<li class="current-menu-item"><a href="./index.jsp">Home<span class="subheader">Welcome</span></a></li>
							<li><a href="./features.jsp">Features<span class="subheader">Awesome options</span></a>
								<ul>
									
									<li><a href="features-columns.jsp"><span> Columns layout</span></a></li>
									<li><a href="features-accordion.jsp"><span> Accordion</span></a></li>
									<li><a href="features-toggle.jsp"><span> Toggle box</span></a></li>
									<li><a href="features-tabs.jsp"><span> Tabs</span></a></li>
									<li><a href="features-infobox.jsp"><span> Text box</span></a></li>
									<li><a href="features-monobox.jsp"><span> Icons</span></a></li>
								</ul>
							</li>
							<li><a href="./blog.jsp">Blog<span class="subheader">Read our posts</span></a></li>
							<li><a href="./portfolio.jsp">Portfolio <span class="subheader">Showcase work</span></a></li>
							<li><a href="./gallery.jsp">Gallery<span class="subheader">Featured work</span></a>
								<ul>
									<li><a href="./gallery.jsp"><span> Four columns</span></a></li>
									<li><a href="gallery-3.jsp"><span> Three columns </span></a></li>
									<li><a href="gallery-2.jsp"><span> Two columns </span></a></li>
									<li><a href="video-./gallery.jsp"><span> Video gallery </span></a></li>
								</ul>
							</li>
							<li><a href="./contact.jsp">Contact<span class="subheader">Get in touch</span></a></li>
							<li><a href="./login">Login<span class="subheader">Proceed to Secure</span></a></li>
						</ul>
						<!-- Navigation -->
					</div>
					<!-- wrapper-menu -->
				</div>
				<!-- ENDS menu-holder -->
			</div>
			<!-- ENDS Menu -->
			
			
			

			<!-- Slider -->
			<div id="slider-block">
				<div id="slider-holder">
					<div id="slider">
						<a href="http://www.luiszuno.com"><img src="resources/images/01.jpg"  title="Visit my web site regularly and get freebies each week!" alt="" /></a>
						<a href="http://themeforest.net/user/Ansimuz/portfolio?ref=ansimuz"><img src="resources/images/02.jpg"  title="Support the freebies buying high quality premium themes from my portfolio at themeforest" alt="" /></a>
					</div>
				</div>
			</div>
			<!-- ENDS Slider -->
			
			<!-- MAIN -->
			<div id="main">
				<!-- wrapper-main -->
				<div class="wrapper">
					
					<!-- headline -->
					<div class="clear"></div>
					<div id="headline">
						<span class="main">Nova is a FREE HTML template</span>
						<span class="sub">Need a professional and sleek html web site design. Try nova is free and easy to use.</span>
						<a href="http://luiszuno.com/blog/downloads/nova-html-template" id="link" class="link-button-big"><span>Download Nova</span></a> 
					</div>
					<!-- ENDS headline -->
					
					<!-- content -->
					<div id="content">
						
							<!-- TABS -->
							<!-- the tabs -->
							<ul class="tabs">
								<li><a href="#"><span>Featured Pages</span></a></li>
								<li><a href="#"><span>Information</span></a></li>
								<li><a href="#"><span>Recent posts</span></a></li>
							</ul>
							
							<!-- tab "panes" -->
							<div class="panes">
							
								<!-- Posts -->
								<div>
									<ul class="blocks-thumbs thumbs-rollover">
										<li>
											<a href="single.jsp" class="thumb" title="An image"><img src="../img/dummies/282x150.gif" alt="Post" /></a>
											<div class="excerpt">
												<a href="single.jsp" class="header">Lorem ipsum dolor</a>
												Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra.
											</div>
											<a href="single.jsp" class="link-button"><span>Read more &#8594;</span></a>
										</li>
										<li>
											<a href="single.jsp" class="thumb" title="An image"><img src="../img/dummies/282x150.gif" alt="Post" /></a>
											<div class="excerpt">
												<a href="single.jsp" class="header">Lorem ipsum dolor</a>
												Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra.
											</div>
											<a href="single.jsp" class="link-button"><span>Read more &#8594;</span></a>
										</li>
										<li>
											<a href="single.jsp" class="thumb" title="An image"><img src="../img/dummies/282x150.gif" alt="Post" /></a>
											<div class="excerpt">
												<a href="single.jsp" class="header">Lorem ipsum dolor</a>
												Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra.
											</div>
											<a href="single.jsp" class="link-button"><span>Read more &#8594;</span></a>
										</li>
									</ul>
								</div>
								<!-- ENDS posts -->
								
								<!-- Information  -->
								<div>
									<div class="plain-text">
										<h6>Pellentesque habitant morbi tristique senectus et netus et malesuada.</h6> 
										<p>Fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus. </p>
										<p>Fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus.Fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper <a href="single.jsp">This is a link</a>. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus. </p>
										<a href="single.jsp" class="link-button"><span>Read more &#8594;</span></a>
									</div>
								</div>
								<!-- ENDS Information -->

								<!-- Posts -->
								<div>
									<ul class="blocks-thumbs thumbs-rollover">
										<li>
											<a href="single.jsp" class="thumb" title="An image"><img src="../img/dummies/282x150.gif" alt="Post" /></a>
											<div class="excerpt">
												<a href="single.jsp" class="header">Lorem ipsum dolor</a>
												Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra.
											</div>
											<a href="single.jsp" class="link-button"><span>Read more &#8594;</span></a>
										</li>
										<li>
											<a href="single.jsp" class="thumb" title="An image"><img src="../img/dummies/282x150.gif" alt="Post" /></a>
											<div class="excerpt">
												<a href="single.jsp" class="header">Lorem ipsum dolor</a>
												Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra.
											</div>
											<a href="single.jsp" class="link-button"><span>Read more &#8594;</span></a>
										</li>
										<li>
											<a href="single.jsp" class="thumb" title="An image"><img src="../img/dummies/282x150.gif" alt="Post" /></a>
											<div class="excerpt">
												<a href="single.jsp" class="header">Lorem ipsum dolor</a>
												Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra.
											</div>
											<a href="single.jsp" class="link-button"><span>Read more &#8594;</span></a>
										</li>
									</ul>
								</div>
								<!-- ENDS posts -->
								
								
							</div>
							<!-- ENDS TABS -->
		
		
		
					</div>
					<!-- ENDS content -->
				</div>
				<!-- ENDS wrapper-main -->
			</div>
			<!-- ENDS MAIN -->
			
			<!-- Twitter -->
			<div id="twitter">
				<div class="wrapper">
					<a href="#" id="prev-tweet"></a>
					<a href="#" id="next-tweet"></a>
					<img id="bird" src="../img/twitterbird.jpeg" alt="Tweets" />
					<div id="tweets">
						<ul class="tweet_list"></ul>
					</div>
				</div>
			</div>
			<!-- ENDS Twitter -->

			
			<!-- FOOTER -->
			<div id="footer">
				<!-- wrapper-footer -->
				<div class="wrapper">
					<!-- footer-cols -->
					<ul id="footer-cols">
						<li class="col">
							<h6>Pages</h6>
							<ul>
								<li class="page_item"><a href="./index.jsp">Home</a></li>
								<li class="page_item"><a href="./features.jsp">Features</a></li>
								<li class="page_item"><a href="./blog.jsp">Blog</a></li>
								<li class="page_item"><a href="./portfolio.jsp">Portfolio</a></li>
								<li class="page_item"><a href="./gallery.jsp">Gallery</a></li>
								<li class="page_item"><a href="./contact.jsp">Contact</a></li>
							</ul>
						</li>
						
						<li class="col">
							<h6>Categories</h6>
							<ul>
								<li><a href="#">Webdesign projects senectus</a></li>
								<li><a href="#/">Wordpress projects senectus</a></li>
								<li><a href="#">Vestibulum tortor quam</a></li>
								<li><a href="#">Code projects amet quam egestas</a></li>
								<li><a href="#">Web design projects senectus</a></li>
								<li><a href="#/">Marketplace projects</a></li>
								<li><a href="#">Writting projects senectus</a></li>
								<li><a href="#">Drawings projects fames Aenean</a></li>
								<li><a href="#/">Wordpress projects Aenean ultricies</a></li>
							</ul>
						</li>
						<li class="col">
							<h6>About the theme</h6>
							Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Cursus faucibus, tortor neque egestas augue, eu vulputate magna eros.
						</li>
						
					</ul>
					<!-- ENDS footer-cols -->
				</div>
				<!-- ENDS wrapper-footer -->
			</div>
			<!-- ENDS FOOTER -->
		
		
			<!-- Bottom -->
			<div id="bottom">
				<!-- wrapper-bottom -->
				<div class="wrapper">
					<div id="bottom-text">2011 Nova all rights reserved. <a href="http://www.luiszuno.com"> Luiszuno.com</a> </div>
					<!-- Social -->
					<ul class="social ">
						<li><a href="http://www.facebook.com" class="poshytip  facebook" title="Become a fan"></a></li>
						<li><a href="http://www.twitter.com" class="poshytip twitter" title="Follow our tweets"></a></li>
						<li><a href="http://www.dribbble.com" class="poshytip dribbble" title="View our work"></a></li>
						<li><a href="http://www.addthis.com" class="poshytip addthis" title="Tell everybody"></a></li>
						<li><a href="http://www.vimeo.com" class="poshytip vimeo" title="View our videos"></a></li>
						<li><a href="http://www.youtube.com" class="poshytip youtube" title="View our videos"></a></li>
					</ul>
					<!-- ENDS Social -->
					<div id="to-top" class="poshytip" title="To top"></div>
				</div>
				<!-- ENDS wrapper-bottom -->
			</div>
			<!-- ENDS Bottom -->
	
	</body>
</html>