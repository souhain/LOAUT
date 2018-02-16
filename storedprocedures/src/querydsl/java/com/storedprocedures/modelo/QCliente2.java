package com.storedprocedures.modelo;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QCliente2 is a Querydsl query type for Cliente2
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCliente2 extends EntityPathBase<Cliente2> {

    private static final long serialVersionUID = 1405908706L;

    public static final QCliente2 cliente2 = new QCliente2("cliente2");

    public final StringPath address = createString("address");

    public final ListPath<Cuenta2, QCuenta2> cuenta2List = this.<Cuenta2, QCuenta2>createList("cuenta2List", Cuenta2.class, QCuenta2.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    public final NumberPath<Integer> idCliente2 = createNumber("idCliente2", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath phone = createString("phone");

    public QCliente2(String variable) {
        super(Cliente2.class, forVariable(variable));
    }

    public QCliente2(Path<? extends Cliente2> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCliente2(PathMetadata<?> metadata) {
        super(Cliente2.class, metadata);
    }

}

