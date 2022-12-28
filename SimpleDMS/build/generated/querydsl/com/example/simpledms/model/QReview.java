package com.example.simpledms.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QReview is a Querydsl query type for Review
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReview extends EntityPathBase<Review> {

    private static final long serialVersionUID = -596796156L;

    public static final QReview review = new QReview("review");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    //inherited
    public final StringPath deleteTime = _super.deleteTime;

    //inherited
    public final StringPath deleteYn = _super.deleteYn;

    public final NumberPath<Integer> dno = createNumber("dno", Integer.class);

    //inherited
    public final StringPath insertTime = _super.insertTime;

    public final StringPath review_content = createString("review_content");

    public final StringPath review_photo = createString("review_photo");

    public final StringPath review_title = createString("review_title");

    public final StringPath review_writer = createString("review_writer");

    public final NumberPath<Integer> rno = createNumber("rno", Integer.class);

    //inherited
    public final StringPath updateTime = _super.updateTime;

    public QReview(String variable) {
        super(Review.class, forVariable(variable));
    }

    public QReview(Path<? extends Review> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReview(PathMetadata metadata) {
        super(Review.class, metadata);
    }

}

