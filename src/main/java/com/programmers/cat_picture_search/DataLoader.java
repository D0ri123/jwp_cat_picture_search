package com.programmers.cat_picture_search;

import com.programmers.cat_picture_search.breed.entity.Breed;
import com.programmers.cat_picture_search.breed.repository.BreedRepository;
import com.programmers.cat_picture_search.feign.cat.dto.CatImage;
import com.programmers.cat_picture_search.feign.cat.dto.CatImage.BreedDto;
import com.programmers.cat_picture_search.image.controller.ImageController;
import com.programmers.cat_picture_search.image.entity.Image;
import com.programmers.cat_picture_search.image.repository.ImageRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

  private final BreedRepository breedRepository;
  private final ImageRepository imageRepository;
  private final ImageController imageController;

  // feignClient를 호출하여 Breed 데이터와 Image 데이터를 한꺼번에 저장한다.
  @Override
  public void run(String... args) throws Exception {
    List<CatImage> images = imageController.getImages(100L);

    for(CatImage image : images) {
      List<String> breedIds = new ArrayList<>();

      //1. breed정보를 저장함과 동시에 breedId만 따로 리스트에 저장한다.
      List<BreedDto> breeds = image.getBreeds();
      if(!breeds.isEmpty()) {
        for (BreedDto breedDto : breeds) {
          Breed savedBreed = Breed.builder()
              .id(breedDto.getId())
              .name(breedDto.getName())
              .temperament(breedDto.getTemperament())
              .origin(breedDto.getOrigin())
              .build();

          if (!breedRepository.existsById(savedBreed.getId())) {
            breedIds.add(breedDto.getId());
            breedRepository.save(savedBreed);
          }
        }

        //2. breedId 리스트를 순회하며, 이미지 정보와 breedId를 각각 저장시킨다.
        for (String breedId : breedIds) {
          Image img = Image.builder()
              .id(image.getId())
              .url(image.getUrl())
              .width(image.getWidth())
              .height(image.getHeight())
              .breed(breedRepository.getReferenceById(breedId))
              .build();
          imageRepository.save(img);
        }
      } else {
        Image img2 = Image.builder()
            .id(image.getId())
            .url(image.getUrl())
            .width(image.getWidth())
            .height(image.getHeight())
            .build();
        imageRepository.save(img2);
      }

    }
  }


}



