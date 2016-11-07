package merp.business.catalog

import javax.inject._
import scala.concurrent.Future
import merp.model.catalog._
import merp.business.utils.ExecutionContexts
import merp.utils.AsyncEnabled


abstract class CustomerService @Inject() (repository: CustomerRepository, ec: ExecutionContexts) extends AsyncEnabled(ec){
    
    implicit val threadpool = ec.repos
    
    def listByFilter(criteria: Option[String] = None, offset: Int, length: Int): Future[Iterable[Customer]] = Future {
        repository.selectBy(criteria, offset, length)
    }
    
     def countByFilter(criteria: Option[String] = None): Future[Int] = Future { repository.countBy(criteria) }
}

class CustomerServiceImpl @Inject() (repository: CustomerRepository, ec: ExecutionContexts) extends CustomerService(repository, ec)


trait CustomerRepository {
  
    def selectBy(criteria: Option[String], offset: Int, length: Int): Iterable[Customer]
    def countBy(criteria: Option[String]): Int
}