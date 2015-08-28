package com.dfostic.data;

import java.util.List;
import com.dfostic.beans.Player;
import org.springframework.data.jpa.repository.JpaRepository;

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
