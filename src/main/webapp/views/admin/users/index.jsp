<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<c:if test="${ empty ds }">
	<p class="alert alert-warning">Không có dữ liệu</p>
</c:if>

<a class="btn btn-success"
	href="/SP22B2_SOF3011_IT16308/users/create">Thêm mới</a>

<c:if test="${ !empty ds }">
	<table class="table">
		<thead>
			<th>Họ tên</th>
			<th>Địa chỉ</th>
			<th>SĐT</th>
			<th>Email</th>
			<th colspan="2">Thao tác</th>
		</thead>
		<tbody>
			<c:forEach items="${ ds }" var="obj">
				<tr>
					<td>${ obj.hoTen }</td>
					<td>${ obj.diaChi }</td>
					<td>${ obj.sdt }</td>
					<td>${ obj.email }</td>
					<td>
						<a class="btn btn-primary">Cập nhật</a>
					</td>
					<td>
						<a
							class="btn btn-danger"
							href="/SP22B2_SOF3011_IT16308/users/delete?id=${ obj.id }"
						>
							Xóa
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
