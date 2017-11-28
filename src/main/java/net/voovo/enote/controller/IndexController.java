package net.voovo.enote.controller;

import java.util.Vector;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.voovo.enote.entity.Comment;
import net.voovo.enote.service.CommentService;
import net.voovo.enote.utils.SnowflakeIdWorker;


@RestController
@RequestMapping
public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	@Resource
	CommentService commentService;
	
	@RequestMapping("/")
	public ModelAndView index(Model model){
		try {
			Vector<Comment> data=commentService.queryComments(new Comment());
			model.addAttribute("data", data);
			model.addAttribute("msg", "1");
		} catch (Exception e) {
			logger.error("index error:"+e);
		}
		return new ModelAndView("/index");
	}
	
	@RequestMapping("/addComment")
	public String addComment() {
		String id = Long.toString(new SnowflakeIdWorker(0,0).nextId());//生成id
		System.out.println(id);
		return "";
	}
}
