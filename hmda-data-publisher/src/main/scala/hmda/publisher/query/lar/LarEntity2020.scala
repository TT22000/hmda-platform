package hmda.publisher.query.lar

import hmda.model.publication.Msa
import hmda.util.conversion.ColumnDataFormatter
import io.chrisdavenport.cormorant
import io.chrisdavenport.cormorant.implicits._
import cormorant.generic.semiauto._
import hmda.publisher.query.lar.LarEntityImpl2020WithMsa.{enforcePartialRead, readNext}
import hmda.util.PsvParsingCompanion
import io.chrisdavenport.cormorant.CSV
// $COVERAGE-OFF$
case class LarPartOne2020(
                           id: Int = 0,
                           lei: String = "",
                           uli: String = "",
                           applicationDate: String = "",
                           loanType: Int = 0,
                           loanPurpose: Int = 0,
                           preapproval: Int = 0,
                           constructionMethod: Int = 0,
                           occupancyType: Int = 0,
                           loanAmount: Double = 0.0,
                           actionTakenType: Int = 0,
                           actionTakenDate: Int = 0,
                           street: String = "",
                           city: String = "",
                           state: String = "",
                           zip: String = "",
                           county: String = "",
                           tract: String = ""
                         ) {
  def isEmpty: Boolean = lei == ""

  def toRegulatorPSV: String =
    s"$id|$lei|$uli|$applicationDate|$loanType|" +
      s"$loanPurpose|$preapproval|$constructionMethod|$occupancyType|" +
      BigDecimal.valueOf(loanAmount).bigDecimal.toPlainString +
      s"|$actionTakenType|$actionTakenDate|$street|$city|$state|" +
      s"$zip|$county|$tract|"
}

object LarPartOne2020 extends PsvParsingCompanion[LarPartOne2020] {
  override val psvReader: cormorant.Read[LarPartOne2020] = cormorant.generic.semiauto.deriveRead
}

case class LarPartTwo2020(
                           ethnicityApplicant1: String = "",
                           ethnicityApplicant2: String = "",
                           ethnicityApplicant3: String = "",
                           ethnicityApplicant4: String = "",
                           ethnicityApplicant5: String = "",
                           otherHispanicApplicant: String = "",
                           ethnicityCoApplicant1: String = "",
                           ethnicityCoApplicant2: String = "",
                           ethnicityCoApplicant3: String = "",
                           ethnicityCoApplicant4: String = "",
                           ethnicityCoApplicant5: String = "",
                           otherHispanicCoApplicant: String = "",
                           ethnicityObservedApplicant: Int = 0,
                           ethnicityObservedCoApplicant: Int = 0,
                           raceApplicant1: String = "",
                           raceApplicant2: String = "",
                           raceApplicant3: String = "",
                           raceApplicant4: String = "",
                           raceApplicant5: String = ""
                         ) {

  def toRegulatorPSV: String =
    s"$ethnicityApplicant1|$ethnicityApplicant2|$ethnicityApplicant3|" +
      s"$ethnicityApplicant4|$ethnicityApplicant5|$otherHispanicApplicant|$ethnicityCoApplicant1|" +
      s"$ethnicityCoApplicant2|$ethnicityCoApplicant3|$ethnicityCoApplicant4|$ethnicityCoApplicant5|" +
      s"$otherHispanicCoApplicant|$ethnicityObservedApplicant|$ethnicityObservedCoApplicant|$raceApplicant1" +
      s"|$raceApplicant2|$raceApplicant3|$raceApplicant4|$raceApplicant5|"

}

object LarPartTwo2020 extends PsvParsingCompanion[LarPartTwo2020] {
  override val psvReader: cormorant.Read[LarPartTwo2020] = cormorant.generic.semiauto.deriveRead
}

