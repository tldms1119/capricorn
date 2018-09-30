package edu.iot.capricorn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import edu.iot.capricorn.model.Member;
import edu.iot.common.dao.CrudDaoImpl;
import edu.iot.common.database.Session;

public class MemberDaoImpl extends CrudDaoImpl<Member, String>
								implements MemberDao {

	public MemberDaoImpl() {
		super("MemberDao");
	}

	@Override
	public int changePassword(Map<String, String> map) throws Exception {
		try (SqlSession session = Session.getSession()){
			int count = session.update(namespace + ".changePassword", map);
			session.commit();
			return count;
		}
	}
	
	@Override
	public List<Member> search(String word) throws Exception {
		word = "%" + word + "%";
		
		try(SqlSession session = Session.getSession()){
			return session.selectList(namespace + ".search", word);
		}
		
	}

	/*@Override
	public void search(String word) throws Exception {
		word = "%" + word + "%";
		
		try(SqlSession session = Session.getSession()){
			session.selectList(namespace + ".search", word);
		}
		
	}

	@Override
	public List<Member> getSearchPage(int start, int end) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		
		try(SqlSession session = Session.getSession()){
			return session.selectList(namespace + ".getPage", map);
		}
	}*/
}
