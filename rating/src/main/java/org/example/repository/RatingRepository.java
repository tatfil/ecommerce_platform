package org.example.repository;

import org.example.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RatingRepository extends JpaRepository<Rating, UUID> {
    Rating getByUserId(UUID uuid);

}
