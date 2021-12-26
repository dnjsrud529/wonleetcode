object countingBits {
  //338
  //my solution is so.. um... short? i think it is not good for algorithm study
  def countBits(n: Int): Array[Int] = {
    val ret = new Array[Int](n+1)

    for(i <- 0 to n){
      ret(i) = i.toBinaryString.toCharArray.filter(_ == '1').size
    }
    println(4&1)
    ret
  }

  //can use shift
  def countBits2(n: Int): Array[Int] = {
    val result = Array.fill(n+1)(0)
    for(i<- 1 to n){
      result(i) = result(i>>1)+ (i&1)
    }
    result
  }

  def main(args: Array[String]): Unit = {
    var tt = Array[Int](2,3,4,5,18,17,6)
    println(countBits(5))
  }
}
