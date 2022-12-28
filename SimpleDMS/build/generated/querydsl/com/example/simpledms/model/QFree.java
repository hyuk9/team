package com.example.simpledms.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFree is a Querydsl query type for Free
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFree extends EntityPathBase<Free> {

    private static final long serialVersionUID = -1395378408L;

    public static final QFree free = new QFree("free");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final StringPath deleteTime = _super.deleteTime;

    //inherited
    public final StringPath deleteYn = _super.deleteYn;

    public final NumberPath<Integer> fno = createNumber("fno", Integer.class);

    public final ArrayPath<byte[], Byte> galleryData = createArray("galleryData", byte[].class);

    public final StringPath galleryFileName = createString("galleryFileName");

    public final StringPath galleryTitle = createString("galleryTitle");

    public final StringPath galleryType = createString("galleryType");

    //inherited
    public final StringPath insertTime = _super.insertTime;

    public final StringPath title = createString("title");

    //inherited
    public final StringPath updateTime = _super.updateTime;

    public final StringPath writer = createString("writer");

    public QFree(String variable) {
        super(Free.class, forVariable(variable));
    }

    public QFree(Path<? extends Free> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFree(PathMetadata metadata) {
        super(Free.class, metadata);
    }

}

