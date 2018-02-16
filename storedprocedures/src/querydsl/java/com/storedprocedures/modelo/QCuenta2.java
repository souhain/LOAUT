package com.storedprocedures.modelo;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QCuenta2 is a Querydsl query type for Cuenta2
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCuenta2 extends EntityPathBase<Cuenta2> {

    private static final long serialVersionUID = 161046080L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCuenta2 cuenta2 = new QCuenta2("cuenta2");

    public final QCliente2 cliente2IdCliente2;

    public final StringPath ejecutiveEmail = createString("ejecutiveEmail");

    public final NumberPath<Integer> idCuenta2 = createNumber("idCuenta2", Integer.class);

    public final NumberPath<Long> saldo = createNumber("saldo", Long.class);

    public QCuenta2(String variable) {
        this(Cuenta2.class, forVariable(variable), INITS);
    }

    public QCuenta2(Path<? extends Cuenta2> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCuenta2(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCuenta2(PathMetadata<?> metadata, PathInits inits) {
        this(Cuenta2.class, metadata, inits);
    }

    public QCuenta2(Class<? extends Cuenta2> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cliente2IdCliente2 = inits.isInitialized("cliente2IdCliente2") ? new QCliente2(forProperty("cliente2IdCliente2")) : null;
    }

}

