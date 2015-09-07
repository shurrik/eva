package com.eden.eva.facade.impl;

import com.eden.common.utils.DateUtils;
import com.eden.eva.facade.IIndexFacade;
import com.eden.eva.facade.IReportDataFacade;
import com.eden.eva.jdbc.service.JdbcSqlService;
import com.eden.eva.model.*;
import com.eden.eva.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shurrik on 2015/8/27.
 */
@SuppressWarnings("unchecked")
@Service("ReportDataFacadeImpl")
public class ReportDataFacadeImpl implements IReportDataFacade{

    @Autowired
    private IReportDataService reportDataService;
    @Autowired
    private IReportPeriodService reportPeriodService;
    @Autowired
    private IIndexFacade indexFacade;
    @Autowired
    private IDatabaseService databaseService;
    @Autowired
    private IReportService reportService;
    @Autowired
    private IQueryService queryService;

    @Override
    public void addByMonth(String repId) throws Exception {
        Report report = reportService.fetch(repId);


        Query query = queryService.findOne("repId", repId);

        Database db = databaseService.fetch(query.getDbId());

        JdbcSqlService sqlService = JdbcSqlService.newInstance(db);
        String sql = indexFacade.createIndexSql(query.getId());
        List<Map<String, Object>> list  = sqlService.queryForList(sql);


        ReportPeriod reportPeriod = this.createReportPeriod(repId);

        for(Map<String, Object> item:list)
        {
            String repKey = (String) item.get("repKey");
            String val = item.get("repVal").toString();
            BigDecimal repVal = new BigDecimal(val);
            this.createReportData(reportPeriod,repKey,repVal);
        }
    }

    private ReportPeriod createReportPeriod(String repId)
    {
        ReportPeriod reportPeriod = new ReportPeriod();
        reportPeriod.setRepId(repId);
        reportPeriod.setYear(DateUtils.getYear());
        reportPeriod.setMonth(DateUtils.getMonth());
        Date[] dates = DateUtils.getStartAndEndDateForToday();
        reportPeriod.setStartDate(dates[0]);
        reportPeriod.setEndDate(dates[1]);
        return reportPeriodService.add(reportPeriod);
    }

    private void createReportData(ReportPeriod reportPeriod,String repKey,BigDecimal repVal)
    {
        ReportData reportData = new ReportData();
        reportData.setRepId(reportPeriod.getRepId());
        reportData.setPeriodId(reportPeriod.getId());
        reportData.setRepKey(repKey);
        reportData.setRepVal(repVal);
        reportDataService.add(reportData);
    }
}
