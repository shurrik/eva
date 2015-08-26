
package com.yunji.oa.dao;

import com.yunji.common.dao.IBaseDAO;
import com.yunji.oa.model.OpLog;

public interface IOpLogDAO extends IBaseDAO<OpLog>{

	Object addop(OpLog oplog);

}
