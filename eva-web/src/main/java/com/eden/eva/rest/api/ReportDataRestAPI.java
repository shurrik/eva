package com.eden.eva.rest.api;

import com.eden.eva.model.ReportData;
import com.eden.eva.service.IReportDataService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by shurrik on 2015/8/27.
 */
@Path("/reportdata")
public class ReportDataRestAPI extends BaseRestAPI{

    @Autowired
    private IReportDataService reportDataService;

//
    @POST
	@Path("/getbyperoid")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<ReportData> getByPeroid(){
		List<ReportData> list = reportDataService.findAll();
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
