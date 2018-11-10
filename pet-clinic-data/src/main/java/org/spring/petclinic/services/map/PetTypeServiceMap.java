package org.spring.petclinic.services.map;

import org.spring.petclinic.model.PetType;
import org.spring.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {
}
