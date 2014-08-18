package net.combase.example.eip.throttle.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public abstract class BaseEntity {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id", unique = true)
	private String id;

	@Column(updatable = false)
	private LocalDateTime created = LocalDateTime.now();

	public String getId() {
		return id;
	}

	public LocalDateTime getCreated() {
		return created;
	}


}
