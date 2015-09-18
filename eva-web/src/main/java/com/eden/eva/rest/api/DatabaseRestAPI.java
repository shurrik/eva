package com.eden.eva.rest.api;

import com.eden.common.domain.view.BizData4Page;
import com.eden.eva.model.Database;
import com.eden.eva.service.IDatabaseService;

import com.eden.eva.util.PageParam;
import com.eden.install.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shurrik on 2015/9/10.
 */
@Path("/database")
public class DatabaseRestAPI extends BaseRestAPI<IDatabaseService>{

    @Autowired
    private IDatabaseService databaseService;

    @POST
    @Path("/list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
//    public BizData4Page<Database> findAll(Map<String,Object> map){
//
//        Map<String, Object> conditions = getQueryMap(map);
//        PageParam pageParam = getPageParam(map);
//        BizData4Page<Database> pageCtx = doPage(conditions, pageParam);
////        List<Database> list = databaseService.findAll();
//        return  pageCtx;
//    }

    public List<Database> findAll(Map<String,Object> map){

//        Map<String, Object> conditions = getQueryMap(map);
//        PageParam pageParam = getPageParam(map);
//        BizData4Page<Database> pageCtx = doPage(conditions, pageParam);
////        List<Database> list = databaseService.findAll();
//        return  pageCtx;
        List<Database> list = databaseService.findAll();
        return list;
    }

    @POST
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Database save(Map<String,Object> map){

        String editId = (String) map.get("editId");
        Database database = databaseService.fetch(editId);
        return database;
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
//    public Database save(Map<String,Object> map){
    public Database save(Database database){

        if(StringUtils.isBlank(database.getId()))
        {
            databaseService.add(database);
        }
        else
        {
            databaseService.update(database);
        }
        return database;
    }

    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(Map<String,Object> map){

        String editId = (String) map.get("editId");
        databaseService.deleteById(editId);
    }

    protected Map getQueryMap(Map<String,Object> map) {
        Map<String, Object> conditions = new HashMap();

        conditions.put("dbServer", (String)map.get("dbServer"));
        return conditions;
    }

    @Override
    protected IDatabaseService getMainService() {
        return databaseService;
    }
}