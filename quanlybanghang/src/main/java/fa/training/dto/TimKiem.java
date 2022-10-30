package fa.training.dto;

public class TimKiem {
	private String trangThaiDonHang;
	private String ngayHenTra;

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	public TimKiem() {
		super();
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	public TimKiem(String trangThaiDonHang, String ngayHenTra) {
		super();
		this.trangThaiDonHang = trangThaiDonHang;
		this.ngayHenTra = ngayHenTra;
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

	public boolean isEmpty() {
		return trangThaiDonHang.equals("") && ngayHenTra.equals("");
	}

}
