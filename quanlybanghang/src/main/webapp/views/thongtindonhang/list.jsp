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
<title>Quản lý báng hàng | Danh sách đơn hàng</title>
<link rel="stylesheet" href="/quanlybanghang/resources/css/index.css">
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="container-fuild m-2">
		<!--Header of page-->
		<div class="d-flex justify-content-between my-2">
			<h3>Danh sách đơn hàng</h3>
			<a href="/quanlybanghang/add">
				<button class="btn btn-success btn-search">Tạo đơn hàng</button>
			</a>
		</div>
		<!-- 
		<div class="d-flex justify-content-between mt-2">
			<form id="formSearch" class="w-100 d-flex justify-content-between" method="GET" action="/quanlybanghang/computer/search">
				<div class="form-group col pl-0 mb-0">
					<input type="text" class="form-control " id="inputSearch" name="search" placeholder="Nhập từ khoá..." value="${search}"/> 
					<span class="form-message"></span>
				</div>
				<button type="submit" class="btn btn-primary ml-auto btn-search">Tìm kiếm</button>
			</form>
		</div> 
		-->
		<div class="d-flex justify-content-between mt-2">
			<form:form 
				id="formSearch" 
				class="w-100 d-flex justify-content-end align-items-end" 
				method="GET" 
				modelAttribute="timKiem"
				action="/quanlybanghang/search">
				<div class="form-group mr-2 mb-0">
				    <form:select 
				        id="trangThaiDonHang" 
				        class="custom-select" 
				        path="trangThaiDonHang" 
				        value="${thongTinDonHang.trangThaiDonHang}">
				        <form:option value="">--trangThaiDonHang--</form:option>
				        <form:option value="Chua giao hang">Chua giao hang</form:option>
				        <form:option value="Da giao hang">Da giao hang</form:option>
				    </form:select> 
				    <span class="form-message"></span>
				</div>
				<div class="form-group mr-2 mb-0">
				    <form:input type="date" 
				        class="form-control" 
				        id="ngayHenTra" 
				        path="ngayHenTra" 
				        placeholder="Nhập ngayHenTra..." 
				        value="${thongTinDonHang.ngayHenTra}"/> 
				    <span class="form-message"></span>
				</div>
				<button type="submit" class="btn btn-primary btn-search">Tìm kiếm</button>
			</form:form>
		</div>
		<!--Báo thành công-->
		<p class="text-center text-success">${messageSuccess}</p>
		<!--Danh sách dữ liệu-->
		<table class="table w-100">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">maDH</th>
					<th scope="col">maKH</th>
					<th scope="col">tenKH</th>
					<th scope="col">gioiTinh</th>
					<th scope="col">soDienThoai</th>
					<th scope="col">ngayDatMay</th>
					<th scope="col">trangThaiDonHang</th>
					<th scope="col">ngayHenTra</th>
					<th scope="col">trangThaiDonHang</th>
					<th scope="col">ngayTra</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${donHangs}" var="donHang" varStatus="var">
					<tr>
						<th scope="row">${var.count}</th>
						<td>
							<a class="text-decoration-none" href="/quanlybanghang/detail/${donHang.maDH}">
								${donHang.maDH}
							</a>
						</td>
						<td>${donHang.khachHang.maKH}</td>
						<td>${donHang.khachHang.tenKH}</td>
						<td>${donHang.khachHang.gioiTinh}</td>
						<td>${donHang.khachHang.soDienThoai}</td>
						<td>${donHang.ngayDatMay}</td>
						<td>${donHang.trangThaiDonHang}</td>
						<td>${donHang.ngayHenTra}</td>
						<td>${donHang.trangThaiDonHang}</td>
						<td>${donHang.ngayTra}</td>
						<td >
							<a class="text-decoration-none" href="/quanlybanghang/edit/${donHang.maDH}">
								<i class="bi bi-pencil-square" style="font-size: 25px; color:blue"></i>
							</a>
							<i 
								class="bi bi-trash3-fill" 
								style="font-size: 25px;color:red"
								dataURL="/quanlybanghang/delete/${donhang.maDH}"
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