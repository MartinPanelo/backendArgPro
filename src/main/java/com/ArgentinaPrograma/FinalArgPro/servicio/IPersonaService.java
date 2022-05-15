
package com.ArgentinaPrograma.FinalArgPro.servicio;

import com.ArgentinaPrograma.FinalArgPro.datosportfolio.datos;
import java.util.List;

public interface IPersonaService {
    
    public List<datos> verDatos();
    
    public void crearDato(datos itemdato);
    
    public void borrarDato(Long id);
    
    public datos buscaritemdato(Long id);
    
}
