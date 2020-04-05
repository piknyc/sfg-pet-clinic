package guru.springframework.sfgpetclinic.services.impl.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerServiceMapTest {
	OwnerServiceMap ownerServiceMap;

	@BeforeEach
	void setUp() {
		ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());

		ownerServiceMap.save(Owner.builder().id(1L).build());
	}

	@Test
	void findAll() {
		Set<Owner> owners = ownerServiceMap.findAll();
		assertEquals(1, owners.size());

	}

	@Test
	void deleteById() {
	}

	@Test
	void delete() {
		ownerServiceMap.deleteById(1L);
		Set<Owner> owners = ownerServiceMap.findAll();
		assertEquals(0, owners.size());
	}

	@Test
	void save() {
		Long id = new Long(2);
		Owner owner2 = Owner.builder().id(id).build();
		Owner saved = ownerServiceMap.save(owner2);
		assertEquals(owner2, saved);
	}

	@Test
	void findById() {
		Owner owner = ownerServiceMap.findById(1L);
		assertNotNull(owner);
	}

	@Test
	void findByLastName() {
	}
}