object removeDuplicatesfromSortedArray {

  def removeDuplicates(nums: Array[Int]): Int = {
    val dist = nums.distinct
    var ret = dist.size

    var cnt = 0
    nums.foreach(n => {
      if(cnt < dist.length)
        nums(cnt) = dist(cnt)
      else
        nums(cnt) = 0

      cnt += 1
    })
    ret
  }

  def main(args: Array[String]): Unit = {
    println(removeDuplicates(Array(1,1,2)))
  }
}
