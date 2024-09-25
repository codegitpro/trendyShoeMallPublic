package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ZhenweijianbieDao;
import com.cl.entity.ZhenweijianbieEntity;
import com.cl.service.ZhenweijianbieService;
import com.cl.entity.view.ZhenweijianbieView;

@Service("zhenweijianbieService")
public class ZhenweijianbieServiceImpl extends ServiceImpl<ZhenweijianbieDao, ZhenweijianbieEntity> implements ZhenweijianbieService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhenweijianbieEntity> page = this.selectPage(
                new Query<ZhenweijianbieEntity>(params).getPage(),
                new EntityWrapper<ZhenweijianbieEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhenweijianbieEntity> wrapper) {
		  Page<ZhenweijianbieView> page =new Query<ZhenweijianbieView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZhenweijianbieView> selectListView(Wrapper<ZhenweijianbieEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhenweijianbieView selectView(Wrapper<ZhenweijianbieEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
