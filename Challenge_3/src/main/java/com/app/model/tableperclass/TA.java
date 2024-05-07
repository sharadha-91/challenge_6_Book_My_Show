package com.app.model.tableperclass;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name="tableperclass_ta")
public class TA extends User{
	private String college;
	private String avgRating;

}
