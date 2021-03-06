/*
 * This file is generated by jOOQ.
 */
package com.example.read.tables;


import com.example.read.Indexes;
import com.example.read.Keys;
import com.example.read.Public;
import com.example.read.tables.records.ProjectionsRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Projections extends TableImpl<ProjectionsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.projections</code>
     */
    public static final Projections PROJECTIONS = new Projections();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ProjectionsRecord> getRecordType() {
        return ProjectionsRecord.class;
    }

    /**
     * The column <code>public.projections.ar_name</code>.
     */
    public final TableField<ProjectionsRecord, String> AR_NAME = createField(DSL.name("ar_name"), SQLDataType.VARCHAR(36).nullable(false), this, "");

    /**
     * The column <code>public.projections.stream_name</code>.
     */
    public final TableField<ProjectionsRecord, String> STREAM_NAME = createField(DSL.name("stream_name"), SQLDataType.VARCHAR(36).nullable(false), this, "");

    /**
     * The column <code>public.projections.last_uow</code>.
     */
    public final TableField<ProjectionsRecord, Integer> LAST_UOW = createField(DSL.name("last_uow"), SQLDataType.INTEGER, this, "");

    private Projections(Name alias, Table<ProjectionsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Projections(Name alias, Table<ProjectionsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.projections</code> table reference
     */
    public Projections(String alias) {
        this(DSL.name(alias), PROJECTIONS);
    }

    /**
     * Create an aliased <code>public.projections</code> table reference
     */
    public Projections(Name alias) {
        this(alias, PROJECTIONS);
    }

    /**
     * Create a <code>public.projections</code> table reference
     */
    public Projections() {
        this(DSL.name("projections"), null);
    }

    public <O extends Record> Projections(Table<O> child, ForeignKey<O, ProjectionsRecord> key) {
        super(child, key, PROJECTIONS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.IDX_STREAM);
    }

    @Override
    public UniqueKey<ProjectionsRecord> getPrimaryKey() {
        return Keys.PROJECTIONS_PKEY;
    }

    @Override
    public List<UniqueKey<ProjectionsRecord>> getKeys() {
        return Arrays.<UniqueKey<ProjectionsRecord>>asList(Keys.PROJECTIONS_PKEY);
    }

    @Override
    public Projections as(String alias) {
        return new Projections(DSL.name(alias), this);
    }

    @Override
    public Projections as(Name alias) {
        return new Projections(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Projections rename(String name) {
        return new Projections(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Projections rename(Name name) {
        return new Projections(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<String, String, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
