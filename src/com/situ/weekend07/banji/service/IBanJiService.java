package com.situ.weekend07.banji.service;

import java.util.List;

import com.situ.weekend07.banji.entity.BanJi;
import com.situ.weekend07.banji.entity.BanJi_PageBean;

public interface IBanJiService {
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
	public abstract boolean deleteById(Integer id);

	/**
	 * 
	 * @param banJi
	 * @return
	 */
	public abstract boolean insert(BanJi banJi);

	/**
	 * 
	 * @param banJi
	 * @return
	 */
	public abstract boolean update(BanJi banJi);

	/**
	 * 
	 * @param name
	 * @return
	 */
	public abstract List<BanJi> searchByName(String name);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public abstract BanJi SearchById(Integer id);

	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public abstract BanJi_PageBean getPageBean(int pageNo, int pageSize);

	/**
	 * 
	 * @param selectIds
	 * @return
	 */
	public abstract boolean deleteAll(String[] selectIds);
}
