object reserveBits {
//190
  // you need treat n as an unsigned value
  //sry,, bit problem is not good for me;; idiot..

  def reverseBits(x: Int): Int = {
    import scala.annotation.tailrec
    @tailrec
    def reverse(in: Int, n: Int = 32, out: Int = 0): Int =
      if (n == 0) out
      else reverse(in >>> 1, n - 1, (out << 1) | (in & 1)) //magic

    def reverseBits2(x: Int): Int = {
      var result = 0
      var num = x
      var position = 31 // 0 indexed
      while(position >= 0){
        result += (num & 1) << position // take last bit of the number and shift to front/right
        num = num >> 1 // shift number 1 place to left, to get next bit in the next interation
        position -= 1 // reduce the position to left shift (num&1)
      }
      result
    }
    reverse(x)
  }

  def reserveBits3(x: Int): Int = {
    x.toBinaryString.reverse.padTo(32,'0').foldLeft(0)((p,n) => (p << 1) + (n - '0'))
  }

  def main(args: Array[String]): Unit = {
    var tt = Array[Int](9,6,4,2,3,5,7,0,1)
    println(reverseBits(10))
  }

}
