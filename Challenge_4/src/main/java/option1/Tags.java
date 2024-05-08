package option1;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity(name="mm_opt1_tags")
public class Tags {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tagId;
	private String tagName;
	
	
  //tag_id, tag_name

}
