//53
object maximumSubarray {
  def maxSubArray(nums: Array[Int]): Int = {
    var ret = nums.sortWith(_>_)(0)

    for(i <- 0 to nums.length -2){
      if(nums(i) > 0 && nums(i) + nums(i+1) > 0){
        var temp = findMax(nums.slice(i,nums.length))
        if(ret < temp)
          ret = temp
      }
    }

    ret
  }

  def findMax(subarray: Array[Int]): Int = {
    if(subarray.length == 2 || subarray.length == 1 || subarray.length == 0)
      return subarray.sum

    if(subarray(subarray.length -1) <= 0)
      return findMax(subarray.slice(0,subarray.length-1))
    else if(subarray(subarray.length-1) + subarray(subarray.length-2) <= 0){
      findMax(subarray.slice(0,subarray.length-2))
    }
    else{
      val ret = findMax(subarray.slice(0,subarray.length-1))
      if(subarray.sum < ret)
        ret
      else
        subarray.sum
    }
  }

  // oh my goddddddddddd
//  def maxSubArray(nums: Array[Int]): Int = {
//
//    var maxSub : Int = nums(0)
//    var curSum : Int = 0
//
//    for(n <- nums){
//      if(curSum < 0){
//        curSum = 0
//      }
//      curSum = curSum + n
//      maxSub = scala.math.max(maxSub, curSum)
//    }
//    return maxSub
//  }

    def main(args: Array[String]): Unit = {
      println(maxSubArray(Array[Int](-2,1,-3,4,-1,2,1,-5,4)))
    }
}
