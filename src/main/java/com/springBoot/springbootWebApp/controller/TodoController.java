package com.springBoot.springbootWebApp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springBoot.springbootWebApp.model.Todo;
import com.springBoot.springbootWebApp.service.LoginService;
import com.springBoot.springbootWebApp.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	//Model
	@Autowired
	TodoService service;
	
	@InitBinder
	public void initbinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@RequestMapping(value="/list-todos", method = RequestMethod.GET)
	public String showTodosList(ModelMap model) {
		String name = (String) model.get("name");
		model.put("todos", service.retrieveTodos(name));
		return "list-todos";
	}
	
	@RequestMapping(value="/add-todo", method = RequestMethod.GET)
	public String ShowaddTodos(ModelMap model) {
		model.addAttribute("todo",new Todo(0, (String) model.get("name"), "", new Date(), false));
		return "todo";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()){
			return "todo";
		}
		
		service.addTodo((String) model.get("name"), todo.getDesc(), todo.getTargetDate(),
				false);
		return "redirect:/list-todos";
	}
	@RequestMapping(value="/delete-todo", method = RequestMethod.GET)
	public String deleteTodos(@RequestParam int id) {
		service.deleteTodo(id);
		return "redirect:/list-todos";
	}
	@RequestMapping(value="/update-todo", method = RequestMethod.GET)
	public String updateTodos(@RequestParam int id,ModelMap model) {
		Todo todo = service.retrieveTodo(id);
		model.put("todo", todo);
		return "todo";
	}
	@RequestMapping(value="/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		todo.setUser((String) model.get("name"));
		if(result.hasErrors()){
			return "todo";
		}
		service.updateTodo(todo);
		
		return "redirect:/list-todos";
	}
	
}
