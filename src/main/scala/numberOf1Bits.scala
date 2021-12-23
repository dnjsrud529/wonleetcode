object numberOf1Bits {
  //191
  def hammingWeight(n: Int): Int = {
    n.toBinaryString.toCharArray.filter(_ == '1').size
  }

  def main(args: Array[String]): Unit = {
    var tt = Array[Int](2,3,4,5,18,17,6)
    println(hammingWeight(11))
  }
}
