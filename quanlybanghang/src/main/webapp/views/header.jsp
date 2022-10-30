<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="/quanlybanghang/"><strong><span style="color: rgb(0,152,218);font-size:20px;line-height:20px">FINAL</span><span style="color: rgb(245,134,52);font-size:27px;line-height:20px">JAVA</span></strong></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
		<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
			<li class="nav-item"><a class="nav-link" href="/quanlybanghang/list">Danh sách đơn hàng</a></li>
			<li class="nav-item"><a class="nav-link" href="/quanlybanghang/add">Tạo đơn hàng</a></li>
			<li class="nav-item"><a class="nav-link" href="/quanlybanghang/list-error">Giả lập trang lỗi</a></li>
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search" style="height: 31px !important;width:300px; font-size: 14px;"
				placeholder="Tìm kiếm....">
		</form>
		<button type="button" class="btn btn-success btn-sm mr-2">Tìm kiếm</button>
		<img style="height: 38px;width: 38px; border-radius: 50%; object-fit:cover;" src="https://phunugioi.com/wp-content/uploads/2020/01/anh-avatar-supreme-dep-lam-dai-dien-facebook-390x260.jpg"/>
	</div>
</nav>