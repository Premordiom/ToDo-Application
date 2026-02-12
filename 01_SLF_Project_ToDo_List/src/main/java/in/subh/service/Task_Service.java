package in.subh.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.subh.controller.*;
import in.subh.entity.Task_Entity;
import in.subh.repository.Task_Repo;


@Service
public class Task_Service {
		
	private final Task_Repo taskRepo;
	
	public Task_Service(Task_Repo taskRepo) {
        this.taskRepo = taskRepo;
    }
	
	public List<Task_Entity> getAllTasks(){
		 return taskRepo.findAll();
	}
	
	public void createTask (String title) {
		Task_Entity taskE = new Task_Entity();
		taskE.setTask(title);
		taskE.setComplate(false);
		taskRepo.save(taskE);
	}
	
	public void deleteTask(Long id) {
		taskRepo.deleteById(id);
	}
	
	public void toggleTask(Long id ) {
		Task_Entity taskE = taskRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid task id: " + id));
		taskE.setComplate(!taskE.isComplate());
		taskRepo.save(taskE);
		
		taskE.setComplate(!taskE.isComplate());
		taskRepo.save(taskE);
	}

}
