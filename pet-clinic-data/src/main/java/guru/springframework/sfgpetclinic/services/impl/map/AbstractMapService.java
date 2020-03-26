package guru.springframework.sfgpetclinic.services.impl.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.*;

public class AbstractMapService<T extends BaseEntity, ID extends Long> {

	protected Map<Long, T> map = new HashMap<>();

	Set<T> findAll() {
		return new HashSet<>(map.values());
	}

	T findById(ID id) {
		return map.get(id);
	}

	T save(T object) {
		if (object != null) {
			if (object.getId() == null) {
				object.setId(generateId());
			}
		} else {
			throw new RuntimeException("Can't save null object");
		}

		map.put(object.getId(), object);

		return object;
	}

	void deleteById(ID id) {
		map.remove(id);
	}


	void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}

	private Long generateId() {

		if (map.size() > 0)
			return Collections.max(map.keySet()) + 1;

		else
			return 1L;
	}

}