case class LarPartThree2020(
                             otherNativeRaceApplicant: String = "",
                             otherAsianRaceApplicant: String = "",
                             otherPacificRaceApplicant: String = "",
                             raceCoApplicant1: String = "",
                             raceCoApplicant2: String = "",
                             raceCoApplicant3: String = "",
                             raceCoApplicant4: String = "",
                             raceCoApplicant5: String = "",
                             otherNativeRaceCoApplicant: String = "",
                             otherAsianRaceCoApplicant: String = "",
                             otherPacificRaceCoApplicant: String = "",
                             raceObservedApplicant: Int = 0,
                             raceObservedCoApplicant: Int = 0,
                             sexApplicant: Int = 0,
                             sexCoApplicant: Int = 0,
                             observedSexApplicant: Int = 0,
                             observedSexCoApplicant: Int = 0,
                             ageApplicant: Int = 0,
                             ageCoApplicant: Int = 0,
                             income: String = ""
                           ) {

  def toRegulatorPSV: String =
    s"$otherNativeRaceApplicant|" +
      s"$otherAsianRaceApplicant|$otherPacificRaceApplicant|$raceCoApplicant1|$raceCoApplicant2|" +
      s"$raceCoApplicant3|$raceCoApplicant4|$raceCoApplicant5|$otherNativeRaceCoApplicant|" +
      s"$otherAsianRaceCoApplicant|$otherPacificRaceCoApplicant|$raceObservedApplicant|" +
      s"$raceObservedCoApplicant|$sexApplicant|$sexCoApplicant|$observedSexApplicant|$observedSexCoApplicant|" +
      s"$ageApplicant|$ageCoApplicant|$income|"

}

object LarPartThree2020 extends PsvParsingCompanion[LarPartThree2020] {
  override val psvReader: cormorant.Read[LarPartThree2020] = cormorant.generic.semiauto.deriveRead
}

case class LarPartFour2020(
                            purchaserType: Int = 0,
                            rateSpread: String = "",
                            hoepaStatus: Int = 0,
                            lienStatus: Int = 0,
                            creditScoreApplicant: Int = 0,
                            creditScoreCoApplicant: Int = 0,
                            creditScoreTypeApplicant: Int = 0,
                            creditScoreModelApplicant: String = "",
                            creditScoreTypeCoApplicant: Int = 0,
                            creditScoreModelCoApplicant: String = "",
                            denialReason1: String = "",
                            denialReason2: String = "",
                            denialReason3: String = "",
                            denialReason4: String = "",
                            otherDenialReason: String = "",
                            totalLoanCosts: String = "",
                            totalPoints: String = "",
                            originationCharges: String = ""
                          ) {

  def toRegulatorPSV: String =
    s"$purchaserType|$rateSpread|$hoepaStatus|$lienStatus|" +
      s"$creditScoreApplicant|$creditScoreCoApplicant|$creditScoreTypeApplicant|$creditScoreModelApplicant|" +
      s"$creditScoreTypeCoApplicant|$creditScoreModelCoApplicant|" +
      s"$denialReason1|$denialReason2|$denialReason3|$denialReason4|" +
      s"$otherDenialReason|$totalLoanCosts|$totalPoints|$originationCharges|"

}

object LarPartFour2020 extends PsvParsingCompanion[LarPartFour2020] {
  override val psvReader: cormorant.Read[LarPartFour2020] = cormorant.generic.semiauto.deriveRead
}

case class LarPartFive2020(
                            discountPoints: String = "",
                            lenderCredits: String = "",
                            interestRate: String = "",
                            paymentPenalty: String = "",
                            debtToIncome: String = "",
                            loanValueRatio: String = "",
                            loanTerm: String = "",
                            rateSpreadIntro: String = "",
                            baloonPayment: Int = 0,
                            insertOnlyPayment: Int = 0,
                            amortization: Int = 0,
                            otherAmortization: Int = 0,
                            propertyValue: String = "",
                            homeSecurityPolicy: Int = 0,
                            landPropertyInterest: Int = 0,
                            totalUnits: Int = 0,
                            mfAffordable: String = "",
                            applicationSubmission: Int = 0
                          ) extends ColumnDataFormatter {

  def toRegulatorPSV: String =
    s"$discountPoints|$lenderCredits|$interestRate|$paymentPenalty|$debtToIncome|$loanValueRatio|$loanTerm|" +
      s"$rateSpreadIntro|$baloonPayment|$insertOnlyPayment|$amortization|$otherAmortization|" +
      toBigDecimalString(propertyValue) + "|" +
      s"$homeSecurityPolicy|$landPropertyInterest|$totalUnits|$mfAffordable|$applicationSubmission|"

}

