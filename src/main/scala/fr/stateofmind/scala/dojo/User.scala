package fr.stateofmind.scala.dojo

case class User(email: Email) {

  override def toString: String = s"[Email : ${email.address}]"

}

