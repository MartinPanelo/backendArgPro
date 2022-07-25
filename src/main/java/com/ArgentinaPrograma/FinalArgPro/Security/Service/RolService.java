
package com.ArgentinaPrograma.FinalArgPro.Security.Service;

import com.ArgentinaPrograma.FinalArgPro.Security.Entity.Rol;
import com.ArgentinaPrograma.FinalArgPro.Security.Enums.RolNombre;
import com.ArgentinaPrograma.FinalArgPro.Security.Repository.iRolRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 *
 * @author martin
 */

@Service
@Transactional
public class RolService {
    
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        
        irolRepository.save(rol);
    }
    
}
