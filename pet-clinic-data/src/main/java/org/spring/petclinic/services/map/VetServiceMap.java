package org.spring.petclinic.services.map;

import org.spring.petclinic.model.Vet;
import org.spring.petclinic.services.SpecialityService;
import org.spring.petclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityServic;

    public VetServiceMap(SpecialityService specialityServic) {
        this.specialityServic = specialityServic;
    }

    @Override
    public Vet save(Vet vet) {
        if(vet != null) {
            vet.getSpecialities().forEach(speciality -> {
                if(speciality.getDescription() != null) {
                    if (speciality.getId() == null)
                        speciality.setId(specialityServic.save(speciality).getId());
                } else {
                    throw new RuntimeException("Speciality description is required");
                }
            });
            return super.save(vet);
        }
        return vet;
    }
}
