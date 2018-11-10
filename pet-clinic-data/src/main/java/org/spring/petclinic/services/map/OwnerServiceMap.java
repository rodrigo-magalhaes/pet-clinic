package org.spring.petclinic.services.map;

import org.spring.petclinic.model.Owner;
import org.spring.petclinic.model.Pet;
import org.spring.petclinic.services.OwnerService;
import org.spring.petclinic.services.PetService;
import org.spring.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public Owner save(Owner owner) {
        if(owner != null) {
            owner.getPets().forEach(pet -> {
                if(pet.getPetType() != null) {
                    if (pet.getPetType().getId() == null)
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                } else {
                    throw new RuntimeException("Pet Type is required");
                }
                if(pet.getId() == null) {
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                }
            });
            return super.save(owner);
        }
        return owner;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
