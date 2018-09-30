package edu.iot.capricorn.model;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Top100 {
	private long id;
	private String title;
	private String region;
	private String location;
	private String content;
	private String address;
	private String homePage;
	private Date regDate;
	private Date updateDate;
	List<String> imageList;
	
	// property는 실제 필드변수와는 관계가 없을 수 있다
	// JSP 파일에서 ${(Top100 인스턴스).summary} 하면 호출되는 메소드
	public String getSummary() {
		String summary = content.substring(0, 20) + "...";
		return summary;
	}
}
