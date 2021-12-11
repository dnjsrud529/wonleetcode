object productofArrayExceptSelf {
  //238
  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    var all = 1
    var withoutZero = 1
    var ret = new Array[Int](nums.length)
    var zeroChk = false

    if(nums.filter(x => x == 0).size >= 2)
      zeroChk = true

    nums.foreach(num => {
      all = all * num
      if(num != 0)
        withoutZero = withoutZero * num
    })

    nums.zipWithIndex.foreach{
      case(num,i) => {
        if(num == 0){
          if(zeroChk)
            ret(i) = 0
          else
            ret(i) = withoutZero
        }else{
          ret(i) = all / num
        }
      }
    }
    ret
  }

  def goodExample(nums: Array[Int]): Array[Int] = {
    val res1 = Array.fill(nums.length)(1)
    val res2 = Array.fill(nums.length)(1)
    val res =  Array.fill(nums.length)(1)

    var left = 1
    for (i <- 0 until nums.length) {
      res1(i) = left
      left = left * nums(i)
    }

    var right = 1

    for (j <- nums.length - 1 to 0 by -1) {
      res2(j) = right
      right = right * nums(j)
    }
    for (i <- 0 until res1.length) {
      res(i) = res1(i) * res2(i)

    }
    res
  }

  def main(args: Array[String]): Unit = {
    var tt = Array[Int](-1,1,0,-3,3,0)
    println(productExceptSelf(tt))
  }

}
