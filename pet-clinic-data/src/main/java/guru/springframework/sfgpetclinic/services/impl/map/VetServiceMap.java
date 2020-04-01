package guru.springframework.sfgpetclinic.services.impl.map;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	private SpecialityService specialityService;

	public VetServiceMap(SpecialityService specialityService) {
		this.specialityService = specialityService;
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

	@Override
	public Vet save(Vet object) {
		if (object != null) {
			if (object.getSpecialities() != null)
				object.getSpecialities().forEach(speciality -> {
					if (speciality.getId() == null) {
						speciality.setId(specialityService.save(speciality).getId());
					}
				});


			return super.save(object);
		} else {
			return null;
		}
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

}

