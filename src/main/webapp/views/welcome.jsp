<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

<fmt:formatDate value="${ now }" pattern="dd/MM/yyyy"/>
<form method="GET"
	action="/SP22B2_SOF3011_IT16308/HelloServlet">
	<label>Họ tên</label>
	<input type="text" name="ho_ten" />
	<button>Gửi</button>
</form>

<h3>Hello ${ name }</h3>
