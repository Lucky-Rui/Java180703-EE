package com.situ.weekend07.banji.service.impl;

import java.util.List;

import com.situ.weekend07.banji.dao.IBanJiDao;
import com.situ.weekend07.banji.dao.impl.BanJiDaoJdbcImpl;
import com.situ.weekend07.banji.entity.BanJi;
import com.situ.weekend07.banji.entity.BanJi_PageBean;
import com.situ.weekend07.banji.service.IBanJiService;

public class BanJiServiceImpl implements IBanJiService{
private IBanJiDao iBanJiDao = new BanJiDaoJdbcImpl();
	
	public BanJi SearchById(Integer id) {
		return iBanJiDao.SearchById(id);
	}
	
	@Override
	public boolean insert(BanJi banJi) {
		int count = iBanJiDao.insert(banJi);
		return count == 1 ? true : false;
	}

	@Override
	public boolean deleteById(Integer id) {
		int count = iBanJiDao.deleteById(id);
		return count == 1 ? true : false;
	}

	@Override
	public boolean update(BanJi banJi) {
		int count = iBanJiDao.update(banJi);
		return count == 1 ? true : false;
	}

	@Override
	public List<BanJi> searchByName(String name) {
		List<BanJi> list = iBanJiDao.searchByName(name);
		return list;
	}

	@Override
	public List<BanJi> list() {
		List<BanJi> list = iBanJiDao.list();
		return list;
	}
	
	@Override
	public BanJi_PageBean getPageBean(int pageNo, int pageSize) {
		BanJi_PageBean pageBean = new BanJi_PageBean();
		//当前页数
		pageBean.setPageNo(pageNo);
		//一页最多多少条记录
		pageBean.setPageSize(pageSize);
		//总记录数
		int totalCount = iBanJiDao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		//总页数
		//总数量   每页数量    总页数
		// 10     3      4       10/3=3...1
		// 11     3      4       10/3=3...2
		// 12     3      4       10/3=4
		// 13     3      5       10/3=4...1
		int totalPage = (int)Math.ceil((double)totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		//每页的记录
		int offset = (pageNo - 1) * pageSize;
		List<BanJi> list = iBanJiDao.pageList(offset, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	public boolean deleteAll(String[] selectIds) {
		int count = iBanJiDao.deleteAll(selectIds);
		return count == selectIds.length ? true : false;
	}
}
