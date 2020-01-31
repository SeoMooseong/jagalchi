package com.spring.jagalchi.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.jagalchi.model.MemberModel;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	SqlSession sqlSession;
	MemberDAO mapper;
	
	@Override
	public ArrayList<MemberModel> selectAllMember() {
		ArrayList<MemberModel> arr = new ArrayList<MemberModel>();
		
		mapper = sqlSession.getMapper(MemberDAO.class);
		arr = mapper.selectAllMember();
		
		return arr;
	}

	@Override
	public MemberModel selectMemberById(String id) {
		
		mapper = sqlSession.getMapper(MemberDAO.class);
		MemberModel member = mapper.selectMemberById(id);
		
		return member;
	}

	@Override
	public int insertMember(MemberModel member) {
		
		mapper = sqlSession.getMapper(MemberDAO.class);
		int result = mapper.insertMember(member);
		
		return result;
	}

	@Override
	public int deleteMember(String id) {
		
		mapper = sqlSession.getMapper(MemberDAO.class);
		int result = mapper.deleteMember(id);
		
		return result;
	}

	@Override
	public int updateMember(MemberModel member) {
		
		mapper = sqlSession.getMapper(MemberDAO.class);
		int result = mapper.updateMember(member);
		
		return result;
	}

	@Override
	public MemberModel loginMember(String id, String password) {

		mapper = sqlSession.getMapper(MemberDAO.class);
		MemberModel member = mapper.loginMember(id, password);

		return member;
	}


}
