package merp.business.catalog

import javax.inject._
import scala.concurrent.Future
import merp.model.catalog._
import merp.business.utils.ExecutionContexts
import merp.utils.AsyncEnabled


abstract class CustomerService @Inject() (repository: CustomerRepository, ec: ExecutionContexts) extends AsyncEnabled(ec){
    
    implicit val threadpool = ec.repos
    
    def listByFilter(criteria: String, offset: Int, length: Int): Future[Iterable[Customer]] = Future {
        repository.selectBy(criteria, offset, length)
    }
}

class CustomerServiceImpl @Inject() (repository: CustomerRepository, ec: ExecutionContexts) extends CustomerService(repository, ec)


trait CustomerRepository {
  
    def selectBy(criteria: String, offset: Int, length: Int): Iterable[Customer]
}