object LarPartFive2020 extends PsvParsingCompanion[LarPartFive2020] {
  override val psvReader: cormorant.Read[LarPartFive2020] = cormorant.generic.semiauto.deriveRead
}

case class LarPartSix2020(
                           payable: Int = 0,
                           nmls: String = "",
                           aus1: String = "",
                           aus2: String = "",
                           aus3: String = "",
                           aus4: String = "",
                           aus5: String = "",
                           otheraus: String = "",
                           aus1Result: Int = 0,
                           aus2Result: String = "",
                           aus3Result: String = "",
                           aus4Result: String = "",
                           aus5Result: String = "",
                           otherAusResult: String = "",
                           reverseMortgage: Int = 0,
                           lineOfCredits: Int = 0,
                           businessOrCommercial: Int = 0
                         ) {

  def toRegulatorPSV: String =
    s"$payable|" +
      s"$nmls|$aus1|$aus2|$aus3|$aus4|$aus5|$otheraus|$aus1Result|$aus2Result|$aus3Result|$aus4Result|$aus5Result|" +
      s"$otherAusResult|$reverseMortgage|$lineOfCredits|$businessOrCommercial"
}

object LarPartSix2020 extends PsvParsingCompanion[LarPartSix2020] {
  override val psvReader: cormorant.Read[LarPartSix2020] = cormorant.generic.semiauto.deriveRead
}

case class LarPartSeven2020(
                             conformingLoanLimit: String = "",
                             ethnicityCategorization: String = "",
                             raceCategorization: String = "",
                             sexCategorization: String = "",
                             dwellingCategorization: String = "",
                             loanProductTypeCategorization: String = "",
                             tractPopulation: Int = 0,
                             tractMinorityPopulationPercent: Double = 0.0,
                             tractMedianIncome: Int = 0,
                             tractOccupiedUnits: Int = 0,
                             tractOneToFourFamilyUnits: Int = 0,
                             tractMedianAge: Int = 0,
                             tractToMsaIncomePercent: Double = 0.0
                           ) {
  def toRegulatorPSV: String =
    s"|$conformingLoanLimit|$tractPopulation|$tractMinorityPopulationPercent|$tractMedianIncome|$tractToMsaIncomePercent|$tractOccupiedUnits" +
      s"|$tractOneToFourFamilyUnits|$tractMedianAge|"
}

object LarPartSeven2020 extends PsvParsingCompanion[LarPartSeven2020] {
  override val psvReader: cormorant.Read[LarPartSeven2020] = { (a: CSV.Row) =>
    (for {
      (rest, conformingLoanLimit)            <- enforcePartialRead(readNext[String], a)
      (rest, tractPopulation)                <- enforcePartialRead(readNext[Int], rest)
      (rest, tractMinorityPopulationPercent) <- enforcePartialRead(readNext[Double], rest)
      (rest, tractMedianIncome)              <- enforcePartialRead(readNext[Int], rest)
      (rest, tractToMsaIncomePercent)        <- enforcePartialRead(readNext[Double], rest)
      (rest, tractOccupiedUnits)             <- enforcePartialRead(readNext[Int], rest)
      (rest, tractOneToFourFamilyUnits)      <- enforcePartialRead(readNext[Int], rest)
      tractMedianAgeOrMore                   <- readNext[Int].readPartial(rest)
    } yield {
      def create(tractMedianAge: Int) =
        LarPartSeven2020(
          conformingLoanLimit = conformingLoanLimit,
          tractPopulation = tractPopulation,
          tractMinorityPopulationPercent = tractMinorityPopulationPercent,
          tractMedianIncome = tractMedianIncome,
          tractToMsaIncomePercent = tractToMsaIncomePercent,
          tractOccupiedUnits = tractOccupiedUnits,
          tractOneToFourFamilyUnits = tractOneToFourFamilyUnits,
          tractMedianAge = tractMedianAge
        )
      tractMedianAgeOrMore match {
        case Left((row, tractMedianAge)) => Left(row, create(tractMedianAge))
        case Right(tractMedianAge)       => Right(create(tractMedianAge))
      }
    })
  }
}

