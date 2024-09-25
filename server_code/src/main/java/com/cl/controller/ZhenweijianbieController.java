package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.ZhenweijianbieEntity;
import com.cl.entity.view.ZhenweijianbieView;

import com.cl.service.ZhenweijianbieService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 真伪鉴别
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-13 20:38:09
 */
@RestController
@RequestMapping("/zhenweijianbie")
public class ZhenweijianbieController {
    @Autowired
    private ZhenweijianbieService zhenweijianbieService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhenweijianbieEntity zhenweijianbie,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			zhenweijianbie.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhenweijianbieEntity> ew = new EntityWrapper<ZhenweijianbieEntity>();

		PageUtils page = zhenweijianbieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhenweijianbie), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhenweijianbieEntity zhenweijianbie, 
		HttpServletRequest request){
        EntityWrapper<ZhenweijianbieEntity> ew = new EntityWrapper<ZhenweijianbieEntity>();

		PageUtils page = zhenweijianbieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhenweijianbie), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhenweijianbieEntity zhenweijianbie){
       	EntityWrapper<ZhenweijianbieEntity> ew = new EntityWrapper<ZhenweijianbieEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhenweijianbie, "zhenweijianbie")); 
        return R.ok().put("data", zhenweijianbieService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhenweijianbieEntity zhenweijianbie){
        EntityWrapper< ZhenweijianbieEntity> ew = new EntityWrapper< ZhenweijianbieEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhenweijianbie, "zhenweijianbie")); 
		ZhenweijianbieView zhenweijianbieView =  zhenweijianbieService.selectView(ew);
		return R.ok("查询真伪鉴别成功").put("data", zhenweijianbieView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhenweijianbieEntity zhenweijianbie = zhenweijianbieService.selectById(id);
		zhenweijianbie = zhenweijianbieService.selectView(new EntityWrapper<ZhenweijianbieEntity>().eq("id", id));
        return R.ok().put("data", zhenweijianbie);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhenweijianbieEntity zhenweijianbie = zhenweijianbieService.selectById(id);
		zhenweijianbie = zhenweijianbieService.selectView(new EntityWrapper<ZhenweijianbieEntity>().eq("id", id));
        return R.ok().put("data", zhenweijianbie);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhenweijianbieEntity zhenweijianbie, HttpServletRequest request){
    	zhenweijianbie.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhenweijianbie);
        zhenweijianbieService.insert(zhenweijianbie);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhenweijianbieEntity zhenweijianbie, HttpServletRequest request){
    	zhenweijianbie.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhenweijianbie);
        zhenweijianbieService.insert(zhenweijianbie);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhenweijianbieEntity zhenweijianbie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhenweijianbie);
        zhenweijianbieService.updateById(zhenweijianbie);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhenweijianbieService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
