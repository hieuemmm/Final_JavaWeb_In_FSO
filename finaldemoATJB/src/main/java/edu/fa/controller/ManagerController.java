package edu.fa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.fa.model.Formregister;
import edu.fa.model.Khachhang;
import edu.fa.service.DatveService;
import edu.fa.service.KhachhangService;

@Controller
public class ManagerController {
	@Autowired
	KhachhangService khachhangService; 
	@Autowired
	DatveService datveService;
	@GetMapping("showaddrigester")
	public String showaddRigester(Model model) {
                model.addAttribute("formregister", new Formregister());
		return "themdangkyxe";
	}
	
	@PostMapping("insertregister")
	public String insertRegister(@ModelAttribute("formregister") Formregister formregister , Model model) {
		
				khachhangService.insertComputer(formregister);
				datveService.insertDatve(formregister);
				return "redirect:/showaddrigester";
                           }
		
	@GetMapping("showlistregister")
	public String showlistRegister(Model model) {
		List<Khachhang> listdngkys = khachhangService.findAll();
		model.addAttribute("listdangkys",  listdngkys);
		System.out.println(listdngkys);
		return "listdangky";
	}  
	
	@GetMapping("searchregister")
	public String searchRegister(Model model, @RequestParam String search) {
		List<Khachhang> listdangkys= khachhangService.selectSearch(search);
		model.addAttribute("listdangkys", listdangkys);
	        System.out.println(listdangkys);
	        
		return "listdangky";
	}
	
	@GetMapping("showupdate/{id}")
	public String updateRegister(@PathVariable("id") String id, Model model) {
		Khachhang khachhang = khachhangService.selectByid(id);
		model.addAttribute("khachhang", khachhang);
		return "suadangky";
	}
	 @PostMapping(value = "update")
		public String editRegister(@ModelAttribute("khachhang") Khachhang khachhang) {
		
			khachhangService.insertRegister(khachhang);
			return "redirect:/showlistregister";
		}
}
