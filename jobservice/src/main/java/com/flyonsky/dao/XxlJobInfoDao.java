package com.flyonsky.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flyonsky.model.XxlJobInfo;

import java.util.List;


/**
 * job info
 * @author xuxueli 2016-1-12 18:03:45
 */
@Mapper
public interface XxlJobInfoDao {

	public List<XxlJobInfo> pageList(@Param("offset") int offset,
									 @Param("pagesize") int pagesize,
									 @Param("jobGroup") int jobGroup,
									 @Param("jobDesc") String jobDesc,
									 @Param("executorHandler") String executorHandler);
	public int pageListCount(@Param("offset") int offset,
							 @Param("pagesize") int pagesize,
							 @Param("jobGroup") int jobGroup,
							 @Param("jobDesc") String jobDesc,
							 @Param("executorHandler") String executorHandler);
	
	public int save(XxlJobInfo info);

	public XxlJobInfo loadById(@Param("id") int id);
	
	public int update(XxlJobInfo item);
	
	public int delete(@Param("id") int id);

	public List<XxlJobInfo> getJobsByGroup(@Param("jobGroup") int jobGroup);

	public int findAllCount();

}
