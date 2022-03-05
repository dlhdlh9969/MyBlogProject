package com.bitc.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.dto.MyBlogBoardDto;
import com.bitc.dto.MyBlogMemberDto;
import com.bitc.dto.MyBlogValueDto;
import com.bitc.service.MyBlogService;
import com.github.pagehelper.PageInfo;

@Controller
public class MyBlogController {

	@Autowired
	private MyBlogService myBlogService;
	
	@RequestMapping("/")
	public String index() throws Exception
	{
		return "blog/index";
	}
	
	@RequestMapping("member/signIn") //회원가입 페이지
	public String signIn(HttpServletRequest request) throws Exception
	{
		HttpSession session = request.getSession();
		StringBuilder stringBuilder = new StringBuilder(request.getRequestURL().toString());
	    String requestURL = stringBuilder.toString();  //현재 URL 문자로 변환
		
		if(requestURL.equals(request.getHeader("Referer")))
		{	
			return "blog/signIn";
		}
		else
		{
			session.setAttribute("PrevPage", request.getHeader("Referer"));
			return "blog/signIn";
		}
		
	}
	
	@RequestMapping("member/login") //로그인 페이지
	public String login(HttpServletRequest request) throws Exception
	{
		HttpSession session = request.getSession();
		
		StringBuilder stringBuilder = new StringBuilder(request.getRequestURL().toString());
	    String requestURL = stringBuilder.toString();  //현재 URL 문자로 변환
		
		if(requestURL.equals(request.getHeader("Referer")))
		{	
			return "blog/login";
		}
		else
		{
			session.setAttribute("PrevPage", request.getHeader("Referer"));
			return "blog/login";
		}
		
		
	}
	@ResponseBody // 회원가입 submit 프로세스
	@RequestMapping(value = "member/signInProcessAjax", method = RequestMethod.POST)
	public Object signInProcess(MyBlogMemberDto myBlogMemberDto, HttpServletRequest request) throws Exception
	{
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultCnt = myBlogService.selectMemberIdCnt(myBlogMemberDto.getUserId());
		
		if(resultCnt > 0)
		{
			map.put("resultCnt", resultCnt);
			return map;
			
		}
		else {
			myBlogService.insertMember(myBlogMemberDto);
			HttpSession session = request.getSession();
			String PrevPage = (String)session.getAttribute("PrevPage");
			map.put("PrevPage", PrevPage);
			
			return map;
		}
	}
	
	@ResponseBody // 로그인 submit 프로세스
	@RequestMapping(value = "member/logInProcessAjax", method = RequestMethod.POST)
	public Object logInProcessAjax(MyBlogMemberDto myBlogMemberDto, HttpServletRequest request) throws Exception
	{
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultCnt = myBlogService.loginCheck(myBlogMemberDto);
		map.put("resultCnt", resultCnt);
		
		if(resultCnt > 0)
		{
			MyBlogMemberDto loginDto = myBlogService.selectMemberDto(myBlogMemberDto.getUserId());
			HttpSession session = request.getSession();
			session.setAttribute("sessionId", loginDto.getUserId());
			session.setAttribute("sessionName", loginDto.getUserName());
			session.setAttribute("Updated", "No");
			session.setMaxInactiveInterval(600);
			
			String PrevPage = (String)session.getAttribute("PrevPage");
			map.put("PrevPage", PrevPage);
			
			return map;
			
		}
		else {
			return map;
		}
	}
	
	@RequestMapping(value="member/logout") // 로그아웃
	public String logout(HttpServletRequest request)throws Exception{
		HttpSession session = request.getSession();
		String referer = request.getHeader("Referer");
		session.invalidate();
		return "redirect:" + referer;
	}
	
	@RequestMapping(value="process/notFound") // 블로그 ID 찾기 실패
	public String notFound() throws Exception
	{
		return "blog/notFound";
	}
	
