package edu.iot.capricorn.dao;

import java.util.List;
import java.util.Map;

import edu.iot.capricorn.model.Member;
import edu.iot.common.dao.CrudDao;

public interface MemberDao extends CrudDao<Member, String> {
	int changePassword(Map<String, String> map) throws Exception;
	
	List<Member> search(String word) throws Exception;
	//void search(String word) throws Exception;
	//List<Member> getSearchPage(int start, int end) throws Exception;
}
