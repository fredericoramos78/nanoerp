package merp.controllers


import javax.inject._

import scala.concurrent._
import play.api.mvc._
import play.api.Configuration
import play.api.libs.json._
import akka.actor.ActorSystem
import scala.concurrent.ExecutionContext

import merp.utils.MERPLogger
import scala.util.Random
import java.security.MessageDigest
import merp.business.auth._


@Singleton
case class MERPAction[A] @Inject() (configuration: Configuration, system: ActorSystem)(action: Action[A])(implicit context: ExecutionContext) 
    extends Action[A] 
    with MERPLogger {
  
    lazy val parser = action.parser

    override def apply(request: Request[A]): Future[Result] = {
        action(request)
    }
}


@Singleton
case class MERPSecureAction[A] @Inject() (configuration: Configuration, system: ActorSystem, authService: AuthenticationService)
    (action: Action[A])(implicit context: ExecutionContext) 
    extends Action[A] 
    with MERPLogger {
  
    import MERPSecureAction._
    
    lazy val parser = action.parser
    
    override def apply(request: Request[A]): Future[Result] = {
        // USER_KEY header must exist
        request.headers.get(USER_KEY) map { userEmail =>
            // also should exist SESSION_KEY header
            request.headers.get(SESSION_KEY) map { cryptedSession =>
                // the user in session should be have an authentication record in the database
                authService.loadSessionForUser(userEmail) map { maybeSessionId => 
                        maybeSessionId.map { sessionId =>
                            // and the session saved in the authentication record should match the on in the request, considering the
                            //   encryption formula defined below. Otherwise we return a HTTP UNAUTHORIZED response. 
                            if (cryptedSession.equals(authService.cryptSession(userEmail, sessionId))) { action(request) }
                        }
                } recover { 
                    case ex: Throwable => LOGGER.error("Could not check the authentication for this request:", ex) 
                }
            }
        } 
        Future.successful( Results.Unauthorized )
    }
}


object MERPSecureAction {
    
    final val USER_KEY = "merp.user.email"
    final val SESSION_KEY = "merp.user.session"
}