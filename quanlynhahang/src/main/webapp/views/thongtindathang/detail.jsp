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
<title>Quản Lý Nhà Hàng | Tạo đơn hàng</title>
<link rel="stylesheet" href="/quanlynhahang/resources/css/index.css">
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="container mt-2">
		<div class="d-flex justify-content-between my-2">
			<h3>Chi tiết đơn hàng</h3>
			<a href="/quanlynhahang/">
				<button class="btn btn-dark btn-search">Quay lại</button>
			</a>
		</div>
		<table class="table w-100">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">maCTDH</th>
					<th scope="col">tenSP</th>
					<th scope="col">soTien</th>
					<th scope="col">ghiChu</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${chiTietDonHangs}" var="chiTietDonHang" varStatus="var">
					<tr>
						<th scope="row">${var.count}</th>
						<td>${chiTietDonHang.maCTDH}</td>
						<td>${chiTietDonHang.tenSP}</td>
						<td>${chiTietDonHang.soTien}</td>
						<td>${chiTietDonHang.ghiChu}</td>
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
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.0/moment.min.js"></script>
	<script src="/quanlynhahang/resources/js/Validator.js"></script>
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