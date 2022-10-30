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

import fa.training.dto.ThongTinDonHang;
import fa.training.dto.TimKiem;
import fa.training.entites.ChiTietDonHang;
import fa.training.entites.DonHang;
import fa.training.entites.KhachHang;
import fa.training.services.IChiTietDonHangService;
import fa.training.services.IDonHangService;
import fa.training.services.IKhachHangService;
import fa.training.utils.UUID_Util;

@Controller
public class ManagerController {
	@Autowired
	IChiTietDonHangService chiTietDonHangService;
	@Autowired
	IDonHangService donHangService;
	@Autowired
	IKhachHangService khachHangService;

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@ModelAttribute("thongTinDonHang")
	public ThongTinDonHang getThongTinDonHangObject() {
		return new ThongTinDonHang();
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@ModelAttribute("timKiem")
	public TimKiem getTimKiemObject() {
		return new TimKiem();
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
			List<DonHang> donHangs = donHangService.findAll();
			System.out.println(donHangs.size());
			model.addAttribute("donHangs", donHangs);
			return "thongtindonhang/list";
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
			List<DonHang> donHangs = donHangService.findAll();
			System.out.println(donHangs.size());
			model.addAttribute("donHangs", donHangs);
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
	@GetMapping("/detail/{maDH}")
	public String detail(Model model, @PathVariable(name = "maDH") String maDH) {
		try {
			DonHang donHang = donHangService.findById(maDH);
			model.addAttribute("chiTietDonHangs", donHang.getChiTietDonHangs());
			return "thongtindonhang/detail";
		} catch (Exception e) {
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
			List<KhachHang> khachHangs = khachHangService.findAll();
			model.addAttribute("khachHangs", khachHangs);
			return "thongtindonhang/add";
		} catch (Exception e) {
			return "error";
		}
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@PostMapping(value = "/saveAdd")
	public String saveAdd(@ModelAttribute(name = "thongTinDonHang") ThongTinDonHang thongTinDonHang, Model model) {
		try {
			System.out.println(thongTinDonHang.getMaKH());
			String maKH = thongTinDonHang.getMaKH();
			// String maKH = "khong ton tai";//Giả lập maKH không tồn tại
			Optional<KhachHang> khachHang = Optional.ofNullable(khachHangService.findById(maKH));
			// Truyền lại thongtindonhang/add nếu validate thất bại
			List<KhachHang> khachHangs = khachHangService.findAll();
			model.addAttribute("khachHangs", khachHangs);
			model.addAttribute("thongTinDonHang", thongTinDonHang);
			// Validate MaKH
			if (!khachHang.isPresent()) {
				model.addAttribute("messageErrorMaKH", "Ma khach hang khong ton tai trong he thong");
				System.out.println("Khong ton tai");
				return "thongtindonhang/add";
			}
			// Validate soTien tối thiểu
			String tenSP = thongTinDonHang.getTenSP();
			int soTien = thongTinDonHang.getSoTien();
			if (tenSP.startsWith("Ao")) {
				if (soTien < 100000) {
					model.addAttribute("messageErrorSoTien", "So tien khong hop le");
					return "thongtindonhang/add";
				}
			}
			if (tenSP.startsWith("Quan") || tenSP.startsWith("Chan vay")) {
				if (soTien < 150000) {
					model.addAttribute("messageErrorSoTien", "So tien khong hop le");
					return "thongtindonhang/add";
				}
			}
			// Validate thành công
			// Tạo đơn hàng
			DonHang donHang = new DonHang();
			donHang.setMaDH(UUID_Util.getNumber("DH", 7));
			donHang.setMaKH(thongTinDonHang.getMaKH());
			donHang.setNgayDatMay(thongTinDonHang.getNgayDatMay());
			donHang.setTrangThaiThanhToan(thongTinDonHang.getTrangThaiThanhToan());
			donHang.setNgayTra(thongTinDonHang.getNgayTra());
			donHang.setTrangThaiDonHang(thongTinDonHang.getTrangThaiDonHang());
			donHang.setNgayHenTra(thongTinDonHang.getNgayHenTra());
			donHang.setKhachHang(khachHang.get());
			donHang = donHangService.add(donHang);
			System.out.println("donHang thành công");
			// Tạo chi tiết đơn hàng
			ChiTietDonHang chiTietDonHang = new ChiTietDonHang();
			chiTietDonHang.setMaCTDH(UUID_Util.getNumber("CTDH", 5));
			chiTietDonHang.setMaDH(donHang.getMaDH());
			chiTietDonHang.setTenSP(thongTinDonHang.getTenSP());
			chiTietDonHang.setSoTien(thongTinDonHang.getSoTien());
			chiTietDonHang.setGhiChu(thongTinDonHang.getGhiChu());
			chiTietDonHang = chiTietDonHangService.add(chiTietDonHang);
			model.addAttribute("messageSuccess", "Tạo đơn hàng thành công");
			System.out.println("chiTietDonHang thành công");
			return list(model);
		} catch (Exception e) {
			return "error";
		}
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@GetMapping(value = "/edit/{maDH}")
	public String edit(Model model, @PathVariable(name = "maDH") String maDH) {
		try {
			DonHang donHang = donHangService.findById(maDH);
			ThongTinDonHang thongTinDonHang = new ThongTinDonHang();
			thongTinDonHang.setMaDH(donHang.getMaDH());
			thongTinDonHang.setMaKH(donHang.getMaKH());
			thongTinDonHang.setNgayDatMay(donHang.getNgayDatMay());
			thongTinDonHang.setTrangThaiThanhToan(donHang.getTrangThaiThanhToan());
			thongTinDonHang.setNgayHenTra(donHang.getNgayHenTra());
			thongTinDonHang.setTrangThaiDonHang(donHang.getTrangThaiDonHang());
			thongTinDonHang.setNgayTra(donHang.getNgayTra());
			thongTinDonHang.setMaCTDH(donHang.getChiTietDonHangs().get(0).getMaCTDH());
			thongTinDonHang.setTenSP(donHang.getChiTietDonHangs().get(0).getTenSP());
			thongTinDonHang.setSoTien(donHang.getChiTietDonHangs().get(0).getSoTien());
			thongTinDonHang.setGhiChu(donHang.getChiTietDonHangs().get(0).getGhiChu());
			// Combobox
			List<KhachHang> khachHangs = khachHangService.findAll();
			model.addAttribute("khachHangs", khachHangs);

			model.addAttribute("thongTinDonHang", thongTinDonHang);
			return "thongtindonhang/edit";
		} catch (Exception e) {
			return "error";
		}
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@PostMapping(value = "/saveEdit")
	public String saveEdit(@ModelAttribute(name = "thongTinDonHang") ThongTinDonHang thongTinDonHang, Model model) {
		try {
			String maKH = thongTinDonHang.getMaKH();
			Optional<KhachHang> khachHang = Optional.ofNullable(khachHangService.findById(maKH));
			if (khachHang.isPresent()) {
				DonHang donHang = new DonHang();
				donHang.setMaDH(thongTinDonHang.getMaDH());
				donHang.setMaKH(thongTinDonHang.getMaKH());
				donHang.setNgayDatMay(thongTinDonHang.getNgayDatMay());
				donHang.setTrangThaiThanhToan(thongTinDonHang.getTrangThaiThanhToan());
				donHang.setNgayTra(thongTinDonHang.getNgayTra());
				donHang.setTrangThaiDonHang(thongTinDonHang.getTrangThaiDonHang());
				donHang.setNgayHenTra(thongTinDonHang.getNgayHenTra());
				donHang.setKhachHang(khachHang.get());
				donHang = donHangService.add(donHang);

				ChiTietDonHang chiTietDonHang = new ChiTietDonHang();
				chiTietDonHang.setMaCTDH(thongTinDonHang.getMaCTDH());
				chiTietDonHang.setMaDH(donHang.getMaDH());
				chiTietDonHang.setTenSP(thongTinDonHang.getTenSP());
				chiTietDonHang.setSoTien(thongTinDonHang.getSoTien());
				chiTietDonHang.setGhiChu(thongTinDonHang.getGhiChu());
				chiTietDonHang = chiTietDonHangService.add(chiTietDonHang);
				model.addAttribute("messageSuccess", "Sửa đơn hàng thành công");
				return list(model);
			} else {
				model.addAttribute("messageError", "Ma khach hang khong ton tai trong he thong");
				model.addAttribute("thongTinDonHang", thongTinDonHang);
				return "thongtindonhang/edit";
			}
		} catch (Exception e) {
			return "error";
		}
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@GetMapping(value = "/search")
	public String filter(@ModelAttribute(name = "timKiem") TimKiem timKiem, Model model) {
		try {
			if (timKiem.isEmpty()) {
				return list(model);
			}
			List<DonHang> donHangs = donHangService.findAllByTimKiem(timKiem);
			model.addAttribute("timKiem", timKiem);
			model.addAttribute("donHangs", donHangs);
			return "thongtindonhang/list";
		} catch (Exception e) {
			return "error";
		}
	}
}
