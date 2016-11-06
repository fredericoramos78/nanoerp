package merp.controllers.api.utils


import play.api.libs.json._


case class DatatablesPost(draw: Int, start: Int, length: Int)

object DatatablesPost {
    implicit val LIST_READER = Json.reads[DatatablesPost]
    
    
    def prepareResponse(draw: Int, total: Int, selected: Int, data: JsValue): JsValue =
        Json.obj("draw" -> draw,
                 "recordsTotal" -> total,
                 "recordsFiltered" -> selected,
                 "data" -> data)
}
