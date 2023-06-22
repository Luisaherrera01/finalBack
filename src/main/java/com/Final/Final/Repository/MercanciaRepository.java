package com.Final.Final.Repository;

import com.Final.Final.Entity.Mercancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface MercanciaRepository extends JpaRepository<Mercancia, Integer> {
}
