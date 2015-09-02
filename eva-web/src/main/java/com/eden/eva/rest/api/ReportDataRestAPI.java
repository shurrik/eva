package com.eden.eva.rest.api;

import com.eden.eva.facade.IIndexFacade;
import com.eden.eva.model.ReportData;
import com.eden.eva.model.ReportPeriod;
import com.eden.eva.service.IReportDataService;
import com.eden.eva.service.IReportPeriodService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

/**
 * Created by shurrik on 2015/8/27.
 */
@Path("/reportdata")
public class ReportDataRestAPI extends BaseRestAPI{

    @Autowired
    private IReportDataService reportDataService;
	@Autowired
	private IReportPeriodService reportPeriodService;
	@Autowired
	private IIndexFacade indexFacade;

//
    @POST
	@Path("/getbyperoid")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<ReportData> getByPeroid(Map<String,Object> map){
//		Integer year = (Integer) map.get("year");
//		Integer month = (Integer) map.get("month");

		ReportPeriod reportPeriod = null;
		if(map.get("year")!=null&& map.get("month")!=null)
		{
			reportPeriod = reportPeriodService.queryOne(map);
		}

		List<ReportData> list = null;
		if(reportPeriod!=null)
		{
			list = reportDataService.findList("periodId",reportPeriod.getId());
		}

		String sql = indexFacade.createIndexSql("1");
		System.out.println(sql);

//		List<ReportData> list = reportDataService.findAll();
		return  list;
	}


//	@POST
//	@Path("/getbyperoid")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public ChartData getByPeroid(){
//		List<ReportData> list = reportDataService.findAll();
//		ChartData chartData = chartDataFacade.getChartData(list);
//		return  chartData;
//	}
}
