package br.usjt.hamilton.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
/*import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;*/
import org.springframework.stereotype.Repository;

import br.usjt.hamilton.model.bean.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

	public City findByLatitudeAndLongitude(String latitude, String longitude);

	public City findByNome(String nome);

	public City findByNomeIgnoreCase(String nome);

	public City buscarPelaLatitudeLongitudeNQ(@Param("latitude") String latitude, @Param("longitude") String longitude);

	@Query("SELECT c FROM City c WHERE lower(c.nome) like concat(lower(?1), '%')")
	public List<City> findByFirstLetter(String letra);

	/*
	 * @Query ("SELECT c FROM City c WHERE c.latitude = ?1 and c.longitude = ?2")
	 * public City buscarPelaLatitudeLongitude (String latitude, String longitude);
	 * 
	 * @Query ("SELECT c FROM City c WHERE c.nome = ?1") public City buscarPeloNome
	 * (String nome);
	 * 
	 * @Query ("SELECT c FROM City c WHERE lower(c.nome) like lower(?1)") public
	 * City buscarPeloNomeIgnoreCase (String nome);
	 * 
	 * 
	 * public City buscarPeloNomeNQ (@Param ("nome") String nome);
	 * 
	 * public City buscarPeloNomeIgnoreCaseNQ (@Param ("nome") String nome);
	 * 
	 * 
	 * 
	 */

}