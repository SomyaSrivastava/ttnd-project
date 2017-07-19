<%@ page import="com.ttnd.Entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dashboard</title>
    <link rel="stylesheet" type="text/css" href="/resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/assets/css/dashboardCSS.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>
<body>

<div class="container">
    <header>
        <%
           User user=(User)session.getAttribute("user");
           if (user==null)
               response.sendRedirect("/");
           out.print(user.toString());
        %>
        <div class="row ">
            <div class="col-md-12 header">
                <div class="linkshare">
                    <a href="#">Link Sharing</a>
                </div>
                <div class="icon">
               	     <span class="searchSpan">
	                     <span class="glyphicon glyphicon-search"></span>
	                     <input type="text" class="noborder" placeholder="Search">
	                     <span class="glyphicon glyphicon-remove-sign"></span>
	                  </span>


                    <i class="fa fa-comment fa-lg" data-toggle="modal" data-target="#createTopic"></i>
                    <!-- Modal -->
                    <div class="modal fade" id="createTopic" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Create Topic(Pop up)</h4>
                                </div>
                                <form class="form-horizontal" action="createtopic" method="get">
                                    <div class="modal-body">
                                        <div class="form-group">
                                            <label class="control-label col-sm-2" >Name*</label>
                                            <div class="col-sm-8 pull-right">
                                                <input type="text" class="form-control" name="name">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-sm-2" for="visibility">Visibility*</label>
                                            <div class="col-sm-8 pull-right">
                                                <select name="visibility">
                                                    <option value="public" selected="selected">Public</option>
                                                    <option value="private">Private</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-default">Save</button>
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    </div>
                                </form>
                            </div>

                        </div>
                    </div>

                    <i class="fa fa-envelope fa-lg"  data-toggle="modal" data-target="#invitation"></i>

                    <!-- Modal -->
                    <div class="modal fade" id="invitation" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Send Invitation(Pop up)</h4>
                                </div>
                                <form class="form-horizontal">
                                    <div class="modal-body">
                                        <div class="form-group">
                                            <label class="control-label col-sm-2" for="email">Email*</label>
                                            <div class="col-sm-8 pull-right">
                                                <input type="text" class="form-control" id="email">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-sm-2" for="Topic">Topic*</label>
                                            <div class="col-sm-8 pull-right">
                                                <select>
                                                    <option value="1" selected="selected">Public</option>
                                                    <option value="2">Private</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-default">Invite</button>
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    </div>
                                </form>
                            </div>

                        </div>
                    </div>



                    <i class="fa fa-link fa-lg" data-toggle="modal" data-target="#shareLink"></i>

                    <!-- Modal -->
                    <div class="modal fade" id="shareLink" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Share Link(Pop Up)</h4>
                                </div>

                                <form class="form-horizontal">
                                    <div class="modal-body">
                                        <div class="form-group">
                                            <label class="control-label col-sm-2" for="name">Name*</label>
                                            <div class="col-sm-8 pull-right">
                                                <input type="text" class="form-control" id="name">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="control-label col-sm-2" for="Description">Description*</label>
                                            <div class="col-sm-8 pull-right">
                                                <textarea class="form-control" rows="5" id="description"></textarea>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="control-label col-sm-2" for="Topic">Topic*</label>
                                            <div class="col-sm-8 pull-right">
                                                <select>
                                                    <option value="1" selected="selected">Topic 1</option>
                                                    <option value="2">Topic 2</option>
                                                </select>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-default">Share</button>
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    </div>
                                </form>
                            </div>

                        </div>
                    </div>

                    <i class="fa fa-File fa-lg " data-toggle="modal" data-target="#resources"></i>

                    <!-- Modal -->
                    <div class="modal fade" id="resources" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Share Document(Pop Up)</h4>
                                </div>
                                <form class="form-horizontal">
                                    <div class="modal-body">
                                        <div class="form-group">
                                            <label class="control-label col-sm-2" for="Topic">Document*</label>
                                            <div class="col-sm-8 pull-right">
                                                <input type="text" class="form-control" id="name">
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <label class="control-label col-sm-2" for="Description">Description*</label>
                                            <div class="col-sm-8 pull-right">
                                                <textarea class="form-control" rows="5" id="description"></textarea>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="control-label col-sm-2" for="Topic">Topic*</label>
                                            <div class="col-sm-8 pull-right">
                                                <select>
                                                    <option value="1" selected="selected">Topic 1</option>
                                                    <option value="2">Topic 2</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-default">Share</button>
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    </div>
                                </form>
                            </div>

                        </div>
                    </div>

                    <i class="fa fa-user fa-lg"></i>
                    <div class="dropdown">
                        <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Uday
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                            <li><a href="#">Profile</a></li>
                            <li><a href="#">Users</a></li>
                            <li><a href="#">Topices</a></li>
                            <li><a href="#">Posts</a></li>
                            <li><a href="#">Logout</a></li>
                        </ul>
                    </div>
                </div>

            </div>
        </div>
</div>
</header>


<script type="text/javascript" src="/resources/assets/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/resources/assets/js/bootstrap.min.js"></script>
</body>
</html>
