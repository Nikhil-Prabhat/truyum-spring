package com.cognizant.truyum.repositary;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.model.MenuItem;
@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
	List<MenuItem> findByActiveTrueAndDateOfLaunchBefore(Date date);
	Optional<MenuItem> findById(long id);
}
