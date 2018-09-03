package com.situ.student.dao;

import java.util.List;

import com.situ.student.entity.BanJi;

public interface IBanJiDao {
	/**
	 * 
	 * @param id
	 * @return
	 */
	int deleteById(Integer id);

	/**
	 * 
	 * @param name
	 * @return
	 */
	List<BanJi> searchByName(String name);

	/**
	 * 
	 * @param banJi
	 * @return
	 */
	int insert(BanJi banJi);

	/**
	 * 
	 * @param banJi
	 * @return
	 */
	int update(BanJi banJi);

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
	BanJi SearchById(Integer id);

	/**
	 * 
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	List<BanJi> pageList(int offset, int pageSize);

	/**
	 * 
	 * @param selectIds
	 * @return
	 */
	int deleteAll(String[] selectIds);

	/**
	 * 
	 * @return
	 */
	int getTotalCount();
}
