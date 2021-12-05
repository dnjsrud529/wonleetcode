object addBinary {
  def addBinary(a: String, b: String): String = {
    if(a.length == 0)
      b
    else if(b.length == 0)
      a

    var ret = ""

    if(a.length >= b.length){
        ret = makeRet(a,b)
    }else{
        ret = makeRet(b,a)
    }

    ret
  }

  def makeRet(a: String,b: String) : String = {
    var overNum = false
    var ret = ""
    a.reverse.zipWithIndex.foreach{
      case(num,i) => {
        if(i < b.length){
          if(overNum){
            if(num == '1' && b.reverse(i) == '1'){
              ret = "1" + ret
            }else if(num == '1' || b.reverse(i) == '1' ){
              ret = "0" + ret
            }else{
              overNum = false
              ret = "1" + ret
            }
          }else{
            if(num == '1' && b.reverse(i) == '1'){
              overNum = true
              ret = "0" + ret
            }else if(num == '1' || b.reverse(i) == '1' ){
              ret = "1" + ret
            }else{
              ret = "0" + ret
            }
          }
        }else{
          if(overNum){
            if(num == '1')
              ret = "0" + ret
            else{
              overNum = false
              ret = "1" + ret
            }
          }else{
            ret = num + ret
          }
        }
      }
    }

    if(overNum)
      ret = "1" + ret
    ret
  }

  def main(args: Array[String]): Unit = {
    println(addBinary("1010","1011"))
  }

}
