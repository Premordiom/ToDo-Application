package in.subh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import in.subh.entity.Task_Entity;
import in.subh.repository.Task_Repo;
import in.subh.service.Task_Service;

@Controller
public class Task_Controller {
	
	
	private final Task_Service ts;
	
	public Task_Controller(Task_Service task_service) {
		this.ts = task_service;       //----------------->>>>This part is get data 
		//------>>>>>>>This part make the data imutable and final so that it cannot be changed after initialization
	}
	
	@GetMapping("/")
	public String getTasks(Model model) {
		
        List<Task_Entity> tasks = ts.getAllTasks();
        model.addAttribute("tasks", tasks);      
        return "task";
	
	}
	
	@PostMapping("/")
	public String createTasks(@RequestParam String title) {		
         ts.createTask(title);             
        return "redirect:/";
	
	}
	
	@GetMapping("/{id}/delete")
	public String deleteTasks(@PathVariable Long id) {
		
            ts.deleteTask(id);  
        return "redirect:/";
	
	}
	
	@GetMapping("/{id}/toggle")
	public String togeltask(@PathVariable Long id) {
		
            ts.toggleTask(id);  
        return "redirect:/";
	
	}
}


