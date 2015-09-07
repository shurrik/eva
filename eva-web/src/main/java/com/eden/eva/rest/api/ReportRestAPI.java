package com.eden.eva.rest.api;

import com.eden.eva.model.Report;
import com.eden.eva.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by shurrik on 2015/8/28.
 */
@Path("/report")
public class ReportRestAPI extends BaseRestAPI{

    @Autowired
    private IReportService reportService;

    @POST
    @Path("/getall")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Report> getALL(){
        List<Report> list = reportService.findAll();
        return  list;
    }
}
