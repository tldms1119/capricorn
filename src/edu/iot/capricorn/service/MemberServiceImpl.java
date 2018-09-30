package edu.iot.capricorn.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.iot.capricorn.Context;
import edu.iot.capricorn.dao.MemberDao;
import edu.iot.capricorn.model.Member;
import edu.iot.common.sec.SHA256Util;

public class MemberServiceImpl implements MemberService {
	
	MemberDao dao = Context.get(MemberDao.class);

	@Override
	public Member login(String id, String pw) throws Exception {
		Member user = dao.findById(id);
		if(user != null) {
			String result = SHA256Util.getEncrypt(pw, user.getSalt());
			if(result.equals(user.getPassword())) {
				return user;
			} else {
				throw new Exception("비밀번호가 일치하지 않습니다");
			}
		} else {
			throw new Exception("존재하지 않는 ID 입니다");
		}			
	}

	@Override
	public void join(Member member) throws Exception {
		dao.insert(member);
	}

	@Override
	public String idcheck(String id) throws Exception {
		Member member = dao.findById(id);
		if(member == null) {
			return "ok";
		}
		return "fail";
	}

	@Override
	public Map<String, Object> getPage(int page) throws Exception {
		Map<String, Object> map = new HashMap<>();
		int start = (page-1)*10 + 1;
		int end = start + 9;
		
		int total = dao.count();
		int totalPage = (int) Math.ceil(total/10.);
		List<Member> list = dao.getPage(start, end);
		
		map.put("page", page);
		map.put("total", total);
		map.put("totalPage", totalPage);
		map.put("list", list);
		
		return map;
	}

	@Override
	public Member findById(String userId) throws Exception {
		
		Member member = dao.findById(userId);
		
		return member;
	}

	@Override
	public int delete(String userId) throws Exception {
		return dao.delete(userId);
	}

	@Override
	public int update(Member member, Member sMember) throws Exception {
		String password = SHA256Util.getEncrypt(member.getPassword(), sMember.getSalt());

		member.setPassword(password);
		
		return dao.update(member);
	}

	@Override
	public int changePassword(Map<String, Object> map) throws Exception {
		Map<String, String> daoMap = new HashMap<>();
		Member member = (Member) map.get("member");
	
		String oldPassword = SHA256Util.getEncrypt((String)map.get("oldPassword"), member.getSalt());
		String newPassword = SHA256Util.getEncrypt((String)map.get("newPassword"), member.getSalt());
		
		daoMap.put("oldPassword", oldPassword);
		daoMap.put("newPassword", newPassword);
		daoMap.put("userId", member.getUserId());
		
		return dao.changePassword(daoMap);
	}

	@Override
	public Map<String, Object> search(int page, String userId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		
		int start = (page-1)*10 + 1;
		int end = start + 9;
		
		//dao.search(userId);									// select_view 생성
		//List<Member> list = dao.getSearchPage(start, end);	// select_view pagination
		List<Member> list = dao.search(userId);
		int total = list.size();
		int totalPage = (int) Math.ceil(total/10.);
		// List<Member> list = dao.getPage
		
		map.put("page", page);
		map.put("total", total);
		map.put("totalPage", totalPage);
		map.put("list", list);
		
		return map;
	}

	
}
