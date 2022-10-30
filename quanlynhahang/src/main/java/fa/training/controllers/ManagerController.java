package fa.training.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.training.dto.ThongTinDatHang;
import fa.training.entites.LoaiKH;
import fa.training.entites.TTOrder;
import fa.training.services.ILoaiKHService;
import fa.training.services.ITTOrderService;
import fa.training.utils.UUID_Util;

@Controller
public class ManagerController {
	@Autowired
	ITTOrderService ttOrderService;
	@Autowired
	ILoaiKHService loaiKHService;

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@ModelAttribute("thongTinDatHang")
	public ThongTinDatHang getThongTinDatHangObject() {
		return new ThongTinDatHang();
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@GetMapping(value = "/")
	public String defaultPage(Model model) {
		return list(model);
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@GetMapping("/list")
	public String list(Model model) {
		try {
			List<TTOrder> ttOrders = ttOrderService.findAll();
			System.out.println(ttOrders.size());
			model.addAttribute("ttOrders", ttOrders);
			return "thongtindathang/list";
		} catch (Exception e) {
			return "error";
		}
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@GetMapping("/list-error")
	public String listError(Model model) {
		try {
			throw new NullPointerException();
		} catch (NullPointerException e) {
			model.addAttribute("exception", "NullPointerException không mong muốn");
			return "error";
		}
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@GetMapping(value = "/add")
	public String add(Model model) {
		try {
			List<LoaiKH> loaiKHs = loaiKHService.findAll();
			model.addAttribute("loaiKHs", loaiKHs);
			return "thongtindathang/add";
		} catch (Exception e) {
			return "error";
		}
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@PostMapping(value = "/saveAdd")
	public String saveAdd(@ModelAttribute(name = "thongTinDatHang") ThongTinDatHang thongTinDatHang, Model model) {
		try {
			System.out.println(thongTinDatHang.getMaLoaiKH());
			String maLoaiKH = thongTinDatHang.getMaLoaiKH();
			// String maKH = "khong ton tai";//Giả lập maKH không tồn tại
			Optional<LoaiKH> loaiKH = Optional.ofNullable(loaiKHService.findById(maLoaiKH));
			// Truyền lại thongtindathang/add nếu validate thất bại
			List<LoaiKH> loaiKHs = loaiKHService.findAll();
			model.addAttribute("loaiKHs", loaiKHs);
			model.addAttribute("thongTinDatHang", thongTinDatHang);
			// Validate maLoaiKH
			if (!loaiKH.isPresent()) {
				model.addAttribute("messageErrorMaLoaiKH", "maLoaiKH khong ton tai trong he thong");
				System.out.println("Khong ton tai");
				return "thongtindathang/add";
			}
			// Validate thành công
			// Tạo TTOrder
			TTOrder ttOrder = new TTOrder();
			ttOrder.setMaOrder(UUID_Util.getNumber("CD", 5));
			ttOrder.setTenKH(thongTinDatHang.getTenKH());
			ttOrder.setMaLoaiKH(thongTinDatHang.getMaLoaiKH());
			ttOrder.setSoDienThoai(thongTinDatHang.getSoDienThoai());
			ttOrder.setNgayOrder(thongTinDatHang.getNgayOrder());
			ttOrder.setSoNguoiLon(thongTinDatHang.getSoNguoiLon());
			ttOrder.setSoTreEm(thongTinDatHang.getSoTreEm());
			ttOrder.setGioVao(thongTinDatHang.getGioVao());
			// tinhTienThanhToan
			thongTinDatHang.tinhTienThanhToan();
			ttOrder.setTienThanhToan(thongTinDatHang.getTienThanhToan());

			ttOrder.setLoaiKH(loaiKH.get());
			ttOrderService.save(ttOrder);
			model.addAttribute("messageSuccess", "Đặt hàng thành công");
			return list(model);
		} catch (Exception e) {
			model.addAttribute("exception", e.toString());
			return "error";
		}
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@GetMapping(value = "/edit/{maOrder}")
	public String edit(Model model, @PathVariable(name = "maOrder") String maOrder) {
		try {
			Optional<TTOrder> ttOrder = Optional.ofNullable(ttOrderService.findById(maOrder));
			if (ttOrder.isPresent()) {
				ThongTinDatHang thongTinDatHang = new ThongTinDatHang();
				thongTinDatHang.setMaOrder(ttOrder.get().getMaOrder());
				thongTinDatHang.setTenKH(ttOrder.get().getTenKH());
				thongTinDatHang.setMaLoaiKH(ttOrder.get().getMaLoaiKH());
				thongTinDatHang.setMaLoaiKH(ttOrder.get().getMaLoaiKH());
				thongTinDatHang.setTenLoaiKH(ttOrder.get().getLoaiKH().getTenLoaiKH());
				thongTinDatHang.setSoDienThoai(ttOrder.get().getSoDienThoai());
				thongTinDatHang.setNgayOrder(ttOrder.get().getNgayOrder());
				thongTinDatHang.setSoNguoiLon(ttOrder.get().getSoNguoiLon());
				thongTinDatHang.setSoTreEm(ttOrder.get().getSoTreEm());
				thongTinDatHang.setGioVao(ttOrder.get().getGioVao());
				// Combobox
				List<LoaiKH> loaiKHs = loaiKHService.findAll();
				model.addAttribute("loaiKHs", loaiKHs);

				model.addAttribute("thongTinDatHang", thongTinDatHang);
				return "thongtindathang/edit";
			}
		} catch (Exception e) {

		}
		return "error";
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@PostMapping(value = "/saveEdit")
	public String saveEdit(@ModelAttribute(name = "thongTinDatHang") ThongTinDatHang thongTinDatHang, Model model) {
		try {
			String maOrder = thongTinDatHang.getMaOrder();
			Optional<TTOrder> ttOrderDB = Optional.ofNullable(ttOrderService.findById(maOrder));
			if (ttOrderDB.isPresent()) {
				// Validate 1
				if (thongTinDatHang.getSoNguoiLon() + thongTinDatHang.getSoTreEm() < ttOrderDB.get().getSoNguoiLon()
						+ ttOrderDB.get().getSoTreEm()) {
					model.addAttribute("messageError", "soNguoiLon + soTreEm khong duoc nho hon ban dau");
					model.addAttribute("thongTinDonHang", thongTinDatHang);
					return "thongtindathang/edit";
				}
				ttOrderDB.get().setSoNguoiLon(thongTinDatHang.getSoNguoiLon());
				ttOrderDB.get().setSoTreEm(thongTinDatHang.getSoTreEm());
				ttOrderDB.get().setGioVao(thongTinDatHang.getGioVao());
				// tinh lai tien thanh toan
				thongTinDatHang.tinhTienThanhToan();
				ttOrderDB.get().setTienThanhToan(thongTinDatHang.getTienThanhToan());
				ttOrderService.save(ttOrderDB.get());
				model.addAttribute("messageSuccess", "Sửa đơn hàng " + maOrder + " thành công");
				return list(model);
			} else {
				model.addAttribute("messageError", "Ma khach hang khong ton tai trong he thong");
				model.addAttribute("thongTinDonHang", thongTinDatHang);
				return "thongtindathang/edit";
			}
		} catch (Exception e) {
			return "error";
		}
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@GetMapping("/search")
	public String search(@RequestParam String search, Model model) {
		if (!search.equals("")) {
			List<TTOrder> ttOrders = ttOrderService.findAllByTenKhachHang(search.trim());
			model.addAttribute("ttOrders", ttOrders);
			model.addAttribute("search", search);
			return "thongtindathang/list";
		}
		return list(model);
	}
}
