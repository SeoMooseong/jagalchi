package com.spring.jagalchi.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.jagalchi.model.CDTO;
import com.spring.jagalchi.model.StatisticsModel;

@Repository
public class CertificateDAOImpl implements CertificateDAO{
	
	@Autowired
	SqlSession sqlSession;
	@Override
	public ArrayList<CDTO> selectCertiByDate(@Param("sdate") String sdate, @Param("edate") String edate) {
		// TODO Auto-generated method stub
		ArrayList<CDTO> arr = new ArrayList<CDTO>();
		
		CertificateDAO mapper = sqlSession.getMapper(CertificateDAO.class);
		arr = mapper.selectCertiByDate(sdate, edate);

		return arr;
	}
	@Override
	public ArrayList<CDTO> selectCertiByRegDate(String sdate, String edate) {
		// TODO Auto-generated method stub
		ArrayList<CDTO> arr = new ArrayList<CDTO>();
		
		CertificateDAO mapper = sqlSession.getMapper(CertificateDAO.class);
		arr = mapper.selectCertiByRegDate(sdate, edate);
		return arr;
	}
	@Override
	public ArrayList<CDTO> selectCertiByCode(String code) {
		// TODO Auto-generated method stub
		ArrayList<CDTO> arr = new ArrayList<CDTO>();
		
		CertificateDAO mapper = sqlSession.getMapper(CertificateDAO.class);
		arr = mapper.selectCertiByCode(code);
		return arr;
	}
	@Override
	public ArrayList<StatisticsModel> selectStatistics(String code) {
		// TODO Auto-generated method stub
		ArrayList<StatisticsModel> arr = new ArrayList<StatisticsModel>();
		
		CertificateDAO mapper = sqlSession.getMapper(CertificateDAO.class);
		arr = mapper.selectStatistics(code);
		return arr;
	}
	@Override
	public String selectObligfldcdByjmcd(String code) {
		// TODO Auto-generated method stub
		CertificateDAO mapper = sqlSession.getMapper(CertificateDAO.class);
		return mapper.selectObligfldcdByjmcd(code);
	}
	@Override
	public ArrayList<StatisticsModel> selectAllStatistics(String code) {
		ArrayList<StatisticsModel> arr = new ArrayList<StatisticsModel>();
		
		CertificateDAO mapper = sqlSession.getMapper(CertificateDAO.class);
		arr = mapper.selectAllStatistics(code);
		return arr;
	}

}
