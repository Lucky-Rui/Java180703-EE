package com.situ.student.dao;

import java.util.List;

import com.situ.student.entity.BanJi;

public interface IBanJiDao {

	int insert(BanJi banji);

	List<BanJi> list();

	int deleteById(Integer id);

	List<BanJi> findByName(String name);

	int updateBanJi(BanJi banJi);

	BanJi findById(Integer id);

	int getTotalCount();

	List<BanJi> pageList(int offset, int pageSize);

	int deleteAll(String[] selectIds);

}
