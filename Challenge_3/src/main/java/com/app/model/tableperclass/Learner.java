package com.app.model.tableperclass;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name="tableperclass_learner")
public class Learner extends User{
	private String company;
	private String college;

}
