package net.voovo.enote.service;

import java.util.HashMap;
import java.util.Vector;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.voovo.enote.entity.Comment;
import net.voovo.enote.mapper.CommentMapper;
import net.voovo.enote.utils.JavaBean2HashMap;

@Service
public class CommentService {
	@Resource
	private CommentMapper mapper;

	public Vector<Comment> queryComments(Comment comment){
		
		/* 基本查询条件 */
		HashMap<Object,Object> cond = JavaBean2HashMap.javaBean2HashMap(comment);
		
		return mapper.getComments(cond);
	}
}
