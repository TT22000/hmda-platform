package hmda.serialization.submission

import java.io.NotSerializableException

import akka.actor.ExtendedActorSystem
import akka.actor.typed.ActorRefResolver
import akka.actor.typed.scaladsl.adapter._
import akka.serialization.SerializerWithStringManifest
import hmda.messages.submission.HmdaRawDataCommands.AddLine
import hmda.persistence.serialization.raw.data.commands.AddLineMessage
import hmda.serialization.submission.HmdaRawDataCommandsProtobufConverter._
// $COVERAGE-OFF$
class HmdaRawDataCommandsSerializer(system: ExtendedActorSystem) extends SerializerWithStringManifest {

  private val resolver = ActorRefResolver(system.toTyped)

  override def identifier: Int = 115

  final val AddLineManifest = classOf[AddLine].getName

  override def manifest(o: AnyRef): String = o.getClass.getName

  override def toBinary(o: AnyRef): Array[Byte] = o match {
    case cmd: AddLine =>
      addLineToProtobuf(cmd, resolver).toByteArray
    case _ =>
      throw new IllegalArgumentException(s"Cannot serialize object of type [${o.getClass.getName}]")
  }

  override def fromBinary(bytes: Array[Byte], manifest: String): AnyRef =
    manifest match {
      case AddLineManifest =>
        addLineFromProtobuf(AddLineMessage.parseFrom(bytes), resolver)
      case _ =>
        throw new NotSerializableException(s"Unimplemented deserialization of message with manifest [$manifest] in [${getClass.getName}]")
    }
}
// $COVERAGE-ON$