package com.arodrigo.sysmodelcon.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity      /*Cidade*/
public class Municipio implements Serializable
{  
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="provincia_id")
    private Provincia provincia;
    
    @ElementCollection
    @CollectionTable(name = "DestritoUrbano")
    private Set<String> destritoUrbano = new HashSet<>();
    
    public Municipio()
    {    	
    }

	public Municipio(Integer id, String nome, Provincia provincia) 
	{
		super();
		this.id = id;
		this.nome = nome;
		this.provincia = provincia;
	}

	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public Provincia getProvincia() 
	{
		return provincia;
	}

	public void setProvincia(Provincia provincia) 
	{
		this.provincia = provincia;
	}
	

	public Set<String> getDestritoUrbano() 
	{
		return destritoUrbano;
	}

	public void setDestritoUrbano(Set<String> destritoUrbano) 
	{
		this.destritoUrbano = destritoUrbano;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Municipio other = (Municipio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
    
}
