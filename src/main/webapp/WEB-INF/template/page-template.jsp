<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
   <jsp:include page="../section/css.jsp"/>
</head>
<body>
<jsp:include page="../section/header.jsp"/>
<jsp:include page="../section/nav.jsp"/>
<section class="main">
    <sitemesh:write property="body"/>
</section>
<jsp:include page="../section/footer.jsp"/>
<jsp:include page="../section/js.jsp"/>
</body>
</html>
