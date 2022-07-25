
package com.ArgentinaPrograma.FinalArgPro.Security.Repository;

import com.ArgentinaPrograma.FinalArgPro.Security.Entity.Rol;
import com.ArgentinaPrograma.FinalArgPro.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author martin
 */

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}
