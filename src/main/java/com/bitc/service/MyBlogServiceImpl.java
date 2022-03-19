package com.bitc.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.dto.MyBlogBoardDto;
import com.bitc.dto.MyBlogMemberDto;
import com.bitc.dto.MyBlogValueDto;
import com.bitc.mapper.MyBlogMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class MyBlogServiceImpl implements MyBlogService {

	@Autowired
	private MyBlogMapper myBlogMapper; 
	
	@Override
	public void insertMember(MyBlogMemberDto myBlogMemberDto) throws Exception {
		myBlogMapper.insertMember(myBlogMemberDto);
		myBlogMapper.insertBlogVal(myBlogMemberDto);
	}

	@Override
	public MyBlogMemberDto selectMemberDto(String selectId) throws Exception {
		return myBlogMapper.selectMemberDto(selectId);
	}

	@Override
	public MyBlogValueDto getBlogValue(String selectId) throws Exception {
		return myBlogMapper.getBlogValue(selectId);
	}

	@Override
	public int loginCheck(MyBlogMemberDto myBlogMemberDto) throws Exception{
		return myBlogMapper.loginCheck(myBlogMemberDto);
	}

	@Override
	public int selectMemberIdCnt(String selectId) throws Exception {
		return myBlogMapper.selectMemberIdCnt(selectId);
	}

	@Override
	public Page<MyBlogBoardDto> guestBoardList(int pageNum, String selectId) throws Exception {
		PageHelper.startPage(pageNum, 10);
		return myBlogMapper.guestBoardList(selectId);
	}

	@Override
	public void BoardDelete(int idx) throws Exception {
		myBlogMapper.BoardDelete(idx);
	}

	@Override
	public void guestBoardInsert(MyBlogBoardDto myBlogBoardDto) throws Exception {
		myBlogMapper.guestBoardInsert(myBlogBoardDto);
	}

	@Override
	public String findUserId(int idx) throws Exception {
		return myBlogMapper.findUserId(idx);
	}

	@Override
	public Page<MyBlogBoardDto> myBoardList(int pageNum, String selectId) throws Exception {
		PageHelper.startPage(pageNum, 10);
		return myBlogMapper.myBoardList(selectId);
	}

	@Override
	public void myBoardInsert(MyBlogBoardDto myBlogBoardDto) throws Exception {
		myBlogMapper.myboardInsert(myBlogBoardDto);
		
	}

	@Override
	public MyBlogBoardDto selectBoardDetail(HashMap<String, Object> param) throws Exception {
		return myBlogMapper.selectBoardDetail(param);
	}

	@Override
	public void BoardUpdate(MyBlogBoardDto myBlogBoardDto) throws Exception {
		myBlogMapper.BoardUpdate(myBlogBoardDto);
	}

	@Override
	public void profileUpdate(MyBlogMemberDto myBlogMemberDto) throws Exception {
		myBlogMapper.profileUpdate(myBlogMemberDto);
	}

	@Override
	public void passwordUpdate(MyBlogMemberDto myBlogMemberDto) throws Exception {
		myBlogMapper.passwordUpdate(myBlogMemberDto);
	}

	@Override
	public void blogValuePFUpdate(MyBlogValueDto myBlogValueDto) throws Exception {
		myBlogMapper.blogValuePFUpdate(myBlogValueDto);
	}

	@Override
	public void blogNameUpdate(MyBlogValueDto myBlogValueDto) throws Exception {
		myBlogMapper.blogNameUpdate(myBlogValueDto);
	}

	@Override
	public void boardColorUpdate(MyBlogValueDto myBlogValueDto) throws Exception {
		myBlogMapper.boardColorUpdate(myBlogValueDto);
	}

}
