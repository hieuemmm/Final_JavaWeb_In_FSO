package fa.training.dto;

import fa.training.utils.DateUtil;

public class ThongTinDatHang {
	private String maLoaiKH;
	private String tenLoaiKH;
	private int chiecKhau;
	private String maOrder;
	private String tenKH;
	private String soDienThoai;
	private String ngayOrder;
	private int soNguoiLon;
	private int soTreEm;
	private String gioVao;
	private int tienThanhToan;

	public ThongTinDatHang() {
		super();
	}

	public String getMaLoaiKH() {
		return maLoaiKH;
	}

	public void setMaLoaiKH(String maLoaiKH) {
		this.maLoaiKH = maLoaiKH;
	}

	public String getTenLoaiKH() {
		return tenLoaiKH;
	}

	public void setTenLoaiKH(String tenLoaiKH) {
		this.tenLoaiKH = tenLoaiKH;
	}

	public int getChiecKhau() {
		return chiecKhau;
	}

	public void setChiecKhau(int chiecKhau) {
		this.chiecKhau = chiecKhau;
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

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	public void tinhTienThanhToan() {
		int totalBuffet = 0, donGiaTreEm = 0, donGiaNguoiLon = 0;
		switch (DateUtil.toDayOfWeek(ngayOrder)) {
			case "T2":
			case "T3":
			case "T4":
			case "T5":
			case "T6":
				if (DateUtil.compareToTime("17:00", gioVao) > 0) {
					System.out.println("Người lớn: 150.000, Trẻ em: 120.000");
					donGiaNguoiLon = 150000;
					donGiaTreEm = 120000;
				} else {
					System.out.println("Người lớn: 200.000, Trẻ em: 150.000");
					donGiaNguoiLon = 200000;
					donGiaTreEm = 150000;
				}
				break;
			case "T7":
			case "CN":
				if (DateUtil.compareToTime("17:00", gioVao) > 0) {
					System.out.println("Người lớn: 200.000, Trẻ em: 150.000");
					donGiaNguoiLon = 200000;
					donGiaTreEm = 150000;
				} else {
					System.out.println("Người lớn: 250.000, Trẻ em: 200.000");
					donGiaNguoiLon = 250000;
					donGiaTreEm = 200000;
				}
				break;
			default:
				break;
		}
		totalBuffet = soNguoiLon * donGiaNguoiLon + soTreEm * donGiaTreEm;
		this.tienThanhToan = totalBuffet - totalBuffet * chiecKhau;
	}

	public ThongTinDatHang(String maLoaiKH, String tenLoaiKH, int chiecKhau, String maOrder, String tenKH,
			String soDienThoai, String ngayOrder, int soNguoiLon, int soTreEm, String gioVao, int tienThanhToan) {
		super();
		this.maLoaiKH = maLoaiKH;
		this.tenLoaiKH = tenLoaiKH;
		this.chiecKhau = chiecKhau;
		this.maOrder = maOrder;
		this.tenKH = tenKH;
		this.soDienThoai = soDienThoai;
		this.ngayOrder = ngayOrder;
		this.soNguoiLon = soNguoiLon;
		this.soTreEm = soTreEm;
		this.gioVao = gioVao;
		this.tienThanhToan = tienThanhToan;
	}

}
