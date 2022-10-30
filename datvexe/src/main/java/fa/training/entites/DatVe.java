package fa.training.entites;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DatVe {
	@Id
	private String maDV;
	private String cCCD;
	private String ngayDatVe;
	private String bienSoXe;
	private String diaDiemXuatPhat;
	private String diaDiemDen;
	private String ngayXuatPhat;

	@ManyToOne
	@JoinColumn(name = "cCCD", insertable = false, updatable = false)
	private KhachHang khachHang;

	public DatVe() {
		super();
	}

	public DatVe(String maDV, String cCCD, String ngayDatVe, String bienSoXe, String diaDiemXuatPhat, String diaDiemDen,
			String ngayXuatPhat, KhachHang khachHang) {
		super();
		this.maDV = maDV;
		this.cCCD = cCCD;
		this.ngayDatVe = ngayDatVe;
		this.bienSoXe = bienSoXe;
		this.diaDiemXuatPhat = diaDiemXuatPhat;
		this.diaDiemDen = diaDiemDen;
		this.ngayXuatPhat = ngayXuatPhat;
		this.khachHang = khachHang;
	}

	public DatVe(String maDV, String cCCD, String ngayDatVe, String bienSoXe, String diaDiemXuatPhat, String diaDiemDen,
			String ngayXuatPhat) {
		super();
		this.maDV = maDV;
		this.cCCD = cCCD;
		this.ngayDatVe = ngayDatVe;
		this.bienSoXe = bienSoXe;
		this.diaDiemXuatPhat = diaDiemXuatPhat;
		this.diaDiemDen = diaDiemDen;
		this.ngayXuatPhat = ngayXuatPhat;
	}

	public String getMaDV() {
		return maDV;
	}

	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}

	public String getcCCD() {
		return cCCD;
	}

	public void setcCCD(String cCCD) {
		this.cCCD = cCCD;
	}

	public String getNgayDatVe() {
		return ngayDatVe;
	}

	public void setNgayDatVe(String ngayDatVe) {
		this.ngayDatVe = ngayDatVe;
	}

	public String getBienSoXe() {
		return bienSoXe;
	}

	public void setBienSoXe(String bienSoXe) {
		this.bienSoXe = bienSoXe;
	}

	public String getDiaDiemXuatPhat() {
		return diaDiemXuatPhat;
	}

	public void setDiaDiemXuatPhat(String diaDiemXuatPhat) {
		this.diaDiemXuatPhat = diaDiemXuatPhat;
	}

	public String getDiaDiemDen() {
		return diaDiemDen;
	}

	public void setDiaDiemDen(String diaDiemDen) {
		this.diaDiemDen = diaDiemDen;
	}

	public String getNgayXuatPhat() {
		return ngayXuatPhat;
	}

	public void setNgayXuatPhat(String ngayXuatPhat) {
		this.ngayXuatPhat = ngayXuatPhat;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	@Override
	public String toString() {
		return "DatVe [maDV=" + maDV + ", cCCD=" + cCCD + ", ngayDatVe=" + ngayDatVe + ", bienSoXe=" + bienSoXe
				+ ", diaDiemXuatPhat=" + diaDiemXuatPhat + ", diaDiemDen=" + diaDiemDen + ", ngayXuatPhat="
				+ ngayXuatPhat + "]";
	}
}
