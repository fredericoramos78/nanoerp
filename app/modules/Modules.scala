package modules

import com.google.inject.AbstractModule
import net.codingwell.scalaguice.ScalaModule
import merp.business.catalog._
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
        bind[CustomerService].to[CustomerServiceImpl]
        ()
    }
}

class DummyRepositoriesModule extends AbstractModule with ScalaModule {
    override def configure = {
        bind[CustomerRepository].to[DummyCustomerRepository]
        ()
    }
}