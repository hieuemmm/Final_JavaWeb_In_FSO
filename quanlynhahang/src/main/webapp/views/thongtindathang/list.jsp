<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>
<title>Quản Lý Nhà Hàng | Danh sách đơn hàng</title>
<link rel="stylesheet" href="/quanlynhahang/resources/css/index.css">
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="container-fuild m-2">
		<!--Header of page-->
		<div class="d-flex justify-content-between my-2">
			<h3>Danh sách đơn hàng</h3>
			<a href="/quanlynhahang/add">
				<button class="btn btn-success btn-search">Tạo đơn hàng</button>
			</a>
		</div>

		<div class="d-flex justify-content-between mt-2">
			<form id="formSearch" class="w-100 d-flex justify-content-between" method="GET" action="/quanlynhahang/search">
				<div class="form-group col pl-0 mb-0">
					<input type="text" class="form-control " id="inputSearch" name="search" placeholder="Nhập từ khoá..." value="${search}"/> 
					<span class="form-message"></span>
				</div>
				<button type="submit" class="btn btn-primary ml-auto btn-search">Tìm kiếm</button>
			</form>
		</div> 
		
		<!--Báo thành công-->
		<p class="text-center text-success">${messageSuccess}</p>
		<!--Danh sách dữ liệu-->
		<table class="table w-100">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="row">maOrder</th>
					<th scope="row">tenKH</th>
					<th scope="row">maLoaiKH</th>
					<th scope="row">soDienThoai</th>
					<th scope="row">ngayOrder</th>
					<th scope="row">soNguoiLon</th>
					<th scope="row">soTreEm</th>
					<th scope="row">gioVao</th>
					<th scope="row">tienThanhToan</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ttOrders}" var="ttOrder" varStatus="var">
					<tr>
						<th scope="row">${var.count}</th>
						<td>${ttOrder.maOrder}</td>
						<td>${ttOrder.tenKH}</td>
						<td>${ttOrder.maLoaiKH}</td>
						<td>${ttOrder.soDienThoai}</td>
						<td>${ttOrder.ngayOrder}</td>
						<td>${ttOrder.soNguoiLon}</td>
						<td>${ttOrder.soTreEm}</td>
						<td>${ttOrder.gioVao}</td>
						<td>${ttOrder.tienThanhToan}</td>
						<td >
							<a class="text-decoration-none" href="/quanlynhahang/edit/${ttOrder.maOrder}">
								<i class="bi bi-pencil-square" style="font-size: 25px; color:blue"></i>
							</a>
							<i 
								class="bi bi-trash3-fill" 
								style="font-size: 25px;color:red"
								dataURL="/quanlynhahang/delete/${ttOrder.maOrder}"
								onclick="deleteFunction(event)"
							></i>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<%@ include file="../footer.jsp"%>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"
		integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+"
		crossorigin="anonymous"></script>
	<script>
		function deleteFunction(event) {
		  let resultConfirm  = confirm("Bạn có muốn xoá không?");
		  if(resultConfirm){
			  window.location.href = event.target.getAttribute("dataURL");
		  }
		}

		function CheckOut(event) {
			window.location.href = event.target.getAttribute("dataURL");
		}
	</script>
</body>
</html>