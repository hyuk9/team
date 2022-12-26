package com.example.simpledms.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAnnounce is a Querydsl query type for Announce
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAnnounce extends EntityPathBase<Announce> {

    private static final long serialVersionUID = 1616084757L;

    public static final QAnnounce announce = new QAnnounce("announce");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final NumberPath<Integer> ano = createNumber("ano", Integer.class);

    public final StringPath content = createString("content");

    //inherited
    public final StringPath deleteTime = _super.deleteTime;

    //inherited
    public final StringPath deleteYn = _super.deleteYn;

    //inherited
    public final StringPath insertTime = _super.insertTime;

    public final StringPath title = createString("title");

    //inherited
    public final StringPath updateTime = _super.updateTime;

    public final StringPath writer = createString("writer");

    public QAnnounce(String variable) {
        super(Announce.class, forVariable(variable));
    }

    public QAnnounce(Path<? extends Announce> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAnnounce(PathMetadata metadata) {
        super(Announce.class, metadata);
    }

}

