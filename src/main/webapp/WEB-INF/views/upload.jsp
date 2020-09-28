
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-09-
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language = "java" contentType = "text/html; charset = UTF-8"
         pageEncoding = "UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv = "Content-Type" content = "text/html; charset = UTF-8">
    <title>upload</title>
</head>
<body>
    <h4>file upload</h4>
    <form action="${pageContext.request.contextPath}/file/upload" method="post" name="uploadForm" enctype="multipart/form-data">
        <table>
            <tr>
                <td>please select the file you want to upload</td>
                <td>
                    <input type="file" name="file">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="upload">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
