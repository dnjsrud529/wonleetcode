object climbStairs {
  //70

  /*
  // I want to make combination.. ohhh nooo
  def climbStairs(n: Int): Int = {
    var ret = 1

    var twoCnt = 1
    if(n % 2 == 0){
      for(i <- n - 1 to n/2 by -1){
        ret += getFactory(i,twoCnt)
        twoCnt += 1
      }
    }else{
      for(i <- n - 1 to (n/2 + 1) by -1){
        ret += getFactory(i,twoCnt)
        twoCnt += 1
      }
    }

    ret
  }

  def getFactory(n: Int, r: Int): Int = {
    var ret = 1
    var newR = r
    if(r >= n) {
      return 1
    }

    if(r > n/2) {
      newR = n - r
    }

    for(i <- 0 until newR) {
      ret *= n - i
      ret /= newR - i
    }


    ret
  } */

  // Surprisingly, this result is a sequence.
  def climbStairs(n: Int): Int = {
    var bbef = 1
    var bef = 1
    var ret = 1
    for (i <- 0 until n-1) {
      ret = bbef + bef
      bbef = bef
      bef = ret
    }
    ret
  }

  def main(args: Array[String]): Unit = {
    var tt = Array[Int](9,6,4,2,3,5,7,0,1)
    println(climbStairs(10))
  }
}
