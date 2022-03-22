package sn.maliki.projetvente;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EleveDao {
    @Query("SELECT * FROM eleve")
    List<Eleve> getAll();

    @Query("SELECT * FROM eleve WHERE uid IN (:eleveIds)")
    List<Eleve> getAllByEleveId(int... eleveIds);

    @Query("SELECT * FROM eleve WHERE nom = :eleveNom")
    List<Eleve> getByEleveNom(String eleveNom);

    @Query("SELECT * FROM eleve WHERE nom LIKE :eleveNom AND prenom LIKE :elevePrenom")
    List<Eleve> getByEleveNomAndPrenom(String eleveNom, String  elevePrenom);

    @Insert
    void insertAll(Eleve... eleves);

    @Delete
    void delete(Eleve eleve);

}
