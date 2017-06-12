package hmda.api.model

import hmda.census.model.{ MsaSummary, Msa }
import hmda.persistence.PaginatedResource

case class Irs(msas: Seq[Msa]) {

  def paginatedResponse(page: Int, path: String): IrsResponse = {
    val total = msas.size
    val p = PaginatedResource(total)(page)
    val pageOfMsas = msas.slice(p.fromIndex, p.toIndex)
    val summary = MsaSummary.fromMsaCollection(msas)
    IrsResponse(pageOfMsas.toList, summary, path, page, total)
  }

}

case class IrsResponse(
  msas: List[Msa],
  summary: MsaSummary,
  path: String,
  currentPage: Int,
  total: Int
) extends PaginatedResponse

/* When converted to JSON, IrsResponse has this format:

IrsResponse(
  msas: List[Msa],
  summary: MsaSummary,
  count: Int,
  total: Int,
  _links: PaginatedLinks)

This happens in MsaProtocol.scala */