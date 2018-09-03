package com.situ.weekend07.banji.dao;

import java.util.List;

import com.situ.weekend07.banji.entity.BanJi;

public interface IBanJiDao {
	/**
	 * 
	 * @param id
	 * @return
	 */
	public abstract int deleteById(Integer id);

	/**
	 * 
	 * @param name
	 * @return
	 */
	public abstract List<BanJi> searchByName(String name);

	/**
	 * 
	 * @param banJi
	 * @return
	 */
	public abstract int insert(BanJi banJi);

	/**
	 * 
	 * @param banJi
	 * @return
	 */
	public abstract int update(BanJi banJi);

	/**
	 * 
	 * @return
	 */
	public abstract List<BanJi> list();

	/**
	 * 
	 * @param id
	 * @return
	 */
	public abstract BanJi SearchById(Integer id);

	/**
	 * 
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public abstract List<BanJi> pageList(int offset, int pageSize);

	/**
	 * 
	 * @param selectIds
	 * @return
	 */
	public abstract int deleteAll(String[] selectIds);

	/**
	 * 
	 * @return
	 */
	public abstract int getTotalCount();
}
