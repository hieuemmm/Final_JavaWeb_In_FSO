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
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>
<title>Quản Lý Nhà Hàng | Sửa đơn hàng</title>
<link rel="stylesheet" href="/quanlynhahang/resources/css/index.css">
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="container mt-2">
		<div class="d-flex justify-content-center my-2">
			<h3>Sửa đơn hàng</h3>
		</div>
		<form:form id="form" 
			class="border p-4" 
			method="POST"
			action="/quanlynhahang/saveEdit"
			modelAttribute="thongTinDatHang">
			<c:if test='${messageSuccess != null}'>
				<div class="form-group">
					<div class="alert alert-success" role="alert">
					  ${messageSuccess}
					</div>
				</div>
			</c:if>
			<c:if test='${messageError != null}'>
				<div class="form-group">
					<div class="alert alert-danger" role="alert">
					  ${messageError}
					</div>
				</div>
			</c:if>
			
			<form:hidden path="maOrder" value="${thongTinDatHang.maOrder}"/>
		    <div class="form-group">
		        <label for="tenKH">tenKH: ${thongTinDatHang.tenKH}</label> 
		        <form:hidden path="tenKH" value="${thongTinDatHang.tenKH}"/>
		    </div>
		    <div class="form-group">
			    <label for="maLoaiKH">maLoaiKH: ${thongTinDatHang.maLoaiKH} (<span>${thongTinDatHang.tenLoaiKH}</span>)</label> 
			    <form:hidden path="maLoaiKH" value="${thongTinDatHang.maLoaiKH}"/>
			</div>
		    <div class="form-group">
		        <label for="soDienThoai">soDienThoai: ${thongTinDatHang.soDienThoai}</label> 
		        <form:hidden path="soDienThoai" value="${thongTinDatHang.soDienThoai}"/>
		    </div>
		    <div class="form-group">
		        <label for="ngayOrder">ngayOrder: ${thongTinDatHang.ngayOrder}</label> 
		        <form:hidden path="ngayOrder" value="${thongTinDatHang.ngayOrder}"/>
		    </div>
		    <div class="form-group">
		        <label for="soNguoiLon">soNguoiLon</label> 
		        <form:input type="number" 
		            class="form-control" 
		            id="soNguoiLon" 
		            path="soNguoiLon" 
		            placeholder="Nhập soNguoiLon..." 
		            value="${thongTinDatHang.soNguoiLon}"/> 
		        <span class="form-message"></span>
		    </div>
		    <div class="form-group">
			    <label for="soTreEm">soTreEm</label> 
			    <form:input type="number" 
			        class="form-control" 
			        id="soTreEm" 
			        path="soTreEm" 
			        placeholder="Nhập soTreEm..." 
			        value="${thongTinDatHang.soTreEm}"/> 
			    <span class="form-message"></span>
			</div>
		    <div class="form-group">
		        <label for="gioVao">gioVao</label> 
		        <form:input type="time" 
		            class="form-control" 
		            id="gioVao" 
		            path="gioVao" 
		            placeholder="Nhập gioVao..." 
		            value="${thongTinDatHang.gioVao}"/> 
		        <span class="form-message"></span>
		    </div>
			<div class="d-flex justify-content-end w-100">
				<button type="reset" class="btn btn-outline-white border mr-auto">Xoá tất cả</button>
				<button type="submit" class="btn btn-primary mr-2">Sửa đơn hàng</button>
				<a href="/quanlynhahang/list" class="mr-2">
					<button type="button" class="btn btn-outline-white border">Quay lại</button>
				</a>
			</div>
		</form:form>
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
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.0/moment.min.js"></script>
	<script src="/quanlynhahang/resources/js/Validator.js"></script>
	<script>
		document.addEventListener('DOMContentLoaded', function() {
			var currentDate = new Date().toISOString().split("T")[0];
			var currentTime = new Date().toISOString().substring(11,16);
			document.getElementById("ngayOrder").value = currentDate;
			//document.getElementById("gioVao").setAttribute("max",currentDate);
			document.getElementById("gioVao").value = currentTime;
			try{
				Validator({
					form : '#form',
					formGroupSelector : '.form-group',
					errorSelector : '.form-message',
					rules : [ 
								//Validator.isRequired('#maKH','Ban can nhap du lieu cho truong nay'),
								//Validator.isRequired('#ngayDatMay','Ban can nhap du lieu cho truong nay'),
								//Validator.isRequired('#trangThaiThanhToan','Ban can nhap du lieu cho truong nay'),
								//Validator.isRequired('#ngayHenTra','Ban can nhap du lieu cho truong nay'),
								//Validator.isGreaterThanOrEqualCurrentDate('#ngayHenTra','Ngay xuat phat phai lon hon hoac bang ngay hien tai'),
								//Validator.isRequired('#tenSP','Ban can nhap du lieu cho truong nay'),
								Validator.isGreaterThanZero('#soNguoiLon','Phải là số nguyên dương lớn hơn 0'),
								Validator.isGreaterThanZero('#soTreEm','Phải là số nguyên dương lớn hơn 0'),
								//Validator.isNumberPhoneLength10AndStartWith0123('#soDienThoai','Số điện thoại phải là số có 10 chữ số và bắt đầu bằng 0123'),
								//Validator.isLength('#soDienThoai',10,'Số điện thoại phải là số có 10 chữ số'),
								//Validator.isPattern('#bienSoXe',/^[0-9][0-9][A-Z]-[0-9][0-9][0-9].[0-9][0-9]$/,'Bien so xe sai dinh dang'),
								//Validator.isGreaterThanOrEqualCurrentDate('#ngayXuatPhat','Ngay xuat phat phai lon hon hoac bang ngay hien tai'),
							],
				});
			}catch(e){
				
			}
		});
	</script>
</body>
</html>