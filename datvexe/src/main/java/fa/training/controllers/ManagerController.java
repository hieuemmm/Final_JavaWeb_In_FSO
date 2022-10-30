package fa.training.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fa.training.dto.ChuaDuDienKien;
import fa.training.dto.DatVeXe;
import fa.training.entites.DatVe;
import fa.training.entites.KhachHang;
import fa.training.services.DatVeService_Impl;
import fa.training.services.IGeneralService;
import fa.training.utils.UUID_Util;

@Controller
public class ManagerController {
	@Autowired
	IGeneralService<KhachHang, String> khachHangService;
	@Autowired
	IGeneralService<DatVe, String> datVeService;

	@ModelAttribute("datVeXe")
	public DatVeXe getDatVeXeObject() {
		return new DatVeXe();
	}

	@ModelAttribute("khachHang")
	public KhachHang getKhachHangObject() {
		return new KhachHang();
	}

	@ModelAttribute("chuaDuDienKien")
	public ChuaDuDienKien getChuaDuDienKienObject() {
		return new ChuaDuDienKien();
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@GetMapping(value = "/")
	public String datvexe(Model model) {
		return list(model);
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@GetMapping("/list-error")
	public String listError(Model model) {
		System.out.println("Tôi ở đây");
		try {
			KhachHang khachHang = khachHangService.findById(null);
			System.out.println(khachHang);
			model.addAttribute("datVes", new ArrayList<DatVe>());
			return "datvexe/list";
		} catch (Exception e) {
			System.out.println("Tôi là error");
			return "error";
		}
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@GetMapping("/list")
	public String list(Model model) {
		List<DatVe> datVes = datVeService.findAll();
		model.addAttribute("datVes", datVes);
		return "datvexe/list";
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@GetMapping(value = "/add")
	public String add(Model model) {
		return "datvexe/add";
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@PostMapping(value = "/saveAdd")
	public String saveAdd(@ModelAttribute(name = "datVeXe") DatVeXe datVeXe, Model model) {
		KhachHang khachHang = new KhachHang(datVeXe.getcCCD(), datVeXe.getHoTen(), datVeXe.getNgaySinh(),
				datVeXe.getGioiTinh(), datVeXe.getSoDienThoai(), datVeXe.getTrangThaiTiem(),
				datVeXe.getKetQuaSetNghiem(), datVeXe.getNgaySetNghiem());
		Optional<KhachHang> khachHangDB = Optional.ofNullable(khachHangService.findById(khachHang.getcCCD()));
		if (khachHangDB.isPresent()) {
			khachHang = khachHangDB.get();
		} else {
			khachHang = khachHangService.save(khachHang);
		}
		DatVe datVe = new DatVe(UUID_Util.getNumber("DV", 7), datVeXe.getcCCD(), datVeXe.getNgayDatVe(),
				datVeXe.getBienSoXe(), datVeXe.getDiaDiemXuatPhat(), datVeXe.getDiaDiemDen(),
				datVeXe.getNgayXuatPhat());
		datVeService.save(datVe);
		model.addAttribute("messageSuccess", "Thêm thành công");
		return list(model);
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@GetMapping(value = "/chuaDuDienKien")
	public String filter(@ModelAttribute(name = "chuaDuDienKien") ChuaDuDienKien chuaDuDienKien, Model model) {
		if (chuaDuDienKien.isEmpty()) {
			model.addAttribute("datVes", datVeService.findAll());
			return "datvexe/list";
		}
		DatVeService_Impl datVeService_Impl = new DatVeService_Impl();
		List<DatVe> datVes = datVeService_Impl.findByChuaDuDieuKien(datVeService.findAll(), chuaDuDienKien);
		model.addAttribute("chuaDuDienKien", chuaDuDienKien);
		model.addAttribute("datVes", datVes);
		return "datvexe/list";
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@GetMapping(value = "/edit/{id}")
	public String edit(Model model, @PathVariable String id) {
		Optional<KhachHang> khachHang = Optional.ofNullable(khachHangService.findById(id));
		if (khachHang.isPresent()) {
			model.addAttribute("khachHang", khachHang.get());
			return "datvexe/edit";
		} else {
			System.out.println("Không tìm thấy");
		}
		return "datvexe/list";
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@PostMapping(value = "/saveEdit")
	public String saveEdit(@ModelAttribute(name = "khachHang") KhachHang editKhachHang, RedirectAttributes attributes) {
		System.out.println(editKhachHang);
		Optional<KhachHang> khachHang = Optional.ofNullable(khachHangService.findById(editKhachHang.getcCCD()));
		if (khachHang.isPresent()) {
			khachHang.get().setSoDienThoai(editKhachHang.getSoDienThoai());
			khachHang.get().setTrangThaiTiem(editKhachHang.getTrangThaiTiem());
			khachHang.get().setKetQuaSetNghiem(editKhachHang.getKetQuaSetNghiem());
			khachHang.get().setNgaySetNghiem(editKhachHang.getNgaySetNghiem());
			khachHangService.save(khachHang.get());

			attributes.addFlashAttribute("messageSuccess",
					"Sửa khách hàng " + khachHang.get().getcCCD() + " thành công");
			List<DatVe> datVes = datVeService.findAll();
			attributes.addFlashAttribute("datVes", datVes);
			return "redirect:/";
		}
		attributes.addFlashAttribute("messageError", "Id" + editKhachHang.getcCCD() + " không tìm thấy");
		return "redirect:/datvexe/edit/" + editKhachHang.getcCCD();
	}
}