	@RequestMapping(value="process/error") // session 종료 외 에러페이지
	public String processError() throws Exception
	{
		return "blog/error";
	}
	
	@RequestMapping(value="{ID}") // 블로그 찾아가기
	public ModelAndView myBlog(@PathVariable("ID") String selectId) throws Exception{
		ModelAndView mv = new ModelAndView("blog/myblogHome");
		ModelAndView notFound = new ModelAndView("blog/notFound");
		
		int resultCnt = myBlogService.selectMemberIdCnt(selectId);
		
			
		if(resultCnt > 0)
		{
			MyBlogValueDto blogvalueDto = myBlogService.getBlogValue(selectId);
			MyBlogMemberDto myBlogMemberDto = myBlogService.selectMemberDto(selectId);
			mv.addObject("blogValue", blogvalueDto);
			mv.addObject("memberValue", myBlogMemberDto);
			return mv;
		}else {
			return notFound;
		}
	}
	
	@RequestMapping("process/setBlog/{userId}") // 블로그관리 페이지
	public ModelAndView blogSet(@PathVariable("userId")String userId, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("blog/myblogSet");
		ModelAndView notFound = new ModelAndView("blog/notFound");
		ModelAndView error = new ModelAndView("blog/error");
		HttpSession session = request.getSession();
		
		MyBlogValueDto blogvalueDto = myBlogService.getBlogValue(userId);
		MyBlogMemberDto myBlogMemberDto = myBlogService.selectMemberDto(userId);
		mv.addObject("blogValue", blogvalueDto);
		mv.addObject("memberValue", myBlogMemberDto);
		
		try {
			if(session.getAttribute("sessionId").equals(userId))
			{
				mv.addObject("blogValue", blogvalueDto);
				mv.addObject("memberValue", myBlogMemberDto);
				return mv;
			}else
			{
				return notFound;
			}
		} catch (Exception e) {
			return error;
		}
	}
	
