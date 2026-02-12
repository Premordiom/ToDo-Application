package in.subh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.subh.entity.Task_Entity;

@Repository
public interface Task_Repo extends JpaRepository<Task_Entity, Long>{
	
	

}
