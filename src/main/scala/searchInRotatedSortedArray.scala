object searchInRotatedSortedArray {
  //33
  def search(nums: Array[Int], target: Int): Int = {
    if(!nums.contains(target))
      return -1

    val chkVal = nums(0)

    if(chkVal == target)
      return 0

    findMax(nums,(nums.length)/2,nums.length,chkVal,target)
  }

  def findMax(subarray: Array[Int],start: Int,end: Int,chkVal: Int,target:Int): Int = {
    if(subarray(start) == target)
      return start
    if(chkVal < target){
      if(subarray(start) > target)
        findMax(subarray,start/2,start,chkVal,target)
      else if(subarray(start) > chkVal && subarray(start) < target)
        findMax(subarray,(start+end)/2,end,chkVal,target)
      else
        findMax(subarray,start/2,start,chkVal,target)
    } else if(chkVal > target){
      if(subarray(start) > target && subarray(start) > chkVal)
        findMax(subarray,(start+end)/2,end,chkVal,target)
      else if(subarray(start) > target && subarray(start) < chkVal)
        findMax(subarray,start/2,start,chkVal,target)
      else if(subarray(start) < target)
        findMax(subarray,(start+end)/2,end,chkVal,target)
      else
        start
    }else{
      start
    }
  }

  def main(args: Array[String]): Unit = {
    var tt = Array[Int](8,9,2,3,4)
    println(search(tt,9))
  }

}
