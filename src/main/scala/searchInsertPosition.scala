//35
object searchInsertPosition {
  def searchInsert(nums: Array[Int], target: Int): Int = {
    var ind = -1
    var cnt = 0

    nums.foreach(num => {
      if(target <= num && ind == -1)
        ind = cnt

      cnt += 1
    })

    if(ind == -1)
      ind = cnt

    ind

  }

}
