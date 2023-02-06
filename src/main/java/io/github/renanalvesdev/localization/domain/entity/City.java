package io.github.renanalvesdev.localization.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_city")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class City {

	@Id
	@Column(name = "id_city")
	private Long id;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name = "qtd_habitants")
	private Long habitants;
	
}
