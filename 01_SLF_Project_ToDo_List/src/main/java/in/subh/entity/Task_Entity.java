package in.subh.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Task_Entity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String task;
    private boolean complate;

}
