/*
 * This file is generated by jOOQ.
 */
package com.example.read;


import com.example.read.tables.CustomerSummary;
import com.example.read.tables.Projections;
import com.example.read.tables.records.CustomerSummaryRecord;
import com.example.read.tables.records.ProjectionsRecord;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in 
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CustomerSummaryRecord> CUSTOMER_SUMMARY_PKEY = Internal.createUniqueKey(CustomerSummary.CUSTOMER_SUMMARY, DSL.name("customer_summary_pkey"), new TableField[] { CustomerSummary.CUSTOMER_SUMMARY.ID }, true);
    public static final UniqueKey<ProjectionsRecord> PROJECTIONS_PKEY = Internal.createUniqueKey(Projections.PROJECTIONS, DSL.name("projections_pkey"), new TableField[] { Projections.PROJECTIONS.AR_NAME, Projections.PROJECTIONS.STREAM_NAME }, true);
}
