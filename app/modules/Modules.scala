package modules

import com.google.inject.AbstractModule
import net.codingwell.scalaguice.ScalaModule

import merp.utils.mongodb._
import merp.business.auth._
import merp.business.catalog._
import merp.business.auth.impl._
import merp.business.catalog.impl._
import merp.business.utils.ExecutionContexts


class UtilitiesModule extends AbstractModule with ScalaModule {
    override def configure = {
        bind[ExecutionContexts].asEagerSingleton()
        ()
    }
}

class ServicesModule extends AbstractModule with ScalaModule {
    override def configure = {
        bind[CustomerService].to[BaseCustomerServiceImpl]
        bind[AuthenticationService].to[DummyAuthenticationServiceImpl]
        ()
    }
}

class DummyRepositoriesModule extends AbstractModule with ScalaModule {
    override def configure = {
        bind[CustomerRepository].to[DummyCustomerRepository]
        ()
    }
}

class MongoRepositoriesModule extends AbstractModule with ScalaModule {
    override def configure = {
        bind[MongoDBHelper].to[MongoDBHelperImpl]
        bind[CustomerRepository].to[MongoCustomerRepository]
        ()
    }
}