package com.situ.weekend07.banji.service;

import java.util.List;

import com.situ.weekend07.banji.entity.BanJi;
import com.situ.weekend07.banji.entity.BanJi_PageBean;

public interface IBanJiService {

	public abstract boolean insert(BanJi banJi);

	public abstract boolean deleteById(Integer id);

	public abstract boolean update(BanJi banJi);

	public abstract List<BanJi> searchByName(String name);

	public abstract List<BanJi> list();

	public abstract BanJi SearchById(Integer id);

	public abstract BanJi_PageBean getPageBean(int pageNo, int pageSize);

	public abstract boolean deleteAll(String[] selectIds);
}
