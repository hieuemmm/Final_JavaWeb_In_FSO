package fa.training.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class LoaiKH {
	@Id
	private String maLoaiKH;
	private String tenLoaiKH;
	private int chiecKhau;

	@OneToMany(mappedBy = "maLoaiKH")
	private List<TTOrder> ttOrders = new ArrayList<TTOrder>();

	public LoaiKH() {
		super();
	}

	public LoaiKH(String maLoaiKH, String tenLoaiKH, int chiecKhau, List<TTOrder> ttOrders) {
		super();
		this.maLoaiKH = maLoaiKH;
		this.tenLoaiKH = tenLoaiKH;
		this.chiecKhau = chiecKhau;
		this.ttOrders = ttOrders;
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

	public List<TTOrder> getTtOrders() {
		return ttOrders;
	}

	public void setTtOrders(List<TTOrder> ttOrders) {
		this.ttOrders = ttOrders;
	}

	@Override
	public String toString() {
		return "LoaiKH [maLoaiKH=" + maLoaiKH + ", tenLoaiKH=" + tenLoaiKH + ", chiecKhau=" + chiecKhau + ", ttOrders="
				+ ttOrders + "]";
	}

}
