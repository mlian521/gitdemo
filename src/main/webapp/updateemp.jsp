<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/4
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/empupdate" method="post" onsubmit="return confirm('确认更新吗？')">
    <table>
        <tr>
            <td>员工编号</td>
            <td>
                ${emp.empno}
                <input type="text" name="empno" value=${emp.empno}>
            </td>
        </tr>
        <tr>
            <td>员工姓名</td>
            <td><input type="text" name="ename" value=${ename}></td>
        </tr>
        <tr>
            <td>入职日期</td>
            <td><input type="Date" name="hiredate" value=${emp.hiredate}></td>
        </tr>
        <tr>
            <td>薪资</td>
            <td><input type="text" name="sal" value=${emp.sal}></td>
        </tr>
        <tr>
            <td><input type="submit" value="更新"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>

</form>
</body>
</html>
