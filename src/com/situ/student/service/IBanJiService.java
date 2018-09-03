package com.situ.student.service;

import java.util.List;

import com.situ.student.entity.BanJi;
import com.situ.student.entity.BanJi_PageBean;

public interface IBanJiService {
	/**
	 * 
	 * @return
	 */
	List<BanJi> list();

	/**
	 * 
	 * @param id
	 * @return
	 */
	boolean deleteById(Integer id);

	/**
	 * 
	 * @param banJi
	 * @return
	 */
	boolean insert(BanJi banJi);

	/**
	 * 
	 * @param banJi
	 * @return
	 */
	boolean update(BanJi banJi);

	/**
	 * 
	 * @param name
	 * @return
	 */
	List<BanJi> searchByName(String name);

	/**
	 * 
	 * @param id
	 * @return
	 */
	BanJi SearchById(Integer id);

	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	BanJi_PageBean getPageBean(int pageNo, int pageSize);

	/**
	 * 
	 * @param selectIds
	 * @return
	 */
	boolean deleteAll(String[] selectIds);
}
