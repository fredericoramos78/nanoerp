package merp.controllers

import javax.inject._
import play.api.mvc._
import play.api.cache._
import play.api.i18n._
import play.api.routing._

import org.webjars.play.RequireJS
import jsmessages.JsMessagesFactory
import controllers.WebJarAssets


@Singleton
class IndexController @Inject() (webJarAssets: WebJarAssets, val messagesApi: MessagesApi, jsMessagesFactory: JsMessagesFactory) 
    extends Controller with I18nSupport {

    
    def index = Action { 
        Ok(views.html.skel(webJarAssets))
    }
    
        def start(path: String) = Action {
        Ok(views.html.skel(webJarAssets))
    }
        
    def jsMessages = Action { 
      val jsMessages = jsMessagesFactory.all
      Ok(jsMessages(Some("window.Messages")))
    }
    
    
   /**
     * Retrieves all routes via reflection.
     * http://stackoverflow.com/questions/12012703/less-verbose-way-of-generating-play-2s-javascript-router
     * If you have controllers in multiple packages, you need to add each package here.
     */
    val routeCache: Seq[JavaScriptReverseRoute] = {
        Seq(
            //classOf[merp.controllers.api.routes.javascript],
            classOf[routes.javascript],
            classOf[merp.controllers.api.catalog.routes.javascript]
        ).flatMap { jsRoutesClass =>
            val controllers = jsRoutesClass.getFields.map(_.get(null))
            controllers.flatMap { controller =>
                controller.getClass.getDeclaredMethods
                    .filter( action => action.getReturnType.isAssignableFrom(classOf[JavaScriptReverseRoute]) )
                    .map( action => action.invoke(controller).asInstanceOf[JavaScriptReverseRoute] )
            }
        }
    }

    /**
     * Returns the JavaScript router that the client can use for "type-safe" routes.
     * Uses browser caching; set duration (in seconds) according to your release cycle.
     *
     * @param varName The name of the global variable, defaults to `jsRoutes`
     */
    def jsRoutes(varName: String = "jsRoutes") = {
        Action { implicit request =>
            Ok(JavaScriptReverseRouter(varName)(routeCache: _*)).as(JAVASCRIPT)
        }
    }    
    
    
    //
    // routes for all views
    //
    def displayView(templateName: String) = Action { 
        templateName match {
            case "home/landing" => Ok(views.html.app.home.landing())
            case "customers/listing" => Ok(views.html.app.catalog.customer.list())
            case "po/listing" => Ok(views.html.app.finance.po.list())
            case "payment/listing" => Ok(views.html.app.finance.payment.list())
            case "invoice/listing" => Ok(views.html.app.finance.invoice.list())
            case _ => NotFound
        } 
    }
}