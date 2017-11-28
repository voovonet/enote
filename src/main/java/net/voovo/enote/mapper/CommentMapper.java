package net.voovo.enote.mapper;


import java.util.HashMap;
import java.util.Vector;

import org.apache.ibatis.annotations.Mapper;

import net.voovo.enote.entity.Comment;

@Mapper
public interface CommentMapper {

	
	public void insertOne(Comment goods);
	
	public void updateOne(Comment goods);
	
	public Vector<Comment> getComments(HashMap<Object,Object> condition);
	
	public int getCommentCount(Comment condition);
	
	public Integer getCommentInfoCount(HashMap<Object,Object> condition);
}

