package com.spring.jagalchi.dao;

import java.util.ArrayList;

import com.spring.jagalchi.model.ReviewModel;

public interface ReviewDAO {
	public ArrayList<ReviewModel> selectAllReview();
	public int insertReview(ReviewModel review);
	public int deleteReview(int rno);
	public int updateReview(int rno, String rcontent);
	
}
