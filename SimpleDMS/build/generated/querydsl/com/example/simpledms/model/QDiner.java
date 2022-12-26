package com.example.simpledms.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QDiner is a Querydsl query type for Diner
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDiner extends EntityPathBase<Diner> {

    private static final long serialVersionUID = -309164086L;

    public static final QDiner diner = new QDiner("diner");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    //inherited
    public final StringPath deleteTime = _super.deleteTime;

    //inherited
    public final StringPath deleteYn = _super.deleteYn;

    public final StringPath dname = createString("dname");

    public final NumberPath<Integer> dno = createNumber("dno", Integer.class);

    //inherited
    public final StringPath insertTime = _super.insertTime;

    public final StringPath loc = createString("loc");

    public final StringPath menu = createString("menu");

    public final StringPath phone = createString("phone");

    public final StringPath photo = createString("photo");

    public final StringPath review = createString("review");

    public final StringPath score = createString("score");

    public final StringPath theme = createString("theme");

    //inherited
    public final StringPath updateTime = _super.updateTime;

    public QDiner(String variable) {
        super(Diner.class, forVariable(variable));
    }

    public QDiner(Path<? extends Diner> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDiner(PathMetadata metadata) {
        super(Diner.class, metadata);
    }

}

