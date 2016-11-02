package merp.business.catalog.impl

import merp.business.catalog.CustomerRepository
import merp.model.catalog._

class DummyCustomerRepository extends CustomerRepository {
  
    def selectBy(criteria: String, offset: Int, length: Int): Iterable[Customer] =
      Seq( Customer("Customer #1", "11.111.111/0001-11", Address("Lancaster #1 street", "1001", null, "London", null, "UK")), 
           Customer("Customer #2", "11.111.111/0001-22", Address("Lancaster #2 street", "1002", null, "London", null, "UK")),
           Customer("Customer #3", "11.111.111/0001-33", Address("Lancaster #3 street", "1003", null, "London", null, "UK")),
           Customer("Customer #4", "11.111.111/0001-44", Address("Lancaster #4 street", "1004", null, "London", null, "UK")) )
}