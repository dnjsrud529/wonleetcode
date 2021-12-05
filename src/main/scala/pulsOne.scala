//66
object pulsOne {
  def plusOne(digits: Array[Int]): Array[Int] = {
    var ret = Array[Int]()
    if(digits(digits.length-1) == 9){
      var fin = false
      digits(digits.length-1) = 0
      for(i <- digits.length -2 to 0 by -1){
        if(!fin){
          if(digits(i) == 9){
            digits(i) = 0
          }else{
            digits(i) = digits(i)+1
            fin = true
          }
        }
      }
    }else{
      digits(digits.length-1) = digits(digits.length-1) + 1
    }

    if(digits(0) == 0) {
      ret = 1 +: digits
      ret
    } else
      digits
  }
//  def plusOne(digits: Array[Int]): Array[Int] = {
//    var ret = Array[Int]()
//    if(digits(digits.length-1) == 9){
//      digits(digits.length-1) = 0
//      if(digits.length != 1){
//        if(digits.filter(x => x>=9).length > 0){
//          var fin = false
//          for(i <- digits.length -2 to 0 by -1){
//            if(!fin){
//              if(digits(i) == 9){
//                digits(i) = 0
//              }else{
//                digits(i) = digits(i)+1
//                fin = true
//              }
//            }
//          }
//        }else{
//          digits(digits.length-2) = digits(digits.length-2)+1
//        }
//      }
//    }else{
//      digits(digits.length-1) = digits(digits.length-1) + 1
//    }
//
//    if(digits(0) == 0) {
//      ret = 1 +: digits
//      ret
//    } else
//      digits
//  }


  def main(args: Array[String]): Unit = {
    var tt = plusOne(Array[Int](4,2,9,9))
    println(tt)
  }
}
