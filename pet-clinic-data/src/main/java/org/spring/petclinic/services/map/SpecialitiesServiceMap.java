package org.spring.petclinic.services.map;

import org.spring.petclinic.model.Speciality;
import org.spring.petclinic.services.SpecialitiesService;
import org.springframework.stereotype.Service;

@Service
public class SpecialitiesServiceMap extends AbstractMapService<Speciality, Long> implements SpecialitiesService {
}
