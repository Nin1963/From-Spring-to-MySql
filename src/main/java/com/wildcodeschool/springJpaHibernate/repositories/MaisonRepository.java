package com.wildcodeschool.springJpaHibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.springJpaHibernate.entities.Maison;

@Repository
public interface MaisonRepository extends JpaRepository<Maison, Long> {
}