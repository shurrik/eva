package com.eden.eva.rest.api;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;



@Path("/monthdivorcestat")
public class MonthdivorcestatRestAPI {
//    @Autowired
//    private IMonthDivorceStatService monthDivorceStatService;
//
//	@POST
//	@Path("/divmarry")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<MonthDivorceStat> divmarry(){
//		List<MonthDivorceStat> list = monthDivorceStatService.findAll();
//		return  list;
//	}
//
//	@POST
//	@Path("/conditionmarry")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<MonthDivorceStat> conditionmarry(Map<String,Object> map){
//		List<MonthDivorceStat> list = monthDivorceStatService.queryList(map, "create_date", "ASC");
//		System.out.println("length："+list.size());
//		return  list;
//	}

}
