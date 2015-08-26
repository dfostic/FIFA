package com.dfostic.data;

import java.util.List;
import com.dfostic.beans.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dfostic
 */

//@NoRepositoryBean
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Player save(Player player);

//    @Query("select p from #{#entityName} p where p.lastname = ?1")
    List<Player> findByLastName(String lastName);

}
