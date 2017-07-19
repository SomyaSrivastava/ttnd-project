<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<html>
<head>
  <meta charset="utf-8"/>
  <meta name="viewport" content="width=device-width" initial-scale="1.0"/>
  <title>Home</title>
  <link rel="stylesheet" type="text/css" href="/resources/assets/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="/resources/assets/css/style.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>
<body>
<%if (session.getAttribute("user")!=null)
        response.sendRedirect("/");
%>
<div class="container">
  <header>
    <div class="row ">
      <div class="col-md-12 header"><a href="#">Link Sharing</a>
        <!--div class="input-group"-->
        <span class="pull-right searchSpan">
      <span class="glyphicon glyphicon-search"></span>
      <input type="text" class="noborder" placeholder="Search">
      <span class="glyphicon glyphicon-remove-sign"></span>
      </span>
        <!--/div></input-group -->

      </div>
    </div>
  </header>

  <div class="row">
    <div class="col-md-8 margin-top">
      <div class="row"><!--Recent shares-->
        <div class="col-md-12">
          <div class="wrapBox">
            <div class="boxHeading">Recent Shares</div>
            <div class="boxBody">
              <div class="wrapper">
                <div class="postHeading">
                  <span class="glyphicon glyphicon-user pull-left"></span>
                  <span class="">
                 <ul class="list-inline">
                   <li>Uday pratap Singh</li>
                   <li>@Uday5min</li>
                   <li class="pull-right"><a>Grails</a></li>
                 </ul>
                 </span>
                  <p class="para">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur egestas orci lacus, finibus commodo nunc auctor vel. Quisque ac varius urna.  </p>
                  <span class="">
                 <ul class="list-inline para">
                   <li><i class="fa fa-facebook-official" aria-hidden="true"></i></li>
                   <li><i class="fa fa-tumblr" aria-hidden="true"></i></li>
                   <li class="pull-right viewPost"><a>View Post</a></li>
                   <i class="fa fa-google-plus" aria-hidden="true"></i>
                 </ul>
                 </span>
                </div>
                <div class="postHeading">
                  <span class="glyphicon glyphicon-user pull-left"></span>
                  <span class="">
                 <ul class="list-inline">
                   <li>Uday pratap Singh</li>
                   <li>@Uday5min</li>
                   <li class="pull-right"><a>Grails</a></li>
                 </ul>
                 </span>
                  <p class="para">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur egestas orci lacus, finibus commodo nunc auctor vel. Quisque ac varius urna.  </p>
                  <span class="">
                 <ul class="list-inline para">
                   <li><i class="fa fa-facebook-official" aria-hidden="true"></i></li>
                   <li><i class="fa fa-tumblr" aria-hidden="true"></i></li>
                   <li class="pull-right viewPost"><a>View Post</a></li>
                   <i class="fa fa-google-plus" aria-hidden="true"></i>
                 </ul>
                 </span>
                </div>
              </div>
            </div> <!-- box body -->
          </div>
        </div>
      </div>

      <!--Top Posts-->
      <div class="row">
        <div class="col-md-12 margin-top">
          <div class="wrapBox">
            <div class="boxHeading">Top Posts
              <div class="dropdown pull-right changeFontSize">
                <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">Today
                  <span class="caret"></span></button>
                <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
                  <li role="presentation"><a role="menuitem" tabindex="-1" href="#">1 Week</a></li>
                  <li role="presentation"><a role="menuitem" tabindex="-1" href="#">1 month</a></li>
                  <li role="presentation"><a role="menuitem" tabindex="-1" href="#">1 year</a></li>
                </ul>
              </div>
            </div>

            <div class="boxBody">
              <div class="wrapper">
                <div class="postHeading">
                  <span class="glyphicon glyphicon-user pull-left"></span>
                  <span class="">
                 <ul class="list-inline">
                   <li>Uday pratap Singh</li>
                   <li>@Uday5min</li>
                   <li class="pull-right"><a>Grails</a></li>
                 </ul>
                 </span>
                  <p class="para">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur egestas orci lacus, finibus commodo nunc auctor vel. Quisque ac varius urna.  </p>
                  <span class="">
                 <ul class="list-inline para">
                   <li><i class="fa fa-facebook-official" aria-hidden="true"></i></li>
                   <li><i class="fa fa-tumblr" aria-hidden="true"></i></li>
                   <li class="pull-right viewPost"><a>View Post</a></li>
                   <i class="fa fa-google-plus" aria-hidden="true"></i>
                 </ul>
                 </span>
                </div>

              </div>
            </div> <!-- box body -->
          </div>
        </div>
      </div>
    </div>


    <div class="col-md-4 margin-top">
      <div class="row"><!--Login-->
        <div class="col-md-12">
          <div class="wrapBox">
            <div class="boxHeading">Login</div>
            <div class="boxBody">
              <form class="form-horizontal" action="/login" method="post">

                <div class="form-group changeFontSize">
                  <label class="control-label col-sm-5" for="username">Username/Email*</label>
                  <div class="col-sm-7">
                    <input type="textbox" class="" name="username">
                  </div>
                </div>
                <div class="form-group changeFontSize">
                  <label class="control-label col-sm-5" for="password">Password*</label>
                  <div class="col-sm-7">
                    <input type="password" class="" name="password">
                  </div>
                </div>
                <div class="form-group changeFontSize ">
                  <div class="col-sm-9">
                    <div style="text-decoration:underline"><a href="/reset">Forgot password</a></div>
                  </div>
                  <div class="col-sm-3 right">
                    <button>Login</button>
                  </div>
                  ${LoginMessage}
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
      <div class="row margin-top"><!--Register-->
        <div class="col-md-12">
          <div class="wrapBox">
            <div class="boxHeading">Register</div>
            <div class="boxBody">

              <form class="form-horizontal" name="registration" enctype="multipart/form-data" action="register" method="POST">
                <%--<form method="POST" action="register" enctype="multipart/form-data">--%>

                <div class="form-group changeFontSize">
                  <label class="control-label col-sm-5 changeFontSizes" for="firstName">First name*</label>
                  <div class="col-sm-7">
                    <input type="textbox" class="" id="firstName" name="firstName">
                  </div>
                </div>

                <div class="form-group changeFontSize">
                  <label class="control-label col-sm-5 changeFontSizes" for="lastName">Last name*</label>
                  <div class="col-sm-7">
                    <input type="textbox" class="" id="lastName" name="lastName">
                  </div>
                </div>
                <div class="form-group changeFontSize">
                  <label class="control-label col-sm-5" for="email">Email*</label>
                  <div class="col-sm-7">
                    <input type="textbox" class="" id="email" name="email">
                  </div>
                </div>
                <div class="form-group changeFontSize">
                  <label class="control-label col-sm-5" for="username">Username*</label>
                  <div class="col-sm-7">
                    <input type="textbox" class="" id="username" name="username">
                  </div>
                </div>
                <div class="form-group changeFontSize">
                  <label class="control-label col-sm-5" for="password">Password*</label>
                  <div class="col-sm-7">
                    <input type="password" class="" id="password" name="password">
                  </div>
                </div>
                <div class="form-group changeFontSize">
                  <label class="control-label col-sm-5" for="confirmPassword">Confirm Password*</label>
                  <div class="col-sm-7">
                    <input type="password" class="" id="confirmPassword" name="confirmPassword">
                  </div>
                </div>
                <div class="form-group changeFontSize">
                  <label class="control-label col-sm-5" for="file">Photo</label>
                  <div class="col-sm-7 padding-right0">
                    <input type="file" id="file" name="file">
                  </div>
                </div>
                <div class="form-group changeFontSize">
                  <div class="col-sm-12 padding-right">
                    <input class="pull-right" type="submit" value="Register">
                      ${registration}
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div><!-- Register -->
    </div><!-- margin top col 4 -->
  </div><!--master row end-->
