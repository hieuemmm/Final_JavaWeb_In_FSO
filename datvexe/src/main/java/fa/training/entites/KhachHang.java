package fa.training.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import fa.training.dto.ChuaDuDienKien;

@Entity
public class KhachHang {
	@Id
	private String cCCD;
	private String hoTen;
	private String ngaySinh;
	private String gioiTinh;
	private String soDienThoai;
	private String trangThaiTiem;
	private String ketQuaSetNghiem;
	private String ngaySetNghiem;

	@OneToMany(mappedBy = "khachHang")
	private List<DatVe> datVes = new ArrayList<DatVe>();

	public KhachHang() {
		super();
	}

	public KhachHang(String cCCD, String hoTen, String ngaySinh, String gioiTinh, String soDienThoai,
			String trangThaiTiem, String ketQuaSetNghiem, String ngaySetNghiem) {
		super();
		this.cCCD = cCCD;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.trangThaiTiem = trangThaiTiem;
		this.ketQuaSetNghiem = ketQuaSetNghiem;
		this.ngaySetNghiem = ngaySetNghiem;
	}

	public String getcCCD() {
		return cCCD;
	}

	public void setcCCD(String cCCD) {
		this.cCCD = cCCD;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getTrangThaiTiem() {
		return trangThaiTiem;
	}

	public void setTrangThaiTiem(String trangThaiTiem) {
		this.trangThaiTiem = trangThaiTiem;
	}

	public String getKetQuaSetNghiem() {
		return ketQuaSetNghiem;
	}

	public void setKetQuaSetNghiem(String ketQuaSetNghiem) {
		this.ketQuaSetNghiem = ketQuaSetNghiem;
	}

	public String getNgaySetNghiem() {
		return ngaySetNghiem;
	}

	public void setNgaySetNghiem(String ngaySetNghiem) {
		this.ngaySetNghiem = ngaySetNghiem;
	}

	public List<DatVe> getDatVes() {
		return datVes;
	}

	public void setDatVes(List<DatVe> datVes) {
		this.datVes = datVes;
	}

	public boolean isChuaDuDieuKien(ChuaDuDienKien chuaDuDienKien) {
		if (trangThaiTiem.equals(chuaDuDienKien.getTrangThaiTiem())
				&& ketQuaSetNghiem.equals(chuaDuDienKien.getKetQuaSetNghiem()))
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "KhachHang [cCCD=" + cCCD + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh
				+ ", soDienThoai=" + soDienThoai + ", trangThaiTiem=" + trangThaiTiem + ", ketQuaSetNghiem="
				+ ketQuaSetNghiem + ", ngaySetNghiem=" + ngaySetNghiem + ", datVes=" + datVes + "]";
	}
}
