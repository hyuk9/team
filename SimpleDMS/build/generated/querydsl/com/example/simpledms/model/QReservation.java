package com.example.simpledms.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QReservation is a Querydsl query type for Reservation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReservation extends EntityPathBase<Reservation> {

    private static final long serialVersionUID = 647448992L;

    public static final QReservation reservation = new QReservation("reservation");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    //inherited
    public final StringPath deleteTime = _super.deleteTime;

    //inherited
    public final StringPath deleteYn = _super.deleteYn;

    //inherited
    public final StringPath insertTime = _super.insertTime;

    public final StringPath phone = createString("phone");

    public final StringPath rcount = createString("rcount");

    public final StringPath reservationDate = createString("reservationDate");

    public final StringPath reservationTime = createString("reservationTime");

    public final StringPath restaurant = createString("restaurant");

    public final NumberPath<Integer> rid = createNumber("rid", Integer.class);

    public final StringPath rname = createString("rname");

    //inherited
    public final StringPath updateTime = _super.updateTime;

    public QReservation(String variable) {
        super(Reservation.class, forVariable(variable));
    }

    public QReservation(Path<? extends Reservation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReservation(PathMetadata metadata) {
        super(Reservation.class, metadata);
    }

}

