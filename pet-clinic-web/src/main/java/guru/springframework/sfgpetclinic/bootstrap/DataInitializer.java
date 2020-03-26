package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component //This becomes Spring bean, going to be registered, and will run
public class DataInitializer implements CommandLineRunner {
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetService petService;


	//@Autowired by default
	public DataInitializer(OwnerService ownerService, VetService vetService, PetService petService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petService = petService;
	}

	@Override
	public void run(String... args) throws Exception {


		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
//		owner1.setAddress("123 Brickerel");
//		owner1.setCity("Miami");
//		owner1.setTelephone("1231231234");


		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner1.setId(2L);
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
//		owner2.setAddress("123 Brickerel");
//		owner2.setCity("Miami");
//		owner2.setTelephone("1231231234");


		ownerService.save(owner2);

		System.out.println("Loaded Owners....");


		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
//		vet1.getSpecialities().add(savedRadiology);

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
//		vet2.getSpecialities().add(savedSurgery);

		vetService.save(vet2);

		System.out.println("Loaded Vets....");
	}
}
