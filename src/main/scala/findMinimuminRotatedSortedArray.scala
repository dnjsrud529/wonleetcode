object findMinimuminRotatedSortedArray {
  //153
  def findMin(nums: Array[Int]): Int = {
    if(nums(0) < nums(nums.length-1) || nums.length == 1)
      return nums(0)

    var chkVal = nums(0)

    nums(findMax(nums,(nums.length)/2,nums.length,chkVal))

  }

  def findMax(subarray: Array[Int],start: Int,end: Int,chkVal: Int): Int = {
    if(start == end || start > end)
      return 0
    if(subarray(start) < chkVal && subarray(start) < subarray(start-1))
      start
    else if(subarray(start) < chkVal)
      findMax(subarray,start/2,start,chkVal)
    else if(subarray(start) > chkVal)
      findMax(subarray,(start+end)/2,end,chkVal)
    else
      0
  }

  def main(args: Array[String]): Unit = {
    var tt = Array[Int](11,13,15,17)
    println(findMin(tt))
  }
}
