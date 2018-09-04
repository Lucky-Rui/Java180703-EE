package com.situ.student.service.impl;

import java.util.List;

import com.situ.student.dao.IBanJiDao;
import com.situ.student.dao.impl.BanJiDaoImpl;
import com.situ.student.entity.BanJi;
import com.situ.student.entity.PageBean;
import com.situ.student.service.IBanJiService;

public class BanJiServiceImpl implements IBanJiService{
private IBanJiDao banJiDao = new BanJiDaoImpl();
	
	public BanJi SearchById(Integer id) {
		return banJiDao.SearchById(id);
	}
	
	@Override
	public boolean insert(BanJi banJi) {
		int count = banJiDao.insert(banJi);
		return count == 1 ? true : false;
	}

	@Override
	public boolean deleteById(Integer id) {
		int count = banJiDao.deleteById(id);
		return count == 1 ? true : false;
	}

	@Override
	public boolean update(BanJi banJi) {
		int count = banJiDao.update(banJi);
		return count == 1 ? true : false;
	}

	@Override
	public List<BanJi> searchByName(String name) {
		List<BanJi> list = banJiDao.searchByName(name);
		return list;
	}

	@Override
	public List<BanJi> list() {
		List<BanJi> list = banJiDao.list();
		return list;
	}
	
	@Override
	public PageBean<BanJi> getPageBean(int pageNo, int pageSize) {
		PageBean<BanJi> pageBean = new PageBean<>();
		//当前页数
		pageBean.setPageNo(pageNo);
		//一页最多多少条记录
		pageBean.setPageSize(pageSize);
		//总记录数
		int totalCount = banJiDao.getTotalCount();
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
		List<BanJi> list = banJiDao.pageList(offset, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	public boolean deleteAll(String[] selectIds) {
		int count = banJiDao.deleteAll(selectIds);
		return count == selectIds.length ? true : false;
	}
}
