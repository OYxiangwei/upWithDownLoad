<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv = "Content-Type" content = "text/html; charset=UTF-8">
    <title>download  page </title>
</head>
<body>
    <h1>click the link to download</h1>
    <a href="${contextPath}download?filename=${requestScope.fileinfo.file.originalFilename}">${requestScope.fileinfo.file.originalFilename}</a>
</body>
</html>