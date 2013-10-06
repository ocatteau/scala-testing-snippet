package fr.stateofmind.scala.dojo


/**
 * Email address object
 * @param address a __valid__ email address
 */
case class Email(address: String) {
  private val matcher = """([\w\.]+)@([\w\.]+)""".r.pattern.matcher(address)
  if (!matcher.matches()) {
    throw new IllegalArgumentException(s"Invalid address : $address")
  }
}

object Email {

  implicit def stringToEmail(address: String) : Email = Email(address)

}