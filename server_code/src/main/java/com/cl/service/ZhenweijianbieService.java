package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZhenweijianbieEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhenweijianbieView;


/**
 * 真伪鉴别
 *
 * @author 
 * @email 
 * @date 2024-03-13 20:38:09
 */
public interface ZhenweijianbieService extends IService<ZhenweijianbieEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhenweijianbieView> selectListView(Wrapper<ZhenweijianbieEntity> wrapper);
   	
   	ZhenweijianbieView selectView(@Param("ew") Wrapper<ZhenweijianbieEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhenweijianbieEntity> wrapper);
   	

}

