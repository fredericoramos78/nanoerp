package merp.model.catalog

import play.api.libs.json._

object Customer {
    implicit val JSON_FORMATTER = Json.format[Customer]
    implicit val JSON_LIST_FORMATTER = Format(Reads.seq(JSON_FORMATTER), Writes.seq(JSON_FORMATTER))
  
}

case class Customer(id: Long, name: String, taxId: String, address: Address)