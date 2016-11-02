package merp.model.catalog

import play.api.libs.json.Json


object Address {
    implicit val JSON_READER = Json.reads[Address]
    implicit val JSON_WRITER = Json.writes[Address]
}

case class Address(street: String, number: String, complement: String, city: String, state: String, country: String) {
    override def toString() = s"$${number} {street} - ${city}, ${country}"
}