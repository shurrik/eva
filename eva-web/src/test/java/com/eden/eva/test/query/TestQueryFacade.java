package com.eden.eva.test.query;

import com.eden.eva.facade.IQueryFacade;
import com.eden.eva.test.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by shurrik on 2015/9/2.
 */
public class TestQueryFacade extends TestBase{

    @Autowired
    private IQueryFacade queryFacade;

    @Test
    public void testCreateSql() throws Exception
    {
        System.out.println("===========================start£º");
        String sql = queryFacade.createSql("1");
        System.out.println(sql);
    }
}
