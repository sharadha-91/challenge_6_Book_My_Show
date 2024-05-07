package com.app.model.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name="singletable_learner")
@DiscriminatorValue(value="3")
public class Learner extends User{

}
