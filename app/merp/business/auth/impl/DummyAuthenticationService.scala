package merp.business.auth.impl

import javax.inject._

import scala.concurrent.Future

import merp.business.auth._
import merp.utils.AsyncEnabled
import merp.business.utils.ExecutionContexts



class DummyAuthenticationServiceImpl @Inject() (ec: ExecutionContexts) extends AsyncEnabled(ec) with AuthenticationService {

    
    lazy val SESSION_MAP: Map[String, String] = Map()
    
    
    override def loadSessionForUser(userEmail: String): Future[Option[String]] = { 
        Future.successful( SESSION_MAP.get(userEmail) )
    }
    
    override def authenticate(userEmail: String, passwrd: String): Future[String] = Future.successful( this.createSessionToken )
    
    override def disconect(userEmail: String): Future[Int] = Future.successful(1)
}