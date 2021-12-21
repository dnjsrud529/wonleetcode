object sumOfTwoIntegers {
  //371
  def getSum(a: Int, b: Int): Int = {
    var negativeA = false
    var negativeB = false
    var binaryA = "00000000000"
    var binaryB = "00000000000"
    if(a<0){
      negativeA = true
      binaryA += (-a).toBinaryString
      binaryA = getComplement(binaryA)
    }else
      binaryA += a.toBinaryString
    if(b<0){
      negativeB = true
      binaryB += (-b).toBinaryString
      binaryB = getComplement(binaryB)
    }else
      binaryB += b.toBinaryString

    binaryA = binaryA.substring(binaryA.length-12)
    binaryB = binaryB.substring(binaryB.length-12)

    var ret = makeRet(binaryA,binaryB)

    if(negativeA && negativeB){
      if(ret.length == 13)
        ret = makeRet(ret,"1")
      return -1 * Integer.parseInt(getComplement(ret.substring(ret.length-11)),2)

    }else if(!negativeA && !negativeB){
      return Integer.parseInt(ret,2)
    }else{
      if(ret.length == 13)
        ret = makeRet(ret,"1").substring(ret.length-12)

      if(ret(0) == '1')
        return -1 * Integer.parseInt(getComplement(ret.substring(ret.length-11)),2)
      else
        return Integer.parseInt(ret.substring(ret.length-11),2)
    }

  }

  def getComplement(neg: String): String = {
    var ret = neg.replace("0","2")
    ret = ret.replace("1","0")
    ret.replace("2","1")
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
    var tt = Array[Int](2,3,4,5,18,17,6)
    println(getSum(-800,15))
  }
}
