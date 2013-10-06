package fr.stateofmind.scala.dojo

object ScalaApp {

  def main(args: Array[String]) {

    val user: User = new User("ocatteau@gmail.com")
    val someUser: Option[User] = Some(user)
    someUser.map((user: User) => println("Email : %s".format(user.email)))

    print(
      """
        |toto \ titi \n
        |pouet
      """.stripMargin)
  }
}
