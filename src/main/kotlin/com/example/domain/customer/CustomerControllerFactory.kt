package com.example.domain.customer

import io.github.crabzilla.core.CommandController
import io.github.crabzilla.pgc.CommandControllerFactory
import io.github.crabzilla.pgc.PgcEventsPublisher
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.context.annotation.Factory
import io.vertx.core.Vertx
import io.vertx.pgclient.PgConnectOptions
import io.vertx.pgclient.PgPool
import io.vertx.sqlclient.PoolOptions
import javax.inject.Named
import javax.inject.Singleton

@Factory
class CustomerControllerFactory {

    @Bean
    fun controller(@Named("writeDb") writeDb: PgPool): CommandController<Customer, CustomerCommand, CustomerEvent> {
        return CommandControllerFactory.create(customerConfig, writeDb)
    }

    @Bean
    fun repo(@Named("readDb") readDb: PgPool): CustomerRepository {
        return CustomerRepository(readDb)
    }

    @Bean
    fun readModelProjector(repository: CustomerRepository): CustomerReadModelProjector {
        return CustomerReadModelProjector(repository)
    }

    @Bean
    fun publisher(projector: CustomerReadModelProjector, @Named("writeDb") writeDb: PgPool):
            PgcEventsPublisher<CustomerEvent> {
        return PgcEventsPublisher(projector, customerConfig.name.value, writeDb, customerJson)
    }

    @Singleton
    @Named("writeDb")
    fun writeDb(vertx: Vertx, config: WriteDbConfig): PgPool {
        val readOptions = PgConnectOptions()
                .setPort(config.port!!)
                .setHost(config.host)
                .setDatabase(config.dbName)
                .setUser(config.dbUser)
                .setPassword(config.dbPassword)
        val pgPoolOptions = PoolOptions().setMaxSize(config.poolSize)
        return PgPool.pool(vertx, readOptions, pgPoolOptions)
    }

    @Singleton
    @Named("readDb")
    fun readDb(vertx: Vertx, config: ReadDbConfig): PgPool {
        val readOptions = PgConnectOptions()
                .setPort(config.port!!)
                .setHost(config.host)
                .setDatabase(config.dbName)
                .setUser(config.dbUser)
                .setPassword(config.dbPassword)
        val pgPoolOptions = PoolOptions().setMaxSize(config.poolSize)
        return PgPool.pool(vertx, readOptions, pgPoolOptions)
    }

}

@ConfigurationProperties("write.database")
class WriteDbConfig  {
    var host: String? = "0.0.0.0"
    var port: Int? = 5432
    var dbName: String? = "example1_write"
    var dbUser: String? = "user1"
    var dbPassword: String? = "pwd1"
    var poolSize: Int = 7
}

@ConfigurationProperties("read.database")
class ReadDbConfig  {
    var host: String? = "0.0.0.0"
    var port: Int? = 5432
    var dbName: String? = "example1_read"
    var dbUser: String? = "user1"
    var dbPassword: String? = "pwd1"
    var poolSize: Int = 7
}