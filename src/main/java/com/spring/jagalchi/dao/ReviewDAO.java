package com.spring.jagalchi.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.spring.jagalchi.model.ReviewModel;

public interface ReviewDAO {
	public ArrayList<ReviewModel> selectAllReview(@Param("rjmcd") String rjmcd);
	public int insertReview(ReviewModel review);
	public int deleteReview(@Param("rno")int rno);
	public int updateReview(@Param("rno")int rno, @Param("rcontent")String rcontent);
	
}
