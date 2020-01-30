package com.spring.jagalchi.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.jagalchi.model.ReviewModel;

@Repository
public class ReviewDAOImpl implements ReviewDAO {
	
	@Autowired
	SqlSession sqlSession;
	ReviewDAO mapper;
	ArrayList<ReviewModel> arr;
	
	@Override
	public ArrayList<ReviewModel> selectAllReview() {
		arr = new ArrayList<ReviewModel>();
		mapper = sqlSession.getMapper(ReviewDAO.class);
		System.out.println("mapper.selectAllReview() :: "+ mapper.selectAllReview());
		arr = mapper.selectAllReview();
		
		return arr;
	}

	@Override
	public int insertReview(ReviewModel review) {
		mapper = sqlSession.getMapper(ReviewDAO.class);
		
		return mapper.insertReview(review);
	}

	@Override
	public int deleteReview(int rno) {
		mapper = sqlSession.getMapper(ReviewDAO.class);
		
		return mapper.deleteReview(rno);
	}

	@Override
	public int updateReview(int rno, String rcontent) {
		mapper = sqlSession.getMapper(ReviewDAO.class);
		
		return mapper.updateReview(rno, rcontent);
	}

}
