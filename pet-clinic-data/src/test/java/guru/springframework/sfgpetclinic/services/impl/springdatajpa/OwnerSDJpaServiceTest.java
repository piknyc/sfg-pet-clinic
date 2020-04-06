package guru.springframework.sfgpetclinic.services.impl.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

	@InjectMocks
	OwnerSDJpaService ownerService;
	Owner returnOwner;
	@Mock
	private OwnerRepository ownerRepository;
	@Mock
	private PetRepository petRepository;
	@Mock
	private PetTypeRepository petTypeRepository;
	private String testLastName = "Smith";

	@BeforeEach
	void setUp() {
		returnOwner = Owner.builder().id(1L).lastName(testLastName).build();
	}

	@Test
	void findByLastName() {

		when(ownerRepository.findByLastName(testLastName)).thenReturn(returnOwner);
		Owner owner = ownerService.findByLastName(testLastName);

		assertNotNull(owner);
		assertEquals(testLastName, owner.getLastName());

		verify(ownerRepository).findByLastName(any());
	}

	@Test
	void findAll() {
		Set<Owner> returnOwnersSet = new HashSet<>();
		returnOwnersSet.add(Owner.builder().id(1l).build());
		returnOwnersSet.add(Owner.builder().id(2l).build());

		when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

		Set<Owner> owners = ownerService.findAll();

		assertNotNull(owners);
		assertEquals(2, owners.size());
	}

	@Test
	void findById() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

		Owner owner = ownerService.findById(1L);

		assertNotNull(owner);
	}

	@Test
	void save() {
		Owner ownerToSave = Owner.builder().id(1L).build();

		when(ownerRepository.save(any())).thenReturn(returnOwner);

		Owner savedOwner = ownerService.save(ownerToSave);

		assertNotNull(savedOwner);

		verify(ownerRepository).save(any());
	}

	@Test
	void delete() {
		ownerService.delete(returnOwner);

		//default is 1 times
		verify(ownerRepository, times(1)).delete(any());
	}

	@Test
	void deleteById() {
	}
}