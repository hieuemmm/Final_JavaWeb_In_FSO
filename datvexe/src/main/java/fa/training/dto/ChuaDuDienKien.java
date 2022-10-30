/**
 * 
 */
package fa.training.dto;

public class ChuaDuDienKien {
	private String trangThaiTiem;
	private String ketQuaSetNghiem;
	
	public ChuaDuDienKien() {
		super();
	}
	
	public ChuaDuDienKien(String trangThaiTiem, String ketQuaSetNghiem) {
		super();
		this.trangThaiTiem = trangThaiTiem;
		this.ketQuaSetNghiem = ketQuaSetNghiem;
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
	public boolean isEmpty() {
		return ketQuaSetNghiem.equals("") && trangThaiTiem.equals("");
	}
}
