/*
 * This file is generated by jOOQ.
 */
package com.example.read;


import com.example.read.tables.Projections;
import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index IDX_STREAM = Internal.createIndex(DSL.name("idx_stream"), Projections.PROJECTIONS, new OrderField[] { Projections.PROJECTIONS.AR_NAME, Projections.PROJECTIONS.STREAM_NAME }, false);
}
