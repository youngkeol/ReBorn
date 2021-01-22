<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>리본</title>
    <link href="/css/layout.css" type="text/css" rel="stylesheet" />
    <link href="/css/member/login.css" type="text/css" rel="stylesheet" />
     <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
</head>
<body>
    <script type="module" src="/js/inc/header.js"></script> 
    <script src="/js/member/login.js" type="text/javascript"></script>
	<tiles:insertAttribute name="header" />
 

    <!-- --------------------------- <body> --------------------------------------- -->
	<main>	 <!-- footer가 main안에 있어야 하므로 메인태그로 감싸줌 -->
	
		<tiles:insertAttribute name="main" />
	
		
	</main>

</body>
</html>