case class LarEntityImpl2020(
                              larPartOne: LarPartOne2020 = LarPartOne2020(),
                              larPartTwo: LarPartTwo2020 = LarPartTwo2020(),
                              larPartThree: LarPartThree2020 = LarPartThree2020(),
                              larPartFour: LarPartFour2020 = LarPartFour2020(),
                              larPartFive: LarPartFive2020 = LarPartFive2020(),
                              larPartSix: LarPartSix2020 = LarPartSix2020(),
                              larPartSeven: LarPartSeven2020 = LarPartSeven2020()
                            ) {

  def toRegulatorPSV: String =
    (larPartOne.toRegulatorPSV +
      larPartTwo.toRegulatorPSV +
      larPartThree.toRegulatorPSV +
      larPartFour.toRegulatorPSV +
      larPartFive.toRegulatorPSV +
      larPartSix.toRegulatorPSV).replaceAll("(\r\n)|\r|\n", "")

  def appendMsa(msa: Msa): LarEntityImpl2020WithMsa = LarEntityImpl2020WithMsa(this, msa)

  def toRegulatorLoanLimitPSV: String =
    (larPartOne.toRegulatorPSV +
      larPartTwo.toRegulatorPSV +
      larPartThree.toRegulatorPSV +
      larPartFour.toRegulatorPSV +
      larPartFive.toRegulatorPSV +
      larPartSix.toRegulatorPSV +
      larPartSeven.toRegulatorPSV).replaceAll("(\r\n)|\r|\n", "")
}

object LarEntityImpl2020 extends PsvParsingCompanion[LarEntityImpl2020] {
  override val psvReader: cormorant.Read[LarEntityImpl2020] = { (a: CSV.Row) =>
    (for {
      (rest, p1) <- enforcePartialRead(LarPartOne2020.psvReader, a)
      (rest, p2) <- enforcePartialRead(LarPartTwo2020.psvReader, rest)
      (rest, p3) <- enforcePartialRead(LarPartThree2020.psvReader, rest)
      (rest, p4) <- enforcePartialRead(LarPartFour2020.psvReader, rest)
      (rest, p5) <- enforcePartialRead(LarPartFive2020.psvReader, rest)
      p6OrMore   <- LarPartSix2020.psvReader.readPartial(rest)
    } yield p6OrMore match {
      case Left((row, p6)) => Left(row, LarEntityImpl2020(p1, p2, p3, p4, p5, p6))
      case Right(p6)       => Right(LarEntityImpl2020(p1, p2, p3, p4, p5, p6))
    })
  }
}

case class LarEntityImpl2020WithMsa(
                                     larEntityImpl2020: LarEntityImpl2020,
                                     msa: Msa
                                   ) {
  def toRegulatorPSV: String = {
    import larEntityImpl2020._
    (larPartOne.toRegulatorPSV +
      larPartTwo.toRegulatorPSV +
      larPartThree.toRegulatorPSV +
      larPartFour.toRegulatorPSV +
      larPartFive.toRegulatorPSV +
      larPartSix.toRegulatorPSV +
      larPartSeven.toRegulatorPSV +
      s"${msa.id}|${msa.name}").replaceAll("(\r\n)|\r|\n", "")
  }
}

object LarEntityImpl2020WithMsa extends PsvParsingCompanion[LarEntityImpl2020WithMsa] {
  override val psvReader: cormorant.Read[LarEntityImpl2020WithMsa] = { (a: CSV.Row) =>
    (for {
      (rest, lar)     <- enforcePartialRead(LarEntityImpl2020.psvReader, a)
      (rest, p7)      <- enforcePartialRead(LarPartSeven2020.psvReader, rest)
      (rest, msaId)   <- enforcePartialRead(readNext[String], rest)
      msaName <- readNext[String].read(rest)
    } yield LarEntityImpl2020WithMsa(lar.copy(larPartSeven = p7), Msa(msaId, msaName))).map(Right(_))
  }
}
// $COVERAGE-ON$