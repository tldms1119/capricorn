package edu.iot.capricorn.service;

import java.util.Map;

import edu.iot.capricorn.model.Member;

public interface MemberService {
	Member login(String id, String pw) throws Exception;
	
	void join(Member member) throws Exception;
	
	String idcheck(String id) throws Exception;
	
	Map<String, Object> getPage(int page) throws Exception;
	
	Map<String, Object> search(int page, String userId) throws Exception;
	
	Member findById(String userId) throws Exception;
	
	int delete(String userId) throws Exception;
	
	int update(Member member, Member sMember) throws Exception;
	
	int changePassword(Map<String, Object> map) throws Exception;
}
