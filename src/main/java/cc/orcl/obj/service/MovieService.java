package cc.orcl.obj.service;

import cc.orcl.obj.model.MovieVo;
import cc.orcl.obj.model.PagedResult;

/**
 * 
 */
public interface MovieService  {

    PagedResult<MovieVo> findByPage(Integer pageNum, Integer pageSize, Integer keyType, String keyword, Integer objType);
}