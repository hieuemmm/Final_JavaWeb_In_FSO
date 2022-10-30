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
<title>CM | Add Computer</title>
<link rel="stylesheet" href="/datvexe/resources/css/index.css">
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="container mt-2">
		<div class="d-flex justify-content-center my-2">
			<h3>Đặt vé xe</h3>
		</div>
		<form:form id="form" 
			style="min-width: 1000px !important"
			class="border p-4 row" 
			method="POST"
			action="/datvexe/saveAdd"
			modelAttribute="datVeXe">
			<c:if test='${messageSuccess != null}'>
				<div class="form-group">
					<div class="alert alert-success" role="alert">
					  ${messageSuccess}
					</div>
				</div>
			</c:if>
			<div class="col-6">
				<div class="form-group">
				    <label for="cCCD">cCCD</label> 
				    <form:input type="text" 
				        class="form-control" 
				        id="cCCD" 
				        path="cCCD" 
				        placeholder="Nhập cCCD..." 
				        value="${datVeXe.cCCD}"/> 
				    <span class="form-message"></span>
				</div>
				<div class="form-group">
				    <label for="hoTen">hoTen</label> 
				    <form:input type="text" 
				        class="form-control" 
				        id="hoTen" 
				        path="hoTen" 
				        placeholder="Nhập hoTen..." 
				        value="${datVeXe.hoTen}"/> 
				    <span class="form-message"></span>
				</div>
				<div class="form-group">
				    <label for="ngaySinh">ngaySinh</label> 
				    <form:input type="date" 
				        class="form-control" 
				        id="ngaySinh" 
				        path="ngaySinh" 
				        placeholder="Nhập ngaySinh..." 
				        value="${datVeXe.ngaySinh}"/> 
				    <span class="form-message"></span>
				</div>
				<div class="form-group">
				    <label for="ketQuaSetNghiem">Giới tính</label> 
				    <form:select
				        class="custom-select" id="gioiTinh" path="gioiTinh" value="${datVeXe.gioiTinh}">
				        <form:option value="">--Giới tính--</form:option>
				        <form:option value="Nam">Nam</form:option>
				        <form:option value="Nữ">Nữ</form:option>
				    </form:select> 
				    <span class="form-message"></span>
				</div>
				<div class="form-group">
				    <label for="soDienThoai">soDienThoai</label> 
				    <form:input type="text" 
				        class="form-control" 
				        id="soDienThoai" 
				        path="soDienThoai" 
				        placeholder="Nhập soDienThoai..." 
				        value="${datVeXe.soDienThoai}"/> 
				    <span class="form-message"></span>
				</div>
				<div class="form-group">
				    <label for="trangThaiTiem">Trạng thái tiêm</label> 
				    <form:select
				        class="custom-select" id="trangThaiTiem" path="trangThaiTiem" value="${datVeXe.trangThaiTiem}">
				        <form:option value="">--Trạng thái tiêm--</form:option>
				        <form:option value="Chua tiem">Chưa tiêm</form:option>
				        <form:option value="Da tiem it nhat 1 mui">Đã tiêm ít nhất một mũi</form:option>
				    </form:select> 
				    <span class="form-message"></span>
				</div>
				<div class="form-group">
				    <label for="ketQuaSetNghiem">Kết quả xét nghiệm</label> 
				    <form:select
				        class="custom-select" id="ketQuaSetNghiem" path="ketQuaSetNghiem" value="${datVeXe.ketQuaSetNghiem}">
				        <form:option value="">--Kết quả xét nghiệm--</form:option>
				        <form:option value="Am tinh">Âm tính</form:option>
				        <form:option value="Duong tinh">Dương tính</form:option>
				    </form:select> 
				    <span class="form-message"></span>
				</div>
				<div class="form-group">
				    <label for="ngaySetNghiem">ngaySetNghiem</label> 
				    <form:input type="date" 
				        class="form-control" 
				        id="ngaySetNghiem" 
				        path="ngaySetNghiem" 
				        placeholder="Nhập ngaySetNghiem..." 
				        value="${datVeXe.ngaySetNghiem}"/> 
				    <span class="form-message"></span>
				</div>
			</div>
			<div class="col-6">
				<div class="form-group">
				    <label for="ngayDatVe">ngayDatVe</label> 
				    <form:input type="date" 
				        class="form-control" 
				        id="ngayDatVe" 
				        path="ngayDatVe" 
				        placeholder="Nhập ngayDatVe..." 
				        value="${datVeXe.ngayDatVe}"/> 
				    <span class="form-message"></span>
				</div>
				<div class="form-group">
				    <label for="bienSoXe">bienSoXe</label> 
				    <form:input type="text" 
				        class="form-control" 
				        id="bienSoXe" 
				        path="bienSoXe" 
				        placeholder="Nhập bienSoXe..." 
				        value="${datVeXe.bienSoXe}"/> 
				    <span class="form-message"></span>
				</div>
				<div class="form-group">
				    <label for="diaDiemXuatPhat">diaDiemXuatPhat</label> 
				    <form:input type="text" 
				        class="form-control" 
				        id="diaDiemXuatPhat" 
				        path="diaDiemXuatPhat" 
				        placeholder="Nhập diaDiemXuatPhat..." 
				        value="${datVeXe.diaDiemXuatPhat}"/> 
				    <span class="form-message"></span>
				</div>
				<div class="form-group">
				    <label for="diaDiemDen">diaDiemDen</label> 
				    <form:input type="text" 
				        class="form-control" 
				        id="diaDiemDen" 
				        path="diaDiemDen" 
				        placeholder="Nhập diaDiemDen..." 
				        value="${datVeXe.diaDiemDen}"/> 
				    <span class="form-message"></span>
				</div>
				<div class="form-group">
				    <label for="ngayXuatPhat">ngayXuatPhat</label> 
				    <form:input type="date" 
				        class="form-control" 
				        id="ngayXuatPhat" 
				        path="ngayXuatPhat" 
				        placeholder="Nhập ngayXuatPhat..." 
				        value="${datVeXe.ngayXuatPhat}"/> 
				    <span class="form-message"></span>
				</div>
			</div>
			<div class="d-flex justify-content-end w-100">
				<button type="reset" class="btn btn-outline-white border mr-auto">Clear</button>
				<button type="submit" class="btn btn-primary mr-2">Create</button>
				<a href="/datvexe/list" class="mr-2">
					<button type="button" class="btn btn-outline-white border">Back</button>
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
	<script src="/datvexe/resources/js/Validator.js"></script>
	<script>
		document.addEventListener('DOMContentLoaded', function() {
			try{
				Validator({
					form : '#form',
					formGroupSelector : '.form-group',
					errorSelector : '.form-message',
					rules : [ 
								Validator.isRequired('#cCCD','Ban can nhap du lieu cho truong nay'),
								Validator.isRequired('#hoTen','Ban can nhap du lieu cho truong nay'),
								Validator.isRequired('#ngaySinh','Ban can nhap du lieu cho truong nay'),
								Validator.isRequired('#gioiTinh','Ban can nhap du lieu cho truong nay'),
								Validator.isRequired('#soDienThoai','Ban can nhap du lieu cho truong nay'),
								Validator.isNumberPhoneHas10Has11AndStartWith0('#soDienThoai','So dien thoai sai dinh dang'),
								Validator.isRequired('#trangThaiTiem','Ban can nhap du lieu cho truong nay'),
								Validator.isRequired('#ngayDatVe','Ban can nhap du lieu cho truong nay'),
								Validator.isRequired('#bienSoXe','Ban can nhap du lieu cho truong nay'),
								Validator.isPattern('#bienSoXe',/^[0-9][0-9][A-Z]-[0-9][0-9][0-9].[0-9][0-9]$/,'Bien so xe sai dinh dang'),
								Validator.isRequired('#diaDiemXuatPhat','Ban can nhap du lieu cho truong nay'),
								Validator.isRequired('#diaDiemDen','Ban can nhap du lieu cho truong nay'),
								Validator.isRequired('#ngayXuatPhat','Ban can nhap du lieu cho truong nay'),
								Validator.isGreaterThanOrEqualCurrentDate('#ngayXuatPhat','Ngay xuat phat phai lon hon hoac bang ngay hien tai'),
							],
				});
			}catch(e){
				
			}
		});
	</script>
</body>
</html>