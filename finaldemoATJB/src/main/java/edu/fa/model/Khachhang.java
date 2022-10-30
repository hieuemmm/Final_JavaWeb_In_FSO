package edu.fa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Khachhang {
	@Id
	private String CCCD;
	private String HoTen;
	private String NgaySinh;
	private String GioiTinh;
	private String SoDienThoai;
	private String TrangThaiTiem;
	private String KetQuaSetNghiem;
	private String NgaySetNghiem;
	
	@OneToMany(mappedBy = "khachHang")
	private List<DatVe> datVes = new ArrayList<DatVe>();
	public String getCCCD() {
		return CCCD;
	}
	public Khachhang(String cCCD, String hoTen, String ngaySinh, String gioiTinh, String soDienThoai,
			String trangThaiTiem, String ketQuaSetNghiem, String ngaySetNghiem) {
		super();
		CCCD = cCCD;
		HoTen = hoTen;
		NgaySinh = ngaySinh;
		GioiTinh = gioiTinh;
		SoDienThoai = soDienThoai;
		TrangThaiTiem = trangThaiTiem;
		KetQuaSetNghiem = ketQuaSetNghiem;
		NgaySetNghiem = ngaySetNghiem;
	}
	public Khachhang() {
		super();
	}
	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getSoDienThoai() {
		return SoDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}
	public String getTrangThaiTiem() {
		return TrangThaiTiem;
	}
	public void setTrangThaiTiem(String trangThaiTiem) {
		TrangThaiTiem = trangThaiTiem;
	}
	public String getKetQuaSetNghiem() {
		return KetQuaSetNghiem;
	}
	public void setKetQuaSetNghiem(String ketQuaSetNghiem) {
		KetQuaSetNghiem = ketQuaSetNghiem;
	}
	public String getNgaySetNghiem() {
		return NgaySetNghiem;
	}
	public void setNgaySetNghiem(String ngaySetNghiem) {
		NgaySetNghiem = ngaySetNghiem;
	}
}
