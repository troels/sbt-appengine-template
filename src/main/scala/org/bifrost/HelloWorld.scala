package org.bifrost

import java.io.File
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}
import org.bifrost.counterfeiter.Counterfeiter


class HelloWorld extends HttpServlet {
  override def doGet(request: HttpServletRequest, response: HttpServletResponse) {
    response.setContentType("text/html")
    Data.writeExample()
    response.getWriter.println(Templates.counterfeiter.renderTemplate(
      "Main.testpage"))
    response.getWriter.println("Hello" + Data.readExample)
  }
}

object Templates {
  def counterfeiter = Counterfeiter.loadFromDir(
    new File(getClass.getClassLoader.getResource("templates").getFile))
}

