package org.spring.petclinic.bootstrap;

import org.spring.petclinic.model.Owner;
import org.spring.petclinic.model.Vet;
import org.spring.petclinic.services.OwnerService;
import org.spring.petclinic.services.VetService;
import org.spring.petclinic.services.map.OwnerServiceMap;
import org.spring.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("ProJuris");
        owner1.setLastName("Juridico");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Avenue");
        owner2.setLastName("Code");

        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Vet ProJuris");
        vet1.setLastName("Juridico");

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Vet Avenue");
        vet2.setLastName("Code");

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Loaded vets...");


    }
}
