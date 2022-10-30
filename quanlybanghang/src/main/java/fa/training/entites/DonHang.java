package fa.training.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import fa.training.dto.TimKiem;

@Entity
public class DonHang {
	@Id
	private String maDH;
	private String maKH;
	private String ngayDatMay;
	private String trangThaiThanhToan;
	private String ngayHenTra;
	private String trangThaiDonHang;
	private String ngayTra;

	@ManyToOne
	@JoinColumn(name = "maKH", insertable = false, updatable = false)
	private KhachHang khachHang;

	@OneToMany(mappedBy = "maDH")
	private List<ChiTietDonHang> chiTietDonHangs = new ArrayList<ChiTietDonHang>();

	public String getMaDH() {
		return maDH;
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	public DonHang() {
		super();
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	public DonHang(String maDH, String maKH, String ngayDatMay, String trangThaiThanhToan, String ngayHenTra,
			String trangThaiDonHang, String ngayTra, KhachHang khachHang, List<ChiTietDonHang> chiTietDonHangs) {
		super();
		this.maDH = maDH;
		this.maKH = maKH;
		this.ngayDatMay = ngayDatMay;
		this.trangThaiThanhToan = trangThaiThanhToan;
		this.ngayHenTra = ngayHenTra;
		this.trangThaiDonHang = trangThaiDonHang;
		this.ngayTra = ngayTra;
		this.khachHang = khachHang;
		this.chiTietDonHangs = chiTietDonHangs;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getNgayDatMay() {
		return ngayDatMay;
	}

	public void setNgayDatMay(String ngayDatMay) {
		this.ngayDatMay = ngayDatMay;
	}

	public String getTrangThaiThanhToan() {
		return trangThaiThanhToan;
	}

	public void setTrangThaiThanhToan(String trangThaiThanhToan) {
		this.trangThaiThanhToan = trangThaiThanhToan;
	}

	public String getNgayHenTra() {
		return ngayHenTra;
	}

	public void setNgayHenTra(String ngayHenTra) {
		this.ngayHenTra = ngayHenTra;
	}

	public String getTrangThaiDonHang() {
		return trangThaiDonHang;
	}

	public void setTrangThaiDonHang(String trangThaiDonHang) {
		this.trangThaiDonHang = trangThaiDonHang;
	}

	public String getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(String ngayTra) {
		this.ngayTra = ngayTra;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public List<ChiTietDonHang> getChiTietDonHangs() {
		return chiTietDonHangs;
	}

	public void setChiTietDonHangs(List<ChiTietDonHang> chiTietDonHangs) {
		this.chiTietDonHangs = chiTietDonHangs;
	}

	public void setMaDH(String maDH) {
		this.maDH = maDH;
	}

	public boolean isTimKiem(TimKiem timKiem) {
		if (timKiem.getTrangThaiDonHang().equals(trangThaiDonHang)
				&& timKiem.getNgayHenTra().equals(timKiem.getNgayHenTra())) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "DonHang [maDH=" + maDH + ", maKH=" + maKH + ", ngayDatMay=" + ngayDatMay + ", trangThaiThanhToan="
				+ trangThaiThanhToan + ", ngayHenTra=" + ngayHenTra + ", trangThaiDonHang=" + trangThaiDonHang
				+ ", ngayTra=" + ngayTra + ", khachHang=" + khachHang + ", chiTietDonHangs=" + chiTietDonHangs + "]";
	}
}
