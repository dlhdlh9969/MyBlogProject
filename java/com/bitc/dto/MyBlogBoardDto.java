package com.bitc.dto;

import lombok.Data;

@Data
public class MyBlogBoardDto {
	
	private int idx;
	private String userId;
	private String title;
	private String contents;
	private String createdDt;
	private String updatedDt;
	private String boardDiv;
	private String boardId;
	private String hitCnt;	
	private String deletedYn;
	private String deletedDt;
	
}
