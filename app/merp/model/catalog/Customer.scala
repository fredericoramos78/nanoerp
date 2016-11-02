package merp.model.catalog

import play.api.libs.json._

object Customer {
    implicit val JSON_READER = Json.reads[Customer]
    implicit val JSON_WRITER = Json.writes[Customer]
    implicit val JSON_LIST_WRITER = Writes.list(JSON_WRITER)
  
}

case class Customer(name: String, taxId: String, address: Address)