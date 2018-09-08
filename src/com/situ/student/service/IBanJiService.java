package com.situ.student.service;

import java.util.List;

import com.situ.student.entity.BanJi;
import com.situ.student.entity.PageBean;
import com.situ.student.entity.Student;

public interface IBanJiService {
	/**
	 * 插入banji信息
	 * 
	 * @param student
	 * @return 插入成功返回true，失败返回false
	 */
	boolean insert(BanJi banJi);

	/**
	 * 返回所有baji的集合
	 * 
	 * @return
	 */
	List<BanJi> list();

	/**
	 * 根据id删除
	 * 
	 * @param id
	 * @return 删除成功返回true 失败返回false
	 */
	boolean deleteById(Integer id);

	/**
	 * 根据名字查找banji信息
	 * 
	 * @param name
	 * @return
	 */
	List<BanJi> findByName(String name);

	/**
	 * 修改banji信息
	 * 
	 * @param student
	 */
	boolean updateBanJi(BanJi banJi);

	/**
	 * 修改时用于查找banji信息来展示
	 * 
	 * @param id
	 * @return
	 */
	BanJi findById(Integer id);

	/**
	 * 通过pageNo和pageSize封住成PageBean对象
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	PageBean getPageBean(int pageNo, int pageSize);

	/**
	 * 批量删除
	 * 
	 * @param selectIds
	 * @return
	 */
	boolean deleteAll(String[] selectIds);

	boolean checkName(String name);
}
