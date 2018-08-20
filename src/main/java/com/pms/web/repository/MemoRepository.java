package com.pms.web.repository;


import com.pms.web.entity.academy.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<Photo,  Integer> {

}
