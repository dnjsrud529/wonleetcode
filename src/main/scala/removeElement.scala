//27
object removeElement {
  def removeElement(nums: Array[Int], `val`: Int): Int = {
    var dist = nums.filter(x => x != `val`)
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
    println(removeElement(Array(3,2,2,3),3))
  }
}
