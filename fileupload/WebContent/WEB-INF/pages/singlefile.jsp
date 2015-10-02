<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://raw.githubusercontent.com/enyo/dropzone/master/dist/dropzone.js"></script>
<link rel="stylesheet" href="https://rawgit.com/enyo/dropzone/master/dist/dropzone.css">
</head>
<body>

<div class="container">
<form action="/fileupload/upload" method="post" enctype="multipart/form-data">
<input type="text" name="desc" placeholder="please enter file desc">
<input type="file" name="uploadedfile">
<input type="file" name="uploadedfile">
<input type="file" name="uploadedfile">
<input type="file" name="uploadedfile">
<button type="submit">Upload</button>
</form>


<br>

<div class="jumbotron">
<h1>Multifile Drag and Drop file Example</h1>
</div>
<br>



<form action="/fileupload/multifileupload"
      class="dropzone"
      id="my-awesome-dropzone">
      
<input type="hidden"  value="${albumId}" name ="albumId">      
      </form>



<br>


<!-- 
<img alt="" src="/fileupload/image/33">-->



</div>



</body>
</html>