</div>
okay

  <script type="text/javascript" src="/resources/assets/js/jquery-3.2.1.min.js"></script>
  <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.js">0</script>
  <script type="text/javascript" src="/resources/assets/js/bootstrap.min.js"></script>
  <script type="text/javascript">
      // Wait for the DOM to be ready
      $(function() {
          // Initialize form validation on the registration form.
          // It has the name attribute "registration"
          $("form[name='registration']").validate({
              // Specify validation rules
              rules: {
                  // The key name on the left side is the name attribute
                  // of an input field. Validation rules are defined
                  // on the right side
                  firstName: "required",
                  lastName: "required",
                  email: {
                      required: true,
                      // Specify that email should be validated
                      // by the built-in "email" rule
                      email: true
                  },
                  password: {
                      required: true,
                      minlength: 5
                  },
                  confirmPassword:"required",
                  username:"required"
              },
              // Specify validation error messages
              messages: {
                  firstName: "Please enter your FirstName",
                  lastName: "Please enter your LastName",
                  password: {
                      required: "Please provide a Password",
                      minlength: "Your Password must be at least 5 characters long"
                  },
                  email: "Please enter a valid email address",
                  confirmPassword:"Please provide a confirmPassword",
                  username:"Please provide a username"
              },
              // Make sure the form is submitted to the destination defined
              // in the "action" attribute of the form when valid
              submitHandler: function(form) {
                  form.submit();
              }
          });
      });
  </script>
</body>
</html>
