package fa.training.entites;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TTOrder {
	@Id
	private String maOrder;
	private String tenKH;
	private String maLoaiKH;
	private String soDienThoai;
	private String ngayOrder;
	private int soNguoiLon;
	private int soTreEm;
	private String gioVao;
	private int tienThanhToan;

	@ManyToOne
	@JoinColumn(name = "maLoaiKH", insertable = false, updatable = false)
	private LoaiKH loaiKH;

	public TTOrder() {
		super();
	}

	public TTOrder(String maOrder, String tenKH, String maLoaiKH, String soDienThoai, String ngayOrder, int soNguoiLon,
			int soTreEm, String gioVao, int tienThanhToan, LoaiKH loaiKH) {
		super();
		this.maOrder = maOrder;
		this.tenKH = tenKH;
		this.maLoaiKH = maLoaiKH;
		this.soDienThoai = soDienThoai;
		this.ngayOrder = ngayOrder;
		this.soNguoiLon = soNguoiLon;
		this.soTreEm = soTreEm;
		this.gioVao = gioVao;
		this.tienThanhToan = tienThanhToan;
		this.loaiKH = loaiKH;
	}

	public String getMaOrder() {
		return maOrder;
	}

	public void setMaOrder(String maOrder) {
		this.maOrder = maOrder;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getMaLoaiKH() {
		return maLoaiKH;
	}

	public void setMaLoaiKH(String maLoaiKH) {
		this.maLoaiKH = maLoaiKH;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getNgayOrder() {
		return ngayOrder;
	}

	public void setNgayOrder(String ngayOrder) {
		this.ngayOrder = ngayOrder;
	}

	public int getSoNguoiLon() {
		return soNguoiLon;
	}

	public void setSoNguoiLon(int soNguoiLon) {
		this.soNguoiLon = soNguoiLon;
	}

	public int getSoTreEm() {
		return soTreEm;
	}

	public void setSoTreEm(int soTreEm) {
		this.soTreEm = soTreEm;
	}

	public String getGioVao() {
		return gioVao;
	}

	public void setGioVao(String gioVao) {
		this.gioVao = gioVao;
	}

	public int getTienThanhToan() {
		return tienThanhToan;
	}

	public void setTienThanhToan(int tienThanhToan) {
		this.tienThanhToan = tienThanhToan;
	}

	public LoaiKH getLoaiKH() {
		return loaiKH;
	}

	public void setLoaiKH(LoaiKH loaiKH) {
		this.loaiKH = loaiKH;
	}

	@Override
	public String toString() {
		return "TTOrder [maOrder=" + maOrder + ", tenKH=" + tenKH + ", maLoaiKH=" + maLoaiKH + ", soDienThoai="
				+ soDienThoai + ", ngayOrder=" + ngayOrder + ", soNguoiLon=" + soNguoiLon + ", soTreEm=" + soTreEm
				+ ", gioVao=" + gioVao + ", tienThanhToan=" + tienThanhToan + ", loaiKH=" + loaiKH + "]";
	}

}
