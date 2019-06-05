package br.usjt.hamilton.model.bean;

import java.io.Serializable;
//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;

import org.hibernate.annotations.NamedQuery;

@NamedQuery (name = "City.buscarPelaLatitudeLongitudeNQ",
query = "SELECT c FROM City c WHERE latitude = :latitude AND longitude = :longitude")

@NamedQuery (name = "City.buscarPeloNomeNQ",
query = "SELECT c FROM City c WHERE nome = :nome")

@NamedQuery (name = "City.buscarPeloNomeIgnoreCaseNQ",
query = "SELECT c FROM City c WHERE lower(c.nome) like lower(:nome)")

@Entity
	
public class City implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String latitude;
	private String longitude;

	//@OneToMany(mappedBy="cidade")
	//private List<PrevisaoTempo> previsao;
	
	public City() {
	}

	public City(Long id, String nome, String latitude, String longitude) {
		super();
		this.id = id;
		this.nome = nome;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
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
		City other = (City) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", nome=" + nome + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}