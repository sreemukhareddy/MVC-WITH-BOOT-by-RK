package com.springboot.web.spring_boot_demo_web_application.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.web.spring_boot_demo_web_application.model.Todo;
import com.springboot.web.spring_boot_demo_web_application.service.TodoService;

@Controller
/*@SessionAttributes("name")*/
public class ToDoController {
	
	@Autowired
	TodoService toDoService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@RequestMapping(value="/list-todos",method=RequestMethod.GET)
	public String listToDos(ModelMap model) {
		
		String name=getLoggedInUserName(model);
		model.put("todos", toDoService.retrieveTodos(name));
		return "list-todos";
	}

	private String getLoggedInUserName(ModelMap model) {
		/*return (String)model.get("name");*/
		
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		
		return principal.toString();
	}
	

	@RequestMapping(value="/add-todo",method=RequestMethod.GET)
	public String showToDo(ModelMap model) {
		//model.put("todo", new Todo(0, (String)model.get("name"), "Default Desc", new Date(), false));
		model.addAttribute("todo", new Todo(0, getLoggedInUserName(model),
				"Default Desc", new Date(), false));
		return "todo";
	}
	
	@RequestMapping(value="/add-todo",method=RequestMethod.POST)
	public String addToDo(ModelMap model,@Valid Todo todo,BindingResult bindingResult){
		
		if(bindingResult.hasErrors()) {
			return "todo";
		}
		
		toDoService.addTodo(getLoggedInUserName(model), todo.getDesc(), todo.getTargetDate(), false);
		
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/delete-todo",method=RequestMethod.GET)
	public String deleteToDo(@RequestParam int id){
		
		toDoService.deleteTodo(id);
		
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/update-todo",method=RequestMethod.GET)
	public String showUpdateToDoPage(@RequestParam int id,ModelMap model){
		
		Todo todo=toDoService.retrieveTodos(id);
		
		model.put("todo", todo);
		
		return "todo";
	}
	
	@RequestMapping(value="/update-todo",method=RequestMethod.POST)
	public String updateToDo(ModelMap model,@Valid Todo todo,BindingResult bindingResult ){
		
		if(bindingResult.hasErrors()) {
			return "todo";
		}
		
		todo.setUser(getLoggedInUserName(model));
		
		toDoService.updateToDo(todo);

		return "redirect:/list-todos";
	}

	
	
	
	
}
