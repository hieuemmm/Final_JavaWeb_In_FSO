package fa.training.entites;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ChiTietDonHang {
	@Id
	private String maCTDH;
	private String maDH;
	private String tenSP;
	private int soTien;
	private String ghiChu;

	@ManyToOne
	@JoinColumn(name = "maDH", insertable = false, updatable = false)
	private DonHang donHang;

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	public ChiTietDonHang() {
		super();
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	public ChiTietDonHang(String maCTDH, String maDH, String tenSP, int soTien, String ghiChu, DonHang donHang) {
		super();
		this.maCTDH = maCTDH;
		this.maDH = maDH;
		this.tenSP = tenSP;
		this.soTien = soTien;
		this.ghiChu = ghiChu;
		this.donHang = donHang;
	}

	public String getMaCTDH() {
		return maCTDH;
	}

	public void setMaCTDH(String maCTDH) {
		this.maCTDH = maCTDH;
	}

	public String getMaDH() {
		return maDH;
	}

	public void setMaDH(String maDH) {
		this.maDH = maDH;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public int getSoTien() {
		return soTien;
	}

	public void setSoTien(int soTien) {
		this.soTien = soTien;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public DonHang getDonHang() {
		return donHang;
	}

	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}

	@Override
	public String toString() {
		return "ChiTietDonHang [maCTDH=" + maCTDH + ", maDH=" + maDH + ", tenSP=" + tenSP + ", soTien=" + soTien
				+ ", ghiChu=" + ghiChu + ", donHang=" + donHang + "]";
	}

}
