import scala.collection.mutable

object validParentheses {
  def isValid(s: String): Boolean = {
    var ret = true
    var stack = List[Char]()
    for(c <- s){
      c match {
        case '(' => stack = c :: stack
        case '{' => stack = c :: stack
        case '[' => stack = c :: stack
        case ')' => if(stack.head == '(') stack = stack.drop(1) else ret = false
        case '}' => if(stack.head == '{') stack = stack.drop(1) else ret = false
        case ']' => if(stack.head == '[') stack = stack.drop(1) else ret = false
        case _ =>
      }
    }
    if(!stack.isEmpty)
      ret = false
    ret
  }

  def isValid2(s: String): Boolean = {
    val terminals = Array("()", "[]", "{}")
    s.foldLeft(List[Char]()){(a,v) => a match {
      case x :: xs if (terminals.contains("" + x + v)) => xs
      case _ => v +: a
    }}.isEmpty
  }

  def isValid3(s: String): Boolean = {
    var ret = ""
    s.foreach(c => {
      c match {
        case '(' | '{' | '[' | ')' | '}' | ']' => ret = ret + c
        case _ =>
      }
    })
    for(a <- 1 to (ret.length / 2)){
      ret = ret.replace("()","")
      ret = ret.replace("{}","")
      ret = ret.replace("[]","")
    }

    ret.length == 0

  }


//  def main(args: Array[String]): Unit = {
//    println(isValid3("{[]}"))
//  }
}
