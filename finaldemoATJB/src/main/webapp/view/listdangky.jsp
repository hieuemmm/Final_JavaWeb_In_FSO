<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Document</title>
<style>
.App {
	margin-left: 25%;
}
</style>
</head>

<body>
        
	<div class="App">
	  <form action="/finaldemoATJB/searchregister">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search"
							name="search">
						<div class="input-group-btn">
							<button class="btn btn btn-success" type="submit">
								<i class="glyphicon glyphicon-search">search</i>
							</button>
						</div>
					</div>
				</form>
		<h3>Danh sách máy</h3>


		<div class="contTable row">
			<table id="IDtable"
				class="table table-striped table-hover table-users col-10">
				<thead>

					<tr>
						<td>CCCD</td>
						<td>HoTen</td>
						<td>NgaySinh</td>
						<td>GioiTinh</td>
						<td>SoDienThoai</td>
						<td> TrangThaiTiem</td>
						<td>KetQuaSetNghiem</td>
						<td>NgaySetNghiem</td>
						<td>Action</td>
					</tr>

				</thead>
				<tbody>
          <c:forEach items="${listdangkys}" var="listFor">
					<tr>
						<td>${listFor.getCCCD()}</td>
						<td>${listFor.getHoTen()}</td>
						<td>${listFor.getNgaySinh()}</td>
						
						<td>${listFor.getGioiTinh()}</td>
						<td>${listFor.getSoDienThoai()}</td>
						<td>${listFor.getTrangThaiTiem()}</td>
						<td>${listFor.getKetQuaSetNghiem()}</td>
					
						<td>${listFor.getNgaySetNghiem()}</td>
						<td><a class="btn btn-success" style="height: 35px;" href="/finaldemoATJB/showupdate/${listFor.getCCCD()}">Sửa</a>
		                        <a class="btn btn-danger" style="height: 35px;" href="/finaldemoATJB/delete/${listFor.getCCCD()}">Xóa</a></td>
					</tr>
            </c:forEach>
				</tbody>
			</table>

		</div>
</div>


</body>

</html>