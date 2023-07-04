package com.programmers.cat_picture_search.image.repository;

import com.programmers.cat_picture_search.image.entity.Image;
import com.programmers.cat_picture_search.image.entity.QImage;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ImageRepositoryImpl implements ImageRepositoryCustom {

  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public List<Image> get50() {
    QImage i = new QImage("i");
    return jpaQueryFactory.selectFrom(i)
        .orderBy(Expressions.numberTemplate(Double.class, "function('rand')").asc())
        .limit(50)
        .fetch();
  }

  @Override
  public List<Image> getKeywordImages(String keyword) {
    QImage i = new QImage("i");
    return jpaQueryFactory.selectFrom(i)
        .where(i.breed.name.like(keyword))
        .fetch();
  }

  @Override
  public Image getImageInfo(String id) {
    QImage i = new QImage("i");
    return jpaQueryFactory.selectFrom(i)
        .where(i.id.like(id))
        .fetchOne();
  }
}
