<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>CADET | Home</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">

        <link rel="stylesheet" href="../css/bootstrap.css">
        <style>
            body {
                padding-top: 60px;
                padding-bottom: 40px;
            }
        </style>
        <link rel="stylesheet" href="../css/bootstrap-responsive.css">
        <link rel="stylesheet" href="css/main.css">

        <script src="../../js/modernizr-2.6.1-respond-1.1.0.min.js"></script>
    </head>
    <body>
        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an outdated browser. <a href="http://browsehappy.com/">Upgrade your browser today</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to better experience this site.</p>
        <![endif]-->

        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="#home"><img id="logo" src="../img/cadet.gif" alt="CADET">&nbsp;&nbsp;&nbsp;CADET</a>
                    <div class="nav-collapse collapse">
                       <ul class="nav">
                           <li class="active"><a href="#home">Home</a></li>
                           <li><a href="#test">Test</a></li>
                           <li><a href="#profile">Profile</a></li>
                       </ul>
                       <button class="btn btn-danger pull-right">Logout</button>
                    </div>
                </div>	<!--/.container -->
            </div>
        </div>	<!--/.navbar -->
        
        <div class="container">
        	<div class="row">
                <div class="accordion span2" id="accordionMenu">

                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-parent="#accordionMenu" href="#home">Home</a>
                        </div>
                    </div>
    
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordionMenu" href="#collapse2">Test</a>
                        </div>
                        <div id="collapse2" class="accordion-body collapse">
                            <div class="accordion-inner">
                                <ul class="nav">
                                    <li><a href="#">Register for Test</a></li>
                                    <li><a href="#">View All Test</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
    
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordionMenu" href="#collapse3">Profile</a>
                        </div>
                        <div id="collapse3" class="accordion-body collapse in">
                            <div class="accordion-inner">

                                <ul class="nav">
                                    <li><a href="#">Change Details</a></li>
                                    <li><a href="#result">Change Password</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
    
                </div>	<!--/#accordion -->

				<div class="container span9 offset*">
					CADET - CANDIDATE DASH BOARD
                </div>

            </div>	<!--/.row div -->

        </div>	<!--/.container div -->

		<hr>
        <footer>
                <div class="container row">
                    <a class="span pull-right" href="#">About</a>
                    <a class="span pull-right" href="#">FAQ</a>
                    <a class="span pull-right" href="#">Contact us</a>
                    <a class="span pull-right" href="#">Help</a>
                    <a class="span pull-right" href="#">Privacy &amp; Policy</a>
                </div>
        </footer>

        <script src="../../js/jquery-1.8.2.js"></script>
        <script>window.jQuery || document.write('<script src="../../js/jquery-1.8.2.js"><\/script>')</script>

        <script src="../../js/bootstrap.js"></script>
    </body>
</html>
