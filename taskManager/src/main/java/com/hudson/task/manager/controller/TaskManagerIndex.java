package com.hudson.task.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class TaskManagerIndex {
	 @RequestMapping(method = RequestMethod.GET)
     public String getIndexPage() {
         return "index";
     }

}
