package org.spring.petclinic.services.map;

import org.spring.petclinic.model.Speciality;
import org.spring.petclinic.services.SpecialityService;
import org.springframework.stereotype.Service;

@Service
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService {
}
