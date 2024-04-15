package org.jeslorlim.modelojpa.repositories;

import org.jeslorlim.modelojpa.model.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.UUID;

@Repository
public interface BecarioRepository extends JpaRepository<Becario, UUID> {
}
