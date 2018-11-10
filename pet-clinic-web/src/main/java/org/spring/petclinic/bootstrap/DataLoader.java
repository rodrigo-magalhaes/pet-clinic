package org.spring.petclinic.bootstrap;

import org.spring.petclinic.model.Owner;
import org.spring.petclinic.model.Pet;
import org.spring.petclinic.model.PetType;
import org.spring.petclinic.model.Vet;
import org.spring.petclinic.services.OwnerService;
import org.spring.petclinic.services.PetTypeService;
import org.spring.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("ProJuris");
        owner1.setLastName("Juridico");
        owner1.setAddress("rua do pesar");
        owner1.setCity("joinville muito loca");
        owner1.setTelephone("123456789");

        Pet projurisDog = new Pet();
        projurisDog.setPetType(savedDogPetType);
        projurisDog.setOwner(owner1);
        projurisDog.setBirthDate(LocalDate.now());
        projurisDog.setName("blinqueduh");

        owner1.getPets().add(projurisDog);

        Owner owner2 = new Owner();
        owner2.setFirstName("Avenue");
        owner2.setLastName("Code");
        owner2.setAddress("rua do pesar");
        owner2.setCity("joinville muito loca");
        owner2.setTelephone("123456789");

        Pet avenueCat = new Pet();
        avenueCat.setPetType(savedCatPetType);
        avenueCat.setOwner(owner2);
        avenueCat.setBirthDate(LocalDate.now());
        avenueCat.setName("ziriguidum");

        owner2.getPets().add(avenueCat);

        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Vet ProJuris");
        vet1.setLastName("Juridico");

        Vet vet2 = new Vet();
        vet2.setFirstName("Vet Avenue");
        vet2.setLastName("Code");

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Loaded vets...");


    }
}
