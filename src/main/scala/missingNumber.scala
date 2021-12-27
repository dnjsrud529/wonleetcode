object missingNumber {
  //268
  def missingNumber(nums: Array[Int]): Int = {
    var i = 0

    while(nums.contains(i))
      i += 1

    i
  }

  // 1+2+3+...+n = n(n+1)/2
  def missingNumber2(nums: Array[Int]): Int = {
    nums.length * (nums.length + 1) / 2 - nums.sum
  }

  //oh..ing??
  def missingNumber3(nums: Array[Int]): Int = {
    var result = 0
    for(i <- 0 until nums.length){
      result ^= i^nums(i)
    }
    result^nums.length
  }

  def main(args: Array[String]): Unit = {
    var tt = Array[Int](9,6,4,2,3,5,7,0,1)
    println(missingNumber3(tt))
  }
}
