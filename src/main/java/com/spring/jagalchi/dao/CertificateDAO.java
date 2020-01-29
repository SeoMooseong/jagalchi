package com.spring.jagalchi.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.jagalchi.model.CDTO;

public interface CertificateDAO {
	public ArrayList<CDTO> selectCertiByDate(@Param("sdate") String sdate, @Param("edate") String edate);
}
