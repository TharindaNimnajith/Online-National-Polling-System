<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>election Management Application</title>
</head>
<body>
	<center>
		<h1>election Management</h1>
        <h2>
        	<a href="new">Add New election</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All elections</a>
        	
        </h2>
	</center>
    <div align="center">
		<c:if test="${election != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${election == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${election != null}">
            			Edit election
            		</c:if>
            		<c:if test="${election == null}">
            			Add New election
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${election != null}">
        			<input type="hidden" name="id" value="<c:out value='${election.id}' />" />
        		</c:if>            
            <tr>
                <th>election Name: </th>
                <td>
                	<input type="text" name="name" size="45"
                			value="<c:out value='${election.name}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>election Email: </th>
                <td>
                	<input type="text" name="email" size="45"
                			value="<c:out value='${election.email}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Country: </th>
                <td>
                	<input type="text" name="country" size="15"
                			value="<c:out value='${election.country}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>
