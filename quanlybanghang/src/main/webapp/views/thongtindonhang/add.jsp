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
<title>Quản Lý Bán Hàng | Tạo đơn hàng</title>
<link rel="stylesheet" href="/quanlybanghang/resources/css/index.css">
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="container mt-2">
		<div class="d-flex justify-content-center my-2">
			<h3>Tạo đơn hàng</h3>
		</div>
		<form:form id="form" 
			style="min-width: 1200px !important"
			class="border p-4 row" 
			method="POST"
			action="/quanlybanghang/saveAdd"
			modelAttribute="thongTinDonHang">
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
			<div class="col-6">
				<div class="form-group">
				    <label for="maKH">maKH(*)</label> 
				    <form:select class="custom-select" id="maKH" path="maKH" value="${thongTinDonHang.maKH}">
				        <form:option value="">--maKH--</form:option>
				        <c:forEach items="${khachHangs}" var="khachHang" varStatus="var">
				        	<form:option value="${khachHang.maKH}">${khachHang.maKH} - ${khachHang.tenKH}</form:option>
				        </c:forEach>
				    </form:select> 
				    <span class=form-message-server> ${messageErrorMaKH}</span>
				    <span class="form-message"></span>
				</div>
				<div class="form-group">
				    <label for="ngayDatMay">ngayDatMay(*)</label> 
				    <form:input type="date" 
				        class="form-control" 
				        id="ngayDatMay" 
				        path="ngayDatMay" 
				        placeholder="Nhập ngayDatMay..." 
				        value="${thongTinDonHang.ngayDatMay}"/> 
				    <span class="form-message"></span>
				</div>
				<div class="form-group">
				    <label for="trangThaiThanhToan">trangThaiThanhToan(*)</label> 
				    <form:select 
				        id="trangThaiThanhToan" 
				        class="custom-select" 
				        path="trangThaiThanhToan" 
				        value="${thongTinDonHang.trangThaiThanhToan}">
				        <form:option value="">--trangThaiThanhToan--</form:option>
				        <form:option value="Chua thanh toan">Chua thanh toan</form:option>
				        <form:option value="Da thanh toan">Da thanh toan</form:option>
				    </form:select> 
				    <span class="form-message"></span>
				</div>
				<div class="form-group">
				    <label for="ngayHenTra">ngayHenTra(*)</label> 
				    <form:input type="date" 
				        class="form-control" 
				        id="ngayHenTra" 
				        path="ngayHenTra" 
				        placeholder="Nhập ngayHenTra..." 
				        value="${thongTinDonHang.ngayHenTra}"/> 
				    <span class="form-message"></span>
				</div>
				<div class="form-group">
				    <label for="trangThaiDonHang">trangThaiDonHang</label> 
				    <form:select 
				        id="trangThaiDonHang" 
				        class="custom-select" 
				        path="trangThaiDonHang" 
				        value="${thongTinDonHang.trangThaiDonHang}">
				        <form:option value="Chua giao hang">Chua giao hang</form:option>
				        <form:option value="Da giao hang">Da giao hang</form:option>
				    </form:select> 
				    <span class="form-message"></span>
				</div>
			</div>
			<div class="col-6">
				<div class="form-group">
				    <label for="tenSP">tenSP(*)</label> 
				    <form:input type="text" 
				        class="form-control" 
				        id="tenSP" 
				        path="tenSP" 
				        placeholder="Nhập tenSP..." 
				        value="${thongTinDonHang.tenSP}"/> 
				    <span class="form-message"></span>
				</div>
				<div class="form-group">
				    <label for="soTien">soTien(*)</label> 
				    <form:input type="number" 
				        class="form-control" 
				        id="soTien" 
				        path="soTien" 
				        placeholder="Nhập soTien..." 
				        value="${thongTinDonHang.soTien}"/> 
				    <span class=form-message-server> ${messageErrorSoTien}</span>
				    <span class="form-message"></span>
				</div>
				<div class="form-group">
				    <label for="ghiChu">ghiChu</label> 
				    <form:input type="text" 
				        class="form-control" 
				        id="ghiChu" 
				        path="ghiChu" 
				        placeholder="Nhập ghiChu..." 
				        value="${thongTinDonHang.ghiChu}"/> 
				    <span class="form-message"></span>
				</div>
			</div>
			<div class="d-flex justify-content-end w-100">
				<button type="reset" class="btn btn-outline-white border mr-auto">Xoa tat ca</button>
				<button type="submit" class="btn btn-primary mr-2">Tao don hang</button>
				<a href="/quanlybanghang/list" class="mr-2">
					<button type="button" class="btn btn-outline-white border">Quay Lai</button>
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
	<script src="/quanlybanghang/resources/js/Validator.js"></script>
	<script>
		document.addEventListener('DOMContentLoaded', function() {
			var currentDate = new Date().toISOString().split("T")[0];
			var currentTime = new Date().toISOString().substring(11,16);
			document.getElementById("ngayDatMay").value = currentDate;
			//document.getElementById("ngayBatDauSuDung").setAttribute("max",currentDate);
			//.getElementById("gioBatDauSuDung").value = currentTime;
			try{
				Validator({
					form : '#form',
					formGroupSelector : '.form-group',
					errorSelector : '.form-message',
					rules : [ 
								Validator.isRequired('#maKH','Ban can nhap du lieu cho truong nay'),
								Validator.isRequired('#ngayDatMay','Ban can nhap du lieu cho truong nay'),
								Validator.isRequired('#trangThaiThanhToan','Ban can nhap du lieu cho truong nay'),
								Validator.isRequired('#ngayHenTra','Ban can nhap du lieu cho truong nay'),
								Validator.isGreaterThanOrEqualCurrentDate('#ngayHenTra','Ngay xuat phat phai lon hon hoac bang ngay hien tai'),
								Validator.isRequired('#tenSP','Ban can nhap du lieu cho truong nay'),
								Validator.isRequired('#soTien','Ban can nhap du lieu cho truong nay'),
								//Validator.isNumberPhoneHas10Has11AndStartWith0('#soDienThoai','So dien thoai sai dinh dang'),
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