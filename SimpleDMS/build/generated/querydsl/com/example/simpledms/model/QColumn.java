package com.example.simpledms.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QColumn is a Querydsl query type for Column
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QColumn extends EntityPathBase<Column> {

    private static final long serialVersionUID = -1017284350L;

    public static final QColumn column = new QColumn("column");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final NumberPath<Integer> cid = createNumber("cid", Integer.class);

    public final StringPath columnContent = createString("columnContent");

    public final StringPath columnPhoto = createString("columnPhoto");

    public final StringPath columnTitle = createString("columnTitle");

    public final StringPath columnWriter = createString("columnWriter");

    //inherited
    public final StringPath deleteTime = _super.deleteTime;

    //inherited
    public final StringPath deleteYn = _super.deleteYn;

    //inherited
    public final StringPath insertTime = _super.insertTime;

    //inherited
    public final StringPath updateTime = _super.updateTime;

    public QColumn(String variable) {
        super(Column.class, forVariable(variable));
    }

    public QColumn(Path<? extends Column> path) {
        super(path.getType(), path.getMetadata());
    }

    public QColumn(PathMetadata metadata) {
        super(Column.class, metadata);
    }

}

