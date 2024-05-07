package com.app.model.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name="mappedsuperclass_TA")
public class TA extends User{

}
