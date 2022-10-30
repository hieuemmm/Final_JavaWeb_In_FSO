package fa.training.dto;

public class ThongTinDonHang {
	private String maKH;
	private String tenKH;
	private String gioiTinh;
	private String soDienThoai;
	private String maDH;
	private String ngayDatMay;
	private String trangThaiThanhToan;
	private String ngayTra;
	private String trangThaiDonHang;
	private String ngayHenTra;
	private String maCTDH;
	private String tenSP;
	private int soTien;
	private String ghiChu;

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	public ThongTinDonHang() {
		super();
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	public ThongTinDonHang(String maKH, String tenKH, String gioiTinh, String soDienThoai, String maDH,
			String ngayDatMay, String trangThaiThanhToan, String ngayTra, String trangThaiDonHang, String ngayHenTra,
			String maCTDH, String tenSP, int soTien, String ghiChu) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.maDH = maDH;
		this.ngayDatMay = ngayDatMay;
		this.trangThaiThanhToan = trangThaiThanhToan;
		this.ngayTra = ngayTra;
		this.trangThaiDonHang = trangThaiDonHang;
		this.ngayHenTra = ngayHenTra;
		this.maCTDH = maCTDH;
		this.tenSP = tenSP;
		this.soTien = soTien;
		this.ghiChu = ghiChu;
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

	public String getMaDH() {
		return maDH;
	}

	public void setMaDH(String maDH) {
		this.maDH = maDH;
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

	public String getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(String ngayTra) {
		this.ngayTra = ngayTra;
	}

	public String getTrangThaiDonHang() {
		return trangThaiDonHang;
	}

	public void setTrangThaiDonHang(String trangThaiDonHang) {
		this.trangThaiDonHang = trangThaiDonHang;
	}

	public String getNgayHenTra() {
		return ngayHenTra;
	}

	public void setNgayHenTra(String ngayHenTra) {
		this.ngayHenTra = ngayHenTra;
	}

	public String getMaCTDH() {
		return maCTDH;
	}

	public void setMaCTDH(String maCTDH) {
		this.maCTDH = maCTDH;
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

	@Override
	public String toString() {
		return "ThongTinDonHang [maKH=" + maKH + ", tenKH=" + tenKH + ", gioiTinh=" + gioiTinh + ", soDienThoai="
				+ soDienThoai + ", maDH=" + maDH + ", ngayDatMay=" + ngayDatMay + ", trangThaiThanhToan="
				+ trangThaiThanhToan + ", ngayTra=" + ngayTra + ", trangThaiDonHang=" + trangThaiDonHang
				+ ", ngayHenTra=" + ngayHenTra + ", maCTDH=" + maCTDH + ", tenSP=" + tenSP + ", soTien=" + soTien
				+ ", ghiChu=" + ghiChu + "]";
	}

}
