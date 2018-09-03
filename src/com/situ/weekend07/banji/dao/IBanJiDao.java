package com.situ.weekend07.banji.dao;

import java.util.List;

import com.situ.weekend07.banji.entity.BanJi;

public interface IBanJiDao {

	public abstract int insert(BanJi banJi);

	public abstract int deleteById(Integer id);

	public abstract int update(BanJi banJi);

	public abstract List<BanJi> searchByName(String name);

	public abstract List<BanJi> list();

	public abstract BanJi SearchById(Integer id);

	public abstract int getTotalCount();

	public abstract List<BanJi> pageList(int offset, int pageSize);

	public abstract int deleteAll(String[] selectIds);
}
