package com.spring.jagalchi.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.jagalchi.model.CDTO;

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

}
