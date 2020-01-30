package com.spring.jagalchi.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.jagalchi.model.CDTO;
import com.spring.jagalchi.model.StatisticsModel;

public interface CertificateDAO {
	public ArrayList<CDTO> selectCertiByDate(@Param("sdate") String sdate, @Param("edate") String edate);
	public ArrayList<CDTO> selectCertiByRegDate(@Param("sdate") String sdate, @Param("edate") String edate);
	public ArrayList<CDTO> selectCertiByCode(@Param("code") String code);
	public ArrayList<StatisticsModel> selectStatistics(@Param("code") String code);
	public String selectObligfldcdByjmcd(@Param("code") String code);
	public ArrayList<StatisticsModel> selectAllStatistics(@Param("code") String code);
}
