package com.programmers.cat_picture_search.image.repository;

import com.programmers.cat_picture_search.image.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {


}
