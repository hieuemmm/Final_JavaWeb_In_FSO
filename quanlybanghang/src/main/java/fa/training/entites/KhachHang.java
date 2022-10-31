package fa.training.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class KhachHang {
	@Id
	private String maKH;
	private String tenKH;
	private String gioiTinh;
	private String soDienThoai;

	@OneToMany(mappedBy = "maKH")
	private List<DonHang> donHangs = new ArrayList<DonHang>();

	/**
	 * @Authour : ThoPP
	 * @Birthday : 1992-08-26
	 */
	public KhachHang() {
		super();
	}

	/**
	 * @Authour : ThoPP
	 * @Birthday : 1992-08-26
	 */
	public KhachHang(String maKH, String tenKH, String gioiTinh, String soDienThoai, List<DonHang> donHangs) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.donHangs = donHangs;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
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

	public List<DonHang> getDonHangs() {
		return donHangs;
	}

	public void setDonHangs(List<DonHang> donHangs) {
		this.donHangs = donHangs;
	}

	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", gioiTinh=" + gioiTinh + ", soDienThoai="
				+ soDienThoai + ", donHangs=" + donHangs + "]";
	}

}
