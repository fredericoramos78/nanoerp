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
import merp.model.catalog._
import merp.business.utils.ExecutionContexts
import merp.controllers.api.utils.DatatablesPost
import merp.utils.AsyncEnabled


class CustomerController @Inject() (webJarAssets: WebJarAssets, requireJS: RequireJS, val messagesApi: MessagesApi, 
                                    jsMessagesFactory: JsMessagesFactory, customerService: CustomerService, ec: ExecutionContexts) 
    extends AsyncEnabled(ec) with Controller with I18nSupport { 
  
    implicit val threadpool = ec.services
    
    def list = Action.async(parse.json) { request =>
        request.body.validate[DatatablesPost].map { form =>
            for ( total <- customerService.countByFilter(None);
                  selected <- customerService.countByFilter(None);
                  data <- customerService.listByFilter(None, form.start, form.length)
                ) yield {
                    var dataAsJson = Json.toJson(data.toList)(Customer.JSON_LIST_FORMATTER)
                    Results.Ok( DatatablesPost.prepareResponse(form.draw, total, selected, dataAsJson) )
                }
        } recoverTotal { case error => Future.successful(BadRequest(error.toString())) }
    }
}