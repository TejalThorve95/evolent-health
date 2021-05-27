package com.example.evolent.contact.repository;

import com.example.evolent.contact.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    @Query(value = "update contact c set c.status = false where c.id = :id", nativeQuery = true)
    void softDeleteById(Integer id);

    @Query(value = "select c.* from contact c where c.status = true", nativeQuery = true)
    List<Contact> findAllWithActiveStatus();
}
