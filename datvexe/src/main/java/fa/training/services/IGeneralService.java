package fa.training.services;

import java.util.List;

public interface IGeneralService<T,K> {
	List<T> findAll();
	List<T> findAllByKeyWord(String keyword);
	T findById(K id);
	T save(T t);
	boolean delete(K id);
}
