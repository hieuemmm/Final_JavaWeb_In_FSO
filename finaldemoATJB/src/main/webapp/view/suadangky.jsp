<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
<style>
.App {
	margin-left: 25%;
}
</style>
</head>
<body>
	<div class="App">
	
		<h3>Dang ky thue xe</h3>
		<form:form class='contInput row' action="/finaldemoATJB/update" method="POST"
			modelAttribute="khachhang">
			<div class="col-12 row">
				<div class="d-flex flex-column ml-2 col-6 row">
					<div class="inputGrcl col-12 row">
						<label class='labelCl col-4' for="l_name">CCCD</label>
						<p>${khackhang.getCCCD()}</p>
						
<form:hidden path="CCCD" class="form-control col-8" id="l_name" name="maKh" />
					</div>

				</div>
			</div>
			<div class="col-12 row">
				<div class="d-flex flex-column ml-2 col-6 row">
					<div class="inputGrcl col-12 row">
						<label class='labelCl col-4' for="l_name">HoTen</label>
						<p>${khackhang.getHoTen()}</p>
						<form:hidden path="HoTen" class="form-control col-8"
							id="l_name" />
					</div>
				</div>
			</div>
			<div class="col-12 row">
				<div class="d-flex flex-column ml-2 col-6 row">
					<div class="inputGrcl col-12 row">
						<label class='labelCl col-4' for="l_name">NgaySinh</label>
						<p>${khackhang.getNgaySinh()}</p>
						<form:hidden  path="NgaySinh" class="form-control col-8"
							id="l_name" />
					</div>

				</div>
			</div>
			<div class="col-12 row">
				<div class="d-flex flex-column ml-2 col-6 row">
					<div class="inputGrcl col-12 row">
						<label class='labelCl col-4' for="l_name">GioiTinh</label>
						<p>${khackhang.getGioiTinh()}</p>
						<form:hidden  path="GioiTinh" class="form-control col-8"
							id="l_name" />
					</div>

				</div>
			</div>
			<div class="col-12 row">
				<div class="d-flex flex-column ml-2 col-6 row">
					<div class="inputGrcl col-12 row">
						<label class='labelCl col-4' for="l_name">SoDienThoai</label>
						<form:input type="text" path="SoDienThoai" class="form-control col-8"
							id="l_name" />
					</div>

				</div>
			</div>
			<div class="col-12 row">
				<div class="d-flex flex-column ml-2 col-6 row">
					<div class="inputGrcl col-12 row">
						<label class='labelCl col-4' for="l_name">TrangThaiTiem</label>
						<form:input type="text" path="TrangThaiTiem" class="form-control col-8"
							id="l_name" />
					</div>

				</div>
			</div>
			<div class="col-12 row">
				<div class="d-flex flex-column ml-2 col-6 row">
					<div class="inputGrcl col-12 row">
						<label class='labelCl col-4' for="l_name">KetQuaSetNghiem</label>
						<form:input type="text" path="KetQuaSetNghiem" class="form-control col-8"
							id="l_name" />
					</div>

				</div>
			</div>
			<div class="col-12 row">
				<div class="d-flex flex-column ml-2 col-6 row">
					<div class="inputGrcl col-12 row">
						<label class='labelCl col-4' for="l_name">NgaySetNghiem</label>
						<form:input type="text" path="NgaySetNghiem" class="form-control col-8"
							id="l_name" />
					</div>

				</div>
			</div>
			
			<button type="submit" class="btn btn-success" id="addSer">them dang ky</button>
		</form:form>
	</div>

</body>
</html>