package edu.fa.service;

import java.util.List;

import edu.fa.model.Formregister;
import edu.fa.model.Khachhang;

public interface KhachhangService {

	void insertComputer(Formregister formregister);

	List<Khachhang> findAll();

	List<Khachhang> selectSearch(String search);

	Khachhang selectByid(String id);

	void insertRegister(Khachhang khachhang);

}