	@RequestMapping("process/profileUpdate") //프로필 업데이트
	public String profileUpdate(MyBlogMemberDto myBlogMemberDto, MyBlogValueDto myBlogValueDto, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		
		try {
			if(session.getAttribute("sessionId").equals(myBlogMemberDto.getUserId()))
			{
				myBlogService.profileUpdate(myBlogMemberDto);
				myBlogService.blogValuePFUpdate(myBlogValueDto);
				session.setAttribute("sessionName", myBlogMemberDto.getUserName());
				
				return "redirect:/process/setBlog/"+myBlogMemberDto.getUserId();
			}else
			{
				return "redirect:/process/notFound";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/process/error";
		}
		
	}
	
	@RequestMapping("process/passwordUpdate") // 비밀번호 변경
	public String passwordUpdate(MyBlogMemberDto myBlogMemberDto , HttpServletRequest request) throws Exception
	{
		HttpSession session = request.getSession();
		
		try {
			if(session.getAttribute("sessionId").equals(myBlogMemberDto.getUserId()))
			{
				myBlogService.passwordUpdate(myBlogMemberDto);
				return "redirect:/process/setBlog/"+myBlogMemberDto.getUserId();
			}else
			{
				return "redirect:/process/notFound";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/process/error";
		}
	}
	
	@RequestMapping("process/blogName") // 블로그이름 변경
	public String blogNameUpdate(MyBlogValueDto myBlogValueDto , HttpServletRequest request) throws Exception
	{
		HttpSession session = request.getSession();
		
		System.out.println(session.getAttribute("sessionId"));
		System.out.println(myBlogValueDto.getUserId());
		
		try {
			if(session.getAttribute("sessionId").equals(myBlogValueDto.getUserId()))
			{
				myBlogService.blogNameUpdate(myBlogValueDto);
				return "redirect:/process/setBlog/"+myBlogValueDto.getUserId();
			}else
			{
				return "redirect:/process/notFound";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/process/error";
		}
	}
	
	@RequestMapping("process/blogColor") // 보더색상 변경
	public String blogColorUpdate(MyBlogValueDto myBlogValueDto , HttpServletRequest request) throws Exception{
HttpSession session = request.getSession();
		
		System.out.println(session.getAttribute("sessionId"));
		System.out.println(myBlogValueDto.getUserId());
		
		try {
			if(session.getAttribute("sessionId").equals(myBlogValueDto.getUserId()))
			{
				myBlogService.boardColorUpdate(myBlogValueDto);
				return "redirect:/process/setBlog/"+myBlogValueDto.getUserId();
			}else
			{
				return "redirect:/process/notFound";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/process/error";
		}
	}
	
	@RequestMapping(value="board/{ID}") // 게시판 찾기
	public ModelAndView myBlogBoard(@PathVariable("ID") String selectId,  @RequestParam(required=false, defaultValue = "1") int pageNum) throws Exception{
		ModelAndView mv = new ModelAndView("blog/myblogBoard");
		ModelAndView notFound = new ModelAndView("blog/notFound");
		
		int resultCnt = myBlogService.selectMemberIdCnt(selectId);
		
		if(resultCnt > 0)
		{	
			PageInfo<MyBlogBoardDto> boardList = new PageInfo<>(myBlogService.myBoardList(pageNum, selectId), 10) ;
			MyBlogValueDto blogvalueDto = myBlogService.getBlogValue(selectId);
			MyBlogMemberDto myBlogMemberDto = myBlogService.selectMemberDto(selectId);
			mv.addObject("boardList", boardList);
			mv.addObject("blogValue", blogvalueDto);
			mv.addObject("memberValue", myBlogMemberDto);
			return mv;
		}else {
			return notFound;
		}
	}
	
	@RequestMapping(value="board/write/{userId}") // 게시판 작성페이지
	public ModelAndView boardWirte(@PathVariable("userId") String userId,  HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("blog/myblogBoardWrite");
		ModelAndView notFound = new ModelAndView("blog/notFound");
		ModelAndView error = new ModelAndView("blog/error");
		
		MyBlogValueDto blogvalueDto = myBlogService.getBlogValue(userId);
		MyBlogMemberDto myBlogMemberDto = myBlogService.selectMemberDto(userId);
		mv.addObject("blogValue", blogvalueDto);
		mv.addObject("memberValue", myBlogMemberDto);
		
		HttpSession session = request.getSession();
		
		try {
			if(session.getAttribute("sessionId").equals(userId))
			{	
				return mv;
			}else
			{
				return notFound;
			}
		} catch (Exception e) {
			return error;
		}
	}
	
	@RequestMapping("board/detail") // 게시판 상세보기
	public ModelAndView boadDetail(@RequestParam("userId")String userId,@RequestParam("idx") int idx,  HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("blog/myblogBoardDetail");
		MyBlogValueDto blogvalueDto = myBlogService.getBlogValue(userId);
		MyBlogMemberDto myBlogMemberDto = myBlogService.selectMemberDto(userId);
		HashMap<String, Object> param = new HashMap<>();
		param.put("userId", userId);
		param.put("idx", idx);
		MyBlogBoardDto boardDetail = myBlogService.selectBoardDetail(param);
		
		mv.addObject("blogValue", blogvalueDto);
		mv.addObject("memberValue", myBlogMemberDto);
		mv.addObject("boardDetail", boardDetail);
		
		HttpSession session = request.getSession();
		StringBuilder stringBuilder = new StringBuilder(request.getRequestURL().toString());
	    String requestURL = stringBuilder.toString();  //현재 URL 문자로 변환
		
	    try {
	    	if(requestURL.equals(request.getHeader("Referer")))
			{	
				return mv;
			}else if(session.getAttribute("Updated").equals("Yes")) {
				session.setAttribute("Updated", "No");
				return mv;
			}
			else
			{
				session.setAttribute("PrevPage", request.getHeader("Referer"));
				return mv;
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("PrevPage", request.getHeader("Referer"));
			return mv;
		}
	    
		
	}
	
	@RequestMapping(value="board/insert") // 게시판 글등록 process
	public String boardInsert(MyBlogBoardDto myBlogBoardDto, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		
		myBlogService.myBoardInsert(myBlogBoardDto);
		
		try {
			if(session.getAttribute("sessionId").equals(myBlogBoardDto.getUserId()))
			{
				return "redirect:/board/"+myBlogBoardDto.getUserId();
			}else
			{
				return "redirect:/process/notFound";
			}
		} catch (Exception e) {
			return "redirect:/process/error";
		}
	}
	
	@RequestMapping(value="guest/{ID}") // 방명록 페이지
	public ModelAndView myBlogGuest(@PathVariable("ID") String selectId, @RequestParam(required=false, defaultValue = "1") int pageNum) throws Exception{
		ModelAndView mv = new ModelAndView("blog/myblogGuest");
		ModelAndView notFound = new ModelAndView("blog/notFound");
		
		PageInfo<MyBlogBoardDto> boardList = new PageInfo<>(myBlogService.guestBoardList(pageNum, selectId), 10) ;
		MyBlogValueDto blogvalueDto = myBlogService.getBlogValue(selectId);
		MyBlogMemberDto myBlogMemberDto = myBlogService.selectMemberDto(selectId);
		mv.addObject("boardList", boardList);
		mv.addObject("blogValue", blogvalueDto);
		mv.addObject("memberValue", myBlogMemberDto);
		
		int resultCnt = myBlogService.selectMemberIdCnt(selectId);
		
		if(resultCnt > 0)
		{	
			return mv;
		}else {
			return notFound;
		}
	}
	
	
	@RequestMapping(value="guest/boardDelete/{idx}") // 게시판 글 삭제
	public String guestBoardDelete(@PathVariable("idx") int idx, HttpServletRequest request) throws Exception
	{
		String findUserId = myBlogService.findUserId(idx);
		HttpSession session = request.getSession();
		
		if(findUserId.equals(session.getAttribute("sessionId")) )
		{
			myBlogService.BoardDelete(idx);
			return "redirect:"+request.getHeader("Referer");
		}else{
			return "redirect:/process/error";
		}
	}
	
	@RequestMapping(value="guest/boardInsert") // 방명록 글 등록 프로세스
	public String guestBoardInsert(MyBlogBoardDto myBlogBoardDto) throws Exception
	{
		myBlogService.guestBoardInsert(myBlogBoardDto);
		return "redirect:/guest/" + myBlogBoardDto.getBoardId();
	}
	
	@RequestMapping(value="board/delete") // 게시판 글 삭제
	public String boardDelete(MyBlogBoardDto myBlogBoardDto, HttpServletRequest request)throws Exception{
		String findUserId = myBlogService.findUserId(myBlogBoardDto.getIdx());
		HttpSession session = request.getSession();
		
		if(findUserId.equals(session.getAttribute("sessionId")) )
		{
			myBlogService.BoardDelete(myBlogBoardDto.getIdx());
			return "redirect:"+session.getAttribute("PrevPage");
		}else{
			return "redirect:/process/error";
		}
	}
	
	@RequestMapping(value="board/update") // 게시판 글 수정
	public String boardUpdate(MyBlogBoardDto myBlogBoardDto, HttpServletRequest request)throws Exception{
		String findUserId = myBlogService.findUserId(myBlogBoardDto.getIdx());
		HttpSession session = request.getSession();
		
		if(findUserId.equals(session.getAttribute("sessionId")) )
		{
			myBlogService.BoardUpdate(myBlogBoardDto);
			session.setAttribute("Updated", "Yes");
			return "redirect:"+request.getHeader("Referer");
		}else{
			return "redirect:/process/error";
		}
	}
	
}
