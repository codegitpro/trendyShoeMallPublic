package com.cl.dao;

import com.cl.entity.ZhenweijianbieEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhenweijianbieView;


/**
 * 真伪鉴别
 * 
 * @author 
 * @email 
 * @date 2024-03-13 20:38:09
 */
public interface ZhenweijianbieDao extends BaseMapper<ZhenweijianbieEntity> {
	
	List<ZhenweijianbieView> selectListView(@Param("ew") Wrapper<ZhenweijianbieEntity> wrapper);

	List<ZhenweijianbieView> selectListView(Pagination page,@Param("ew") Wrapper<ZhenweijianbieEntity> wrapper);
	
	ZhenweijianbieView selectView(@Param("ew") Wrapper<ZhenweijianbieEntity> wrapper);
	

}
