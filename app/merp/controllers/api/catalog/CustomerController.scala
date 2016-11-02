package merp.controllers.api.catalog


import javax.inject._
import scala.concurrent.Future
import play.api.mvc._
import play.api.libs.json.Json
import play.api.i18n._

import jsmessages.JsMessagesFactory
import controllers.WebJarAssets
import org.webjars.play.RequireJS

import merp.controllers.api.utils.Paginator
import merp.business.catalog.CustomerService
import merp.business.utils.ExecutionContexts
import merp.utils.AsyncEnabled


class CustomerController @Inject() (webJarAssets: WebJarAssets, requireJS: RequireJS, val messagesApi: MessagesApi, 
                                    jsMessagesFactory: JsMessagesFactory, customerService: CustomerService, ec: ExecutionContexts) 
    extends AsyncEnabled(ec) with Controller with I18nSupport { 
  
    implicit val threadpool = ec.services
  
    case class ListFilter(filterBy: String, offset: Int, pageSize: Int) extends Paginator(offset, pageSize)
    implicit val LISTFILTER_READER = Json.reads[ListFilter]
    
    def list = Action.async(parse.json) { request =>
        request.body.validate[ListFilter].map { form =>
            customerService.listByFilter(form.filterBy, form.offset, form.pageSize) map { case result =>
                Results.Ok(Json.obj("result" -> result.toSeq))
            } recover {
                case ex: Exception => BadRequest(ex.toString()) 
            }
        } recoverTotal { case error => Future.successful(BadRequest(error.toString())) }
    }
}