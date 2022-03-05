package com.bitc.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.dto.MyBlogBoardDto;
import com.bitc.dto.MyBlogMemberDto;
import com.bitc.dto.MyBlogValueDto;
import com.github.pagehelper.Page;

@Mapper
public interface MyBlogMapper {

	void insertMember(MyBlogMemberDto myBlogMemberDto) throws Exception;

	MyBlogMemberDto selectMemberDto(String selectId) throws Exception;

	void insertBlogVal(MyBlogMemberDto myBlogMemberDto) throws Exception;

	MyBlogValueDto getBlogValue(String selectId) throws Exception;

	int loginCheck(MyBlogMemberDto myBlogMemberDto) throws Exception;

	int selectMemberIdCnt(String selectId) throws Exception;

	Page<MyBlogBoardDto> guestBoardList(String selectId) throws Exception;

	void BoardDelete(int idx) throws Exception;

	void guestBoardInsert(MyBlogBoardDto myBlogBoardDto) throws Exception;

	String findUserId(int idx) throws Exception;

	Page<MyBlogBoardDto> myBoardList(String selectId) throws Exception;

	void myboardInsert(MyBlogBoardDto myBlogBoardDto) throws Exception;

	MyBlogBoardDto selectBoardDetail(HashMap<String, Object> param) throws Exception;

	void BoardUpdate(MyBlogBoardDto myBlogBoardDto) throws Exception;

	void profileUpdate(MyBlogMemberDto myBlogMemberDto) throws Exception;

	void passwordUpdate(MyBlogMemberDto myBlogMemberDto) throws Exception;

	void blogValuePFUpdate(MyBlogValueDto myBlogValueDto) throws Exception;

	void blogNameUpdate(MyBlogValueDto myBlogValueDto) throws Exception;

	void boardColorUpdate(MyBlogValueDto myBlogValueDto) throws Exception;
}
