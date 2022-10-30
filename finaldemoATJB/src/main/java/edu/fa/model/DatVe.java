package edu.fa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DatVe {
	@Id
	private String MaDV;
	private String CCCD;
	private String NgayDatVe;
	private String BienSoXe;
	private String DiaDiemXuatPhat;
	private String DiaDiemDen;
	private String NgayXuatPhat;

	@ManyToOne
	@JoinColumn(name = "CCCD", insertable = false, updatable = false)
	private Khachhang khachHang;

	public DatVe() {
		super();
	}

	public String getMaDV() {
		return MaDV;
	}

	public void setMaDV(String maDV) {
		MaDV = maDV;
	}

	public String getCCCD() {
		return CCCD;
	}

	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}

	public String getNgayDatVe() {
		return NgayDatVe;
	}

	public void setNgayDatVe(String ngayDatVe) {
		NgayDatVe = ngayDatVe;
	}

	public String getBienSoXe() {
		return BienSoXe;
	}

	public void setBienSoXe(String bienSoXe) {
		BienSoXe = bienSoXe;
	}

	public String getDiaDiemXuatPhat() {
		return DiaDiemXuatPhat;
	}

	public void setDiaDiemXuatPhat(String diaDiemXuatPhat) {
		DiaDiemXuatPhat = diaDiemXuatPhat;
	}

	public String getDiaDiemDen() {
		return DiaDiemDen;
	}

	public void setDiaDiemDen(String diaDiemDen) {
		DiaDiemDen = diaDiemDen;
	}

	public String getNgayXuatPhat() {
		return NgayXuatPhat;
	}

	public void setNgayXuatPhat(String ngayXuatPhat) {
		NgayXuatPhat = ngayXuatPhat;
	}

	public DatVe(String maDV, String cCCD, String ngayDatVe, String bienSoXe, String diaDiemXuatPhat, String diaDiemDen,
			String ngayXuatPhat) {
		super();
		MaDV = maDV;
		CCCD = cCCD;
		NgayDatVe = ngayDatVe;
		BienSoXe = bienSoXe;
		DiaDiemXuatPhat = diaDiemXuatPhat;
		DiaDiemDen = diaDiemDen;
		NgayXuatPhat = ngayXuatPhat;
	}

}
