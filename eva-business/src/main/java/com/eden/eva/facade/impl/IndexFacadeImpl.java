package com.eden.eva.facade.impl;

import com.eden.eva.facade.IIndexFacade;
import com.eden.eva.facade.IQueryFacade;
import com.eden.eva.model.Index;
import com.eden.eva.service.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by shurrik on 2015/9/2.
 */
@SuppressWarnings("unchecked")
@Service("IndexFacadeImpl")
public class IndexFacadeImpl implements IIndexFacade {
    @Autowired
    private IQueryFacade queryFacade;
    @Autowired
    private IIndexService indexService;

    @Override
    public String createIndexSql(String qryId) {
        Index index = indexService.findOne("qryId", qryId);
//        String querySql = queryFacade.createSql(qryId);

        String selectSql = this.createSelect(index);
        String fromSql = this.createFrom(index);
        String groupSql = this.createGroup(index);

        String sql = selectSql+fromSql+groupSql;

        return sql;
    }

    private String  createSelect(Index index)
    {
//        SELECT
//        datatable.name repKey,
//        COUNT(datatable.user_name) repVal
        StringBuffer sb = new StringBuffer();
        sb.append(" SELECT datatable."+index.getIndexX()+" repKey,");
        sb.append(index.getFunc()+"(datatable."+index.getIndexY()+") repVal");
        String sql = sb.toString();
        return sql;
    }

    private String createFrom(Index index)
    {
        StringBuffer sb = new StringBuffer();
        sb.append(" FROM ( "+queryFacade.createSql(index.getQryId())+" ) datatable");
        String sql = sb.toString();
        return sql;
    }

    private String createGroup(Index index)
    {
//        GROUP BY datatable.name
        StringBuffer sb = new StringBuffer();
        sb.append(" GROUP BY datatable."+index.getIndexX());
        String sql = sb.toString();
        return sql;
    }
}
